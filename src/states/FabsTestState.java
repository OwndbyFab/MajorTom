package states;

import assets.Paint;
import assets.SpaceShip;
import assets.Wall;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class FabsTestState extends BasicGameState {

    public static final int ID = 2;

    SpaceShip spaceShip;
    Wall wall;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
        spaceShip = new SpaceShip(new Point(500, 500));
        wall = new Wall(new Line(30, 30, 500,500), true);
    }

    @Override
    public void render(GameContainer container, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        spaceShip.render(container, g);
        wall.render(container, g);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        spaceShip.update(gameContainer, i);
    }
}
