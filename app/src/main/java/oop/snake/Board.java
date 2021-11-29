package oop.snake;

public class Board {
    private int height;
    private int width;

    public Board() {
        this.height = 100;
        this.width = 100;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }
}
