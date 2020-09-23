package edu.eci.arep.sparkDocker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

import org.json.JSONObject;

public class DBConnection {
    
    MongoClient mongoClient;
    MongoClientURI mongouri;
    DB database;
    DBCollection collection; 

    public DBConnection() {
        this.mongouri = new MongoClientURI("mongodb://54.210.150.219:27017");
        this.mongoClient = new MongoClient(this.mongouri);
        this.database = mongoClient.getDB("areplab");
        this.collection = database.getCollection("info");
    }

    /**
     * Muestra todos los datos de la db
     */
    public void queryAll() {
        List<DBObject> consulta = collection.find().toArray();
        System.out.println(consulta);
    }

    /**
     * Inserta datos en la db
     * @param String de un json
     */
    public void insert(String data) {
        DBObject doc = (DBObject)JSON.parse(data);
        collection.insert(doc);
    }

    /**
     * Ultimos 10 datos
     * @return Arraylist con los datos
     */
    public ArrayList<JSONObject> queryTail() {
        List<DBObject> consulta = collection.find().toArray();
        ArrayList<JSONObject> data = new ArrayList<>();
        int lengthTail = 10,i = consulta.size()-1, count = 0;

        if(consulta.size()<lengthTail){lengthTail=consulta.size();} //Si hay menos de 10 mensajes

        while(count<lengthTail){
            JSONObject recover = new JSONObject();
            recover.put("msg", consulta.get(i).get("msg"));
            recover.put("date", consulta.get(i).get("date"));
            data.add(recover);
            count++;i--;
        }
        return data;
    }
}
