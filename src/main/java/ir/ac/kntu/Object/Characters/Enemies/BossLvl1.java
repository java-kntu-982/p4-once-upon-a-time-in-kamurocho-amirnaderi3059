package ir.ac.kntu.Object.Characters.Enemies;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BossLvl1 extends Enemy {

    private static BossLvl1 single_instance = null;
    private Circle representative = new Circle();

    private BossLvl1(){
        super();
    }

    public void setEnemy() {
        BossLvl1.getInstance().setAttack(5000);
        BossLvl1.getInstance().setHealth(8000);
        BossLvl1.getInstance().ShapeSetter();
        BossLvl1.getInstance().setAttackRange(attackRangeCons);
    }

    public static BossLvl1 getInstance() {
        if(single_instance == null) {
            single_instance = new BossLvl1();
        }
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        representative.setFill(Color.DARKGREEN);
        representative.setRadius(10);
    }

    public Circle getRepresentative() {
        return representative;
    }

}
