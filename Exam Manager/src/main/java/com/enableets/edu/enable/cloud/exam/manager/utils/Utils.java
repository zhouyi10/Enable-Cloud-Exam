package com.enableets.edu.enable.cloud.exam.manager.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author caleb_liu@enable-ets.com
 * @date 2021/05/21
 **/

public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * 转换类
     * @param from 源数据
     * @param toClass 目标class
     * @return
     */
    public static <F, T> T translate(F from, Class<T> toClass) {
        if (from == null) {
            return null;
        }
        DozerBeanMapper mapper = getIActorBeanMapper(from, toClass);
        return mapper.map(from, toClass);
    }

    /**
     * IActor Bean Mapper
     * @param from origin class
     * @param toClass target class
     * @param <F> origin class
     * @param <T> target class
     * @return
     */
    public static <F, T> DozerBeanMapper getIActorBeanMapper(F from, Class<T> toClass) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                Class<?> fromClass = from.getClass();
                TypeMappingBuilder mapping = mapping(fromClass, toClass);
                try {
                    fromClass.getDeclaredField("participators");
                    toClass.getDeclaredField("participators");
                    mapping.fields("participators", "participators", FieldsMappingOptions.copyByReference());
                } catch(Exception e){}
                try {
                    fromClass.getDeclaredField("publisher");
                    toClass.getDeclaredField("publisher");
                    mapping.fields("publisher", "publisher", FieldsMappingOptions.copyByReference());
                } catch(Exception e){}
                try {
                    fromClass.getDeclaredField("owner");
                    toClass.getDeclaredField("owner");
                    mapping.fields("owner", "owner", FieldsMappingOptions.copyByReference());
                } catch(Exception e){}

            }
        });
        return mapper;
    }

    /**
     * 网页下载文件名编码
     * @param fileName 文件名
     * @return 编码后的文件名
     */
    public static String encodeFileName(HttpServletRequest request, HttpServletResponse response,
                                        String fileName) {
        String agent = request.getHeader("User-Agent").toLowerCase();
        String defaultName = null;
        try {
            if (agent != null) {
                agent = agent.toLowerCase();
                if (agent.indexOf("msie") != -1 || agent.indexOf("trident") != -1) {
                    defaultName = URLEncoder.encode(fileName, "utf-8");
                    // 原始的空格使用urlEncode 编码后转换为+号(基于历史原因), 而ie解析时会直接作为+号处理,
                    // 因此需要手工替换一下这个特殊字符.
                    defaultName = defaultName.replaceAll("\\+", "%20");
                    response.addHeader("Content-Disposition", "attachment;filename=" + defaultName);
                } else if (agent.indexOf("opera") != -1) {
                    // Opera浏览器只能采用filename*
                    defaultName = URLEncoder.encode(fileName, "utf-8");
                    response.addHeader("Content-Disposition", "attachment;filename*=UTF-8''" + defaultName);
                } else if (agent.indexOf("applewebkit") != -1 || agent.indexOf("mozilla") != -1
                        || agent.indexOf("safari") != -1) {
                    // Chrome、FireFox、Safari
                    // filename部分只能使用utf-8的原始字节，而http header 必须使用单字节编码的字符串,
                    // 因此需要将原始内容重新构造为iso-8单字节编码的字符串
                    defaultName = new String(fileName.getBytes("utf-8"), "ISO_8859_1");
                    response.addHeader("Content-Disposition", "attachment;filename=" + defaultName);
                }
            } else { // 如果没有UA，则默认使用IE的方式进行编码，因为毕竟IE还是占多数的
                defaultName = URLEncoder.encode(fileName, "utf-8");
                // 原始的空格使用urlEncode 编码后转换为+号(基于历史原因), 而ie解析时会直接作为+号处理,
                // 因此需要手工替换一下这个特殊字符.
                defaultName = defaultName.replaceAll("\\+", "%20");
                response.addHeader("Content-Disposition", "attachment;filename=" + defaultName);
            }
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        return defaultName;
    }
}
