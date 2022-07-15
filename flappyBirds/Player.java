package flappyBirds;


import processing.core.PImage;

public class Player {

    public static final int WIDTH = 39;
    public static final int HEIGHT = 27;
    private static final float UPWARDS_ACCELERATION = 14;
    private static final float DOWNWARDS_ACCELERATION = (float) 1.5;

    private final Main P;
    private float y;
    private float vy;
    private final int x;
    private final PImage image;

    public Player(Main P){
        this.P = P;
        this.y = 0;
        this.vy = 0;
        this.x = P.width / 2 - WIDTH / 2;
        this.image = P.loadImage("../assets/bird.png");
    }

    /*
    Wird mehrmals pro sekunde ausgeführt.
    Verändert die Geschwindigkeit des Spielers (Schwerkraft / springen) und
    bewegt ihn
    */
    public void draw(){
        P.image(image, x,y, WIDTH, HEIGHT);

        updateVelocity();
        y += vy;
    }

    /*
    Wurde die Leertaste oder die Maus gedrückt so wird die geschwindigkeit des Spielers negativ.
    Ansonsten wird der Spieler weiter nach unten beschleunigt außer er berührt die obere oder untere Wand.
    */
    public void updateVelocity(){
        float newVY;

        if(jumpActionTriggered()) {
            newVY = -UPWARDS_ACCELERATION;
        } else {
            newVY = vy + DOWNWARDS_ACCELERATION;
        }

        if(willBeInsideFrame(newVY)){
            vy = newVY;
        } else {
            vy = 0;
        }
    }

    public boolean jumpActionTriggered(){
        return P.mousePressed || P.keyPressed && P.key == ' ';
    }

    public boolean willBeInsideFrame(float newVY){
        float newY = y + newVY;
        return newY >= 0 && newY + HEIGHT <= P.height;
    }

    public float getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public float getVy() {
        return vy;
    }
}
