package states;

import main.MajorTom;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuState extends BasicGameState{
    public static final int ID = 0;
    private StateBasedGame game;
    private Button button, button1, button2,button3;


    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.game = game;
        button = new Button(container, MajorTom.WIDTH/2-200, MajorTom.HEIGHT/2-200, 400, 70, "Play");
        button1 = new Button(container, MajorTom.WIDTH/2-200, MajorTom.HEIGHT/2-100, 400, 70, "Tutorial");
        button2 = new Button(container, MajorTom.WIDTH/2-200, MajorTom.HEIGHT/2, 400, 70, "Settings");
        button3 = new Button(container, MajorTom.WIDTH/2-200, MajorTom.HEIGHT/2+100,400, 70, "Quit");


    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        button.render(container, g);
        button1.render(container, g);
        button2.render(container, g);
        button3.render(container, g);


    }


    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        button.update(container);
        if (button.isPressed()) {
            game.enterState(Level01.ID, new FadeOutTransition(Color.blue), new FadeInTransition(Color.cyan));
        }
        button1.update(container);
        if (button1.isPressed()) {
            game.enterState(LevelTutorial.ID, new FadeOutTransition(Color.blue), new FadeInTransition(Color.cyan));
        }
        button2.update(container);
        if (button2.isPressed()) {
            System.out.println("Optionen");
        }
        button3.update(container);
        if (button3.isPressed()) {
            System.exit(0);
        }

    }
}
