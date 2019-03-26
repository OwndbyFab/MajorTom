package states;

import assets.SpaceShipVector;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import physic.Collision;

public class Fr0dg3TestState extends BasicGameState {

    static final int ID = 3;
    private SpaceShipVector spaceShip;
    private Shape[] shapes;
    private Collision collision;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) {
        spaceShip = new SpaceShipVector(new Vector2f(100,100));
        Shape collisionLine = new Line(200,200,300,300);

        Shape collisionPolygon = new Polygon();
        ((Polygon) collisionPolygon).addPoint(500,500);
        ((Polygon) collisionPolygon).addPoint(550,450);
        ((Polygon) collisionPolygon).addPoint(600,600);

        shapes = new Shape[2];
        shapes[0] = collisionLine;
        shapes[1] = collisionPolygon;
        collision = new Collision();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) {
        spaceShip.render(graphics);
        for (Shape shape : shapes) {
            graphics.draw(shape);
        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) {
        collision.detectCollision(spaceShip,shapes);
        spaceShip.update(gameContainer);
    }
}
