package ir.ac.kntu.GamePlay;

import ir.ac.kntu.Object.Characters.Enemies.Enemy;
import ir.ac.kntu.Object.Characters.Heroes.Hero;
import ir.ac.kntu.Object.HQ;

import java.util.LinkedList;
import java.util.Random;

public class Level1 {
    LinkedList<Enemy> enemyGroup = new LinkedList<>();

    public static void setTheScene(){
        for(Hero hero : Hero.getHeroes()){
            Random ran = new Random();
            hero.getRepresentative().setVisible(true);
            hero.getRepresentative().setX(ran.nextInt(100)+710);
            hero.getRepresentative().setY(ran.nextInt(500)+50);
        }
        HQ.getHQList().get(0).getFacility().setVisible(true);
        HQ.getHQList().get(1).getFacility().setVisible(true);
        GameSetup.getPresentHQ().add(HQ.getHQList().get(0));
        GameSetup.getPresentHQ().add(HQ.getHQList().get(1));
        waves();
    }

    public static void waves(){
        GameSetup.graySoldierSetting(50,350);
        GameSetup.redSoldierSetting(50,50);
    }


}
