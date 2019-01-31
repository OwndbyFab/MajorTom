package main;

import main.states.GameState;
import main.states.MenuState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;



public class MajorTom extends StateBasedGame {

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new MajorTom());
            container.setDisplayMode(800, 600, false);
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