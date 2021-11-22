package oop.snake;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 6;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75; 
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 5;
    int fruitEaten;
    int appleX;
    int appleY;    
    
    Panel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }
    public void startGame() {
        newFruit();
        running = true;
        timer = new Time(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++){
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH,i*UNIT_SIZE);
        }
        g.setColor(Color.yellow);
        g.gillOval(fruitX, fruitY, UNIT_SIZE, UNIT_SIZE);

    }
    public void newFruit(){
        fruitX = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        fruitY = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
    }
    public void checkFruit(){
        if((x[0] == fruitX) && (y[0] == fruitY)){
            bodyParts++;
            fruitEaten++;
            newFruit();
        }
    }
    public void checkCollisions(){
        //checks if head with body
        for(int i = bodyParts;i>0;i--){
            if((x[0] == x[i])&& (y[0] == y[i])){
                running = false;
            }
        }    
        //check if head touches left boreder  
        if (x[0] < 0) {
            running = false;
        }
        //check if head touches right boreder  
        if (x[0] < SCREEN_WIDTH) {
            running = false;
        }
        //check if head touches top boreder  
        if (y[0] < 0) {
            running = false;
        }
        //check if head touches top boreder  
        if (y[0] < SCREEN_HEIGHT) {
            running = false;
        }
        if(!running){
            timer.stop();
        }
    }
    public void gameOver(Graphics g) {
        //score
        g.setColor(Color.yellow);
        g.setFont(new Font("Ink Free",Font.BOLD,40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score : "+fruitEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score : "+fruitEaten))/2, g.getFont().getsize());
        //game over text
        g.setColor(Color.yellow);
        g.setFont(new Font("Ink Free",Font.BOLD,40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }
}
