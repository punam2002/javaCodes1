package com.company;;
import java.util.Random;
import java.util.Scanner;
public class Game {
        public static void main(String[] args) {
            System.out.println("Let's Play Paper Scissor Rock Game ");
            Random R1 = new Random();
            Scanner S1 = new Scanner(System.in);
            //  System.out.println("Get random number between 1 to 5 ");
            //no. 1 is for Scissor
            //no. 2 is for Paper
            //no.3 is for Rock
            int NoOfTry=0;
          boolean flag=true;
           while(flag) {
               NoOfTry++;
               System.out.println("Enter 1 for Scissor or 2 for Paper or 3 for Rock");
               int User_Input = S1.nextInt();
               int computer_Input = R1.nextInt(3) + 1;
               System.out.println("Computer Choice is :- " + computer_Input);

               if (User_Input == computer_Input) {
                   System.out.println("your Game is Draw.");
               } else if ((User_Input == 1 && computer_Input == 2) || (User_Input == 2 && computer_Input == 3) ||
                       (User_Input == 3 && computer_Input == 1)) {
                   System.out.println("Congratulations..... You Win ! in " + NoOfTry+"th try");
                   flag = false;
               } else {
                   System.out.println("Oops you loose try next time.....");

               }
           }
            }
        }



