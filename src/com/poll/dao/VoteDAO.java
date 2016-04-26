package com.poll.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.poll.db.MongoDBClient;
import com.poll.domain.Vote;

public class VoteDAO {
	
	private final static Logger LOG = LoggerFactory.getLogger(VoteDAO.class);

	private static final String COLLECTION_NAME = "votes";
	private MongoCollection<Vote> collection;
	private MongoDatabase db;
	
	public VoteDAO() {
		db = new MongoDBClient().getDB();
		collection = db.getCollection(COLLECTION_NAME).withDocumentClass(Vote.class);
	}

	public void save(Vote bean) {
		LOG.info("Creating broadcast offering");
		collection.insertOne(bean);
	}

}
