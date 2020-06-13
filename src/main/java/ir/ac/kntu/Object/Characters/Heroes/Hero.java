package ir.ac.kntu.Object.Characters.Heroes;

import ir.ac.kntu.GamePlay.GameFlow;
import ir.ac.kntu.GamePlay.GameSetup;
import ir.ac.kntu.Object.Characters.Characters;
import ir.ac.kntu.Object.Characters.Enemies.Enemy;
import ir.ac.kntu.Object.HQ;
import ir.ac.kntu.Object.Upgrade;
import ir.ac.kntu.Organizer.Main;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.LinkedList;


public abstract class Hero extends Characters {
    protected int fieldOfView;
    protected static final int fieldOfViewCons = 10;
    protected  int lvl;
    protected Button button = new Button(getClass().getSimpleName());
    protected Button button1 = new Button(getClass().getSimpleName());
    protected boolean chosen;
    protected Text name = new Text();
    protected Text training = new Text();
    protected Rectangle representative = new Rectangle();
    protected static LinkedList<Hero> heroes = new LinkedList<>();
    protected static LinkedList<Hero> destructedHeroes = new LinkedList<>();


    public Hero(int health, int attack, int attackRange, int fieldOfView)  {
        super(health, attack, attackRange);
        this.fieldOfView = fieldOfView;
    }

    public Hero() {}

    public abstract void setHero();

    public static void setHeroes(){
        DaigoDojima.getInstance().setHero();
        FutoshiShimano.getInstance().setHero();
        GoroMajima.getInstance().setHero();
        JiroKawara.getInstance().setHero();
        KaoruSayama.getInstance().setHero();
        MakotoDate.getInstance().setHero();
        OsamuKashiwagi.getInstance().setHero();
        RyoTakashima.getInstance().setHero();
        RyujiGoda.getInstance().setHero();
        ShintaroKazama.getInstance().setHero();
        SoheiDojima.getInstance().setHero();
        TaigaSaejima.getInstance().setHero();
        DaigoDojima.getInstance().setText();
        FutoshiShimano.getInstance().setText();
        GoroMajima.getInstance().setText();
        JiroKawara.getInstance().setText();
        KaoruSayama.getInstance().setText();
        MakotoDate.getInstance().setText();
        OsamuKashiwagi.getInstance().setText();
        RyoTakashima.getInstance().setText();
        RyujiGoda.getInstance().setText();
        ShintaroKazama.getInstance().setText();
        SoheiDojima.getInstance().setText();
        TaigaSaejima.getInstance().setText();
        DaigoDojima.getInstance().ShapeSetter();
        FutoshiShimano.getInstance().ShapeSetter();
        GoroMajima.getInstance().ShapeSetter();
        JiroKawara.getInstance().ShapeSetter();
        KaoruSayama.getInstance().ShapeSetter();
        MakotoDate.getInstance().ShapeSetter();
        OsamuKashiwagi.getInstance().ShapeSetter();
        RyoTakashima.getInstance().ShapeSetter();
        RyujiGoda.getInstance().ShapeSetter();
        ShintaroKazama.getInstance().ShapeSetter();
        SoheiDojima.getInstance().ShapeSetter();
        TaigaSaejima.getInstance().ShapeSetter();
    }

    public void UpgradeHero(){
        Upgrade.spendMoney(getLvl()*10);
        setHealth((getHealth()*104)/100);
        setAttack((getAttack()*104)/100);
        setLvl(getLvl()+1);
    }



    public void setText(){
        getName().setText( getClass().getSimpleName() + "  H:" + getHealth()
                + "  A:" + getAttack());
        int nextLvl = getLvl()+1;
        getTraining().setText("current Level: " + getLvl() + "  current Health: " +
                getHealth() + "  current Attack: " + getAttack() +
                "\nnext Level: " + nextLvl + " next Health: " +
                getHealth() * 104 / 100 + " next Attack: " + getAttack() * 104 / 100);
        Main.getRoot().getChildren().removeAll(getName(),getTraining());
        Main.getRoot().getChildren().addAll(getName(),getTraining());
    }

    public void attackHero(Enemy enemy){
        if(distance(enemy)>attackRange && distance(enemy)<fieldOfView){
            movement(enemy.getRepresentative().getCenterX(),enemy.getRepresentative().getCenterY());
        }
        else if(distance(enemy)<attackRange){
            enemy.setUnderAttack(true);
            enemy.setHealth(enemy.getHealth()-(int)(getAttack()*0.05));
        }
        enemy.getAttackingHero().add(this);
        enemy.destruction();
    }

    public void movement(double destinationX,double destinationY){
        double theta = Math.atan((destinationY - representative.getTranslateX()) / (destinationX - representative.getTranslateY()));
        if(representative.getY()>destinationY) {
            representative.setX(representative.getX() - GameFlow.getSpeedCons() * 2 * Math.sin(theta));
            representative.setY(representative.getY() - GameFlow.getSpeedCons() * 2 * Math.cos(theta));
        }
        else{
            representative.setX(representative.getX() + GameFlow.getSpeedCons() * 2 * Math.sin(theta));
            representative.setY(representative.getY() + GameFlow.getSpeedCons() * 2 * Math.cos(theta));
        }
    }


    public double distance(Enemy enemy){
        return Math.sqrt(Math.pow(getRepresentative().getX()-enemy.getRepresentative().getCenterX(),2)+
                Math.pow(getRepresentative().getY()-enemy.getRepresentative().getCenterY(),2));
    }

    @Override
    public void destruction() {
        if(this.getHealth() <= 0){
            Hero.getHeroes().get(Hero.getHeroes().indexOf(this)).getRepresentative().setVisible(false);
            destructedHeroes.add(this);
        }
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public  int getLvl() {
        return lvl;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setFieldOfView(int fieldOfView) {
        this.fieldOfView = fieldOfView;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public static LinkedList<Hero> getHeroes() {
        return heroes;
    }

    public static void setHeroes(LinkedList<Hero> heroes) {
        Hero.heroes = heroes;
    }

    public Text getName() {
        return name;
    }

    public void setName(Text name) {
        this.name = name;
    }

    public Text getTraining() {
        return training;
    }

    public void setTraining(Text training) {
        this.training = training;
    }

    public Rectangle getRepresentative() {
        return representative;
    }

    public Button getButton1() {
        return button1;
    }

    public static LinkedList<Hero> getDestructedHeroes() {
        return destructedHeroes;
    }

    public void setDestructedHeroes(LinkedList<Hero> destructedHeroes) {
        this.destructedHeroes = destructedHeroes;
    }
}
