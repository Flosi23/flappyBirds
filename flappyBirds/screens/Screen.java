package flappyBirds.screens;

import flappyBirds.Main;

public abstract class Screen {

    protected final Main P;
    protected final ScreenManager screenManager;

    public Screen(Main P, ScreenManager screenManager){
        this.P = P;
        this.screenManager = screenManager;
    }

    //Methode wird einmal beim Programmstart ausgef�ht
    public void setup(){};
    // Methode wird jedes Mal wenn der Screen neu angezeigt wird (wenn zu ihm gewechselt wird) ausgef�ht
    public void drawOnce(){};
    // Methode wird x mal pro Sekunde ausgef�ht
    public void draw(){};
}
