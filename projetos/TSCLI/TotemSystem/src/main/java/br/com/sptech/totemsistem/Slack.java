/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sptech.totemsistem;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author Letícia
 */
public class Slack {
    private static HttpClient client = HttpClient.newHttpClient();
    private static String link1 = "https://hooks.slack.com";
    private static String link2 = "/services/T03DZ5B98PL/B03H4PPRZM5";
    private static String link3 = "/GvIrWQcIWhqmTqLZUxsMOZ73";
            
    private static final String URL = link1+link2+link3;
    
    
    public static void sendMessage(JSONObject content)throws IOException, InterruptedException{ 
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
        
        HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());
        
        //System.out.println(String.format("Status: %s", response.statusCode()));
        //System.out.println(String.format("Response: %s", response.body()));
    }
}
