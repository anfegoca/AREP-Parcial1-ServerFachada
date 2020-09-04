package edu.eci.arep.HttpFacade;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
    
   
    

    public static void main(String[] args) {
        port(getPort());
        get("/index", (req, res) -> inputDataPage(req, res));
        
    }

    private static String inputDataPage(Request req, Response res) {
        String num = req.queryParams("number");
        String oper = req.queryParams("oper");
        String url = "https://sheltered-hollows-90641.herokuapp.com/results?number="+num+"&oper="+oper;
        String readLine = null;
        String json = null;
        try{
        URL server = new URL(url);
        HttpURLConnection conection = (HttpURLConnection) server.openConnection();
        conection.setRequestMethod("GET");
        
        System.out.println("HOLA "+conection.getResponseMessage());
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
           json= response.toString();
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
        }catch(Exception e){

        }
        return json;
        
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
