package com.nhnacademy;

import com.nhnacademy.Unit.Fly;
import com.nhnacademy.Unit.Ground;
import com.nhnacademy.Unit.Species;
import java.util.ArrayList;
import java.util.List;

public class Prepare {
    static List<Species> speciesList = new ArrayList<>();
    public static void startGame(){
        System.out.println("게임을 시작합니다...");
        System.out.println("원하는 종족의 번호를 선택해주세요.");
        System.out.println("1.Terran 2.Protos 3.Zerg");
        int species = 0;
        while(true){
            try{
                species = InputShell.inputFromShell();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            if(species == 1){
                terranStart();
                break;
            } else if (species ==2) {
                protosStart();
                break;
            } else if (species ==3) {
                zergStart();
                break;
            }else{
                System.out.println("리스트에 있는 종족을 선택해주세요!");
            }
        }
    }

    private static void zergStart() {
        int count = 0;
        int randomValue;
        String tag = "Zerg";
        while(count < 8) {
            randomValue = (int) ((Math.random() * 5));

            switch (randomValue) {
                case 0:{
                    speciesList.add(new Fly(tag, "Queen", 15, 25));
                    break;
                }
                case 1:{
                    speciesList.add(new Ground(tag, "Zergling", 2,2, false));
                    break;}
                case 2:{
                    speciesList.add(new Ground(tag, "Hydralisk", 3,7, true));
                    break;}
                case 3:{
                    speciesList.add(new Ground(tag,"Ultralisk",5,15, false));
                    break;
                }
                case 4:{
                    speciesList.add(new Fly(tag,"Mutalisk",2,8));
                    break;
                }
                case 5:{
                    speciesList.add(new Fly(tag,"Guardian",3,6));
                    break;
                }
                default:
                    throw new IllegalArgumentException("Error!");
            }
            count++;
        }
    }

    public static List<Species> getSpeciesList() {
        return speciesList;
    }

    public static List<Species> getComSpeciesList() {
        int MAX_VALUE = 3;
        int randomSpecies = (int) (Math.random() * MAX_VALUE) + 1;
        speciesList.clear();
        if(randomSpecies == 1){
            terranStart();
        } else if (randomSpecies == 2) {
            protosStart();
        }else{
            zergStart();
        }

        return speciesList;
    }
    private static void protosStart() {
        int count = 0;
        int randomValue;
        String tag = "Protos";

        while(count < 4) {
            randomValue = (int) ((Math.random() * 5));

            switch (randomValue) {
                case 0:{
                    speciesList.add(new Fly(tag, "Carrier", 25, 40));
                    break;
                }
                case 1:{
                    speciesList.add(new Ground(tag, "Zealot", 5,20,false));
                    break;}
                case 2:{
                    speciesList.add(new Ground(tag, "Dragoon", 3,15, true));
                    break;}
                case 3:{
                    speciesList.add(new Ground(tag,"HighTempler",10,2, false));
                    break;
                }
                case 4:{
                    speciesList.add(new Fly(tag,"Scout",5,10));
                    break;
                }
                case 5:{
                    speciesList.add(new Fly(tag,"Corsair",4,12));
                    break;
                }
                default:
                    throw new IllegalArgumentException("Error!");
            }
            count++;
        }
    }

    private static void terranStart() {
        int count = 0;
        int randomValue;
        String tag = "Terran";
        while(count < 5) {
            randomValue = (int) ((Math.random() * 5));
            switch (randomValue) {
                case 0:{
                    speciesList.add(new Fly(tag, "BattleCruzer", 20, 30));
                    break;
                }
                case 1:{
                    speciesList.add(new Ground(tag, "Marine", 3,10, false));
                    break;}
                case 2:{
                    speciesList.add(new Ground(tag, "Tank", 7,15, false));
                    break;}
                case 3:{
                    speciesList.add(new Ground(tag,"Goliath",5,15, true));
                    break;
                }
                case 4:{
                    speciesList.add(new Fly(tag,"Wraith",3,10));
                    break;
                }
                case 5:{
                    speciesList.add(new Fly(tag,"Valkyrie",4,12));
                    break;
                }
                default:
                    throw new IllegalArgumentException("Error!");
            }
            count++;
        }
    }
}
