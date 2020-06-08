package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javax.swing.plaf.FontUIResource;

public class FutoshiShimano extends Hero {
    private static FutoshiShimano single_instance = null;

    private FutoshiShimano(int health, int attack, int attackRange, int fieldOfView) {
        super(health, attack, attackRange, fieldOfView);
    }

    private FutoshiShimano(){}

    @Override
    public void setHero() {
        FutoshiShimano.getInstance().setAttack(4000);
        FutoshiShimano.getInstance().setHealth(4200);
        FutoshiShimano.getInstance().setAttackRange(attackRangeCons);
        FutoshiShimano.getInstance().setFieldOfView(2*fieldOfViewCons);
        FutoshiShimano.getInstance().setLvl(1);

    }


    public static FutoshiShimano getInstance(){
        if(single_instance == null)
            single_instance = new FutoshiShimano();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        FutoshiShimano.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        FutoshiShimano.getInstance().getRepresentative().setHeight(15);
        FutoshiShimano.getInstance().getRepresentative().setWidth(15);
    }
}
