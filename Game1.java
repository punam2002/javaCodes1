package com.company;
import java.util.Scanner;
import java.util.Random;

class Guess {
    int userInput;
    int computerInput;
    int noOfGuesses=0;

    Guess(){
        Random R = new Random();
        computerInput = R.nextInt(100);
    }

    void takeUserInput() {
        Scanner S = new Scanner(System.in);
        System.out.println("Guess the number : ");
        userInput = S.nextInt();
    }

    boolean show() {
        noOfGuesses++;
        if (userInput == computerInput) {
            System.out.format("Yes, You Guess the right number %d in %d no.of Guesses. ", userInput, noOfGuesses);
            return true;
        }
        else if (userInput > computerInput) {
            System.out.println("Too High......");

        }
        else if (userInput < computerInput) {
            System.out.println("Too Low ......");
        }

        return false;
    }
}

    public class Game1 {
        public static void main(String[] args) {
          Guess G = new Guess();
          boolean b= false;
          while(!b) {
              G.takeUserInput();
              b=G.show();
          }
        }
    }

