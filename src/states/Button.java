package states;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

    public class Button extends AbstractComponent implements MusicListener{

        private int width;
        private int height;
        private int x;
        private int y;
        private int mouseX;
        private int mouseY;
        private boolean pressed;
        private Shape hitbox;
        private boolean over;
        private String text;
        private Music music;


        public Button(GUIContext container, int x, int y, int width, int height, String text) throws SlickException {
            super(container);
            setLocation(x, y);
            this.width = width;
            this.height = height;
            this.text = text;
            hitbox = new Rectangle(x, y, width, height);

        }

        @Override
        public int getHeight() {
            return height;
        }

        @Override
        public int getWidth() {
            return width;
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public int getY() {
            return y;
        }

        public boolean isPressed() {
            return pressed;
        }



        public void update(GUIContext container) {
            mouseX = container.getInput().getMouseX();
            mouseY = container.getInput().getMouseY();
            over = hitbox.contains(mouseX, mouseY);

            if (over && container.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                pressed = true;
            }else{
                pressed = false;
            }
        }

        @Override
        public void render(GUIContext container, Graphics g) throws SlickException {

            g.setColor(new Color(214, 29, 112));


            g.fillRect(x, y, width, height);
            g.setColor(Color.white);
            g.drawString(text, x + width/2 -40, y + height/2-10);
        }
        @Override
        public void setLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public void musicEnded(Music music) {

        }

        @Override
        public void musicSwapped(Music music, Music music1) {

        }
    }
