package flappyBirds.tubes;

import flappyBirds.Main;
import flappyBirds.Player;
import processing.core.PImage;

import java.util.Random;

public class Tube {

    private static final float SPEED = (float) 15;
    private static final int MIN_HEIGHT = 300;
    private static final int MAX_HEIGHT = 550;

    private final Main P;
    private final float y;
    private float x;
    private final float height;
    private final int width;
    private final float imageY;
    private boolean beforePlayer;
    private final PImage image;

    public Tube(Main P, TubeDirection direction, PImage image){
        this.P = P;
        this.x = P.width;
        Random random = new Random();
        this.height = random.nextInt(MAX_HEIGHT - MIN_HEIGHT) + MIN_HEIGHT;
        this.y = direction == TubeDirection.DOWN ? 0 : P.height - height;
        this.beforePlayer = false;
        this.image = image;
        this.imageY = direction == TubeDirection.DOWN ? height - image.height : y;
        this.width = image.width;
    }

    /*
    Zeichnet ein Bild der Röhre auf den Bildschirm. Wird bei jedem Methodenaufruf
    um SPEED Pixel nach links bewegt
    */
    public void draw(){
        P.fill(255);
        P.image(image, x, imageY);

        x -= SPEED;
    }

    /*
    Hilfsmethode um zu überprüfen, ob der Spieler sich seit dem letzten Aufruf der Methode
    an der Röhre vorbeibewegt hat
    */
    public boolean beforePlayerHasChanged(Player player) {
        if(this.x < player.getX() && !beforePlayer){
            beforePlayer = true;
            return true;
        }
        return false;
    }

    /*
    Überprüft, ob der Spieler mit dieser Röhre kollidiert
    */
    public boolean collidesWithPlayer(Player player){
        return
                player.getY() + Player.HEIGHT >= this.y &&
                player.getY() <= this.y + this.height &&
                player.getX() + Player.WIDTH >= this.x &&
                player.getX() <= this.x + this.width;
    }

    public int getWidth() {
        return width;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
