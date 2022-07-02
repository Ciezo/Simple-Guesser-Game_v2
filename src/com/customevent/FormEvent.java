/** 
    Document   : FormEvent.java
    Created on : July 2, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
        This is our custom event handler where we can register and pass event sources from
        registered components. 

        @NOTE:
            Remember that the requirement is to use custom event handling. And so, this class file
            is just for that. 

*/

// PACKAGE SECTION
package com.customevent;


// IMPORT SECTION
import java.util.EventObject;


public class FormEvent extends EventObject {

    // Parsed int 
    private int parsed_int; 

    public FormEvent(Object source) {
        /* Getting the super constructor is necessary for this */
        super(source); 
    } 

    public FormEvent(Object source, int parsed_int) {
        super(source); 
        this.parsed_int = parsed_int; 
    }

    public void setParsed_int(int parsed_int) {
        this.parsed_int = parsed_int; 
    }

    public int getParsed_int() {
        System.out.println("Returning parsed integer from Event source");
        return  parsed_int; 
    }
}
