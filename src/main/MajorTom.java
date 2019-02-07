package main;

import states.GameState;
import states.MenuState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;



public class MajorTom extends StateBasedGame {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new MajorTom());
            container.setDisplayMode(800, 600, false);
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
        addState(new MenuState());
        addState(new GameState());
    }

}