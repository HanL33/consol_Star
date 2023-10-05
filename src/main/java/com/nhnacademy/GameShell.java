package com.nhnacademy;

import static com.nhnacademy.Prepare.getComSpeciesList;
import static com.nhnacademy.Prepare.getSpeciesList;

import com.nhnacademy.Unit.FlyUint;
import com.nhnacademy.Unit.GroundUnit;
import com.nhnacademy.Unit.Species;
import java.util.ArrayList;
import java.util.List;

public class GameShell {

    private List<Species> player = new ArrayList<>();
    private List<Species> com = new ArrayList<>();
    private void setPlayer(){
        player.addAll(getSpeciesList());
    }
    private void setCom(){
        com = getComSpeciesList();
    }

    public void playGame(){
        Prepare.startGame();
        setPlayer();
        setCom();
        while(Turn()){
            battlePase(player, com);
        }
        if(player.isEmpty()){
            System.out.println("com win!");
        }
        if(com.isEmpty()){
            System.out.println("player win!");
        }
    }

    private boolean Turn() {
        if(player.isEmpty() || com.isEmpty()){
            return false;
        }
        return true;
    }

    private void battlePase(List<Species> player, List<Species> com) {
        System.out.println("Player");
        showList(player);
        System.out.println("Com");
        showList(com);
        sellectUnit();
        enemyTurn();
    }

    private void sellectUnit() {
        int unitNumber = Integer.MAX_VALUE;
        int enemyUnitNumber = Integer.MAX_VALUE;
        while (true) {
            if (canNotFight(player)){
                break;
            }
            try {
                System.out.println("공격할 유닛을 골라주세요");
                unitNumber = InputShell.inputFromShell();
                System.out.println("공격받을 유닛을 골라주세요");
                enemyUnitNumber = InputShell.inputFromShell();
                if (com.get(enemyUnitNumber) instanceof GroundUnit) {
                    break;
                }
                if (player.get(unitNumber).isSP() || player.get(unitNumber) instanceof FlyUint) {
                    break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(unitNumber != Integer.MAX_VALUE || enemyUnitNumber != Integer.MAX_VALUE) {
            try {
                int ATK = player.get(unitNumber).attack();
                com.get(enemyUnitNumber).defence(ATK);
                if (com.get(enemyUnitNumber).getDEF() <= 0) {
                    com.remove(enemyUnitNumber);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean canNotFight(List<Species> ally) {
        for (int i = 0; i < ally.size(); i++) {
            if (ally.get(i).isSP() || ally.get(i) instanceof FlyUint) {
                return false;
            }
        }
        return true;
    }

    private void enemyTurn() {
        int randomPlayerUnit = Integer.MAX_VALUE;
        int randomComUnit = Integer.MAX_VALUE;

        int playerMax = player.size() -1;
        int comMax = com.size() -1;

        while (true) {
            if(com.isEmpty() || player.isEmpty() || canNotFight(com)){
                break;
            }
            try {
                randomPlayerUnit = (int) (Math.random() * playerMax);
                randomComUnit = (int) (Math.random() * comMax);
                if (player.get(randomPlayerUnit) instanceof GroundUnit) {
                    break;
                }
                if (com.get(randomComUnit).isSP() || com.get(randomComUnit) instanceof FlyUint) {
                    break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(randomPlayerUnit != Integer.MAX_VALUE || randomComUnit != Integer.MAX_VALUE){
        int ATK = com.get(randomComUnit).attack();
        player.get(randomPlayerUnit).defence(ATK);
        if (player.get(randomPlayerUnit).getDEF() <= 0) {
            player.remove(randomPlayerUnit);
        }
        }
    }

    private void showList(List<Species> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(i + ". " + list.get(i));
        }
    }

}
