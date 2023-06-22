package com.modul;

import java.io.BufferedReader;
import org.json.*;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.io.*;

public class SendDataToServlet {

    public static void main(String[] args) {
        try {
        	
            // Create a custom PrintStream that captures the output
            OutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            
            // Set the custom PrintStream as the new System.out
            System.setOut(printStream);
            
            // Your program's code
            System.out.println("17");
            System.out.println("090");
            
            // Get the captured output and split it into lines
            String[] lines = outputStream.toString().split(System.lineSeparator());
        	

            

            // Create a JSON object and add the latitude and longitude to it
           for(String s : lines) {
        	   
               JSONObject jsonObject = new JSONObject();
               jsonObject.put("latitude", s);
               double latitude1 = jsonObject.getDouble("latitude");
               System.out.println(latitude1+"from json file");

        	   
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
