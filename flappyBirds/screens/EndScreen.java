package flappyBirds.screens;

import flappyBirds.Main;
import flappyBirds.button.Button;

public class EndScreen extends Screen {

    private Button homeButton;
    private Button exitButton;

    protected String startGameButtonLabel;
    protected String headingText;

    public EndScreen(Main P, ScreenManager screenManager){
        super(P, screenManager);
        this.startGameButtonLabel = "Retry";
        this.headingText = "Game Over!";
    }

    //Knöpfe werden intialisiert und callbacks gesetzt
    @Override
    public void setup(){
        this.homeButton = new Button(P.width / 2 - 100, P.height / 2, P, startGameButtonLabel);
        this.exitButton = new Button(P.width / 2 + 60, P.height / 2,  P,"Exit Game");
        this.homeButton.onClick(this::homeButtonClicked);
        this.exitButton.onClick(this::exitButtonClicked);
    }

    public void homeButtonClicked(){
        P.setScore(0);
        screenManager.showGameScreen();
    }

    public void exitButtonClicked() {
        this.P.exit();
    }

    @Override
    public void drawOnce() {
        P.fill(0, 25);
        P.strokeWeight(0);
        P.rect(0,0,P.width, P.height);
        P.textSize(65);
        float size = this.headingText.length() * 23;
        P.fill(0);
        P.text(headingText, (float) P.width / 2 - size / 2 , 300);
    }

    @Override
    public void draw() {
        this.homeButton.draw();
        this.exitButton.draw();
    }
}
