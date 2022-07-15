package flappyBirds.tubes.queue;

import flappyBirds.Player;
import flappyBirds.tubes.Tube;

public abstract class Listelement {
    //F�gt eine weitere R�hre in die Warteschlange ein
    public abstract Listelement insert(Tube data);
    //Gibt die n�chste R�hre zur�ck
    public abstract Listelement getNext();
    //"Zeichnet" die aktuelle sowie die n�chste R�hre
    public abstract void draw();
    // �berpr�ft ob diese oder die n�chste R�hre mit dem Spieler kollidiert
    public abstract boolean collidesWithPlayer(Player player);
    // Berechnet den Score vom Spieler
    public abstract int calcScore(Player player);
}
