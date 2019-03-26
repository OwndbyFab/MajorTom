package physic;

import assets.SpaceShipVector;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Polygon;
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
        Vector2f velocity = spaceShip.getVelocity();
        Vector2f collisionLine = findIntersectingLineVector(spaceShip.getPolygon(),gameObject);
        Vector2f perpendicular = collisionLine.getPerpendicular().normalise();
        double scalar = perpendicular.dot(velocity);
        if (scalar > 0 ) {
            perpendicular = perpendicular.negate();
        }
        Vector2f velocityNegated = velocity.negate();
        Vector2f projOntoPerp = new Vector2f();
        velocityNegated.projectOntoUnit(perpendicular,projOntoPerp);
        Vector2f aV = projOntoPerp.sub(velocityNegated);
        Vector2f reflection = velocityNegated.add(aV.scale(2));

        spaceShip.setVelocity(reflection);




        /*Vector2f perpendicular = findIntersectingLineVector(spaceShip.getPolygon(),gameObject).getPerpendicular().normalise();
        if (velocity.dot(perpendicular)<0) perpendicular = perpendicular.negate();
        double scalar = velocity.dot(perpendicular);
        double sqrtLengths = velocity.length() * perpendicular.length();
        double cos = scalar / sqrtLengths;
        double cosInDegree = 180 / Math.PI * Math.acos(cos);

        //check if perpendicular is clock- or counterclock oriented to velocity.
        double velTheta = velocity.getTheta();
        double perpTheta = perpendicular.getTheta();
        if(velTheta < 45 && perpTheta > 360 - velTheta){
            spaceShip.setVelocity(velocity.negate().sub(2*cosInDegree));
        }//counter
        else if(velTheta > 315 && perpTheta < 360 - velTheta){
            //clockwise
            spaceShip.setVelocity(velocity.negate().sub(2*-cosInDegree));
        }else if(velTheta < perpTheta){
            //clockwise
            spaceShip.setVelocity(velocity.negate().sub(2*-cosInDegree));
        } else {
            //counter
            spaceShip.setVelocity(velocity.negate().sub(2*cosInDegree));
        }*/

    }

    private Vector2f findIntersectingLineVector(Polygon ship, Shape gameObject) {

        Line line = new Line(0,0,0,0);
        int pointCount = gameObject.getPointCount();

        for (int i = 0; i < pointCount-1; i++) {
            float[] point = gameObject.getPoint(i);
            float[] nxtPoint = gameObject.getPoint(i+1);
            line.set(point,nxtPoint);
            if (line.intersects(ship)) return new Vector2f(line.getDX(),line.getDY());

        }

        float[] lastPoint = gameObject.getPoint(pointCount-1);
        float[] firstPoint = gameObject.getPoint(0);
        line.set(lastPoint,firstPoint);
        if (line.intersects(ship)) return new Vector2f(line.getDX(),line.getDY());

        return null;
    }


}
