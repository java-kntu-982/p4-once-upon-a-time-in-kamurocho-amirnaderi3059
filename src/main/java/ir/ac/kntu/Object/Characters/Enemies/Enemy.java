package ir.ac.kntu.Object.Characters.Enemies;

import ir.ac.kntu.GamePlay.GameSetup;
import ir.ac.kntu.GamePlay.GameFlow;
import ir.ac.kntu.Object.Characters.Characters;
import ir.ac.kntu.Object.HQ;
import javafx.scene.shape.Circle;

public abstract class Enemy extends Characters {
    protected Circle representative = new Circle();
    protected boolean underAttack;


    public Enemy(int health, int attack, int attackRange) {
        super(health, attack, attackRange);
    }

    public Enemy() throws CloneNotSupportedException {

    }

    public static void setEnemies() throws CloneNotSupportedException {
        for(int i=0; i<15;i++) {
            GraySoldier graySample = new GraySoldier(1000, 800, attackRangeCons);
            graySample.ShapeSetter();
            RedSoldier redSample = new RedSoldier(1000, 500, attackRangeCons);
            redSample.ShapeSetter();
            YellowSoldier yellowSample = new YellowSoldier(800, 1800, 2 * attackRangeCons);
            yellowSample.ShapeSetter();
            GraySoldier.getGraySoldiers().add(graySample);
            RedSoldier.getRedSoldiers().add(redSample);
            YellowSoldier.getYellowSoldiers().add(yellowSample);
        }
    }

    public Circle getRepresentative() {
        return representative;
    }

    @Override
    public void movement(double destinationX,double destinationY){
        double theta = Math.atan(Math.abs(destinationY-representative.getCenterX()/destinationX-representative.getCenterY()));
        representative.setCenterX(representative.getCenterX()+ GameFlow.getSpeedCons()*2*Math.sin(theta));
        representative.setCenterY(representative.getCenterY()+ GameFlow.getSpeedCons()*2*Math.cos(theta));
    }

    public void march(){
        if(distance(GameSetup.getPresentHQ().get(0))>distance(GameSetup.getPresentHQ().get(1))) {
            this.movement(GameSetup.getPresentHQ().get(1).getFacility().getCenterX(), GameSetup.getPresentHQ().get(1).getFacility().getCenterY());
        }
        else {
            this.movement(GameSetup.getPresentHQ().get(0).getFacility().getCenterX(), GameSetup.getPresentHQ().get(0).getFacility().getCenterY());
        }
    }

    public double distance(HQ hq){
        return Math.sqrt(Math.pow(hq.getFacility().getCenterX()-getRepresentative().getCenterX(),2)+Math.pow(hq.getFacility().getCenterY()-getRepresentative().getCenterY(),2));
    }

    //public abstract void setEnemy() throws CloneNotSupportedException;
}
