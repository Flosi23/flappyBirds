package flappyBirds.screens;

import flappyBirds.Main;
import flappyBirds.Player;
import flappyBirds.tubes.queue.Queue;
import processing.core.PImage;

public class GameScreen extends Screen {
    private Player player;
    private Queue tubes;

    public GameScreen(Main P, ScreenManager screenManager){
        super(P, screenManager);
    }

    @Override
    public void setup() {
        this.player = new Player(this.P);
        this.tubes = new Queue(this.P);
    }

    @Override
    public void drawOnce() {
        setup();
    }

    @Override
    public void draw(){
        P.clear();

        PImage image = P.loadImage("../assets/gameBackground.png");
        P.image(image, 0, 0);

        P.strokeWeight(1);

        player.draw();
        tubes.draw();

        if(P.getScore() > P.getHighScore()){
            P.setHighScore(P.getScore());
        }

        P.textSize(40);
        P.fill(0);
        P.text("Score: " + P.getScore(), 100, 50);
        P.text("High Score: " + P.getHighScore(), 100, 100);

        tubes.removeHeadIfNeeded();
        tubes.spawnTube();
        tubes.calcAndSetScore(player);

        if(tubes.collidesWithPlayer(player)){
            screenManager.showEndScreen();
        }
    }
}
