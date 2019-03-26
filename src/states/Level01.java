package states;

import assets.FuelTank;
import assets.SpaceShip;
import assets.SpaceShipVector;
import assets.Wall;
import main.MajorTom;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import physic.Collision;

import java.util.ArrayList;

public class Level01 extends BasicGameState {

    public static final int ID = 1;
    SpaceShipVector spaceShip;
   // public Wall[] walls;
    public Shape[] shapes;
    public ArrayList<FuelTank> fuelTanks;
    Collision collision;


    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        spaceShip = new SpaceShipVector(new Vector2f(100,100));
        fuelTanks = new ArrayList<FuelTank>(1);
        fuelTanks.add(new FuelTank(new RoundedRectangle(200, 200, 20, 30, 2)));
        collision = new Collision();
        shapes = new Shape[6];
        shapes[0] = (new Line(0,0, MajorTom.WIDTH, 0));
        shapes[1] = (new Line(MajorTom.WIDTH, 0, MajorTom.WIDTH, MajorTom.HEIGHT));
        shapes[2] = (new Line(MajorTom.WIDTH,MajorTom.HEIGHT, 0, MajorTom.HEIGHT));
        shapes[3] = (new Line(0,MajorTom.HEIGHT, 0, 0));
        shapes[4] = (new Line(0,(MajorTom.HEIGHT / 2) - 100 , MajorTom.WIDTH, (MajorTom.HEIGHT / 2) - 100 ));
        shapes[5] = (new Line(0,(MajorTom.HEIGHT / 2) + 100 , MajorTom.WIDTH, (MajorTom.HEIGHT / 2) + 100 ));

    }


    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        collision.detectCollision(spaceShip, shapes);

        spaceShip.update(container);

        int removeIndex =  -1;

      /*  for (Wall wall : level.getWalls()) {
            // if (wall.getShape().intersects(spaceShip.getShip()))
            //   spaceShip.collide();
            wall.checkCollision(spaceShip.getShip());
        } */

        for (FuelTank fueltank : fuelTanks){
            if (spaceShip.getPolygon().intersects(fueltank.getShape())) {
                removeIndex = fuelTanks.indexOf(fueltank);
                spaceShip.fillGas();
            }
        }


        if (removeIndex != -1){
            fuelTanks.remove(removeIndex);
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        spaceShip.render(g);
        for (Shape shape : shapes) {
            g.setColor(Color.white);
            g.draw(shape);
        }

    }

}
