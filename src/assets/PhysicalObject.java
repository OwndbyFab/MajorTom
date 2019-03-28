package assets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public abstract class PhysicalObject extends Entity {

    boolean hasCollision;

    public PhysicalObject(Shape shape, boolean hasCollision) {
        super(shape);
        this.hasCollision = hasCollision;
    }

    @Override
    public void render(GameContainer container, Graphics g){
        super.render(container, g);
    }

    @Override
    protected void update(GameContainer container, int delta) {

    }
}
