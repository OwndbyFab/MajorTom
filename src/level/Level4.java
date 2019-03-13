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



public class Level4 extends LevelBase {

    public Level4(){
        /*
        spawn = new Portal(new Circle());
        exit = new Portal(new Circle());
        */

        walls = new Wall[6];

        fuelTanks = new ArrayList<FuelTank>(1);
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        super.render(container, g);
    }

    public void update(GameContainer container, int delta) throws SlickException {
    }
}
