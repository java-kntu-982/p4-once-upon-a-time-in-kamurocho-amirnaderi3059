package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class JiroKawara extends Hero {
    private static JiroKawara single_instance = null;

    private JiroKawara(int health, int attack, int attackRange, int fieldOfView) {
        super(health, attack, attackRange, fieldOfView);
    }

    private JiroKawara(){}

    @Override
    public void setHero() {
        JiroKawara.getInstance().setAttack(3200);
        JiroKawara.getInstance().setHealth(5500);
        JiroKawara.getInstance().setAttackRange(3*attackRangeCons);
        JiroKawara.getInstance().setFieldOfView(3*fieldOfViewCons);
        JiroKawara.getInstance().setLvl(1);
        /*JiroKawara.getInstance().setName(new Text("Jiro Kawara  H:" + JiroKawara.getInstance().getHealth()
                + "  A:" + JiroKawara.getInstance().getAttack()));
        int nextLvl = JiroKawara.getInstance().getLvl()+1;
        JiroKawara.getInstance().setTraining(new Text("current Level: " + JiroKawara.getInstance().getLvl() + "  current Health: " +
                JiroKawara.getInstance().getHealth() + "  current Attack: " + JiroKawara.getInstance().getAttack() +
                "\nnext Level: " + JiroKawara.getInstance().getLvl()+1 + " next Health: " +
                JiroKawara.getInstance().getHealth()*104/100 + " next Attack: " + JiroKawara.getInstance().getAttack()*104/100));*/
    }


    public static JiroKawara getInstance(){
        if(single_instance == null)
            single_instance = new JiroKawara();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        JiroKawara.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        JiroKawara.getInstance().getRepresentative().setHeight(15);
        JiroKawara.getInstance().getRepresentative().setWidth(15);
    }
}
