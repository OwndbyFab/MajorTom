package states;

import assets.SpaceShip;
import main.MajorTom;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {

    static final int ID = 1;
    private SpaceShip spaceShip;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }


    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        spaceShip.update(container, delta);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        spaceShip.render(container, g);
    }

}
