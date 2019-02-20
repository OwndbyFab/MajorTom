package states;

import assets.FuelTank;
import assets.SpaceShip;
import level.Level;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {

    public static final int ID = 1;
    SpaceShip spaceShip;
    Level level;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        spaceShip = new SpaceShip(new Point(100, 100));
        level = new Level();
    }


    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        spaceShip.update(container, delta);

        int removeIndex =  -1;

        /*****************Tests Fabian Collision**************************************************/
      /*  for (Wall wall : level.getWalls()) {
            // if (wall.getShape().intersects(spaceShip.getShip()))
            //   spaceShip.collide();
            wall.checkCollision(spaceShip.getShip());
        } */

        for (FuelTank fueltank : level.getFuelTanks()){
            if (spaceShip.getShip().intersects(fueltank.getShape())) {
                removeIndex = level.getFuelTanks().indexOf(fueltank);
                spaceShip.fillGas();
            }
        }


        if (removeIndex != -1){
            level.getFuelTanks().remove(removeIndex);
        }


        if (spaceShip.getShip().intersects(level.getPortal().getShape())){
            System.out.println("Portal erreicht");
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        spaceShip.render(container, g);
        level.render(container, g);
    }

}
