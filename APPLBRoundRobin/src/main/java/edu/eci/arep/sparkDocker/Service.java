package edu.eci.arep.sparkDocker;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import spark.Request;
import spark.Response;

public class Service {
    public static void main(String args[]) {
        port(getPort());
        HTTPRESTUNI serviceREST = new HTTPRESTUNI();
        get("/hello", (req, res) -> "Hello Docker");
        get("/index", (req, res) -> indexDataPage(req, res,serviceREST));
        get("/processdata", (req, res) -> processDataPage(req, res,serviceREST));
    }

    private static String processDataPage(Request req, Response res, HTTPRESTUNI serviceREST) {
        String msg = req.queryParams("value");
        RESTinsert(msg,serviceREST);
        res.redirect("/index");
        return "";
    }

    private static String indexDataPage(Request req, Response res, HTTPRESTUNI serviceREST) {
        String table = RESTqueryTail(serviceREST);

        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Mensajes</h2>"
                + "<form action=\"/processdata\">"
                + "  Mensaje<br>"
                + "  <input type=\"text\" name=\"value\">"
                + "  <br>"
                + "  <input type=\"submit\" value=\"Enviar\">"
                + "</form>"
                + "<p> Presione enviar para procesar los datos</p>"

                + "<table border =\"1\">\n"
                + "<tr>\n"
                + "<th>Mensaje</th>\n"
                + "<th>Fecha</th>\n"
                + "</tr>\n"+
                table
                +"</table>\n"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String RESTqueryTail(HTTPRESTUNI serviceREST) {
        String table = "";
        String data = serviceREST.getRequest("/messages");
        Gson gson = new Gson();
        Message[] msgs = gson.fromJson(data,Message[].class);
        for(Message p: msgs){
            table+="<tr>\n"
            + "<td>"+p.getMsg()+"</td>\n"
            + "<td>"+p.getDate()+"</td>\n"
            + "</tr>\n";
        }
        return table;
    }

    private static String RESTinsert(String msg, HTTPRESTUNI serviceREST) {
        String data = null;
        serviceREST.postRequest(msg);
        return data;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
        }
}
