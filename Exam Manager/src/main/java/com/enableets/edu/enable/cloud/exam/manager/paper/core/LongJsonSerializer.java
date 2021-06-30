package com.enableets.edu.enable.cloud.exam.manager.paper.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 序列化时将long转化成String,解决异步请求返回参数转json时，long失精度
 * @author walle_yu@enable-ets.com
 * @since 2017年11月6日
 */
public class LongJsonSerializer extends JsonSerializer<Long> {

	@Override
	public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		String text = (value == null ? null : String.valueOf(value));
		if (text != null) {
			gen.writeString(text);
		}
	}

}
