package insertq;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class connection
 */
public class connection {
	    private static MongoClient getConnection() {
	        int port_no = 27017;
	        String url = "localhost";
	 
	        MongoClient mongoClntObj = new MongoClient(url, port_no);
	        return mongoClntObj;
	    }
	 
	    // Method to insert user in the mongodb
	    public static void insertdata(String fname, String lname) {
	        String db_name = "student",
	                db_collection_name = "emp";
	 
	        // Get the mongodb connection
	        MongoDatabase db = getConnection().getDatabase(db_name);
	 
	        // Get the mongodb collection.
	        MongoCollection<Document> col = db.getCollection(db_collection_name);
	        
	        Document document = new Document();
	        
	    	document.append("fname", fname);
	    	document.append("lname", lname);
	    	
	    	col.insertOne(document);
	    	System.out.println("Inserted");
	    }

}
