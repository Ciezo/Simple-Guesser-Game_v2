/** 
    Document   : FeedbackPanel.java
    Created on : July 2, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
        This is the feedback panel where we try to display corrersponding messages to the user. 
        
        These messages are the following: 
            1. Your guess is higher than the target
            2. Your guess is lower than the target
            3. Congratulations, your guess is correct! 

        The said messages must only be displayed upon meeting the following conditions: 
            if user_input < rgn: 
                Your guess is lower than the target
            
            if user_input > rgn: 
                Your guess is higher than the target

            if user_input == rgn: 
                Congratulations, your guess is correct! 

        @NOTE: 
            Again, remember that we need to meet the following requirements which states 
            "...MainFrame should display on the FeedbackPanel the messages corresponding to the user inputs"

        So, the MainFrame is responsible for displaying on the text area of this Feedback panel. And that is why  
        we need to set up a method that can append or add text to the text area inside this Feed back panel. 
        Lastly, as we are expecting appending or adding multiple lines of text then we need a scroll pane.
*/

// PACKAGE SECTION
package com.game.feedback;


// IMPORT SECTION
import javax.swing.*;
import java.awt.*;


public class FeedbackPanel extends JPanel {
    
    // Text area 
    private JTextArea feedback_area; 

    // Scroll pane
    private JScrollPane sp; 

    // String messages 
    private String msg1 = "Congratulations, your guess is correct!"; 
    private String msg2 = "Your guess is higher than the target"; 
    private String msg3 = "Your guess is lower than the target"; 

    public FeedbackPanel() {
        
        // Initialize properties of this Panel
        /* Layout manager properties */ 
        setLayout(new BorderLayout(50, 50));
        /* Set up a titled border around the panel  */
        setBorder(BorderFactory.createTitledBorder("Feedback")); 
        /* Set up the preferred size */
        setPreferredSize(new Dimension(300, 300));

        /* Initialize text area and set up properties */
        feedback_area = new JTextArea(); 
        feedback_area.setRows(5);
        feedback_area.setColumns(20);
        feedback_area.setOpaque(false);

        /* Initialize  scroll pane */
        sp = new JScrollPane();
        // sp.add(feedback_area, BorderLayout.CENTER); 
        add(sp = new JScrollPane(feedback_area), BorderLayout.CENTER);

    }

    public String getMsg1() {
        return msg1; 
    }

    public String getMsg2() {
        return msg2; 
    }

    public String getMsg3() {
        return msg3; 
    }

    public void appendText(String text) {
        feedback_area.append(text + "\n" + "\r");
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
    //     FeedbackPanel fbp = new FeedbackPanel(); 
    //     JFrame frame = new JFrame(); 
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.add(fbp); 
    //     frame.pack();
    //     frame.setVisible(true);
    // }
}
 