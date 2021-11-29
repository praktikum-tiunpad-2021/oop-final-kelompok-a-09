package oop.snake;

public class Board {
    // Tinggi frame
    private int height;
    // Lebar frame
    private int width;

    // Konstruktor
    public Board() {
        this.height = 100;
        this.width = 100;
    }

    // Getter tinggi frame
    public int getHeight(){
        return this.height;
    }

    // Getter lebar frame
    public int getWidth(){
        return this.width;
    }
}
