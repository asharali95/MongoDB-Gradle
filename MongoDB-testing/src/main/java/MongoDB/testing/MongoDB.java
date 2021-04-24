package MongoDB.testing;

import java.net.UnknownHostException;

import com.mongodb.*;
//you need a client to run on. we do this as Mongo client

public class MongoDB {
	public static MongoClient mongoClient;
	public static DB database;
	public static DBCollection test;
	public static void main(String arg[])throws UnknownHostException {
		mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		database = mongoClient.getDB("MongoDB-testing"); // in parameter, we are adding database name 
		// the reason why we have getDB is because getDB first check if there is existing database, if not then it create new one
		 test = database.getCollection("test");
//		 DBObject DatabaseObj = new BasicDBObject("employee","ashar").append("items",new int[]).append("table","table5"); // can be done by this too but we have better way 

//		 TestObj testObj = new TestObj();
//		 testObj.setMemberID("Ashar");
//		 testObj.setTimer(1);
//		 testObj.setXp(1234);
		 
		 //Now insert our items in database;
		 
//		 test.insert(convert(testObj));
		 
//		 DBObject query = new BasicDBObject("XP",1234); // means that we want specific obj of data whose XP is 1234
		 
//		 DBCursor cursor= test.find(query); // we need a cursor to take that database and find query. if there is more than one satisfying the query it will return
		 // if we want just first one then we use cursor.one()
		 
//		 while(cursor.hasNext()) {
//			 DBObject next = cursor.next();
//			 System.out.println(next);
//		 }
		 
//		 TestObj newMod = new TestObj();
//		 newMod.setXp(9101);
//		 newMod.setMemberID("Zeeshan");
//		 newMod.setTimer(3);
//		 test.insert(convert(newMod));
		 DBObject query = new BasicDBObject("XP",1234);
		 DBCursor cursor= test.find(query);
//		 test.findAndModify(query,convert(newMod)); // for modification in test collection
//		 cursor = test.find(query);
		 
//		 while(cursor.hasNext()) {
//			 DBObject next = cursor.next();
//			 System.out.println(next);
//		 }
		 
		 //remove query
		 test.findAndRemove(query);
		 System.out.println(cursor.count());
		 
	}
		 
		
		 
		 
	public static DBObject convert(TestObj testObj) {
		return new BasicDBObject("XP",testObj.getXp()).append("Timer",testObj.getTimer()).append("Member ID", testObj.getMemberID());
		
	}
}
