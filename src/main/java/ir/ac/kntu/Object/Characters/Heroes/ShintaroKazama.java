package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;

public class ShintaroKazama extends Hero {
    private static ShintaroKazama single_instance = null;



    private ShintaroKazama(){}

    @Override
    public void setHero() {
        ShintaroKazama.getInstance().setAttack(4500);
        ShintaroKazama.getInstance().setHealth(4500);
        ShintaroKazama.getInstance().setAttackRange(attackRangeCons);
        ShintaroKazama.getInstance().setFieldOfView(2*fieldOfViewCons);
        ShintaroKazama.getInstance().setLvl(1);
        /*ShintaroKazama.getInstance().setName(new Text("Shintaro Kazama  H:" + ShintaroKazama.getInstance().getHealth()
                + "  A:" + ShintaroKazama.getInstance().getAttack()));
        int nextLvl = ShintaroKazama.getInstance().getLvl()+1;
        ShintaroKazama.getInstance().setTraining(new Text("current Level: " + ShintaroKazama.getInstance().getLvl() + "  current Health: " +
                ShintaroKazama.getInstance().getHealth() + "  current Attack: " + ShintaroKazama.getInstance().getAttack() +
                "\nnext Level: " + ShintaroKazama.getInstance().getLvl()+1 + " next Health: " +
                ShintaroKazama.getInstance().getHealth()*104/100 + " next Attack: " + ShintaroKazama.getInstance().getAttack()*104/100));*/
    }


    public static ShintaroKazama getInstance(){
        if(single_instance == null)
            single_instance = new ShintaroKazama();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        ShintaroKazama.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        ShintaroKazama.getInstance().getRepresentative().setHeight(15);
        ShintaroKazama.getInstance().getRepresentative().setWidth(15);
    }
}
