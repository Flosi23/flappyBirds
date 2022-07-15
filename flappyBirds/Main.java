package flappyBirds;

import flappyBirds.screens.ScreenManager;
import processing.core.PApplet;


public class Main extends PApplet {

    private ScreenManager screenManager;

    private int score;
    private int highScore;

    /*
    Diese Methode wird einmal bei Programmstart ausgeführt.
    */
    @Override
    public void setup() {
       this.screenManager = new ScreenManager(this);
       this.screenManager.setup();
    }

    /*
    Auch diese Methode wird einmal bei Programmstart ausgeführt.
    In ihr werden die Maße des Fensters festgelegt
    */
    @Override
    public void settings() {
        fullScreen();
    }

    /*
    Wird mehrmals pro Sekunde (abhängig von der frameRate) ausgeführt.
    */
    @Override
    public void draw(){
        screenManager.draw();
    }

    /*
    Getter und Setter für score und highScore
    */
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
