package ir.ac.kntu.GamePlay;

import ir.ac.kntu.Object.Characters.Enemies.*;
import ir.ac.kntu.Object.Characters.Heroes.*;
import ir.ac.kntu.Object.HQ;
import ir.ac.kntu.Organizer.Menu;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.LinkedList;

import static ir.ac.kntu.Organizer.Main.*;


public class GameSetup {
    private static Hero selected;
    private static int counter = 0;
    private static LinkedList<HQ> presentHQ = new LinkedList<>();


    public static void setBasics() throws CloneNotSupportedException {
        Menu.enteringMainMenu();
        Menu.getMissions().setVisible(false);
        Menu.getOrganization().setVisible(false);
        Menu.getFortifyHQ().setVisible(false);
        Menu.getTrain().setVisible(false);
        getScene().setFill(Color.BLACK);

        getRoot().getChildren().addAll(HQ.getHQList().get(0).getFacility(),HQ.getHQList().get(1).getFacility()
                ,HQ.getHQList().get(2).getFacility(),BossLvl1.getInstance().getRepresentative(),
                BossLvl2.getInstance().getRepresentative(), DaigoDojima.getInstance().getRepresentative(),
                FutoshiShimano.getInstance().getRepresentative(), GoroMajima.getInstance().getRepresentative(),
                JiroKawara.getInstance().getRepresentative(), KaoruSayama.getInstance().getRepresentative(),
                MakotoDate.getInstance().getRepresentative(), OsamuKashiwagi.getInstance().getRepresentative(),
                RyoTakashima.getInstance().getRepresentative(), RyujiGoda.getInstance().getRepresentative(),
                ShintaroKazama.getInstance().getRepresentative(), SoheiDojima.getInstance().getRepresentative(),
                TaigaSaejima.getInstance().getRepresentative());

        BossLvl1.getInstance().getRepresentative().setVisible(false);
        BossLvl2.getInstance().getRepresentative().setVisible(false);
        DaigoDojima.getInstance().getRepresentative().setVisible(false);
        FutoshiShimano.getInstance().getRepresentative().setVisible(false);
        GoroMajima.getInstance().getRepresentative().setVisible(false);
        JiroKawara.getInstance().getRepresentative().setVisible(false);
        KaoruSayama.getInstance().getRepresentative().setVisible(false);
        MakotoDate.getInstance().getRepresentative().setVisible(false);
        OsamuKashiwagi.getInstance().getRepresentative().setVisible(false);
        RyoTakashima.getInstance().getRepresentative().setVisible(false);
        RyujiGoda.getInstance().getRepresentative().setVisible(false);
        ShintaroKazama.getInstance().getRepresentative().setVisible(false);
        SoheiDojima.getInstance().getRepresentative().setVisible(false);
        TaigaSaejima.getInstance().getRepresentative().setVisible(false);
        HQ.getHQList().get(0).getFacility().setVisible(false);
        HQ.getHQList().get(1).getFacility().setVisible(false);
        HQ.getHQList().get(2).getFacility().setVisible(false);
        for (int i = 0; i < 15; i++) {
            getRoot().getChildren().add(GraySoldier.getGraySoldiers().get(i).getRepresentative());
            getRoot().getChildren().add(RedSoldier.getRedSoldiers().get(i).getRepresentative());
            getRoot().getChildren().add(YellowSoldier.getYellowSoldiers().get(i).getRepresentative());
            GraySoldier.getGraySoldiers().get(i).getRepresentative().setVisible(false);
            RedSoldier.getRedSoldiers().get(i).getRepresentative().setVisible(false);
            YellowSoldier.getYellowSoldiers().get(i).getRepresentative().setVisible(false);
        }
    }

    public static void pointer(){
        selected = Hero.getHeroes().get(counter);
        getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.E){
                if(counter<Hero.getHeroes().size()-1)
                    counter++;
                else
                    counter = 0;
            }
        });
        getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.Q){
                if(counter>0)
                    counter--;
                else
                    counter = Hero.getHeroes().size()-1;
            }
        });
    }

    public static void movement(){
        GameFlow.heroMovement();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(RedSoldier i : RedSoldier.getRedSoldiers()){
                    i.march();
                }
                for(GraySoldier i : GraySoldier.getGraySoldiers()){
                    i.march();
                }
                try {
                    pointer();
                }catch (Exception e){
                    System.out.println("your stack of heros is empty");
                }


            }
        };
        timer.start();
    }



    public static void graySoldierSetting(int inX,int inY){
        int initialX = inX;
        int initialY = inY;
        int cnt  = 0;
        for(GraySoldier i : GraySoldier.getGraySoldiers()) {
            i.getRepresentative().setVisible(true);
            i.getRepresentative().setCenterX(initialX);
            i.getRepresentative().setCenterY(initialY);
            initialY += 20;
            cnt++;
            if(cnt==7){
                initialY = inY;
                initialX += 20;
            }
        }
    }

    public static void redSoldierSetting(int inX,int inY){
        int initialX = inX;
        int initialY = inY;
        int cnt  = 0;
        for(RedSoldier i : RedSoldier.getRedSoldiers()) {
            i.getRepresentative().setVisible(true);
            i.getRepresentative().setCenterX(initialX);
            i.getRepresentative().setCenterY(initialY);
            initialY += 20;
            cnt++;
            if(cnt==7){
                initialY = inY;
                initialX += 20;
            }
        }
    }

    public static void YellowSoldierSetting(int inX,int inY){
        int initialX = inX;
        int initialY = inY;
        int cnt  = 0;
        for(YellowSoldier i : YellowSoldier.getYellowSoldiers()) {
            i.getRepresentative().setVisible(true);
            i.getRepresentative().setCenterX(initialX);
            i.getRepresentative().setCenterY(initialY);
            initialY += 20;
            cnt++;
            if(cnt==7){
                initialY = inY;
                initialX += 20;
            }
        }
    }

    public void enemyMarch(Enemy enemy){
        if(distanceCalculator(enemy.getRepresentative(),presentHQ.get(0).getFacility()) <
                distanceCalculator(enemy.getRepresentative(),presentHQ.get(1).getFacility())){
           // enemy.m
        }
    }

    public double distanceCalculator(Shape shape1,Shape shape2){
        return Math.sqrt(Math.pow(shape1.getTranslateX()-shape2.getTranslateX(),2)+Math.pow(shape1.getTranslateY()-shape2.getTranslateY(),2));
    }


    public static Hero getSelected() {
        return selected;
    }

    public static LinkedList<HQ> getPresentHQ() {
        return presentHQ;
    }
}
