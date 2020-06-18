package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;


public class RyoTakashima extends Hero {
    private static RyoTakashima single_instance = null;



    private RyoTakashima(){}

    @Override
    public void setHero() {
        RyoTakashima.getInstance().setAttack(3800);
        RyoTakashima.getInstance().setHealth(3600);
        RyoTakashima.getInstance().setAttackRange(attackRangeCons);
        RyoTakashima.getInstance().setFieldOfView(fieldOfViewCons);
        RyoTakashima.getInstance().setLvl(1);
        /*RyoTakashima.getInstance().setName(new Text("Ryo Takashima  H:" + RyoTakashima.getInstance().getHealth()
                + "  A:" + RyoTakashima.getInstance().getAttack()));
        int nextLvl = RyoTakashima.getInstance().getLvl()+1;
        RyoTakashima.getInstance().setTraining(new Text("current Level: " + RyoTakashima.getInstance().getLvl() + "  current Health: " +
                RyoTakashima.getInstance().getHealth() + "  current Attack: " + RyoTakashima.getInstance().getAttack() +
                "\nnext Level: " + RyoTakashima.getInstance().getLvl()+1 + " next Health: " +
                RyoTakashima.getInstance().getHealth()*104/100 + " next Attack: " + RyoTakashima.getInstance().getAttack()*104/100));*/
    }


    public static RyoTakashima getInstance(){
        if(single_instance == null)
            single_instance = new RyoTakashima();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        RyoTakashima.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        RyoTakashima.getInstance().getRepresentative().setHeight(15);
        RyoTakashima.getInstance().getRepresentative().setWidth(15);
    }
}
