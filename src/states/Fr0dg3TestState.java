package states;

import assets.SpaceShipVector;
import main.MajorTom;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import physic.Collision;

public class Fr0dg3TestState extends BasicGameState {

    static final int ID = 3;
    private SpaceShipVector spaceShip;
    private Shape[] shapes;
    private Collision collision;
    RoundedRectangle rectangle;


    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) {
        spaceShip = new SpaceShipVector(new Vector2f(100, 100));
        Shape collisionLine = new Line(200, 200, 300, 250);

        /*Shape polygon = new Polygon();
        ((Polygon) polygon).addPoint(500, 500);
        ((Polygon) polygon).addPoint(600, 500);
        ((Polygon) polygon).addPoint(550, 600);*/

        Shape border = new Polygon();
        ((Polygon) border).addPoint(0, 0);
        ((Polygon) border).addPoint(MajorTom.WIDTH, 0);
        ((Polygon) border).addPoint(MajorTom.WIDTH, MajorTom.HEIGHT);
        ((Polygon) border).addPoint(0, MajorTom.HEIGHT);

        Shape roundedRect = new RoundedRectangle(400,400, 40, 20, 20);


        shapes = new Shape[3];
        shapes[0] = collisionLine;
        /*shapes[1] = polygon;*/
        shapes[1] = roundedRect;
        shapes[2] = border;
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
        collision.detectCollision(spaceShip, shapes);
        spaceShip.update(gameContainer);


    }
}
