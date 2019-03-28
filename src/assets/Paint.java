package assets;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Polygon;

public class Paint {

    private Polygon ship;
    private Point shipTop;
    private Polygon newShape;

    public Paint(Point startPoint){
        //Startpoint (e.g. 100,100)
        Polygon ship = new Polygon();
        ship.addPoint(startPoint.getX(),startPoint.getY());
        ship.addPoint(startPoint.getX() + 10,startPoint.getY() - 50);
        ship.addPoint(startPoint.getX() + 20,startPoint.getY());
        ship.addPoint(startPoint.getX() + 10,startPoint.getY() - 10);

        this.ship = ship;
        this.shipTop = new Point(ship.getPoints()[2],ship.getPoints()[3]);

        newShape = new Polygon();
        newShape.addPoint(200,200);
        newShape.addPoint(215,240);
        newShape.addPoint(185,240);


    }


    public void render(GameContainer container, Graphics g) throws SlickException {
        g.setColor(Color.green);
        g.fill(ship);

        g.drawString("Länge: " + ship.getWidth() + " , Breite: " + ship.getHeight(), 100,100);
        g.drawLine(200,200, 200,240); //40y   mitte 200, 220
        g.drawLine(185,220, 215,220); //30x

        g.setColor(Color.blue);
        g.draw(newShape);
    }



}
