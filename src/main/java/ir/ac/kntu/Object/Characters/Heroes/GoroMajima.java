package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;


public class GoroMajima extends Hero {
    private static GoroMajima single_instance = null;


    private GoroMajima(){}

    @Override
    public void setHero() {
        GoroMajima.getInstance().setAttack(4500);
        GoroMajima.getInstance().setHealth(4000);
        GoroMajima.getInstance().setAttackRange(4*attackRangeCons);
        GoroMajima.getInstance().setFieldOfView(3*fieldOfViewCons);
        GoroMajima.getInstance().setLvl(1);
        /*GoroMajima.getInstance().setName(new Text("Goro Majima  H:" + GoroMajima.getInstance().getHealth()
                + "  A:" + GoroMajima.getInstance().getAttack()));
        int nextLvl = GoroMajima.getInstance().getLvl()+1;
        GoroMajima.getInstance().setTraining(new Text("current Level: " + GoroMajima.getInstance().getLvl() + "  current Health: " +
                GoroMajima.getInstance().getHealth() + "  current Attack: " + GoroMajima.getInstance().getAttack() +
                "\nnext Level: " + GoroMajima.getInstance().getLvl()+1 + " next Health: " +
                GoroMajima.getInstance().getHealth()*104/100 + " next Attack: " + GoroMajima.getInstance().getAttack()*104/100));*/
    }


    public static GoroMajima getInstance(){
        if(single_instance == null)
            single_instance = new GoroMajima();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        GoroMajima.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        GoroMajima.getInstance().getRepresentative().setHeight(15);
        GoroMajima.getInstance().getRepresentative().setWidth(15);
    }
}
