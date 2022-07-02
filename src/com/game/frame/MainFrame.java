/** 
    Document   : MainFrame.java
    Created on : July 2, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
        This is the Main frame where the two other panels should be contained. And so, this class will 
        be extending the JFrame to instantiate a window. 
        Moreover, it is where the event handling will take place by using the custom event handler
        that we have. 
        
        @NOTE: 
            Rememeber that we need to follow this requirement: 
            "...The event will then be passed on to the MainFrame who will handle the event. 
            To handle the event, MainFrame should display on the FeedbackPanel the messages 
            corresponding to the user inputs"
*/

// PACKAGE SECTION
package com.game.frame;


// IMPORT SECTION
import javax.swing.*;
import java.awt.*;
import com.game.input.*;
import com.algo.guess.Guesser;
import com.customevent.FormEvent;
import com.customevent.FormListener;
import com.game.feedback.*;

public class MainFrame extends JFrame {
    
    // Custom Panels 
    InputPanel inputPanel; 
    FeedbackPanel feedbackPanel; 

    // Guesser Algorithm and instantiate it
    Guesser guess = new Guesser();

    // Labels
    JLabel gameHeader;  

    // Fonts 
    Font calibri = new Font("Calibri", Font.BOLD, 34); 

    public MainFrame() {
        // Initialize properties of this frame
        setTitle("Simple Guesser Game v2 by Cloyd Van S. Secuya");
        setSize(new Dimension(300, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Set up Layout manager */
        setLayout(new BorderLayout());

        // Add components to this frame class 
        initComponents();

        // Set up a fresh RGN for every instance of the MainFrame
        guess.setRGN();

        /**
         * @NOTE: Custom event handling
         */
        inputPanel.setFormListener(new FormListener() {
            @Override
            public void formEventOccurred(FormEvent e) {
                // Get the number from the generated event object
                int guess_input = e.getParsed_int(); 
                
                // Get the generated number which is the number to guess
                int number_to_guess = guess.getRGN(); 
                /* Log that into console */
                System.out.println("Number to guess: " + number_to_guess);
                /* Start up the guess checker */
                guess.guessChecker(guess_input); 
                /* Set up the flag */
                int to_check = guess.getCheckerFlag(); 
                /**
                 * @NOTE: 
                 *      These are conditions to see about the result of guesser checker 
                 *      and its algorithm
                 */
                // Guess input is lower
                if (to_check == 1) {
                    feedbackPanel.appendText(feedbackPanel.getMsg3()); 
                }
                // Guess input is higher
                else if(to_check == 2) {
                    feedbackPanel.appendText(feedbackPanel.getMsg2());
                }
                // Guess input is winner ; RGN == GUESS INPUT
                else if(to_check == 3) {
                    feedbackPanel.appendText(feedbackPanel.getMsg1());
                }
            }
        });
        
        // Pack up the frame 
        pack(); 

        // Display the frame 
        setVisible(true);

    }

    private void initComponents() {

        /* Initialize and set up custom panels */
        inputPanel = new InputPanel(); 
        feedbackPanel = new FeedbackPanel(); 
        
        /* Initialize labels and set properties */
        gameHeader = new JLabel("Higher - Lower Game", JLabel.LEFT); 
        gameHeader.setFont(calibri); 

        /* Add components to frame */  
        add(gameHeader, BorderLayout.NORTH); 
        add(inputPanel, BorderLayout.WEST); 
        add(feedbackPanel, BorderLayout.EAST);         
    }

    public static void main(String[] args) {
        new MainFrame(); 
    }
}