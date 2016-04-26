package com.poll.domain;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.mongodb.BasicDBObject;

public class Vote extends BasicDBObject{
	
	private static final long serialVersionUID = -2169953152734092166L;
	
	private String name;
	private String number;
	private String key;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("name =");
		builder.append(name);
		builder.append(", number = ");
		builder.append(number);
		builder.append(", key = ");
		builder.append(key);
		return builder.toString();
	}

	public String toJson() {
		String json = "{}";
		try {
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			json = ow.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}
