package states;

import assets.FuelTank;
import assets.Portal;
import assets.SpaceShipVector;
import main.MajorTom;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import physic.Collision;

import java.util.ArrayList;

public class Level03 extends BasicGameState {

    public static final int ID = 3;
    SpaceShipVector spaceShip;

    public Shape[] shapes;
    public Shape[] shapesWithoutCollision;
    private Portal portal;

    public ArrayList<FuelTank> fuelTanks;
    Collision collision;
    private int width = MajorTom.WIDTH;
    private int height = MajorTom.HEIGHT;


    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        spaceShip = new SpaceShipVector(new Vector2f(100,MajorTom.HEIGHT/2));
        spaceShip.getPolygon().transform(Transform.createRotateTransform(90));
        fuelTanks = new ArrayList<FuelTank>(1);
        fuelTanks.add(new FuelTank(new RoundedRectangle(200, 200, 20, 30, 2)));
        collision = new Collision();
        shapes = new Shape[16];

        shapes[0] = (new Line(0,0, width, 0));
        shapes[1] = (new Line(width, 0, width, height));
        shapes[2] = (new Line(width,height, 0, height));
        shapes[3] = (new Line(0,height, 0, 0));

        shapes[4] = (new Line(width/10*2,0, width/10*3, height/10*4));
        shapes[5] = (new Line(width/10*3, height/10*4, width/10*4, 0));
        shapes[6] = (new Line(width/10*6,0, width/10*7, height/10*4));
        shapes[7] = (new Line(width/10*7, height/10*4,width/10*8,0));


        shapes[8] = (new Line(width/10*4,height/10*5,width/10*5,height/10*2));
        shapes[9] = (new Line(width/10*5,height/10*2, width/10*6,height/10*5));
        shapes[10] = (new Line(width/10*6,height/10*5, width/10*5, height/10*8));
        shapes[11] = (new Line(width/10*5, height/10*8, width/10*4, height/10*5));

        shapes[12] = (new Line(width/10*2, height,width/10*3,height/10*6));
        shapes[13] = (new Line(width/10*3,height/10*6,width/10*4,height));
        shapes[14] = (new Line(width/10*6,height,width/10*7,height/10*6));
        shapes[15] = (new Line(width/10*7,height/10*6,width/10*8,height));




        portal = new Portal(new Vector2f(width/10*9,height/10*5));



    }


    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        collision.detectCollision(spaceShip, shapes);

        spaceShip.update(container);

        int removeIndex =  -1;

        for (FuelTank fueltank : fuelTanks){
            if (spaceShip.getPolygon().intersects(fueltank.getShape())) {
                removeIndex = fuelTanks.indexOf(fueltank);
                spaceShip.fillGas();
            }
        }


        if (removeIndex != -1){
            fuelTanks.remove(removeIndex);
        }

        if (spaceShip.getPolygon().intersects(portal.getCircle())) game.enterState(game.getCurrentStateID()+1,new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        spaceShip.render(g);
        for (Shape shape : shapes) {
            g.setColor(Color.white);
            g.draw(shape);
        }
        portal.render(g);

    }

}
