/** 
    Document   : FormListener.java
    Created on : July 2, 2022 
    Author     : Cloyd Van S. Secuya
    Description:
        This is responsible for being the custom event listener interface. 
*/

// PACKAGE SECTION
package com.customevent;


// IMPORT SECTION
import java.util.EventListener;


public interface FormListener extends EventListener {
    public void formEventOccurred(FormEvent e);
}