package physic;

import assets.SpaceShipVector;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class Collision {

    public void detectCollision(SpaceShipVector spaceShip, Shape[] gameObjects) {
        Shape shipPolygon = spaceShip.getPolygon();

        for (Shape gameObject: gameObjects) {
            if (shipPolygon.intersects(gameObject)) resolveCollision(spaceShip,gameObject);
        }
    }

    private void resolveCollision(SpaceShipVector spaceShip, Shape gameObject) {
        Vector2f velocity = spaceShip.getVelocity().normalise();
        Vector2f perpendicular = findIntersectingLineVector(spaceShip.getPolygon(),gameObject).getPerpendicular().normalise();
        if (velocity.dot(perpendicular)<0) perpendicular = perpendicular.negate();
        double scalar = velocity.dot(perpendicular);
        double sqrtLengths = Math.sqrt(velocity.length()) * Math.sqrt(perpendicular.length());
        double cos = scalar / sqrtLengths;
        double cosInDegree = 180 / Math.PI * Math.acos(cos);

        spaceShip.setVelocity(velocity.negate().sub(2*cosInDegree));

    }

    private Vector2f findIntersectingLineVector(Shape ship, Shape gameObject) {
        Line line = new Line(0,0,0,0);
        int pointCount = gameObject.getPointCount();

        for (int i = 0; i < pointCount-1; i++) {
            float[] point = gameObject.getPoint(i);
            float[] nxtPoint = gameObject.getPoint(i+1);
            line.set(point,nxtPoint);
            if (line.intersects(ship)) return new Vector2f(line.getX(),line.getY());

        }

        float[] lastPoint = gameObject.getPoint(pointCount-1);
        float[] firstPoint = gameObject.getPoint(0);
        line.set(lastPoint,firstPoint);
        if (line.intersects(ship)) return new Vector2f(line.getX(),line.getY());

        return null;
    }


}
