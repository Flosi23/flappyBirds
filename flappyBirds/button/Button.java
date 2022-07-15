package flappyBirds.button;

import processing.core.PApplet;

public class Button {

    private static final int WIDTH = 70;
    private static final int HEIGHT = 50;

    private final String label;
    private final PApplet P;
    private ButtonCallback callback;

    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Button(int x, int y, PApplet P, String label){
       this.label = label;
       this.P = P;
       this.x = x;
       this.y = y;
       this.width = this.label.length() * 12;
       this.height = HEIGHT;
    }

    //Zeichnet den Knopf
    public void draw(){
        P.strokeWeight(1);
        P.fill(205);
        P.rect(x,y,width, height);
        P.textSize(20);
        P.fill(0);
        P.text(label, x + 10, y + (float) (height / 2) + 8);

        if(P.mousePressed && mouseOverButton() && callback != null){
            callback.callback();
        }
    }

    //Überprüft ob sich der Cursor momentan über dem Knopf befindet
    private boolean mouseOverButton(){
        return P.mouseX > this.x && P.mouseX < this.x + width && P.mouseY > this.y && P.mouseY < this.y + height;
    }

    //Setzt die Funktion die aufgerufen werden soll sobald der Knopf gedrückt wurde
    public void onClick(ButtonCallback callback){
        this.callback = callback;
    }
}

