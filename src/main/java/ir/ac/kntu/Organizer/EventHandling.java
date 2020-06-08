package ir.ac.kntu.Organizer;

import ir.ac.kntu.GamePlay.GameSetup;
import ir.ac.kntu.GamePlay.Level1;
import ir.ac.kntu.Object.Characters.Enemies.Enemy;
import ir.ac.kntu.Object.Characters.Heroes.*;
import ir.ac.kntu.Object.HQ;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import static ir.ac.kntu.Organizer.Menu.exitingMainMenu;
import static ir.ac.kntu.Organizer.Menu.mission1;

public class EventHandling {
    static EventHandler<MouseEvent> trainMouse;

    public static void eventHandling(){



        Menu.missions.setOnMouseClicked(mouseEvent -> {
            exitingMainMenu();
            Menu.setMissionMenu();
            handleMission();
        });

        Menu.organization.setOnMouseClicked(mouseEvent -> {
            exitingMainMenu();
            for(Hero i : Hero.getHeroes())
                i.getName().setVisible(true);
            Menu.setOrganization();
            handleOrganization();
        });

        Menu.train.setOnMouseClicked(mouseEvent -> {
            exitingMainMenu();
            Menu.setTrainingMenu();
            handleTrain();
        });

        Menu.fortifyHQ.setOnMouseClicked(mouseEvent -> {
            exitingMainMenu();
            Menu.setFortifyHQMenu();
            handleFortifyHQ();
        });

        Menu.back.setOnMouseClicked(mouseEvent -> {
            Menu.enteringMainMenu();


        });
    }

    private static void handleFortifyHQ() {
        eachHqFortified(HQ.getHQList().get(0));
        eachHqFortified(HQ.getHQList().get(1));
        eachHqFortified(HQ.getHQList().get(2));
    }



    private static void handleTrain() {
        eachHeroTrained(DaigoDojima.getInstance());
        eachHeroTrained(FutoshiShimano.getInstance());
        eachHeroTrained(GoroMajima.getInstance());
        eachHeroTrained(JiroKawara.getInstance());
        eachHeroTrained(KaoruSayama.getInstance());
        eachHeroTrained(MakotoDate.getInstance());
        eachHeroTrained(OsamuKashiwagi.getInstance());
        eachHeroTrained(RyoTakashima.getInstance());
        eachHeroTrained(RyujiGoda.getInstance());
        eachHeroTrained(ShintaroKazama.getInstance());
        eachHeroTrained(SoheiDojima.getInstance());
        eachHeroTrained(TaigaSaejima.getInstance());

    }

    private static void handleOrganization() {
        eachHeroOrganised(DaigoDojima.getInstance());
        eachHeroOrganised(FutoshiShimano.getInstance());
        eachHeroOrganised(GoroMajima.getInstance());
        eachHeroOrganised(JiroKawara.getInstance());
        eachHeroOrganised(KaoruSayama.getInstance());
        eachHeroOrganised(MakotoDate.getInstance());
        eachHeroOrganised(OsamuKashiwagi.getInstance());
        eachHeroOrganised(RyoTakashima.getInstance());
        eachHeroOrganised(RyujiGoda.getInstance());
        eachHeroOrganised(ShintaroKazama.getInstance());
        eachHeroOrganised(SoheiDojima.getInstance());
        eachHeroOrganised(TaigaSaejima.getInstance());
    }

    private static void handleMission() {
        mission1.setOnMouseClicked(mouseEvent -> {
            try {
                Enemy.setEnemies();
                GameSetup.setBasics();
                Level1.setTheScene();
                GameSetup.movement();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void eachHeroOrganised(Hero hero){
        hero.getButton().setOnMouseClicked(mouseEvent -> {
            if(hero.isChosen()) {
                hero.setChosen(false);
                Hero.getHeroes().remove(hero);
                hero.getName().setVisible(false);
            }else {
                if(Hero.getHeroes().size() < 8) {
                    hero.setChosen(true);
                    Hero.getHeroes().add(hero);
                    hero.getName().setVisible(true);
                }
            }
            int x = 265;
            int y = 420;
            int cnt = 0;
            for(Hero i : Hero.getHeroes()){
                i.getName().setY(y);
                i.getName().setX(x);
                y += 30;
                cnt++;
                if(cnt==4){
                    y = 420;
                    x =450;
                }
            }
        });
    }

    public static void eachHeroTrained(Hero hero){
        trainMouse = event -> {
            if (event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
                hero.getTraining().setVisible(true);
                hero.getTraining().setY(420);
                hero.getTraining().setX(265);
            } else if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
                hero.getTraining().setVisible(false);
                hero.UpgradeHero();
                hero.setText();
                System.out.println(hero.getLvl());
                System.out.println(hero.getTraining().getText());
            } else if (event.getEventType().equals(MouseEvent.MOUSE_EXITED)) {
                hero.getTraining().setVisible(false);
            }
        };
        hero.getButton1().addEventHandler(MouseEvent.ANY,trainMouse);

    eventHandling();
    }

    private static void eachHqFortified(HQ hq) {
        hq.getButton().setOnMouseEntered(mouseEvent -> {
            hq.getCurrentState().setVisible(true);
            hq.getCurrentState().setX(265);
            hq.getCurrentState().setY(420);
        });

        hq.getButton().setOnMouseExited(mouseEvent -> {
            hq.getCurrentState().setVisible(false);
        });

        hq.getButton().setOnMouseClicked(mouseEvent -> {
            hq.getCurrentState().setVisible(false);
            hq.upgradeHQ();
            hq.setText();
        });
        eventHandling();
    }
}
