package oop.snake;

// class point untuk memberikan posisi koordinat x dan y pada board game
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void addX(int x){
        this.x += x;
    }

    public void addY(int y){
        this.y += y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
