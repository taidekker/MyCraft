/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mycraft;

/**
 *
 * @author napapis
 */
import java.util.Scanner;
import static java.lang.System.*;

// Main place where Java code is run
public class Main {
    public static void main(String[] args) {
        // A single instance of the CharaterMain object (called char_1)
        CharacterMain char_1 = new CharacterMain("Fred");
        out.println("Welcome to MyCraft " + char_1.getName() + "!");
        Scanner myScanner = new Scanner(in);

        // This is the game loop where the player can
        // continue to call methods of the class objects, or leave
        while(true){

            // This block needs to be here to enusre the forever loop can quit
            boolean continue_playing = true;
            out.println("Keep playing? (y/n");
            if(myScanner.nextLine().equals("n")){
                out.println("Quitting game! Goodbye!");
                break;
            }
            // The actual game
            else{
                // All game functions are called within the .play() method.
                // feed free to call other functions you wish to create!
                char_1.play();
            }
        }
    }
}