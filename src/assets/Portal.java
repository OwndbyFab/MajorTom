package assets;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;

public class Portal {
    private Circle circle;

    public Portal(Vector2f location) {
        this.circle = new Circle(location.x, location.y, 20);
    }

    public void render(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.darkGray);
        g.fill(circle);
        g.setColor(color);
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
