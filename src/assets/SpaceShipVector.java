package assets;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;

import static main.MajorTom.WIDTH;

public class SpaceShipVector {

    private Polygon polygon;
    private Vector2f velocity;
    private final static float SPEEDLIMIT = 3;
    private Color color;
    private int hp;
    private int maxHp;
    private float gas;
    private float fillGasAmount;
    private float maxGas;


    /**
     * Creates a new SpaceShipVector object.
     * @param location sets the starting location of polygon.
     */
    public SpaceShipVector(Vector2f location) {
        //Shape
        polygon = new Polygon();
        polygon.addPoint(location.getX(), location.getY());
        polygon.addPoint(location.getX()+10, location.getY()-50);
        polygon.addPoint(location.getX()+20, location.getY());
        polygon.addPoint(location.getX()+10, location.getY()-10);

        velocity = new Vector2f(0,0);

        color = Color.magenta;

        maxHp = 100;
        hp = maxHp;
        //Fuel setup
        maxGas = 100;
        fillGasAmount = 25;
        gas = 40;
    }

    public void update(GameContainer container) {
        Input input = container.getInput();
        if(input.isKeyDown(Input.KEY_UP)) accelerate();
        if(input.isKeyDown(Input.KEY_RIGHT)) rotate(true);
        if(input.isKeyDown(Input.KEY_LEFT)) rotate(false);


        polygon = (Polygon) polygon.transform(Transform.createTranslateTransform(velocity.x, velocity.y));
    }

    public void render(Graphics g) {
        //draw polygon
        g.setColor(color);
        g.fill(polygon);
        g.setColor(Color.blue);
        /*g.drawLine(polygon.getCenterX(),polygon.getCenterY(),polygon.getCenterX()+velocity.copy().scale(5).x,polygon.getCenterY()+velocity.copy().scale(5).y); */
        g.setColor(color);

        //HUD
        g.drawString("HP: " + hp, WIDTH - 80,10);
        g.drawString("Fuel: " + Math.round(gas), WIDTH - 98, 30);

        if (gas < 1){
            g.setColor(Color.red);
            g.drawString("No fuel", (WIDTH / 2 - 100), 10);
        }
        else if(gas < 30){
            g.setColor(Color.yellow);
            g.drawString("Fuel low", (WIDTH / 2 - 100), 10);
        }
    }

    /**
     * Adds a scaled normalized Vector that points to shipTop to velocity. Is called from update method
     */
    private void accelerate() {

        Vector2f top = new Vector2f(polygon.getPoint(1)[0], polygon.getPoint(1)[1]);
        if (gas >= 0) {
            velocity = velocity.add(top.sub(new Vector2f(polygon.getCenterX(), polygon.getCenterY())).normalise().scale((float) 0.1));
            gas -= 0.1;
        }
            if (velocity.getX() > SPEEDLIMIT) velocity.x = SPEEDLIMIT;
            if (velocity.getX() < -SPEEDLIMIT) velocity.x = -SPEEDLIMIT;
            if (velocity.getY() > SPEEDLIMIT) velocity.y = SPEEDLIMIT;
            if (velocity.getY() < -SPEEDLIMIT) velocity.y = -SPEEDLIMIT;
    }

    /**
     * lets the polygon rotate (counter)clockwise. Called from update method.
     * @param clockwise boolean that shows rotationdirection
     */
    private void rotate (boolean clockwise) {
        float rotation = (float) 0.1;
        if(!clockwise) rotation *= -1;
        polygon = (Polygon) polygon.transform(Transform.createRotateTransform(rotation, polygon.getCenterX(), polygon.getCenterY()));
    }

    //Wall collision
    public void getCollisionDamage(){
        hp -= 10;
    }

    public void fillGas(){
        System.out.println("gas collected");
        if ((gas + fillGasAmount) > maxGas) {
            gas = maxGas;

        } else {
            gas += 25;
        }
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }

    public Vector2f getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public float getGas() {
        return gas;
    }

    public void setGas(float gas) {
        this.gas = gas;
    }

    public float getMaxGas() {
        return maxGas;
    }

    public void setMaxGas(float maxGas) {
        this.maxGas = maxGas;
    }
}
