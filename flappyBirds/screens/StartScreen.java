package flappyBirds.screens;

import flappyBirds.Main;

public class StartScreen extends EndScreen{

    public StartScreen(Main P, ScreenManager screenManager){
        super(P, screenManager);
        this.startGameButtonLabel = "Start Game";
        this.headingText = "Flappy Birds";
    }

    @Override
    public void drawOnce() {
        P.fill(255,255,255);
        P.rect(0,0,P.width, P.height);
        P.textSize(65);
    }
}
