package ir.ac.kntu.Organizer;

import ir.ac.kntu.Object.Characters.Heroes.*;
import ir.ac.kntu.Object.HQ;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import static ir.ac.kntu.Organizer.Main.root;

public class Menu {
    static Button missions = new Button("Missions");
    static Button organization = new Button("Organization");
    static Button train = new Button("Train");
    static Button fortifyHQ = new Button("Fortify HQ");
    static Button back = new Button("Back");
    static Button mission1 = new Button("mission 1");
    static Button mission2 = new Button("mission 2");
    static Text textMission1 = new Text(" Number of waves: 6\n Number of enemies: 180" +
            "\n Type of soldiers: grey & red\n Boss level: 1");
    static Text textMission2 = new Text(" Number of waves: 8\n Number of enemies: 280" +
            "\n Type of soldiers: grey & red & yellow\n Boss level: 2");
    static Rectangle infoBox = new Rectangle();
    private static Effect Shadow;


    public void setButtons(){
        eachButton(missions,375,50);
        eachButton(organization,375,100);
        eachButton(train,375,150);
        eachButton(fortifyHQ,375,200);
        eachButton(back,10,5);
        back.setVisible(false);
        EventHandling.eventHandling();
        infoBox.setFill(Color.TRANSPARENT);
        infoBox.setHeight(100);
        infoBox.setWidth(300);
        infoBox.setX(300);
        infoBox.setY(400);
        infoBox.setStroke(Color.BLACK);
        infoBox.setStrokeWidth(5);
        infoBox.setArcHeight(30);
        infoBox.setArcWidth(30);
        infoBox.setVisible(false);
    }

    public static void eachButton(Button button, int X, int Y) {
        button.setStyle("-fx-background-color: gray");
        button.setPrefWidth(150);
        button.setPrefHeight(30);
        button.setTranslateX(X);
        button.setTranslateY(Y);
        button.setOpacity(.9);
        button.setOnMouseEntered(mouseEvent -> button.setEffect(Shadow));
        button.setOnMouseExited(mouseEvent -> button.setEffect(null));
    }


    public void addingButtons(){
        root.getChildren().addAll(missions,organization,train,fortifyHQ,back);
        root.getChildren().addAll(mission1,mission2,textMission1,textMission2,infoBox);
        root.getChildren().addAll(DaigoDojima.getInstance().getButton(),FutoshiShimano.getInstance().getButton(),
                GoroMajima.getInstance().getButton(),JiroKawara.getInstance().getButton(),
                KaoruSayama.getInstance().getButton(),MakotoDate.getInstance().getButton(),
                OsamuKashiwagi.getInstance().getButton(),RyoTakashima.getInstance().getButton(),
                RyujiGoda.getInstance().getButton(),ShintaroKazama.getInstance().getButton(),
                SoheiDojima.getInstance().getButton(),TaigaSaejima.getInstance().getButton(),
                DaigoDojima.getInstance().getButton1(),FutoshiShimano.getInstance().getButton1(),
                GoroMajima.getInstance().getButton1(),JiroKawara.getInstance().getButton1(),
                KaoruSayama.getInstance().getButton1(),MakotoDate.getInstance().getButton1(),
                OsamuKashiwagi.getInstance().getButton1(),RyoTakashima.getInstance().getButton1(),
                RyujiGoda.getInstance().getButton1(),ShintaroKazama.getInstance().getButton1(),
                SoheiDojima.getInstance().getButton1(),TaigaSaejima.getInstance().getButton1());
        root.getChildren().addAll(HQ.getHQList().get(0).getButton(),
                HQ.getHQList().get(1).getButton(),
                HQ.getHQList().get(2).getButton());
        enteringMainMenu();
        mission1.setVisible(false);
        mission2.setVisible(false);
        textMission1.setVisible(false);
        textMission2.setVisible(false);
        infoBox.setVisible(false);
        setButtons();
    }



    static void setFortifyHQMenu() {
        HQ.getHQList().get(0).getButton().setVisible(true);
        HQ.getHQList().get(1).getButton().setVisible(true);
        HQ.getHQList().get(2).getButton().setVisible(true);
        eachButton(HQ.getHQList().get(0).getButton(),375,50);
        eachButton(HQ.getHQList().get(1).getButton(),375,100);
        eachButton(HQ.getHQList().get(2).getButton(),375,150);
        infoBox.setVisible(true);
        infoBox.setWidth(400);
        infoBox.setX(250);
        infoBox.setHeight(150);
    }

