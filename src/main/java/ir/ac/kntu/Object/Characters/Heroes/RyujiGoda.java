package ir.ac.kntu.Object.Characters.Heroes;

import javafx.scene.paint.Color;

public class RyujiGoda extends Hero{
    private static RyujiGoda single_instance = null;


    private RyujiGoda() {
    }

    @Override
    public void setHero() {
        RyujiGoda.getInstance().setAttack(5000);
        RyujiGoda.getInstance().setHealth(5000);
        RyujiGoda.getInstance().setAttackRange(2 * attackRangeCons);
        RyujiGoda.getInstance().setFieldOfView(fieldOfViewCons);
        RyujiGoda.getInstance().setLvl(1);
    }



    public static RyujiGoda getInstance() {
        if(single_instance == null)
            single_instance = new RyujiGoda();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        RyujiGoda.getInstance().getRepresentative().setFill(Color.GREENYELLOW);
        RyujiGoda.getInstance().getRepresentative().setHeight(15);
        RyujiGoda.getInstance().getRepresentative().setWidth(15);
    }
}
