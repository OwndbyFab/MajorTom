package level;

import assets.FuelTank;
import assets.Portal;
import assets.Wall;
import main.MajorTom;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.RoundedRectangle;

import java.util.ArrayList;

public class Level1 extends LevelBase {

    public Level1() {
        spawn = new Portal(new Circle(20, 20, 20), true, Color.magenta);
        exit = new Portal(new Circle(MajorTom.WIDTH - 20, MajorTom.HEIGHT - 20, 20), true, Color.orange);

        walls = new Wall[6];
        walls[0] = new Wall(new Line(0, 0, MajorTom.WIDTH, 0), true);
        walls[1] = new Wall(new Line(MajorTom.WIDTH, 0, MajorTom.WIDTH, MajorTom.HEIGHT), true);
        walls[2] = new Wall(new Line(MajorTom.WIDTH, MajorTom.HEIGHT, 0, MajorTom.HEIGHT), true);
        walls[3] = new Wall(new Line(0, MajorTom.HEIGHT, 0, 0), true);
        walls[4] = new Wall(new Line(395, 0, 0, MajorTom.HEIGHT), true);
        walls[5] = new Wall(new Line(0, 350, MajorTom.WIDTH, 0), true);

        fuelTanks = new ArrayList<FuelTank>(1);
        fuelTanks.add(new FuelTank(new RoundedRectangle(200, 200, 20, 30, 2)));
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        super.render(container, g);
    }

    public void update(GameContainer container, int delta) throws SlickException {

    }


}
