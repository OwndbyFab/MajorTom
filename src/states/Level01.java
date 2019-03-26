package states;

import assets.FuelTank;
import assets.SpaceShip;
import assets.SpaceShipVector;
import assets.Wall;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Level01 extends BasicGameState {

    public static final int ID = 1;
    SpaceShipVector spaceShip;
    public Wall[] walls;
    public ArrayList<FuelTank> fuelTanks;


    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        spaceShip = new SpaceShipVector(new Vector2f(100,100));
        fuelTanks = new ArrayList<FuelTank>(1);
        fuelTanks.add(new FuelTank(new RoundedRectangle(200, 200, 20, 30, 2)));
    }


    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        spaceShip.update(container);

        int removeIndex =  -1;

        /*****************Tests Fabian Collision**************************************************/
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
    }

}
