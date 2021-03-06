package ir.ac.kntu.GamePlay;

import ir.ac.kntu.Object.Characters.Enemies.Enemy;
import ir.ac.kntu.Object.Characters.Heroes.Hero;
import javafx.scene.input.MouseEvent;
import static ir.ac.kntu.Organizer.Main.getScene;

public class GameFlow {
    private static final double speedCons = 0.5;


    public static void heroMovement() {
        getScene().addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {

            GameSetup.getSelected().getRepresentative().setX(event.getX());
            GameSetup.getSelected().getRepresentative().setY(event.getY());

            /*Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println(event.getSceneX());
                    double angle = Math.atan(Math.abs((event.getSceneX() - GameSetup.getSelected().getRepresentative().getX()) /
                            (event.getSceneY() - GameSetup.getSelected().getRepresentative().getY())));
                    if(GameSetup.getSelected().getRepresentative().getX() - event.getSceneY() > 0){
                        GameSetup.getSelected().getRepresentative().setX(GameSetup.getSelected().getRepresentative().getX() -
                                (Math.sin(angle) * speedCons * 4));
                    }
                    else{
                        GameSetup.getSelected().getRepresentative().setX(GameSetup.getSelected().getRepresentative().getX() +
                                Math.sin(angle) * speedCons * 4);
                    }
                    if ((GameSetup.getSelected().getRepresentative().getY() - event.getSceneY() > 0)) {
                        GameSetup.getSelected().getRepresentative().setY(GameSetup.getSelected().getRepresentative().getY() -
                                (Math.sin(angle) * speedCons * 4));
                    }
                    else {
                        GameSetup.getSelected().getRepresentative().setY(GameSetup.getSelected().getRepresentative().getY() +
                                Math.sin(angle) * speedCons * 4);
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                *//*    tempX.set(Math.abs(event.getSceneX() - GameSetup.getSelected().getRepresentative().getX()));
                    tempY.set(Math.abs(event.getSceneY() - GameSetup.getSelected().getRepresentative().getY()));*//*
                }
                };
            task.run();*/
        });

    }


    public static void heroAttack(Enemy enemy){
        for(Hero i : Hero.getHeroes()){
            i.attackHero(enemy);
        }
    }

    public static void enemyAttack(Hero hero){
        for(Enemy i: GameSetup.getEnemyGroup()){
            i.attackEnemy(hero);
        }
    }



    public static double getSpeedCons() {
        return speedCons;
    }

}
