package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.ObjectStreamClass;

public class OsamuKashiwagi extends Hero {
    private static OsamuKashiwagi single_instance = null;

    private OsamuKashiwagi(int health, int attack, int attackRange, int fieldOfView) {
        super(health, attack, attackRange, fieldOfView);
    }

    private OsamuKashiwagi(){}

    @Override
    public void setHero() {
        OsamuKashiwagi.getInstance().setAttack(3000);
        OsamuKashiwagi.getInstance().setHealth(4000);
        OsamuKashiwagi.getInstance().setAttackRange(attackRangeCons);
        OsamuKashiwagi.getInstance().setFieldOfView(2*fieldOfViewCons);
        OsamuKashiwagi.getInstance().setLvl(1);
        /*OsamuKashiwagi.getInstance().setName(new Text("Osamu Kashiwagi  H:" + OsamuKashiwagi.getInstance().getHealth()
                + "  A:" + OsamuKashiwagi.getInstance().getAttack()));
        int nextLvl = OsamuKashiwagi.getInstance().getLvl()+1;
        OsamuKashiwagi.getInstance().setTraining(new Text("current Level: " + OsamuKashiwagi.getInstance().getLvl() + "  current Health: " +
                OsamuKashiwagi.getInstance().getHealth() + "  current Attack: " + OsamuKashiwagi.getInstance().getAttack() +
                "\nnext Level: " + OsamuKashiwagi.getInstance().getLvl()+1 + " next Health: " +
                OsamuKashiwagi.getInstance().getHealth()*104/100 + " next Attack: " + OsamuKashiwagi.getInstance().getAttack()*104/100));*/
    }


    public static OsamuKashiwagi getInstance(){
        if(single_instance == null)
            single_instance = new OsamuKashiwagi();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        OsamuKashiwagi.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        OsamuKashiwagi.getInstance().getRepresentative().setHeight(15);
        OsamuKashiwagi.getInstance().getRepresentative().setWidth(15);
    }
}
