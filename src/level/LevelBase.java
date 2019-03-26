package level;

import assets.FuelTank;
import assets.Portal;
import assets.Wall;
import main.MajorTom;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;

import java.util.ArrayList;

public abstract class LevelBase {
    public Portal spawn;
    public Portal exit;

    public Wall[] outerBoundaries = new Wall[4];



    public LevelBase() {
        outerBoundaries[0] = new Wall(new Line(3, 50, MajorTom.WIDTH - 3, 50), true);
        outerBoundaries[1] = new Wall(new Line(MajorTom.WIDTH - 3, 50, MajorTom.WIDTH - 3, MajorTom.HEIGHT - 3), true);
        outerBoundaries[2] = new Wall(new Line(MajorTom.WIDTH - 3, MajorTom.HEIGHT - 3, 3, MajorTom.HEIGHT - 3), true);
        outerBoundaries[3] = new Wall(new Line(3, MajorTom.HEIGHT - 3, 3, 50), true);
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        for (Wall wall : outerBoundaries)
            wall.render(container, g);

        spawn.render(container, g);
        exit.render(container, g);
    }
}
