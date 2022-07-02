/** 
    Document   : InputPanel.java
    Created on : July 2, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
        This is the input panel class where the user will be entering 
        their answers for the guessing game. Moreover, it is where the events will be coming 
        from so we need to implement the registering of components for Event listeners and objects.

        @NOTE: 
            Remember that we need to follow the requirements of the program. In which it states 
            "The event will be coming from InputPanel (when the textbox is “entered” after typing a number)."

        And so we will be needing a KeyListener

        Lastly, we can use some codes from the Simple-Guesser-Game_v1 
*/

// PACKAGE SECTION
package com.game.input;


// IMPORT SECTION
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputPanel extends JPanel {
    
    // Labels 
    private JLabel gameHint; 

    // Text field 
    private JTextField user_input; 

    // Integer for parsing String 
    private int number_input_parsedAsInt; 

    public InputPanel() {
        
        // Initialize properties of this panel 
        /* Layout Manager */
        GridBagLayout gb=new GridBagLayout(); 
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(10, 10, 10, 10);
        setLayout(gb);
        /* Set up a titled border around the panel  */
        setBorder(BorderFactory.createTitledBorder("InputForm")); 
        /* Set up the preferred size */
        setPreferredSize(new Dimension(300, 300));

        /* Initialize labels and set up layout properties */
        gameHint = new JLabel("Enter a number [1 to 100]", JLabel.CENTER);
        gbc.gridx = 0; 
        gbc.gridy = 0;
        gbc.gridheight=1;
        gbc.gridwidth=1;
        add(gameHint, gbc);   

        /* Intialize text field  and set up layout properties */
        user_input = new JTextField();  
        user_input.setPreferredSize(new Dimension(75, 75));
        user_input.setFont(new Font("Calibri", Font.PLAIN, 40));
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridheight=1;
        gbc.gridwidth=1;
        add(user_input, gbc); 

        /* Register the user_input text field to have an event handler  */
        /**
         * @NOTE: 
         *      We will be using anonymous class because it is just one object 
         *      that needs to be register.
         */
        user_input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                e.getKeyCode(); 
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("USER HAS PRESSED <ENTER> KEY");
                    String inputFromText = user_input.getText();
                    System.out.println("Input: " + inputFromText);

                    /* Fetch the text input and parse it into integer */
                    number_input_parsedAsInt = Integer.parseInt(inputFromText);
                    System.out.println("Parsed String input as integer: " + number_input_parsedAsInt); 

                    /* Then pass that number to our public method */ 
                    getParsed_userInput(); 
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

    }

    public int getParsed_userInput() {
        System.out.println("Returning parsed input: " + number_input_parsedAsInt);
        return number_input_parsedAsInt; 
    }

    /**
     * @NOTE: 
     *      Please, uncomment if necessary. 
     *      This is for testing to see if the elements and components 
     *      are laid out properly. 
     *      
     *      We can only run this main method when we make changes to the 
     *      componenent properties such as changing the size or position. 
     */
    // public static void main(String[] args) {
    //     InputPanel ip = new InputPanel(); 
    //     JFrame frame = new JFrame(); 
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.add(ip); 
    //     frame.pack();
    //     frame.setVisible(true);
    // }
}