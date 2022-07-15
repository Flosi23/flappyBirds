package flappyBirds.tubes.queue;

import flappyBirds.Player;
import flappyBirds.tubes.Tube;

public class End extends Listelement{
    
    //was die einzelnen Funktionen machen wird in Listelement beschrieben

    @Override
    public Listelement insert(Tube data) {
        return new Knot(data);
    }

    @Override
    public Listelement getNext() {
        return this;
    }

    @Override
    public void draw() {}

    @Override
    public boolean collidesWithPlayer(Player player) {
        return false;
    }

    @Override
    public int calcScore(Player player) {
        return 0;
    }
}
