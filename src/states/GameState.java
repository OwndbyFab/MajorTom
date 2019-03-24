package states;

import assets.FuelTank;
import assets.SpaceShip;
import level.LevelBase;
import level.*;
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
    private LevelBase level;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) {
        spaceShip = new SpaceShip(new Point(100, 100));

        switch (MajorTom.currentLevel) {
            case 1:
                level = new Level1();
                break;
            case 2:
                level = new Level2();
                break;
            case 3:
                level = new Level3();
                break;
            case 4:
                level = new Level4();
                break;
        }
    }


    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        spaceShip.update(container, delta);

        int removeIndex = -1;

        /*****************Tests Fabian Collision**************************************************/
      /*
      for (Wall wall : level.getWalls()) {
            // if (wall.getShape().intersects(spaceShip.getPolygon()))
            //   spaceShip.getCollisionDamage();
            wall.checkCollision(spaceShip.getPolygon());
        } */

      /*
    for (FuelTank fueltank : level.fuelTanks) {
        if (spaceShip.getPolygon().intersects(fueltank.getShape())) {
            removeIndex = level.fuelTanks.indexOf(fueltank);
            spaceShip.fillGas();
        }
    }

    if (removeIndex != -1) {
        level.fuelTanks.remove(removeIndex);
    }

    if (spaceShip.getPolygon().intersects(level.getPortal().getShape())) {
        System.out.println("Portal erreicht");
    }
    */
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        spaceShip.render(container, g);
        level.render(container, g);
    }

}
