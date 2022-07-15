package flappyBirds.screens;

import flappyBirds.Main;

// Klasse Verwaltet alle Screens und bietet die Möglichkeit zwischen ihnen zu Wechseln
public class ScreenManager {

    private final Screen startScreen;
    private final Screen gameScreen;
    private final Screen endScreen;

    private Screen currentScreen;

    public ScreenManager(Main P){
       this.startScreen = new StartScreen(P, this);
       this.gameScreen = new GameScreen(P, this);
       this.endScreen = new EndScreen(P, this);
       this.currentScreen = startScreen;
       this.currentScreen.drawOnce();
    }

    //führe das setup für alle screens aus
    public void setup(){
        this.startScreen.setup();
        this.gameScreen.setup();
        this.endScreen.setup();
    }

    public void draw() {
        currentScreen.draw();
    }

    // wechselt den aktuellen Screen
    private void switchToScreen(Screen screen){
        this.currentScreen = screen;
        this.currentScreen.drawOnce();
    }

    public void showStartScreen() {
        switchToScreen(startScreen);
    }

    public void showEndScreen(){
        switchToScreen(endScreen);
    }

    public void showGameScreen(){
        switchToScreen(gameScreen);
    }
}
