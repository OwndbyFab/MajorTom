package assets;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public abstract class Entity {
    public Shape shape;

    public Entity(Shape shape) {
        this.shape = shape;
    }

    public void render(GameContainer container, Graphics g) {
        g.draw(shape);
    }

    protected abstract void update(GameContainer container, int delta);
}