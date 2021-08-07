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
public class BlockMain {
    // create class variables
    private static String name;             // can be anything!
    private static String type;             // "Ore", "Stone", "Misc", "Air"
    private static int harvest_level;       // number of hits required for mining (0-10)
    private static int xp_drop;             // amount to drop after mined (0+)
    private static String sound;

    public BlockMain(String type){
        BlockMain.name = "Block";
        BlockMain.setType(type);

    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        BlockMain.name = name;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        String[] types = {"Air", "Misc", "Ore", "Stone"};
        switch (type){
            case "Air":
               // BlockMain.setType(type);
                BlockMain.setHarvest_level(0);
                BlockMain.setXp_drop(1);
                BlockMain.setSound("whoosh");
                break;
            case "Misc":
               // BlockMain.setType(type);
                BlockMain.setHarvest_level(1);
                BlockMain.setXp_drop(15);
                BlockMain.setSound("gabgeut");
                break;
            case "Ore":
               // BlockMain.setType(type);
                BlockMain.setHarvest_level(3);
                BlockMain.setXp_drop(30);
                BlockMain.setSound("tink!");
                break;
            case "Stone":
               // BlockMain.setType(type);
                BlockMain.setHarvest_level(2);
                BlockMain.setXp_drop(25);
                BlockMain.setSound("Thud..");
                break;
        }

    }

    public static int getHarvest_level() {
        return harvest_level;
    }

    public static void setHarvest_level(int harvest_level) {
        if(harvest_level >= 0 && harvest_level < 10) {
            BlockMain.harvest_level = harvest_level;
        }
        else{
            System.out.println("Block [" + BlockMain.getName() + "] has a harvest level out of possible range....");
        }
    }

    public static int getXp_drop() {
        return xp_drop;
    }

    public static void setXp_drop(int drop) {
        if (drop > 0) {
            BlockMain.xp_drop = drop;
        }
    }

    public static String getSound() {
        return sound;
    }

    public static void setSound(String sound) {
        BlockMain.sound = sound;
    }
}