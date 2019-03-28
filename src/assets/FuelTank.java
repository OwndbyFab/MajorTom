package assets;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Shape;

public class FuelTank extends Item {

    public FuelTank(Shape shape) {
        super(shape);
    }


    @Override
    public void render(GameContainer container, Graphics g) {
        g.setColor(new Color(64, 132, 13));
        super.render(container, g);
        g.drawLine(shape.getCenterX() - 2, shape.getMinY(), shape.getCenterX() -2, shape.getMinY() -3);
        g.drawLine(shape.getCenterX() -2, shape.getMinY() - 3, shape.getMaxX() -2, shape.getMinY() -3);
        g.drawLine(shape.getMaxX() -2, shape.getMinY() - 3, shape.getMaxX() -2, shape.getMinY());
        g.fill(new Rectangle(shape.getMinX() + 1, shape.getMinY() - 2, 4, 4));
        g.setColor(Color.white);

      /*  g.draw(new RoundedRectangle(shape.getCenterX() - 4, shape.getCenterY() - 9, 10,18, 2));

        g.drawLine(shape.getCenterX() - 4, shape.getCenterY() - 9, shape.getMinX() + 2, shape.getMinY() + 2);
        g.drawLine(shape.getCenterX() + 4, shape.getCenterY() - 9, shape.getMaxX() - 2, shape.getMinY() + 2);
        g.drawLine(shape.getCenterX() + 5, shape.getCenterY() + 8, shape.getMaxX() - 2, shape.getMaxY() - 2);
        g.drawLine(shape.getCenterX() - 4, shape.getCenterY() + 8, shape.getMinX() + 2, shape.getMaxY() - 2); */
    }




}
