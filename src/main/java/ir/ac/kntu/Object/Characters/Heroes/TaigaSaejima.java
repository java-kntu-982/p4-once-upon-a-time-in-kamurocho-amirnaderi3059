package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.time.temporal.TemporalAccessor;

public class TaigaSaejima extends Hero{
    private static TaigaSaejima single_instance = null;

    private TaigaSaejima(int health, int attack, int attackRange, int fieldOfView) {
        super(health, attack, attackRange, fieldOfView);
    }

    private TaigaSaejima(){}

    @Override
    public void setHero() {
        TaigaSaejima.getInstance().setAttack(5000);
        TaigaSaejima.getInstance().setHealth(7000);
        TaigaSaejima.getInstance().setAttackRange(attackRangeCons);
        TaigaSaejima.getInstance().setFieldOfView(fieldOfViewCons);
        TaigaSaejima.getInstance().setLvl(1);
        /*TaigaSaejima.getInstance().setName(new Text("Taiga Saejima  H:" + TaigaSaejima.getInstance().getHealth()
                + "  A:" + TaigaSaejima.getInstance().getAttack()));
        int nextLvl = TaigaSaejima.getInstance().getLvl()+1;
        TaigaSaejima.getInstance().setTraining(new Text("current Level: " + TaigaSaejima.getInstance().getLvl() +
                "  current Health: " + TaigaSaejima.getInstance().getHealth() + "  current Attack: " +
                TaigaSaejima.getInstance().getAttack() + "\nnext Level: " + nextLvl + " next Health: " +
                TaigaSaejima.getInstance().getHealth()*104/100 + " next Attack: " + TaigaSaejima.getInstance().getAttack()*104/100));*/
    }


    public static TaigaSaejima getInstance(){
        if(single_instance == null)
            single_instance = new TaigaSaejima();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        TaigaSaejima.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        TaigaSaejima.getInstance().getRepresentative().setHeight(15);
        TaigaSaejima.getInstance().getRepresentative().setWidth(15);
    }
}
