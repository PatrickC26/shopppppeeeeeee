package tw.cgu.b0921251.finalexam;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;



public class firebase {

    private final static String url_com = "https://app-design-1a03e-default-rtdb.firebaseio.com/";
    private final static String url_key = ".json?auth=fEsM7TRIFJWezuFDFEqLS3Qze0WrmAa0wmPuZk5M";
    private static Object MainActivity;


    static boolean database_Delete(String dic) {
        try{
            String url = url_com + dic + url_key;
            URL obj0 = new URL(url);
            HttpURLConnection httpCon = (HttpURLConnection) obj0.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestProperty(
                    "Content-Type", "application/x-www-form-urlencoded" );
            httpCon.setRequestMethod("DELETE");
            httpCon.connect();
            System.out.println("Response Code : " + httpCon.getResponseCode());
            database_PutTime();
            if (httpCon.getResponseCode() == 200)
                return true;
        }
        // Other error message
        catch (Exception e ) {
            e.printStackTrace();
        }
        return false;
    }

    static String database_Get(String dic) {
        String get = "";


        try{
            String url = url_com + dic + url_key;
            System.out.println(url);
            URL obj0 = new URL(url);
            Scanner scan0 = new Scanner(obj0.openStream());
            System.out.println(url);
            get = scan0.nextLine();//.next();
            if (get.equals("null")) {
                get = "";
                return get;
            }
            get = get.substring(1, get.length()-1);
            HttpURLConnection con0 = (HttpURLConnection) obj0.openConnection();
            System.out.println("Response Code : " + con0.getResponseCode());
            System.out.println("Value get : " + get);
        }
        // Other error message
        catch (Exception e ) {
            e.printStackTrace();
        }
        return get;
    }

    static String httpGet(String url) {
        String get = "";
        try{
            URL obj0 = new URL(url);
            Scanner scan0 = new Scanner(obj0.openStream());
            get = scan0.nextLine();//.next();
            if (get.equals("null")) {
                get = "";
                return get;
            }
            get = get.substring(1, get.length()-1);
            return get;
        }
        // Other error message
        catch (Exception e ) {
            e.printStackTrace();
        }
        return get;

    }

    static boolean database_PutTime() {
        try {
            URL url = new URL(url_com + "versions/renewTime/" + url_key);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            httpCon.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());
            out.write("\"" + getTime().toString().replaceAll(":", "").replaceAll("-", "") + "\"");
            out.flush();
            out.close();
            httpCon.getInputStream();
            if (httpCon.getResponseCode() == 200) {
                return true;
            }
        }
        catch(Exception e ) {
            e.printStackTrace();
        }
        return false;
    }

    static boolean database_Put(String dic, String data, boolean origionalText) {
        try {
            String urlS = url_com + dic + url_key;

            URL url = new URL(urlS);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            httpCon.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());
            if (origionalText)
                out.write(String.format(data));
            else
                out.write(String.format("\""+data+"\""));
            out.flush();
            out.close();
            httpCon.getInputStream();
            if (httpCon.getResponseCode() == 200) {
                database_PutTime();
                return true;
            }
        }
        catch(Exception e ) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getTime() {
        String nowtime = httpGet("http://worldtimeapi.org/api/timezone/Asia/Taipei");
        nowtime = nowtime.substring(nowtime.indexOf("datetime") + 11, nowtime.indexOf("+08:00\",\"day_of_week"));
        nowtime = nowtime.substring(0, nowtime.indexOf('.'));

        return nowtime;
    }

}
