package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SoheiDojima extends Hero{
    private static SoheiDojima single_instance = null;

    private SoheiDojima(int health, int attack, int attackRange, int fieldOfView) {
        super(health, attack, attackRange, fieldOfView);
    }

    private SoheiDojima(){}

    @Override
    public void setHero() {
        SoheiDojima.getInstance().setAttack(3000);
        SoheiDojima.getInstance().setHealth(3000);
        SoheiDojima.getInstance().setAttackRange(attackRangeCons);
        SoheiDojima.getInstance().setFieldOfView(fieldOfViewCons);
        SoheiDojima.getInstance().setLvl(1);
        /*SoheiDojima.getInstance().setName(new Text("Sohei Dojima  H:" + SoheiDojima.getInstance().getHealth()
                + "  A:" + SoheiDojima.getInstance().getAttack()));
        int nextLvl = SoheiDojima.getInstance().getLvl()+1;
        SoheiDojima.getInstance().setTraining(new Text("current Level: " + SoheiDojima.getInstance().getLvl() + "  current Health: " +
                SoheiDojima.getInstance().getHealth() + "  current Attack: " + SoheiDojima.getInstance().getAttack() +
                "\nnext Level: " + SoheiDojima.getInstance().getLvl()+1 + "     next Health: " +
                SoheiDojima.getInstance().getHealth()*104/100 + "next Attack: " + SoheiDojima.getInstance().getAttack()*104/100));*/
    }


    public static SoheiDojima getInstance(){
        if(single_instance == null)
            single_instance = new SoheiDojima();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        SoheiDojima.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        SoheiDojima.getInstance().getRepresentative().setHeight(15);
        SoheiDojima.getInstance().getRepresentative().setWidth(15);
    }
}
