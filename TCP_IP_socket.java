package com.AdvJava;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
public class TCP_IP_socket {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("time-A.timefreq.bldrdoc.gov",13);
            //s.getInputStream() method get the stream in the form of binary bytes, so we
            // have to use InputStreamReader object into the bufferedReader class to
            // convert it into user understandable form.

            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            boolean more =true;
            while(more){
                String line =in.readLine();
                if(line==null)
                    more=false;
                else
                    System.out.println(line);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
