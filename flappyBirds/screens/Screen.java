package flappyBirds.screens;

import flappyBirds.Main;

public abstract class Screen {

    protected final Main P;
    protected final ScreenManager screenManager;

    public Screen(Main P, ScreenManager screenManager){
        this.P = P;
        this.screenManager = screenManager;
    }

    //Methode wird einmal beim Programmstart ausgefüht
    public void setup(){};
    // Methode wird jedes Mal wenn der Screen neu angezeigt wird (wenn zu ihm gewechselt wird) ausgefüht
    public void drawOnce(){};
    // Methode wird x mal pro Sekunde ausgefüht
    public void draw(){};
}
