package oop.snake;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 6;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
<<<<<<< HEAD
    static final int DELAY = 75; 
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 5;
    int fruitEaten;
    int appleX;
    int appleY;    
=======
    static final int DELAY = 100;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 5;
    char direction;
    boolean running = false;
    boolean isNewGame = true;
    boolean isPaused;
    int appleEaten;
    Timer speed;
>>>>>>> a50eaa7941ff339b03652dad02ad9391a86a9a7b
    
    Panel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
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
<<<<<<< HEAD
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
=======

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
        g.drawString("Score : " + appleEaten, (SCREEN_WIDTH - metrics.stringWidth("Score : " + appleEaten))/2, getFont().getSize()+6);
    }
    public void startGame(){
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
    public void checkApple(){
        appleEaten+=4;
    }
    public void resetGame(){
        isNewGame = false;
        bodyParts = 6;
        appleEaten = 0;
        direction = 'R';
>>>>>>> a50eaa7941ff339b03652dad02ad9391a86a9a7b
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(running){
            move();
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
