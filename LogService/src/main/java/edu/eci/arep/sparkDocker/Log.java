package edu.eci.arep.sparkDocker;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONObject;

import spark.Request;

public class Log {

    public static void main(String args[]) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Docker");
        get("/messages", (req, res) -> search());
        post("/input", (req, res) -> entrada(req));
    }

    public static ArrayList<JSONObject> search() {
        DBConnection con = new DBConnection();
        return con.queryTail();
    }

    public static String entrada(Request req) {
        DBConnection con = new DBConnection();
        JSONObject data = new JSONObject();
        data.put("msg", req.body());
        data.put("date", new Date());
        con.insert(data.toString());
        return "Done";
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
        }
}
