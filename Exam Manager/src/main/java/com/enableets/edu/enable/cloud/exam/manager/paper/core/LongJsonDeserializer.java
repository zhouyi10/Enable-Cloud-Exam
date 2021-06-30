package com.enableets.edu.enable.cloud.exam.manager.paper.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 反序列化时将string转化成long,解决异步请求返回参数转json时，long失精度
 * @author walle_yu@enable-ets.com
 * @since 2017年11月6日
 */
public class LongJsonDeserializer extends JsonDeserializer<Long> {

	private static final Logger log = LoggerFactory.getLogger(LongJsonDeserializer.class);
	
	@Override
	public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String value = p.getText();
		try {
			return value == null? null : Long.parseLong(value);
		} catch (Exception e) {
			log.error("parse Long error!", e);
			return null;
		}
	}

}
