package states;

import main.MajorTom;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuState extends BasicGameState {
    private static final int ID = 0;
    private StateBasedGame game;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.game = game;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        if (MajorTom.currentLevel > 1)
            g.drawString("0  -  Continue Game", 0, MajorTom.HEIGHT /2);
        else
            g.drawString("", 0 , MajorTom.HEIGHT);
            g.drawString("1  -  New Game", 0, MajorTom.HEIGHT / 2 + 20);

        g.drawString("2  -  FabsTestState", 0, MajorTom.HEIGHT / 2 + 40);
        g.drawString("3  -  Fr0dg3TestState", 0, MajorTom.HEIGHT / 2 + 60);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (container.getInput().isKeyPressed(Input.KEY_0)
                || container.getInput().isKeyPressed(Input.KEY_NUMPAD0)){
            MajorTom.currentLevel = 1;
            game.enterState(GameState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

        if (container.getInput().isKeyPressed(Input.KEY_1)
                || container.getInput().isKeyPressed(Input.KEY_NUMPAD1))
            game.enterState(GameState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

        if (container.getInput().isKeyPressed(Input.KEY_2)
                || container.getInput().isKeyPressed(Input.KEY_NUMPAD2))
            game.enterState(FabsTestState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

        if (container.getInput().isKeyPressed(Input.KEY_3)
                || container.getInput().isKeyPressed(Input.KEY_NUMPAD3))
            game.enterState(Fr0dg3TestState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    }
}