    static void setOrganization() {
        DaigoDojima.getInstance().getButton().setVisible(true);
        FutoshiShimano.getInstance().getButton().setVisible(true);
        GoroMajima.getInstance().getButton().setVisible(true);
        JiroKawara.getInstance().getButton().setVisible(true);
        KaoruSayama.getInstance().getButton().setVisible(true);
        MakotoDate.getInstance().getButton().setVisible(true);
        OsamuKashiwagi.getInstance().getButton().setVisible(true);
        RyoTakashima.getInstance().getButton().setVisible(true);
        RyujiGoda.getInstance().getButton().setVisible(true);
        ShintaroKazama.getInstance().getButton().setVisible(true);
        SoheiDojima.getInstance().getButton().setVisible(true);
        TaigaSaejima.getInstance().getButton().setVisible(true);
        infoBox.setVisible(true);
        infoBox.setWidth(400);
        infoBox.setX(250);
        infoBox.setHeight(150);
        eachButton(DaigoDojima.getInstance().getButton(),100,50);
        eachButton(FutoshiShimano.getInstance().getButton(),100,90);
        eachButton(GoroMajima.getInstance().getButton(),100,130);
        eachButton(JiroKawara.getInstance().getButton(),100,170);
        eachButton(KaoruSayama.getInstance().getButton(),100,210);
        eachButton(MakotoDate.getInstance().getButton(),100,250);
        eachButton(OsamuKashiwagi.getInstance().getButton(),650,50);
        eachButton(RyoTakashima.getInstance().getButton(),650,90);
        eachButton(RyujiGoda.getInstance().getButton(),650,130);
        eachButton(ShintaroKazama.getInstance().getButton(),650,170);
        eachButton(SoheiDojima.getInstance().getButton(),650,210);
        eachButton(TaigaSaejima.getInstance().getButton(),650,250);
    }

    public static void setTrainingMenu(){
        DaigoDojima.getInstance().getButton1().setVisible(true);
        FutoshiShimano.getInstance().getButton1().setVisible(true);
        GoroMajima.getInstance().getButton1().setVisible(true);
        JiroKawara.getInstance().getButton1().setVisible(true);
        KaoruSayama.getInstance().getButton1().setVisible(true);
        MakotoDate.getInstance().getButton1().setVisible(true);
        OsamuKashiwagi.getInstance().getButton1().setVisible(true);
        RyoTakashima.getInstance().getButton1().setVisible(true);
        RyujiGoda.getInstance().getButton1().setVisible(true);
        ShintaroKazama.getInstance().getButton1().setVisible(true);
        SoheiDojima.getInstance().getButton1().setVisible(true);
        TaigaSaejima.getInstance().getButton1().setVisible(true);
        infoBox.setVisible(true);
        infoBox.setWidth(400);
        infoBox.setX(250);
        infoBox.setHeight(150);
        eachButton(DaigoDojima.getInstance().getButton1(),100,50);
        eachButton(FutoshiShimano.getInstance().getButton1(),100,90);
        eachButton(GoroMajima.getInstance().getButton1(),100,130);
        eachButton(JiroKawara.getInstance().getButton1(),100,170);
        eachButton(KaoruSayama.getInstance().getButton1(),100,210);
        eachButton(MakotoDate.getInstance().getButton1(),100,250);
        eachButton(OsamuKashiwagi.getInstance().getButton1(),650,50);
        eachButton(RyoTakashima.getInstance().getButton1(),650,90);
        eachButton(RyujiGoda.getInstance().getButton1(),650,130);
        eachButton(ShintaroKazama.getInstance().getButton1(),650,170);
        eachButton(SoheiDojima.getInstance().getButton1(),650,210);
        eachButton(TaigaSaejima.getInstance().getButton1(),650,250);
    }


    static void setMissionMenu() {
        mission1.setVisible(true);
        mission2.setVisible(true);
        infoBox.setVisible(true);
        eachButton(mission1,375,50);
        eachButton(mission2,375,100);
        textMission2.setVisible(false);
        textMission1.setVisible(false);
        textMission1.setY(420);
        textMission1.setX(320);
        textMission2.setX(320);
        textMission2.setY(420);
        mission1.setOnMouseEntered(mouseEvent -> textMission1.setVisible(true));
        mission1.setOnMouseExited(mouseEvent -> textMission1.setVisible(false));
        mission2.setOnMouseEntered(mouseEvent -> textMission2.setVisible(true));
        mission2.setOnMouseExited(mouseEvent -> textMission2.setVisible(false));


    }

