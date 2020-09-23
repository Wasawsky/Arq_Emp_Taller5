package edu.eci.arep.sparkDocker;

import java.util.List;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class HTTPRESTUNI {

    String[] servers = {"35001","35002","35003"}; 
    String actualServer = "";
    int nServer=0;
    String mainUrl = "http://54.210.150.219:";

    public HTTPRESTUNI() {
        this.actualServer = servers[nServer];
    }

    public String getRequest(String path) {
        String url = mainUrl+actualServer+path;
        HttpResponse<String> response = Unirest.get(url).asString();
        return response.getBody();
    }

    public void postRequest(String msg) {
        String path = "/input";
        String url = mainUrl+actualServer+path;
        HttpResponse<String> response = Unirest.post(url)
                                            .body(msg)
                                            .asString();
        swapServer();
    }
    private void swapServer() {
        nServer++;
        if(nServer==3){nServer=0;}
        actualServer=servers[nServer];
    }
}
