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
import com.game.feedback.*;

public class MainFrame extends JFrame {
    
    // Custom Panels 
    InputPanel inputPanel; 
    FeedbackPanel feedbackPanel; 

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