    static void exitingMainMenu() {
        missions.setVisible(false);
        organization.setVisible(false);
        train.setVisible(false);
        fortifyHQ.setVisible(false);
        back.setVisible(true);
    }

    public static void enteringMainMenu(){
        DaigoDojima.getInstance().getName().setVisible(false);
        FutoshiShimano.getInstance().getName().setVisible(false);
        GoroMajima.getInstance().getName().setVisible(false);
        JiroKawara.getInstance().getName().setVisible(false);
        KaoruSayama.getInstance().getName().setVisible(false);
        MakotoDate.getInstance().getName().setVisible(false);
        OsamuKashiwagi.getInstance().getName().setVisible(false);
        RyoTakashima.getInstance().getName().setVisible(false);
        RyujiGoda.getInstance().getName().setVisible(false);
        ShintaroKazama.getInstance().getName().setVisible(false);
        SoheiDojima.getInstance().getName().setVisible(false);
        TaigaSaejima.getInstance().getName().setVisible(false);
        DaigoDojima.getInstance().getTraining().setVisible(false);
        FutoshiShimano.getInstance().getTraining().setVisible(false);
        GoroMajima.getInstance().getTraining().setVisible(false);
        JiroKawara.getInstance().getTraining().setVisible(false);
        KaoruSayama.getInstance().getTraining().setVisible(false);
        MakotoDate.getInstance().getTraining().setVisible(false);
        OsamuKashiwagi.getInstance().getTraining().setVisible(false);
        RyoTakashima.getInstance().getTraining().setVisible(false);
        RyujiGoda.getInstance().getTraining().setVisible(false);
        ShintaroKazama.getInstance().getTraining().setVisible(false);
        SoheiDojima.getInstance().getTraining().setVisible(false);
        TaigaSaejima.getInstance().getTraining().setVisible(false);
        DaigoDojima.getInstance().getButton().setVisible(false);
        FutoshiShimano.getInstance().getButton().setVisible(false);
        GoroMajima.getInstance().getButton().setVisible(false);
        JiroKawara.getInstance().getButton().setVisible(false);
        KaoruSayama.getInstance().getButton().setVisible(false);
        MakotoDate.getInstance().getButton().setVisible(false);
        OsamuKashiwagi.getInstance().getButton().setVisible(false);
        RyoTakashima.getInstance().getButton().setVisible(false);
        RyujiGoda.getInstance().getButton().setVisible(false);
        ShintaroKazama.getInstance().getButton().setVisible(false);
        SoheiDojima.getInstance().getButton().setVisible(false);
        TaigaSaejima.getInstance().getButton().setVisible(false);
        HQ.getHQList().get(0).getButton().setVisible(false);
        HQ.getHQList().get(1).getButton().setVisible(false);
        HQ.getHQList().get(2).getButton().setVisible(false);
        HQ.getHQList().get(0).getCurrentState().setVisible(false);
        HQ.getHQList().get(1).getCurrentState().setVisible(false);
        HQ.getHQList().get(2).getCurrentState().setVisible(false);
        DaigoDojima.getInstance().getButton1().setVisible(false);
        FutoshiShimano.getInstance().getButton1().setVisible(false);
        GoroMajima.getInstance().getButton1().setVisible(false);
        JiroKawara.getInstance().getButton1().setVisible(false);
        KaoruSayama.getInstance().getButton1().setVisible(false);
        MakotoDate.getInstance().getButton1().setVisible(false);
        OsamuKashiwagi.getInstance().getButton1().setVisible(false);
        RyoTakashima.getInstance().getButton1().setVisible(false);
        RyujiGoda.getInstance().getButton1().setVisible(false);
        ShintaroKazama.getInstance().getButton1().setVisible(false);
        SoheiDojima.getInstance().getButton1().setVisible(false);
        TaigaSaejima.getInstance().getButton1().setVisible(false);
        back.setVisible(false);
        mission1.setVisible(false);
        mission2.setVisible(false);
        infoBox.setVisible(false);
        textMission1.setVisible(false);
        textMission2.setVisible(false);
        missions.setVisible(true);
        organization.setVisible(true);
        train.setVisible(true);
        fortifyHQ.setVisible(true);

    }

    public static Button getMissions() {
        return missions;
    }

    public static Button getOrganization() {
        return organization;
    }

    public static Button getFortifyHQ() {
        return fortifyHQ;
    }

    public static Button getTrain() {
        return train;
    }
}
