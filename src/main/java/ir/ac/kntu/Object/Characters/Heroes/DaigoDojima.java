package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class DaigoDojima extends Hero {

    private static DaigoDojima single_instance = null;

    private DaigoDojima(int health, int attack, int attackRange, int fieldOfView) {
        super(health, attack, attackRange, fieldOfView);
    }

    private DaigoDojima(){}

    @Override
    public void setHero(){
        DaigoDojima.getInstance().setAttack(4000);
        DaigoDojima.getInstance().setHealth(4000);
        DaigoDojima.getInstance().setAttackRange(2*attackRangeCons);
        DaigoDojima.getInstance().setFieldOfView(3*fieldOfViewCons);
        DaigoDojima.getInstance().setLvl(1);
    }


    public static DaigoDojima getInstance(){
        if(single_instance == null)
            single_instance = new DaigoDojima();
        return single_instance;
    }


    @Override
    public void ShapeSetter() {
        DaigoDojima.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        DaigoDojima.getInstance().getRepresentative().setHeight(15);
        DaigoDojima.getInstance().getRepresentative().setWidth(15);
    }
}
