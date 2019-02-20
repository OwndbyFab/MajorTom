package assets;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class Portal extends PhysicalObject{
    public Portal(Shape shape, boolean hasCollision) {
        super(shape, hasCollision);
    }



    @Override
    public void render(GameContainer container, Graphics g) {
        g.setColor(Color.magenta);
        super.render(container, g);
    }
}
