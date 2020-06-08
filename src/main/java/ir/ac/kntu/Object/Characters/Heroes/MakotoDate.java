package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.awt.event.MouseAdapter;

public class MakotoDate extends Hero{
    private static MakotoDate single_instance = null;

    private MakotoDate(int health, int attack, int attackRange, int fieldOfView) {
        super(health, attack, attackRange, fieldOfView);
    }

    private MakotoDate(){}

    @Override
    public void setHero() {
        MakotoDate.getInstance().setAttack(1800);
        MakotoDate.getInstance().setHealth(4500);
        MakotoDate.getInstance().setAttackRange(3*attackRangeCons);
        MakotoDate.getInstance().setFieldOfView(2*fieldOfViewCons);
        MakotoDate.getInstance().setLvl(1);
        /*MakotoDate.getInstance().setName(new Text("Makota Date  H:" + MakotoDate.getInstance().getHealth()
                + "  A:" + MakotoDate.getInstance().getAttack()));
        int nextLvl = MakotoDate.getInstance().getLvl()+1;
        MakotoDate.getInstance().setTraining(new Text("current Level: " + MakotoDate.getInstance().getLvl() + "  current Health: " +
                MakotoDate.getInstance().getHealth() + "  current Attack: " + MakotoDate.getInstance().getAttack() +
                "\nnext Level: " + MakotoDate.getInstance().getLvl()+1 + " next Health: " +
                MakotoDate.getInstance().getHealth()*104/100 + " next Attack: " + MakotoDate.getInstance().getAttack()*104/100));*/
    }


    public static MakotoDate getInstance(){
        if(single_instance == null)
            single_instance = new MakotoDate();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        MakotoDate.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        MakotoDate.getInstance().getRepresentative().setHeight(15);
        MakotoDate.getInstance().getRepresentative().setWidth(15);
    }
}
