package level;

import assets.FuelTank;
import assets.Portal;
import assets.Wall;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public abstract class LevelBase {
    public Portal spawn;
    public Portal exit;

    public Wall[] walls;

    public ArrayList<FuelTank> fuelTanks;

    public void render(GameContainer container, Graphics g) throws SlickException {
        for (Wall wall : walls)
            wall.render(container, g);
        for (FuelTank fuelTank : fuelTanks)
            fuelTank.render(container, g);

        spawn.render(container, g);
        exit.render(container, g);
    }
}
