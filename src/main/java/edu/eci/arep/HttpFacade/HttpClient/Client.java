package edu.eci.arep.HttpFacade.HttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
    public static void main(String[] args) {

        String url = "http://localhost:4567/index?number=123&oper=tan";
        String readLine = null;
        String json = null;
        try {
            URL server = new URL(url);
            HttpURLConnection conection = (HttpURLConnection) server.openConnection();
            conection.setRequestMethod("GET");

            System.out.println("HOLA " + conection.getResponseMessage());
            int responseCode = conection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
                in.close();
                
                System.out.println("Respuesta " + response.toString());
                
            } else {
                System.out.println("GET NOT WORKED");
            }
        } catch (Exception e) {

        }

    }

}
