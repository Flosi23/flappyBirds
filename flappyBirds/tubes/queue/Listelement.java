package flappyBirds.tubes.queue;

import flappyBirds.Player;
import flappyBirds.tubes.Tube;

public abstract class Listelement {
    //Fügt eine weitere Röhre in die Warteschlange ein
    public abstract Listelement insert(Tube data);
    //Gibt die nächste Röhre zurück
    public abstract Listelement getNext();
    //"Zeichnet" die aktuelle sowie die nächste Röhre
    public abstract void draw();
    // Überprüft ob diese oder die nächste Röhre mit dem Spieler kollidiert
    public abstract boolean collidesWithPlayer(Player player);
    // Berechnet den Score vom Spieler
    public abstract int calcScore(Player player);
}
