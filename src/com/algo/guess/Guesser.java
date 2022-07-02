/** 
    Document   : Guesser.java
    Created on : July 2, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
        This is our guessing algorithm responsible for generating RNG with a set of 
        max threshold. 
*/

// PACKAGE SECTION
package com.algo.guess;


// IMPORT SECTION
import java.util.Random;
import com.game.input.*;

public class Guesser {
    
    /* Attributes */
    // Fetch the instance of input panel
    // InputPanel inputPanel = new InputPanel(); 

    // Set up the maximum boundary of generating numbers 
    private int MAX_THRESHOLD = 100; 

    // Random class for implementing rgn
    private Random random = new Random(); 
    private int rgn = random.nextInt(MAX_THRESHOLD); 

    // Flag checker
    private int checker = 0; 

    // A method to set the RGN; not more than the MAX_THRESHOLD
    public void setRGN() {
        random = new Random(); 
        rgn = random.nextInt(MAX_THRESHOLD);
    }

    // A method responsible for returning the value of the generated number 
    public int getRGN() {
        return rgn;
    }

    public int getCheckerFlag() {
        return checker; 
    }

    /**
     * @NOTE: 
     *      Once this method is called. 
     *      It quickly calls and gets the return parsed Integer from the user input 
     *      of the textfield from the inputpanel. 
     */
    public void guessChecker(int guess_input) {
        
        /* @NOTE: 
         *      Always initialize to zero to make sure the checker flag 
         *      is always fresh.
         */
        checker = 0;

        // Logging to console 
        System.out.println("Guesser checker being called and ran in background");

        // Guess number of user input 
        // int guess_input = inputPanel.getParsed_userInput(); 

        /* Start checking */
        // If the user input is lower than the generated number
        if (guess_input < rgn) {
            System.out.println("Your guess is lower than the target");
            checker = 1; 
        }
        // If the user input is higher than the generated number
        else if (guess_input > rgn ) {
            System.out.println("Your guess is higher than the target");
            checker = 2; 
        }

        else if (guess_input == rgn) {
            // Outside of both of these conditions there can be default way for the user to win
            System.out.println("Congratulations, your guess is correct! ");
            checker = 3; 
        }

    }

}
