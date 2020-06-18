package ir.ac.kntu.GamePlay;

import ir.ac.kntu.Object.Characters.Enemies.*;
import ir.ac.kntu.Object.Characters.Heroes.Hero;
import ir.ac.kntu.Object.HQ;
import ir.ac.kntu.Organizer.Main;
import java.util.Random;

public class Levels {

    public static void setTheScene1(){
        for(Hero hero : Hero.getHeroes()){
            Random ran = new Random();
            hero.getRepresentative().setVisible(true);
            hero.getRepresentative().setX(ran.nextInt(100)+710);
            hero.getRepresentative().setY(ran.nextInt(500)+50);
        }
        Main.getRoot().getChildren().addAll(HQ.getHQList().get(0).getFacility(),HQ.getHQList().get(1).getFacility());
        HQ.getHQList().get(0).getFacility().setVisible(true);
        HQ.getHQList().get(1).getFacility().setVisible(true);
        GameSetup.getPresentHQ().add(HQ.getHQList().get(0));
        GameSetup.getPresentHQ().add(HQ.getHQList().get(1));
    }


    public static void setTheScene2(){
        for(Hero hero : Hero.getHeroes()){
            Random ran = new Random();
            hero.getRepresentative().setVisible(true);
            hero.getRepresentative().setX(ran.nextInt(100)+710);
            hero.getRepresentative().setY(ran.nextInt(500)+50);
        }
        HQ.getHQList().get(1).getFacility().setVisible(true);
        HQ.getHQList().get(2).getFacility().setVisible(true);
        GameSetup.getPresentHQ().add(HQ.getHQList().get(1));
        GameSetup.getPresentHQ().add(HQ.getHQList().get(2));
    }

    public static void firstBoss(){
        GameSetup.bossSetting(50,300, BossLvl1.getInstance());
    }

    public static void secondBoss(){GameSetup.bossSetting(50,300, BossLvl2.getInstance());
    }

    public static void waveType1(){
        GameSetup.graySoldierSetting(50,350, GraySoldier.getGraySoldiers1());
        GameSetup.graySoldierSetting(50,50, GraySoldier.getGraySoldiers());
    }

    public static void waveType2(){
        GameSetup.graySoldierSetting(50,350,GraySoldier.getGraySoldiers());
        GameSetup.redSoldierSetting(50,50, RedSoldier.getRedSoldiers());
    }

    public static void waveType3(){
        GameSetup.redSoldierSetting(50,350,RedSoldier.getRedSoldiers1());
        GameSetup.redSoldierSetting(50,50,RedSoldier.getRedSoldiers());
    }

    public static void waveType4(){
        GameSetup.YellowSoldierSetting(50,350, YellowSoldier.getYellowSoldiers());
        GameSetup.YellowSoldierSetting(50,50, YellowSoldier.getYellowSoldiers1());
    }

    public static void waveType5(){
        GameSetup.YellowSoldierSetting(50,350, YellowSoldier.getYellowSoldiers());
        GameSetup.redSoldierSetting(50,50,RedSoldier.getRedSoldiers());
    }

    public static void waveType6(){
        GameSetup.YellowSoldierSetting(50,350, YellowSoldier.getYellowSoldiers());
        GameSetup.graySoldierSetting(50,350,GraySoldier.getGraySoldiers());
    }

    public static void waveHandler(){
        Random ran = new Random();
        int comingWave;
        if(GameSetup.getEnemyGroup().isEmpty()){
            comingWave = ran.nextInt(3)+1;
            System.out.println(comingWave);
            switch (comingWave){
                case 1: waveType1();
                break;
                case 2: waveType2();
                break;
                case 3: waveType3();
                break;

            }
        }
    }

    public static void waveHandler1(){
        Random ran = new Random();
        int comingWave;
        if(GameSetup.getEnemyGroup().isEmpty()){
            comingWave = ran.nextInt(6)+1;
            System.out.println(comingWave);
            switch (comingWave){
                case 1: waveType1();
                    break;
                case 2: waveType2();
                    break;
                case 3: waveType3();
                    break;
                case 4: waveType4();
                    break;
                case 5: waveType5();
                    break;
                case  6:waveType6();
                    break;
            }
        }
    }


}
