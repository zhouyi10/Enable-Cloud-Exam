package com.enableets.edu.enable.cloud.exam.manager.bo;

/**
 * 公用map对象(只含有code和name字段)
 * @author duffy_ding
 * @since 2017/12/29
 */
public class CodeNameMapBO implements java.io.Serializable{
	
	/** 编码  */
	private String code;
	
	/** 名称  */
	private String name;

	public CodeNameMapBO() {
	}
	
	public CodeNameMapBO(String code, String name,String... relations) {
		this.code = code;
		this.name = name;
		this.relationCode = join(relations);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String relationCode;
	private static String join(String...relations) {
		if (relations != null && relations.length > 0) {
			String result = "";
			for (String s : relations) {
				result += "_" + s;
			}
			return result.substring(1);
		} else {
			return null;
		}
	}
}
