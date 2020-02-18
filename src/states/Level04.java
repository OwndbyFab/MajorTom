package states;

import assets.FuelTank;
import assets.Portal;
import assets.SpaceShipVector;
import main.MajorTom;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import physic.Collision;

import java.util.ArrayList;

public class Level04 extends BasicGameState {
    public static final int ID = 4;
    SpaceShipVector spaceShip;

    public Shape[] shapes;
    private Portal portal;

    public ArrayList<FuelTank> fuelTanks;
    Collision collision;
    private int width = MajorTom.WIDTH;
    private int height = MajorTom.HEIGHT;

    @Override
    public int getID() {
        return ID;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        spaceShip = new SpaceShipVector(new Vector2f(50, 50));
        spaceShip.getPolygon().transform(Transform.createRotateTransform(90));
        fuelTanks = new ArrayList<>(1);
        fuelTanks.add(new FuelTank(new RoundedRectangle(200, 200, 20, 30, 2)));
        collision = new Collision();
        shapes = new Shape[13];

        shapes[0] = (new Line(0,0, width, 0));
        shapes[1] = (new Line(width, 0, width, height));
        shapes[2] = (new Line(width,height, 0, height));
        shapes[3] = (new Line(0,height, 0, 0));

        shapes[4] = new Line(width/8, 0, width/8, height * 3/4);
        shapes[5] = new Line(width/8, height * 3/4, width/4, height * 7/8);
        shapes[6] = new Line(width/4, height * 7/8, width/4, 0);
        shapes[7] = new Line(width *3/8, height, width *3/8, height/8);
        shapes[8] = new Line(width *3/8, height/8, width/2, height/4);
        shapes[9] = new Line(width/2, height/4, width/2, height);
        shapes[10] = new Line(width *5/8, 0, width * 5/8, height * 7/8);
        shapes[11] = new Line(width * 5/8, height * 7/8, width *7/8, height * 3/4);
        shapes[12] = new Line(width *7/8, height * 3/4, width * 7/8, 0);

        portal = new Portal(new Vector2f(width * 15/16,height /10));
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        collision.detectCollision(spaceShip, shapes);
        if (spaceShip.getHp() <= 0) {
            game.enterState(EndState.ID, new FadeOutTransition(new Color(234, 68, 68)), new FadeInTransition(Color.red));
        }

        spaceShip.update(container);

        int removeIndex =  -1;

        for (FuelTank fueltank : fuelTanks)
            if (spaceShip.getPolygon().intersects(fueltank.getShape())) {
                removeIndex = fuelTanks.indexOf(fueltank);
                spaceShip.fillGas();
            }

        if (removeIndex != -1)
            fuelTanks.remove(removeIndex);

        if (spaceShip.getPolygon().intersects(portal.getCircle()))
            game.enterState(game.getCurrentStateID()+1,new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        spaceShip.render(g);
        for (Shape shape : shapes) {
            g.setColor(Color.white);
            g.draw(shape);
        }
        portal.render(g);
    }
}
