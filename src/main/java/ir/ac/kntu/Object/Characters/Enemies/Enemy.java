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

    public Enemy(){

    }

    public static void setEnemies(){
        enemySetting(GraySoldier.getGraySoldiers(),RedSoldier.getRedSoldiers(),YellowSoldier.getYellowSoldiers());
        enemySetting(GraySoldier.getGraySoldiers1(),RedSoldier.getRedSoldiers1(),YellowSoldier.getYellowSoldiers1());
        /*for(int i=0; i<15;i++) {
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
        }*/
    }

    public static void bossSetting(){
        BossLvl1.getInstance().setEnemy();
        BossLvl2.getInstance().setEnemy();
        BossLvl2.getInstance().ShapeSetter();
        BossLvl1.getInstance().ShapeSetter();
        BossLvl1.getInstance().setSpeed(2*GameFlow.getSpeedCons());
        BossLvl1.getInstance().setSpeed(2*GameFlow.getSpeedCons());
    }



    public static void enemySetting(LinkedList<GraySoldier> gray,LinkedList<RedSoldier> red , LinkedList<YellowSoldier> yellow){
        gray.clear();
        red.clear();
        yellow.clear();
        for (int i = 0; i < 15; i++) {
            GraySoldier graySample = new GraySoldier(1000, 2000, attackRangeCons);
            graySample.setSpeed(GameFlow.getSpeedCons() * 2);
            graySample.ShapeSetter();
            RedSoldier redSample = new RedSoldier(1000, 500, attackRangeCons);
            redSample.setSpeed(GameFlow.getSpeedCons() * 3);
            redSample.ShapeSetter();
            YellowSoldier yellowSample = new YellowSoldier(800, 1800, 2 * attackRangeCons);
            yellowSample.setSpeed(GameFlow.getSpeedCons() * 1);
            yellowSample.ShapeSetter();
            gray.add(graySample);
            red.add(redSample);
            yellow.add(yellowSample);
            bossSetting();
        }
    }





    public Circle getRepresentative() {
        return representative;
    }

    public void setUnderAttack(boolean underAttack) {
        this.underAttack = underAttack;
    }

    public void action(double destinationX,double destinationY){
        double theta = Math.atan((destinationX-getRepresentative().getCenterX())/
                (destinationY-getRepresentative().getCenterY()));
        movement(destinationY, theta);
    }

    @Override
    public void movement(double destinationY, double theta) {
        if(getRepresentative().getCenterY()>destinationY){
            getRepresentative().setCenterX(getRepresentative().getCenterX() - getSpeed() * Math.sin(theta));
            getRepresentative().setCenterY(getRepresentative().getCenterY() - getSpeed() * Math.cos(theta));
            /*System.out.println(getRepresentative().getCenterX());
            System.out.println(getRepresentative().getCenterY());*/
        } else{
            getRepresentative().setCenterX(getRepresentative().getCenterX() + getSpeed() * Math.sin(theta));
            getRepresentative().setCenterY(getRepresentative().getCenterY() + getSpeed() * Math.cos(theta));
            System.out.println(getRepresentative().getCenterX());
            System.out.println(getRepresentative().getCenterY());
        }
    }

    public void action(double destinationX,double destinationY,HQ hq){
        double theta = Math.atan((destinationX-getRepresentative().getCenterX())/
                (destinationY-getRepresentative().getCenterY()));
        if(Math.sqrt((destinationX-getRepresentative().getCenterX())*(destinationX-getRepresentative().getCenterX()))<attackRange){
            damageBuilding(hq);
        }
        else {
            movement(destinationY, theta);
        }
    }

    public void damageBuilding(HQ hq) {
        hq.setDurability((int) (hq.getDurability()-(getAttack()*0.0001)));
        hq.destruction();
        if(hq.getDurability()<=0){

        }
    }

    public void march() {
        if(!underAttack) {
            if(GameSetup.getPresentHQ().size()==2){
                //System.out.println(GameSetup.getPresentHQ().get(0).getDurability()+ "\n"+ GameSetup.getPresentHQ().get(1).getDurability() );
                if (distanceHq(GameSetup.getPresentHQ().get(0)) > distanceHq(GameSetup.getPresentHQ().get(1))) {
                    this.action(GameSetup.getPresentHQ().get(1).getFacility().getCenterX(),
                            GameSetup.getPresentHQ().get(1).getFacility().getCenterY(), GameSetup.getPresentHQ().get(1));
                } else {
                    this.action(GameSetup.getPresentHQ().get(0).getFacility().getCenterX(),
                            GameSetup.getPresentHQ().get(0).getFacility().getCenterY(), GameSetup.getPresentHQ().get(0));
                }
            }else if(GameSetup.getPresentHQ().size()==1){
                //System.out.println(GameSetup.getPresentHQ().get(0).getDurability());
                action(GameSetup.getPresentHQ().get(0).getFacility().getCenterX(),
                        GameSetup.getPresentHQ().get(0).getFacility().getCenterY(),GameSetup.getPresentHQ().get(0));
            }else {
                GameSetup.loseOrWin(false);
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
        }
    }

    public void attackEnemy(Hero hero){
        if(underAttack){
            if(this.distanceHero(hero)<=attackRange){
                System.out.println("*");
                hero.setHealth((int) (hero.getHealth()-getAttack()*0.005));
            }else{
                action(hero.getRepresentative().getX(),hero.getRepresentative().getY());
            }
            hero.destruction();
            if(attackingHero.isEmpty()){
                march();
            }
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

    public static LinkedList<Enemy> getDestructedEnemies() {
        return destructedEnemies;
    }




}
