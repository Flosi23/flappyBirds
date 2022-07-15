package flappyBirds.tubes.queue;

import flappyBirds.Player;
import flappyBirds.tubes.Tube;

public class Knot extends Listelement{
    private final Tube tube;
    private Listelement next;
    
    //was die einzelnen Funktionen machen wird in Listelement beschrieben

    public Knot(Tube tube){
        this.tube = tube;
        this.next = new End();
    }

    @Override
    public Listelement insert(Tube data) {
        this.next = next.insert(data);
        return this;
    }

    public Listelement getNext() {
        return next;
    }

    @Override
    public void draw() {
        this.tube.draw();
        this.next.draw();
    }

    @Override
    public boolean collidesWithPlayer(Player player) {
        if(this.tube.collidesWithPlayer(player)){
            return true;
        }
        return this.next.collidesWithPlayer(player);
    }

    @Override
    public int calcScore(Player player) {
        if(this.tube.beforePlayerHasChanged(player)){
            return this.next.calcScore(player) + 1;
        }
        return this.next.calcScore(player);
    }

    public Tube getTube() {
        return tube;
    }
}
