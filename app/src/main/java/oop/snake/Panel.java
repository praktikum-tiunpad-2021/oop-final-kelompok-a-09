package oop.snake;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 6;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];    
    
    Panel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
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
