package ir.ac.kntu.Object.Characters.Enemies;

import ir.ac.kntu.GamePlay.GameSetup;
import ir.ac.kntu.GamePlay.GameFlow;
import ir.ac.kntu.Object.Characters.Characters;
import ir.ac.kntu.Object.Characters.Heroes.Hero;
import ir.ac.kntu.Object.HQ;
import javafx.scene.shape.Circle;

import java.util.LinkedList;

public abstract class Enemy extends Characters {
    protected Circle representative = new Circle();
    protected boolean underAttack;
    protected double speed;
    protected LinkedList<Hero> attackingHero = new LinkedList<>();
    protected static LinkedList<Enemy> destructedEnemies = new LinkedList<>();


    public Enemy(int health, int attack, int attackRange) {
        super(health, attack, attackRange);
    }

    public Enemy() throws CloneNotSupportedException {

    }

    public static void setEnemies() throws CloneNotSupportedException {
        for(int i=0; i<15;i++) {
            GraySoldier graySample = new GraySoldier(1000, 800, attackRangeCons);
            graySample.setSpeed(GameFlow.getSpeedCons()*2);
            graySample.ShapeSetter();
            RedSoldier redSample = new RedSoldier(1000, 500, attackRangeCons);
            redSample.setSpeed(GameFlow.getSpeedCons()*3);
            redSample.ShapeSetter();
            YellowSoldier yellowSample = new YellowSoldier(800, 1800, 2 * attackRangeCons);
            yellowSample.setSpeed(GameFlow.getSpeedCons()*1);
            yellowSample.ShapeSetter();
            GraySoldier.getGraySoldiers().add(graySample);
            RedSoldier.getRedSoldiers().add(redSample);
            YellowSoldier.getYellowSoldiers().add(yellowSample);
        }
    }

    public Circle getRepresentative() {
        return representative;
    }

    public boolean isUnderAttack() {
        return underAttack;
    }

    public void setUnderAttack(boolean underAttack) {
        this.underAttack = underAttack;
    }

    @Override
    public void movement(double destinationX,double destinationY){
        double theta = Math.atan((destinationX-getRepresentative().getCenterX())/
                (destinationY-getRepresentative().getCenterY()));
        if(getRepresentative().getCenterY()>destinationY){
            getRepresentative().setCenterX(getRepresentative().getCenterX() - getSpeed() * Math.sin(theta));
            getRepresentative().setCenterY(getRepresentative().getCenterY() - getSpeed() * Math.cos(theta));
        } else{
            getRepresentative().setCenterX(getRepresentative().getCenterX() + getSpeed() * Math.sin(theta));
            getRepresentative().setCenterY(getRepresentative().getCenterY() + getSpeed() * Math.cos(theta));
        }
    }

    public void march(){
        if(!underAttack) {
            if (distanceHq(GameSetup.getPresentHQ().get(0)) > distanceHq(GameSetup.getPresentHQ().get(1))) {
                this.movement(GameSetup.getPresentHQ().get(1).getFacility().getCenterX(),
                        GameSetup.getPresentHQ().get(1).getFacility().getCenterY());
            } else {
                this.movement(GameSetup.getPresentHQ().get(0).getFacility().getCenterX(),
                        GameSetup.getPresentHQ().get(0).getFacility().getCenterY());
            }
        }
    }

    public double distanceHq(HQ hq){
        return Math.sqrt(Math.pow(hq.getFacility().getCenterX()-getRepresentative().getCenterX(),2)+
                Math.pow(hq.getFacility().getCenterY()-getRepresentative().getCenterY(),2));
    }

    public double distanceHero(Hero hero){
        return Math.sqrt(Math.pow(hero.getRepresentative().getX()-getRepresentative().getCenterX(),2)+
                Math.pow(hero.getRepresentative().getY()-getRepresentative().getCenterY(),2));
    }

    @Override
    public void destruction() {
        if(this.getHealth() <= 0){
            destructedEnemies.add(this);
            representative.setVisible(false);
        }
    }

    public void attackEnemy(Hero hero){
        LinkedList<Hero> deadHeroes = new LinkedList<>();
        if(underAttack){
            if(this.distanceHero(hero)<=attackRange){
                System.out.println("*");
                hero.setHealth((int) (hero.getHealth()-getAttack()*0.05));
            }else{
                if(this.distanceHero(hero)>attackRange)
                    movement(hero.getRepresentative().getX(),hero.getRepresentative().getY());
            }
            hero.destruction();
        }
    }


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public LinkedList<Hero> getAttackingHero() {
        return attackingHero;
    }

    public void setAttackingHero(LinkedList<Hero> attackingHero) {
        this.attackingHero = attackingHero;
    }

    public static LinkedList<Enemy> getDestructedEnemies() {
        return destructedEnemies;
    }

    public void setDestructedEnemies(LinkedList<Enemy> destructedEnemies) {
        this.destructedEnemies = destructedEnemies;
    }
}
