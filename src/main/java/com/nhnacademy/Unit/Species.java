package com.nhnacademy.Unit;

public class Species {
    public String tag;
    public String name;
    public int ATK;
    public int DEF;
    public boolean SP;

    public Species(String tag, String name, int ATK, int DEF, boolean SP) {
        this.tag = tag;
        this.name = name;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SP = SP;
    }

    @Override
    public String toString() {
        return "Species{" +
                "tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", ATK=" + ATK +
                ", DEF=" + DEF +
                ", SP=" + SP +
                '}';
    }

    public int attack(){
        return this.ATK;
    }

    public boolean isSP() {
        return SP;
    }

    public int defence(int enemyATK){
        this.DEF = DEF - enemyATK;
        return DEF;
    }

    public int getDEF() {
        return DEF;
    }
}
