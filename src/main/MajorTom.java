package main;

import states.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;
import states.GameState;


public class MajorTom extends StateBasedGame {

    public static final int WIDTH = 1600;
    public static final int HEIGHT = 900;

    public static int currentLevel = 1;

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new MajorTom());
            container.setDisplayMode(WIDTH, HEIGHT, false);
            container.setTargetFrameRate(60);

            container.start();
        } catch (SlickException s) {
            s.printStackTrace();
        }
    }

    public MajorTom() {
        super("Major Tom");
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {

        container.setMaximumLogicUpdateInterval(60);
        container.setTargetFrameRate(60);
        container.setAlwaysRender(true);
        container.setVSync(true);

        addState(new MenuState());
        addState(new GameState());
        addState(new FabsTestState());
        addState(new Fr0dg3TestState());
        addState(new Level01());

    }
}