package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuState extends BasicGameState {
    public static final int ID = 0;
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
        g.drawString("Press 1 to start Game", 150, 10 );
        g.drawString("Press 2 to start FabsTestState", 150, 30 );
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    public void keyReleased(int key, char c){
        if (key == Input.KEY_1){
            game.enterState(GameState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

        if (key == Input.KEY_2){
            game.enterState(FabsTestState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }
    }
}
