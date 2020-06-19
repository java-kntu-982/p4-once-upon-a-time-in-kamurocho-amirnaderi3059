package ir.ac.kntu.GamePlay;

import ir.ac.kntu.Object.Characters.Enemies.*;
import ir.ac.kntu.Object.Characters.Heroes.*;
import ir.ac.kntu.Object.HQ;
import ir.ac.kntu.Object.Upgrade;
import ir.ac.kntu.Organizer.Main;
import ir.ac.kntu.Organizer.Menu;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.text.WrappedPlainView;
import java.util.LinkedList;
import java.util.TimerTask;

import static ir.ac.kntu.Organizer.Main.*;


public class GameSetup {
    private static Hero selected;
    private static int counter = 0;
    private static LinkedList<HQ> presentHQ = new LinkedList<>();
    private static LinkedList<Enemy> enemyGroup = new LinkedList<>();
    private static Text pointer = new Text();
    private static Rectangle nameKeeper = new Rectangle();
    private static AnimationTimer timer1;
    private static AnimationTimer timer2;
    private static boolean bossFlag = false;



    public static void setBasics() {
        Menu.enteringMainMenu();
        Menu.getMissions().setVisible(false);
        Menu.getOrganization().setVisible(false);
        Menu.getFortifyHQ().setVisible(false);
        Menu.getTrain().setVisible(false);
        getScene().setFill(Color.BLACK);
        getRoot().getChildren().add(nameKeeper);
        getRoot().getChildren().add(pointer);
        nameKeeper.setVisible(true);
        nameKeeper.setStroke(Color.WHITE);
        pointer.setFill(Color.WHITE);
        pointer.setX(408);
        pointer.setY(22);
        nameKeeper.setX(400);
        nameKeeper.setY(10);
        nameKeeper.setWidth(100);
        nameKeeper.setHeight(20);
        getRoot().getChildren().addAll(/*HQ.getHQList().get(0).getFacility(),HQ.getHQList().get(1).getFacility()
                ,HQ.getHQList().get(2).getFacility()BossLvl1.getInstance().getRepresentative(),
                BossLvl2.getInstance().getRepresentative(),*/ DaigoDojima.getInstance().getRepresentative(),
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
        /*HQ.getHQList().get(0).getFacility().setVisible(false);
        HQ.getHQList().get(1).getFacility().setVisible(false);
        HQ.getHQList().get(2).getFacility().setVisible(false);
        */for (int i = 0; i < 15; i++) {
            /*getRoot().getChildren().add(GraySoldier.getGraySoldiers().get(i).getRepresentative());
            getRoot().getChildren().add(RedSoldier.getRedSoldiers().get(i).getRepresentative());
            getRoot().getChildren().add(YellowSoldier.getYellowSoldiers().get(i).getRepresentative());
            getRoot().getChildren().add(GraySoldier.getGraySoldiers1().get(i).getRepresentative());
            getRoot().getChildren().add(RedSoldier.getRedSoldiers1().get(i).getRepresentative());
            getRoot().getChildren().add(YellowSoldier.getYellowSoldiers1().get(i).getRepresentative());*/
            GraySoldier.getGraySoldiers().get(i).getRepresentative().setVisible(false);
            RedSoldier.getRedSoldiers().get(i).getRepresentative().setVisible(false);
            YellowSoldier.getYellowSoldiers().get(i).getRepresentative().setVisible(false);
            GraySoldier.getGraySoldiers1().get(i).getRepresentative().setVisible(false);
            RedSoldier.getRedSoldiers1().get(i).getRepresentative().setVisible(false);
            YellowSoldier.getYellowSoldiers1().get(i).getRepresentative().setVisible(false);
        }
    }

    public static void pointer(){
        selected = Hero.getHeroes().get(counter);
        pointer.setText(selected.getClass().getSimpleName());
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
        if(selected == null){
            if(counter>0)
                counter--;
            else
                counter = Hero.getHeroes().size()-1;
        }
    }

    public static void enemyStrike(){
        final int[] waveCnt = {0};
        timer1 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (Enemy i : enemyGroup) {
                    i.march();
                    if(waveCnt[0]==8)
                        System.out.println("boss1");
                    GameFlow.heroAttack(i);
                    //System.out.println(enemyGroup.size());
                }
                for (Enemy i : Enemy.getDestructedEnemies()) {
                    enemyGroup.remove(i);
                    getRoot().getChildren().remove(i.getRepresentative());
                }
                if (enemyGroup.size() == 30) {
                    Enemy.getDestructedEnemies().clear();
                }
                if (waveCnt[0] == 7&& !bossFlag&&GameSetup.getEnemyGroup().isEmpty()) {
                    System.out.println("boss");
                    Levels.firstBoss();
                    waveCnt[0]++;
                    bossFlag=true;
                }

                if (GameSetup.getEnemyGroup().isEmpty() && waveCnt[0]<7) {
                    waveCnt[0]++;
                    if(waveCnt[0]>=1)
                        Upgrade.earnMoney();
                    Levels.waveHandler();
                    System.out.println(getEnemyGroup().size());
                    try{
                        Enemy.setEnemies();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if (waveCnt[0] == 8&&enemyGroup.isEmpty()) {
                    for(int i=0;i<3;i++){
                        Upgrade.earnMoney();
                    }
                    waveCnt[0]=0;
                    loseOrWin(true);
                    timer2.stop();
                    timer1.stop();
                }
            }
        };
        timer1.start();

    }

    public static void heroStrike()  {
        GameFlow.heroMovement();
        timer2 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(Hero i: Hero.getHeroes()){
                    GameFlow.enemyAttack(i);
                    //System.out.println(i.getHealth());
                }
                for(Hero i : Hero.getDestructedHeroes()){
                    Hero.getHeroes().remove(i);
                }
                if(Hero.getHeroes().isEmpty()){
                    loseOrWin(false);
                    timer1.stop();
                    timer2.stop();
                }
                try {
                    pointer();
                }catch (Exception e){
                    //System.out.println("your stack of heros is empty");
                }


            }
        };
        timer2.start();
    }



    public static void graySoldierSetting(int inX,int inY,LinkedList<GraySoldier> soldiers){
        int initialX = inX;
        int initialY = inY;
        int cnt  = 0;
        for(GraySoldier i : soldiers) {
            getRoot().getChildren().add(i.getRepresentative());
            i.getRepresentative().setCenterX(initialX);
            i.getRepresentative().setCenterY(initialY);
            initialY += 20;
            cnt++;
            if(cnt==7){
                initialY = inY;
                initialX += 20;
            }
            enemyGroup.add(i);
            i.getRepresentative().setVisible(true);
        }
    }

    public static void redSoldierSetting(int inX,int inY,LinkedList<RedSoldier> soldiers){
        int initialX = inX;
        int initialY = inY;
        int cnt  = 0;
        for(RedSoldier i : soldiers) {
            getRoot().getChildren().add(i.getRepresentative());
            i.getRepresentative().setVisible(true);
            i.getRepresentative().setCenterX(initialX);
            i.getRepresentative().setCenterY(initialY);
            initialY += 20;
            cnt++;
            if(cnt==7){
                initialY = inY;
                initialX += 20;
            }
            enemyGroup.add(i);
        }
    }

    public static void YellowSoldierSetting(int inX,int inY, LinkedList<YellowSoldier> soldiers){
        int initialX = inX;
        int initialY = inY;
        int cnt  = 0;
        for(YellowSoldier i : soldiers) {
            getRoot().getChildren().add(i.getRepresentative());
            i.getRepresentative().setVisible(true);
            i.getRepresentative().setCenterX(initialX);
            i.getRepresentative().setCenterY(initialY);
            initialY += 20;
            cnt++;
            if(cnt==7){
                initialY = inY;
                initialX += 20;
            }
            enemyGroup.add(i);
        }
    }

    public static void bossSetting(int inX,int inY,Enemy boss){
        getRoot().getChildren().add(boss.getRepresentative());
        boss.getRepresentative().setVisible(true);
        boss.getRepresentative().setCenterY(inY);
        boss.getRepresentative().setCenterX(inX);
        enemyGroup.add(boss);
    }


    public static void loseOrWin(boolean status) {
        timer1.stop();
        timer2.stop();
        getRoot().getChildren().remove(nameKeeper);
        getRoot().getChildren().remove(pointer);
        try {
            getRoot().getChildren().removeAll(/*HQ.getHQList().get(0).getFacility(),HQ.getHQList().get(1).getFacility()
                ,HQ.getHQList().get(2).getFacility()*/BossLvl1.getInstance().getRepresentative(),
                    BossLvl2.getInstance().getRepresentative(), DaigoDojima.getInstance().getRepresentative(),
                    FutoshiShimano.getInstance().getRepresentative(), GoroMajima.getInstance().getRepresentative(),
                    JiroKawara.getInstance().getRepresentative(), KaoruSayama.getInstance().getRepresentative(),
                    MakotoDate.getInstance().getRepresentative(), OsamuKashiwagi.getInstance().getRepresentative(),
                    RyoTakashima.getInstance().getRepresentative(), RyujiGoda.getInstance().getRepresentative(),
                    ShintaroKazama.getInstance().getRepresentative(), SoheiDojima.getInstance().getRepresentative(),
                    TaigaSaejima.getInstance().getRepresentative());
        }catch(Exception ignored){}

        for (int i = 0; i < 15; i++) {
            getRoot().getChildren().remove(GraySoldier.getGraySoldiers().get(i).getRepresentative());
            getRoot().getChildren().remove(RedSoldier.getRedSoldiers().get(i).getRepresentative());
            getRoot().getChildren().remove(YellowSoldier.getYellowSoldiers().get(i).getRepresentative());
            getRoot().getChildren().remove(GraySoldier.getGraySoldiers1().get(i).getRepresentative());
            getRoot().getChildren().remove(RedSoldier.getRedSoldiers1().get(i).getRepresentative());
            getRoot().getChildren().remove(YellowSoldier.getYellowSoldiers1().get(i).getRepresentative());
            GraySoldier.getGraySoldiers().get(i).getRepresentative().setVisible(false);
            GraySoldier.getGraySoldiers1().get(i).getRepresentative().setVisible(false);
            RedSoldier.getRedSoldiers().get(i).getRepresentative().setVisible(false);
            RedSoldier.getRedSoldiers1().get(i).getRepresentative().setVisible(false);
            YellowSoldier.getYellowSoldiers().get(i).getRepresentative().setVisible(false);
            YellowSoldier.getYellowSoldiers1().get(i).getRepresentative().setVisible(false);

        }
        for(Hero i : Hero.getHeroes()){
            i.setChosen(false);
        }
        Hero.getHeroes().clear();
        enemyGroup.clear();
        for(int i=0;i<3;i++){
            getRoot().getChildren().remove(HQ.getHQList().get(i).getFacility());
            HQ.getHQList().get(i).getFacility().setVisible(false);
        }
        Text informer = new Text();
        informer.setX(450);
        informer.setY(320);
        informer.setFont(Font.font("verdana",FontPosture.ITALIC,32));
        informer.setFill(Color.WHITE);
        if(status){
            informer.setText("YOU WON!");
        }else {
            informer.setText("YOU LOST!");
        }
        Main.getRoot().getChildren().add(informer);
        informer.setVisible(true);
        Timeline statusRevealed = new Timeline(new KeyFrame(Duration.ZERO), new KeyFrame(Duration.seconds(3)));
        statusRevealed.setCycleCount(1);
        statusRevealed.play();
        statusRevealed.setOnFinished(actionEvent -> {
            Main.getRoot().getChildren().remove(informer);
        });
        getScene().setFill(Color.rgb(129,50,80));
        Menu.enteringMainMenu();
        Hero.setHeroes();
        HQ.setHQ();
        Menu menu = new Menu();
        menu.setButtons();
    }






    public static Hero getSelected() {
        return selected;
    }

    public static LinkedList<HQ> getPresentHQ() {
        return presentHQ;
    }

    public static LinkedList<Enemy> getEnemyGroup() {
        return enemyGroup;
    }

}
