 package com.company;
import java.io.*;
import java.net.*;
public class Making_Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client Window....");
            //establish the connection...
            Socket SKT = new Socket("localhost", 5001);

            //Creates keyboard input stream.
            BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

            //Creates Socket input stream.
            BufferedReader BR1 = new BufferedReader(new InputStreamReader(SKT.getInputStream()));

            //Creates Socket Output stream.
            PrintWriter PW = new PrintWriter(SKT.getOutputStream(), true);

            //read Reply From Server...
            System.out.println(BR1.readLine());
             boolean flag=true;
            while (flag) {
                //readLine From Keyboard....

                String line = BR.readLine();

                //Send Line to Server....
                PW.println(line);

                if(line.trim().equals("Bye"))
                    flag=false;

                 else
                //read Reply from server...
                System.out.println("Server Reply :- " + line);



            }
        }
        catch(Exception e){
            System.exit(0);
        }
    }
}
