package ir.ac.kntu.Object;

import ir.ac.kntu.GamePlay.GameSetup;
import ir.ac.kntu.Organizer.Main;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.LinkedList;

public class HQ implements Objects {

    private int durability;
    private int lvl;
    private String name;
    private Circle facility = new Circle();
    private Button button = new Button();
    private Text currentState = new Text();
    private static LinkedList<HQ> HQList = new LinkedList<>();

    public HQ(int durability, int lvl, String name) {
        this.durability = durability;
        this.lvl = lvl;
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }


    public static LinkedList<HQ> getHQList() {
        return HQList;
    }

    public Button getButton() {
        return button;
    }

    public Circle getFacility() {
        return facility;
    }

    public Text getCurrentState() {
        return currentState;
    }

    public String getName() {
        return name;
    }

    public static void setHQ(){
        HQ container = new HQ(3000,1,"container");
        container.setText();
        HQList.add(container);
        HQ Truck = new HQ(5000,1,"Truck");
        Truck.setText();
        HQList.add(Truck);
        HQ Van = new HQ(6000,1,"Van");
        HQList.add(Van);
        Van.setText();
        container.ShapeSetter();
    }


    @Override
    public void ShapeSetter() {
        HQ.getHQList().get(0).facility.setRadius(20);
        HQ.getHQList().get(1).facility.setRadius(20);
        HQ.getHQList().get(2).facility.setRadius(20);
        HQ.getHQList().get(0).facility.setFill(Color.WHEAT);
        HQ.getHQList().get(1).facility.setFill(Color.CORAL);
        HQ.getHQList().get(2).facility.setFill(Color.AZURE);
        HQ.getHQList().get(0).facility.setCenterX(850);
        HQ.getHQList().get(0).facility.setCenterY(450);
        HQ.getHQList().get(1).facility.setCenterX(850);
        HQ.getHQList().get(1).facility.setCenterY(150);
        HQ.getHQList().get(2).facility.setCenterX(850);
        HQ.getHQList().get(2).facility.setCenterY(450);
    }

    @Override
    public void destruction() {
        if(durability<=0){
            GameSetup.getPresentHQ().get(GameSetup.getPresentHQ().indexOf(this)).getFacility().setVisible(false);
            GameSetup.getPresentHQ().remove(this);
        }
    }

    public void setText(){
        for(HQ i : HQList){
            int nextLvl = i.getLvl()+1;
            i.getCurrentState().setText("current level : " + i.getLvl() + " current durability : " +
                    i.getDurability() + "\nnext level : " + nextLvl + " next Durability : " + i.getDurability()*11/10);
            i.getButton().setText(i.getName());
            Main.getRoot().getChildren().removeAll(i.getCurrentState());
            Main.getRoot().getChildren().addAll(i.getCurrentState());
        }
    }


    public void upgradeHQ(){
        Upgrade.spendMoney(getLvl()*100);
        setDurability((getDurability()*11)/10);
        setLvl(getLvl()+1);
    }
}
