package edu.eci.arep.HttpFacade.HttpClient;

public class Client {
    public static void main(String [] args){
        
        String url = "https://sheltered-hollows-90641.herokuapp.com/results?number=";
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
           System.out.println("Respuesta "+ response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
        }catch(Exception e){

        }

    }
    
    
}
