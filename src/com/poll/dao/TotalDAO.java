package com.poll.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.poll.db.MongoDBClient;

public class TotalDAO {
	
	private final static Logger LOG = LoggerFactory.getLogger(TotalDAO.class);

	private static final String COLLECTION_NAME = "votes";
	private MongoCollection<Document> collection;
	private MongoDatabase db;
	
	public TotalDAO() {
		db = new MongoDBClient().getDB();
		collection = db.getCollection(COLLECTION_NAME);
	}

	public List<Document> getTotals() {
		LOG.debug("Get Totals !");
		List<Document> docs = new ArrayList<>();
		
		AggregateIterable<Document> iterable = collection.aggregate(Arrays
				.asList(new Document("$group", new Document("_id", "$name").
						append("count", new Document("$sum", 1)))));
		
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		    	LOG.debug("The Result is: " + document.toJson());
		        docs.add(document);
		    }
		});
		
		if(docs!=null && docs.size()>0){
			return docs;
		}else{
			LOG.debug("No data found.");
			return null;
		}
	}
}
