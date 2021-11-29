package oop.snake;

public class Fruit {
    // koordinat x buah
    private int fruitX;

    // koordinat y buah
    private int fruitY;

    // warna buah
    private int fruitColor;

    // konstruktor null
    public Fruit() {
        this.fruitX = 0;
        this.fruitY = 0;
        this.fruitColor = 0;
    }

    // setter koordinat x buah
    public void setFruitX(int fruitX){
        this.fruitX = fruitX;
    }

    // setter koordinat y buah
    public void setFruitY(int fruitY){
        this.fruitY = fruitY;
    }

    // setter warna buah
    public void setColor(int fruitColor){
        this.fruitColor = fruitColor;
    }

    // getter koordinat x buah
    public int getFruitX(){
        return this.fruitX;
    }

    // getter koordinat y buah
    public int getFruitY(){
        return this.fruitY;
    }
    
    // getter warna buah
    public int getColor(){
        return this.fruitColor;
    }
}
