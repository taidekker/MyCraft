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


public class CharacterMain {

    // Set up character variables
    private static String name;         // Character's name
    private static float health;        // Health (between 0-10)
    private static float xp_level;      // Range from 0-n where n is the amount to reach next level.
    private static int level;           // Level from 0-n where in is unlimited level
    private static int armor_level;     // Amount of armor on the character (0-10)
    private static int hunger_level;    // Amount of hunger a character has (10-0): 10 being full and 0 being starving

    public static int[] char_loc = {0,0,0};     // This is for the move function x,y,z


    // Constructor :)
    public CharacterMain(String n){
        // hard set all values so calls to setters will still work
        CharacterMain.name = n;
        CharacterMain.health = 10;
        CharacterMain.xp_level = 0;
        CharacterMain.level = 1;
        CharacterMain.armor_level = 0;
        CharacterMain.hunger_level = 10;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CharacterMain.name = name;
    }

    public static float getHealth() {
        return health;
    }

    public static void setHealth(float health) {
        CharacterMain.health += health;
        // check if within ranges
        if(CharacterMain.health > 10){
            CharacterMain.health = 10;
        }
        if (CharacterMain.health <= 0){
            System.out.println("Character is no longer... well... alive");
            // call death function (once made).
        }
    }

    public static float getXp_level() {
        return xp_level;
    }

    public static void setXp_level(float xp_level) {
        CharacterMain.xp_level = xp_level;
        float next_level = CharacterMain.level * 125;
        if (CharacterMain.xp_level >= next_level){
            System.out.println("Level Up!");
            setLevel();
            CharacterMain.xp_level = 0;
        }
    }

    public static int getLevel() {
        return level;
    }

    private static void setLevel() {
        CharacterMain.level += 1;
    }

    public static int getArmor_level() {
        return armor_level;
    }

    public static void setArmor_level(int armor_level) {
        CharacterMain.armor_level += armor_level;
        if(CharacterMain.armor_level > 10){
            CharacterMain.armor_level = 10;
        }
        if(CharacterMain.armor_level < 0){
            CharacterMain.armor_level = 0;
        }
    }

    public static int getHunger_level() {
        return hunger_level;
    }

    public static void setHunger_level(int hunger_level) {
        CharacterMain.hunger_level += hunger_level;
        if(CharacterMain.hunger_level > 10){
            CharacterMain.hunger_level = 10;
        }
        if(CharacterMain.hunger_level < 0){
            CharacterMain.hunger_level = 0;
        }
    }

    public static int[] getChar_loc(){
        return char_loc;
    }

    // Function to control/call all other functions
    public static void play(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println(CharacterMain.getName() + ", what would you like to do (1-3)");
        System.out.println("1. Stand still");
        System.out.println("2. Move");
        System.out.println("3. Mine");

        String todo = myScanner.nextLine();
        switch (todo) {
            case "1":
                System.out.println("Standing still");
                break;
            case "2":
                System.out.println("time to move");
                move();
                break;
            case "3":
                System.out.println("time to mine!");
                mine();
                break;
        }
    }

    // A function that will change the character's location
    // Hint, you could have this monitor what biome you are in, or what kind of blocks are present.
    public static void move(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Which direction would you like to move? (w,s,a,d,up,down");
        String direct = myScanner.nextLine();
        switch (direct) {
            case "w":
                CharacterMain.char_loc[0] += 1;
                break;
            case "s":
                CharacterMain.char_loc[0] -= 1;
                break;
            case "a":
                CharacterMain.char_loc[1] += 1;
                break;
            case "d":
                CharacterMain.char_loc[1] -= 1;
                break;
            case "up":
                CharacterMain.char_loc[2] += 1;
                break;
            case "down":
                CharacterMain.char_loc[2] -= 1;
        }
    }

    // A function to simulate the mining of a block.
    // Will create a new block instance and then break it
    // will also give xp.
    // could create new CharacterMain attribute for block item to be stored in inventory?
    public static void mine(){
        System.out.println("looking for block....");
        BlockMain block = new BlockMain("Ore");
        for(int i = 0; i < block.getHarvest_level(); i++){
            System.out.println(block.getSound());
        }
        CharacterMain.setXp_level(block.getXp_drop());
    }
}