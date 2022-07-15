package flappyBirds.tubes.queue;

import flappyBirds.Main;
import flappyBirds.Player;
import flappyBirds.tubes.Tube;
import flappyBirds.tubes.TubeDirection;
import processing.core.PImage;

public class Queue {

    private static final int SPAWNING_INTERVAL = 15;
    private int spawnCounter;
    private int direction = 0;
    private final PImage tubeTop;
    private final PImage tubeBottom;

    private Listelement first;
    private final Main P;

    public Queue(Main P){
        this.P = P;
        this.first = new End();
        this.spawnCounter = SPAWNING_INTERVAL;
        this.tubeTop = P.loadImage("../assets/wallTop.png");
        this.tubeBottom = P.loadImage("../assets/wallBottom.jpg");
    }

    /*
    Kreiert im SPAWNING_INTERVAL neue Röhren die eine abwechselnd nach oben oder nach unten zeigen
    */
    public void spawnTube(){
        spawnCounter--;

        if(spawnCounter == 0) {
            spawnCounter = SPAWNING_INTERVAL;
            direction = direction == 0 ? 1 : 0;
            this.insert(new Tube(this.P, getDirection(direction),getImage(direction)));
        }
    }

    private TubeDirection getDirection(int direction){
       return direction == 0 ? TubeDirection.UP : TubeDirection.DOWN;
    }

    private PImage getImage(int direction){
        return direction == 0 ? tubeBottom : tubeTop;
    }

    //Berechnet den Score vom Spieler
    public void calcAndSetScore(Player player) {
        P.setScore(this.first.calcScore(player) + P.getScore());
    }
    
    //Fügt ein weiteres Element zur Schlange hinzu
    private void insert(Tube data){
        first = first.insert(data);
    }

    //Entfernt das letzte element
    private void remove(){
        first = first.getNext();
    }

    /*
    Entfernt die älteste Röhre in der Warteschlange, wenn sie nicht mehr angezeigt wird
    */
    public void removeHeadIfNeeded(){
        if(this.first instanceof Knot){
            Knot knot = (Knot) first;
            Tube tube = knot.getTube();
            if(tube.getX() + tube.getWidth() < 0) this.remove();
        }
    }

    //überprüft ob eine Röhre mit dem Spieler kollidiert
    public boolean collidesWithPlayer(Player player){
        return first.collidesWithPlayer(player);
    }

    public void draw(){
        first.draw();
    }
}
