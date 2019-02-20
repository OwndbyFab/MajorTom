package level;

import assets.FuelTank;
import assets.Portal;
import assets.Wall;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.RoundedRectangle;

import java.util.ArrayList;

public class Level1 {

    Wall [] walls;

    Portal portal;

    ArrayList<FuelTank> fuelTanks;



    public Wall[] getWalls() {
        return walls;
    }

    public ArrayList<FuelTank> getFuelTanks() { return fuelTanks; }

    public Portal getPortal() { return portal;}

    public Level1(){
       /* walls = new Wall[6];
        walls[0] = new Wall(new Rectangle( 0,0, SCREEN_WIDTH, 1), true);
        walls[1] = new Wall(new Rectangle( SCREEN_WIDTH - 5,0, 1, SCREEN_HEIGHT), true);
        walls[2] = new Wall(new Rectangle( 0,SCREEN_HEIGHT - 5, SCREEN_WIDTH, 1), true);
        walls[3] = new Wall(new Rectangle( 0,0, 1, SCREEN_HEIGHT), true);

        walls[4] = new Wall(new Rectangle( 395,0, 1, SCREEN_HEIGHT), true);
        walls[5] = new Wall(new Rectangle( 0,350, SCREEN_WIDTH, 1), true); */

        fuelTanks = new ArrayList<FuelTank>(1);
        fuelTanks.add(new FuelTank(new RoundedRectangle(200,200,20,30, 2)));
        portal = new Portal(new Circle(250,250,20), true);
    }

    public void update(GameContainer container, int delta) throws SlickException {
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
       /* for ( Wall wall : walls)
            wall.render(container, g); */

        for (FuelTank fuelTanks : fuelTanks)
            fuelTanks.render(container, g);


        portal.render(container, g);
    }
}
