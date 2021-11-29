package oop.snake;

public class Fruit {
    private int x;
    private int y;

    public Fruit() {
        this.x = 0;
        this.y = 0;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
