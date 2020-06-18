package ir.ac.kntu.Object.Characters.Enemies;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BossLvl2 extends Enemy {
    private static BossLvl2 single_instance = null;
    private Circle representative = new Circle();

    private BossLvl2(){
        super();
    }


    public void setEnemy() {
        BossLvl2.getInstance().setAttack(12000);
        BossLvl2.getInstance().setHealth(20000);
        BossLvl2.getInstance().ShapeSetter();
        BossLvl2.getInstance().setAttackRange(attackRangeCons);
    }

    public static BossLvl2 getInstance(){
        if(single_instance == null) {
            single_instance = new BossLvl2();
        }
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        representative.setFill(Color.DARKBLUE);
        representative.setRadius(10);
    }

    public Circle getRepresentative() {
        return representative;
    }

}
