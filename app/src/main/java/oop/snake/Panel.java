package oop.snake;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 6;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 5;
    char direction;
    boolean running = false;
    boolean isNewGame = true;
    int fruitX;
    int fruitY;
    int fruitEaten;
    Timer speed;
    Random random;

    Panel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
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
        if(isNewGame || running){
            for(int i = 0; i<bodyParts; i++){
                if(i==0){
                    g.setColor(new Color(255, 226, 226));
                    g.fillRect(x[i]+300, y[i]+300, UNIT_SIZE, UNIT_SIZE);
                } else{
                    g.setColor(new Color(255, 199, 199));
                    g.fillRect(x[i]+300, y[i]+300, UNIT_SIZE, UNIT_SIZE);
                }
            }

            g.setColor(Color.white);
            g.setFont(new Font("Sans-Serif", Font.BOLD, 16));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score : " + fruitEaten, (SCREEN_WIDTH - metrics.stringWidth("Score : " + fruitEaten))/2, getFont().getSize()+6);

            g.setColor(Color.yellow);
            g.fillOval(fruitX, fruitY, UNIT_SIZE, UNIT_SIZE);
        } else{
            gameOver(g);
        }
    }
    public void newFruit(){
        fruitX = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        fruitY = random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
    }
    public void checkFruit(){
        if((x[0]+300 == fruitX) && (y[0]+300 == fruitY)){
            bodyParts++;
            fruitEaten+=4;
            newFruit();
        }
    }
    public void startGame(){
        newFruit();
        running = true;
        speed = new Timer(DELAY, this);
        speed.start();
    }
    public void move(){
        for(int i = bodyParts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction){
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }
    public void checkCollisions(){
        //checks if head with body
        if(!isNewGame){
            for(int i = bodyParts;i>0;i--){
                if((x[0]+300 == x[i]+300)&&(y[0]+300 == y[i]+300)){
                    running = false;
                }
            }
        }
        //check if head touches left border
        if (x[0]+300 < 0) {
            running = false;
        }
        //check if head touches right border
        if (x[0]+300 > SCREEN_WIDTH) {
            running = false;
        }
        //check if head touches top border 
        if (y[0]+300 < 0) {
            running = false;
        }
        //check if head touches bottom border
        if (y[0]+300 > SCREEN_HEIGHT) {
            running = false;
        }
        if(!running){
            speed.stop();
        }
    }
    public void gameOver(Graphics g) {
        //score
        g.setColor(Color.white);
        g.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score : " + fruitEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score : " + fruitEaten))/2, getFont().getSize()+6);
        //game over text
        g.setColor(Color.white);
        g.setFont(new Font("Sans-Serif", Font.BOLD, 36));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
    }
    public void resetGame(){
        isNewGame = false;
        bodyParts = 5;
        fruitEaten = 0;
        direction = 'R';
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(running){
            move();
            checkFruit();
            checkCollisions();
        }
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                if(direction != 'R'){
                    direction = 'L';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(direction != 'L'){
                    direction = 'R';
                }
                break;
            case KeyEvent.VK_UP:
                if(direction != 'D'){
                    direction = 'U';
                }
                break;
            case KeyEvent.VK_DOWN:
                if(direction != 'U'){
                    direction = 'D';
                }
                break;
            case KeyEvent.VK_SPACE:
                if(isNewGame){
                    resetGame();
                }
                break;
            }
        }
    }
}
