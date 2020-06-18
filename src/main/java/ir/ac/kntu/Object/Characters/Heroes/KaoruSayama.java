package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;

public class KaoruSayama extends Hero{
    private static KaoruSayama single_instance = null;


    private KaoruSayama(){}

    @Override
    public void setHero() {
        KaoruSayama.getInstance().setAttack(4500);
        KaoruSayama.getInstance().setHealth(4500);
        KaoruSayama.getInstance().setAttackRange(4*attackRangeCons);
        KaoruSayama.getInstance().setFieldOfView(2*fieldOfViewCons);
        KaoruSayama.getInstance().setLvl(1);
        /*KaoruSayama.getInstance().setName(new Text("Kaoru Sayama  H:" + KaoruSayama.getInstance().getHealth()
                + "  A:" + KaoruSayama.getInstance().getAttack()));
        int nextLvl = KaoruSayama.getInstance().getLvl()+1;
        KaoruSayama.getInstance().setTraining(new Text("current Level: " + KaoruSayama.getInstance().getLvl() + "  current Health: " +
                KaoruSayama.getInstance().getHealth() + "  current Attack: " + KaoruSayama.getInstance().getAttack() +
                "\nnext Level: " + KaoruSayama.getInstance().getLvl()+1 + "next Health: " +
                KaoruSayama.getInstance().getHealth()*104/100 + " next Attack: " + KaoruSayama.getInstance().getAttack()*104/100));*/
    }


    public static KaoruSayama getInstance(){
        if(single_instance == null)
            single_instance = new KaoruSayama();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        KaoruSayama.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        KaoruSayama.getInstance().getRepresentative().setHeight(15);
        KaoruSayama.getInstance().getRepresentative().setWidth(15);
    }
}
