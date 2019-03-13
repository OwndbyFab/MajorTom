package assets;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;

public class Wall extends PhysicalObject{


    public Wall(Line shape, boolean hasCollision) {
        super(shape, hasCollision);
    }

    @Override
    public void render(GameContainer container, Graphics g) {
        g.setColor(Color.white);
        super.render(container, g);
    }
}
