package com.company;

import java.io.*;
import java.net.*;


public class Making_Server {
    public static void main(String[] args) {
        try{
            System.out.println("Server Window");


            ServerSocket SS=new ServerSocket(5001);

            System.out.println("Waiting For the Client");

            Socket Sin=SS.accept();

            System.out.println("Connected to the Client");

            BufferedReader BR=new BufferedReader(new InputStreamReader(Sin.getInputStream()));
             PrintWriter PW1=new PrintWriter(Sin.getOutputStream(),true);
             PW1.println("Hello! Enter Bye to Exit.");
            boolean more=false;
            while(!more){
                String S=BR.readLine();
                if(S.equals("Bye"))
                    more=true;
                  else
                System.out.println("Echo:- "+S);

            }
            

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
