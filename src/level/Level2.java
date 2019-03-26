package level;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.RoundedRectangle;

import main.MajorTom;

import assets.FuelTank;
import assets.Portal;
import assets.Wall;



public class Level2 extends LevelBase {

    public Wall[] walls;

    public Level2() {
        super();
        /*
        spawn = new Portal(new Circle());
        exit = new Portal(new Circle());
        */

        walls = new Wall[6];
        walls[0] = new Wall(new Line( 0,0, MajorTom.WIDTH, 0), true);
        walls[1] = new Wall(new Line( MajorTom.WIDTH - 5,0, 1, MajorTom.HEIGHT), true);
        walls[2] = new Wall(new Line( 0,MajorTom.HEIGHT - 5, MajorTom.WIDTH, 1), true);
        walls[3] = new Wall(new Line( 0,0, 1, MajorTom.HEIGHT), true);
        walls[4] = new Wall(new Line( 395,0, 0, MajorTom.HEIGHT), true);
        walls[5] = new Wall(new Line( 0,350, MajorTom.WIDTH, 1), true);

/*        fuelTanks = new ArrayList<FuelTank>(1);
        fuelTanks.add(new FuelTank(new RoundedRectangle(200, 200, 20, 30, 2)));*/
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
       super.render(container, g);
    }

    public void update(GameContainer container, int delta) throws SlickException {
    }
}
