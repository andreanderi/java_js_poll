package com.poll.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBClient {

	private final String DB_HOST = "localhost";
	private final int    DB_PORT = 27017;
	private final String DB_NAME = "poll";
	private final String DB_USER = "poll";
	private final String DB_PASS = "123";
	
	private MongoClient mongoClient;

	public MongoDBClient(){
		 		
		StringBuilder url = new StringBuilder();
		url.append("mongodb://");
		url.append(DB_USER);
		url.append(":");
		url.append(DB_PASS);
		url.append("@");
		url.append(DB_HOST);
		url.append(":");
		url.append(DB_PORT);
		
		MongoClientURI uri = new MongoClientURI(url.toString());
		mongoClient = new MongoClient(uri);
	 }
	
	public MongoDatabase getDB(){	
		MongoDatabase db = mongoClient.getDatabase(DB_NAME);
		return db;		
	 }
}