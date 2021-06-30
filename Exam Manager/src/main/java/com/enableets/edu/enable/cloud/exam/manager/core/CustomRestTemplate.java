package com.enableets.edu.enable.cloud.exam.manager.core;

import com.enableets.edu.framework.core.util.RestTemplate;
import com.enableets.edu.framework.core.util.StringUtils;
import com.enableets.edu.module.service.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @author duffy_ding
 * @since 2020/08/27
 */
@Slf4j
public class CustomRestTemplate extends RestTemplate {

    public CustomRestTemplate(String clientId, String clientSecret) {
        super();
        this.getInterceptors().add(new CustomClientHttpRequestInterceptor(clientId, clientSecret));
    }
    public <R> R get(String url) {
        ParameterizedTypeReference<Response<R>> responseType = new ParameterizedTypeReference<Response<R>>() { };
        R result = this.exchange(url, HttpMethod.GET, new HttpEntity<String>(null, getDefaultHeaders()), responseType).getBody().getData();
        return result;
    }

    public <R> List<R> getList(String url) {
        ParameterizedTypeReference<Response<List<R>>> responseType = new ParameterizedTypeReference<Response<List<R>>>() { };
        List<R> result = this.exchange(url, HttpMethod.GET, new HttpEntity<String>(null, getDefaultHeaders()), responseType).getBody().getData();
        return result;
    }

    public <P, R> R post(String url, P param) {
        ParameterizedTypeReference<Response<R>> responseType = new ParameterizedTypeReference<Response<R>>() { };
        R result = this.exchange(url, HttpMethod.POST, new HttpEntity<P>(param, getDefaultHeaders()), responseType).getBody().getData();
        return result;
    }

    public <P, R> List<R> postList(String url, P param) {
        ParameterizedTypeReference<Response<List<R>>> responseType = new ParameterizedTypeReference<Response<List<R>>>() { };
        List<R> result = this.exchange(url, HttpMethod.POST, new HttpEntity<P>(param, getDefaultHeaders()), responseType).getBody().getData();
        return result;
    }

    private HttpHeaders getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public static class CustomHttpRequestWrapper implements HttpRequest {

        private HttpRequest request;

        private URI uri;

        public CustomHttpRequestWrapper(HttpRequest request, URI uri) {
            this.request = request;
            this.uri = uri;
        }

        @Override
        public HttpMethod getMethod() {
            return request.getMethod();
        }

        @Override
        public String getMethodValue() {
            return null;
        }

        @Override
        public URI getURI() {
            return uri;
        }

        @Override
        public HttpHeaders getHeaders() {
            return request.getHeaders();
        }
    }

    public static class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

        private String clientId;

        private String clientSecret;

        private ClientHttpRequestFactory factory;

        public CustomClientHttpRequestInterceptor(String clientId, String clientSecret) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            factory = new SimpleClientHttpRequestFactory();
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            Map<String, String> params = collectSignParam(request.getURI(), body);
            String sign = sign(params);
            URI newUri = newUri(request.getURI(), params, sign);
            return execution.execute(new CustomHttpRequestWrapper(request, newUri), body);
        }

        public URI newUri(URI oldUri, Map<String, String> params, String sign) throws IOException {
            StringBuilder builder = new StringBuilder();
            for (String key : params.keySet()) {
                if (!"data".equals(key) && StringUtils.isNotBlank(params.get(key))) {
                    builder.append("&").append(key).append("=").append(params.get(key));
                }
            }
            builder.append("&clientId=").append(clientId).append("&sign=").append(sign);
            URI newUri = null;
            try {
                newUri = new URI(oldUri.getScheme(), oldUri.getAuthority(), oldUri.getPath(), builder.substring(1), oldUri.getFragment());
            } catch (URISyntaxException e) {
                log.error(e.getMessage(), e);
            }
            return newUri;
        }

        public String sign(Map<String, String> params) {
            String[] keyArray = params.keySet().toArray(new String[0]);
            Arrays.sort(keyArray);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(clientId);

            for(int i = 0; i < keyArray.length; ++i) {
                String key = keyArray[i];
                if (StringUtils.isNotBlank(params.get(key))) {
                    stringBuilder.append(key).append(params.get(key));
                }
            }

            stringBuilder.append(clientSecret);
            try {
                return DigestUtils.sha1Hex(stringBuilder.toString().getBytes("UTF-8")).toUpperCase();
            } catch (UnsupportedEncodingException e) {
                log.error(e.getMessage(), e);
                return null;
            }
        }

        public Map<String, String> collectSignParam(URI uri, byte[] body) {
            Map<String, String> params = new HashMap();
            if (body != null && body.length > 0) {
                try {
                    String bodystr = new String(body, "UTF-8");
                    params.put("data", bodystr);
                } catch (UnsupportedEncodingException e) {
                    params.put("data", new String(body));
                }
            }
            String query = uri.getQuery();
            if (StringUtils.isNotBlank(uri.getQuery())) {
                List<String> queries = Arrays.asList(uri.getQuery().split("&"));
                Collections.reverse(queries);
                for (String paramStr : queries) {
                    String[] split = paramStr.split("=");
                    if (split.length < 2 || StringUtils.isBlank(split[1])){
                        continue;
                    }
                    params.put(split[0], split[1]);
                }
            }
            params.put("timestamp", String.valueOf(System.currentTimeMillis()));
            return params;
        }
    }

}
