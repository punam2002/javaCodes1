package com.company;
import java.util.regex.*;
import java.util.*;
public class Email_Validation {

      public static boolean isValid(String email)
        {
            String regex = "^(.+)@(.+)$";
          // Pattern P1=new Pattern();  throw an error becoz the class Pattern in regex is private
           Pattern P1 = Pattern.compile(regex);
            if (email == null)
                return false;
            return P1.matcher(email).matches();
        }

        public static void main(String[] args){
          Scanner S1 = new Scanner(System.in);
           System.out.println("Enter Your Email :- ");
            String email=S1.next();
      //      String email="";   we can use this if the user input in implicit (without using scanner class).
            boolean result = isValid(email);
            if (result)
 System.out.println("Provided email address "+ email+ " is valid \n");
                else
            System.out.println("Provided email address "+ email+ " is invalid \n");
        }
    }

