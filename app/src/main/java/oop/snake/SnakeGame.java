/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package oop.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SnakeGame extends Application {
	// variable
	static int speed = 7;
	static int fruitEaten = 0;
	static int pointSize = 6;
	static int bodyParts = 5;
	static boolean running = false;
	static boolean isPaused = false;
	static boolean isNewGame = true;
	static boolean isGameOver = true;
	static List<Point> snake = new ArrayList<>();
	static Direction direction = Direction.up;
	static Random rand = new Random();
	static Board board = new Board();
	static Fruit fruit = new Fruit();

	public void start(Stage primaryStage) {
		try {
			newFruit();

			VBox root = new VBox();
			Canvas c = new Canvas(board.getWidth()*pointSize, board.getHeight()*pointSize);
			GraphicsContext gc = c.getGraphicsContext2D();
			root.getChildren().add(c);

			new AnimationTimer() {
				long lastSnakeCheck = 0;

				public void handle(long now) {
					if (lastSnakeCheck == 0) {
						lastSnakeCheck = now;
						snakeCheck(gc);
						return;
					}

					if (now - lastSnakeCheck > 1000000000/speed && !isPaused) {
						lastSnakeCheck = now;
						snakeCheck(gc);
					}
				}

			}.start();

			Scene scene = new Scene(root, board.getWidth() * pointSize, board.getHeight() * pointSize);

			// kontrol player
			scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
				if (key.getCode() == KeyCode.UP) {
					if(direction != Direction.down)
						direction = Direction.up;
				}
				if (key.getCode() == KeyCode.LEFT) {
					if(direction != Direction.right)
						direction = Direction.left;
				}
				if (key.getCode() == KeyCode.DOWN) {
					if(direction != Direction.up)
						direction = Direction.down;
				}
				if (key.getCode() == KeyCode.RIGHT) {
					if(direction != Direction.left)
						direction = Direction.right;
				}
				if (key.getCode() == KeyCode.SPACE) {
					if(isNewGame){
						running = true;
						isGameOver = false;
					} else {
						resetGame();
					}
				}
				if (key.getCode() == KeyCode.P) {
					isPaused = !isPaused;
				}
			});

			// inisialisasi snake
			while(bodyParts>0){
				snake.add(new Point(board.getWidth()/2, board.getHeight()/2));
				bodyParts--;
			}

			primaryStage.setScene(scene);
			primaryStage.setTitle("SNAKE GAME");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void resetGame() {
		fruitEaten = 0;
		isNewGame = true;
		isGameOver = false;
		running = true;
		bodyParts = 5;
		direction = Direction.up;
		snake.clear();
		while(bodyParts>0){
			snake.add(new Point(board.getWidth()/2, board.getHeight()/2));
			bodyParts--;
		}
	}

	// berisi tampilan start, tampilan game over dan movement dari snake
	public static void snakeCheck(GraphicsContext gc) {
		// tampilan awal
		if(isNewGame && isGameOver){
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, board.getWidth()*pointSize, board.getHeight()*pointSize);

			gc.setFill(Color.WHITE);
			gc.setFont(new Font("Sans-Serif", 50));
			gc.fillText("SNAKE GAME", 155, board.getHeight()*pointSize/2);
			gc.setFont(new Font("Sans-Serif", 18));
			gc.fillText("Press space to start game", 205, board.getHeight()*pointSize/2+30);
			return;
		}

		// tampilan jika game over
		if (isGameOver) {
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, board.getWidth()*pointSize, board.getHeight()*pointSize);

			gc.setFill(Color.RED);
			gc.setFont(new Font("Sans-Serif", 24));
			gc.fillText("Score: " + fruitEaten, 265, board.getHeight()*pointSize/2-60);
			gc.setFont(new Font("Sans-Serif", 50));
			gc.fillText("GAME OVER", 165, board.getHeight()*pointSize/2);
			gc.setFont(new Font("Sans-Serif", 18));
			gc.fillText("Press space to restart game", 195, board.getHeight()*pointSize/2+30);
			return;
		}

		// move snake
		if(running){
			isNewGame = false;
			for (int i=snake.size()-1; i>=1; i--) {
				snake.get(i).setX(snake.get(i-1).getX());
				snake.get(i).setY(snake.get(i-1).getY());
			}

			switch (direction) {
			case up:
				snake.get(0).addY(-1);;
				if (snake.get(0).getY() < 0) { // akan game over jika snake menabrak batas atas
					isGameOver = true;
					running = false;
				}
				break;
			case down:
				snake.get(0).addY(1);;
				if (snake.get(0).getY() > board.getHeight()) { // akan game over jika snake menabrak batas bawah
					isGameOver = true;
					running = false;
				}
				break;
			case left:
				snake.get(0).addX(-1);;
				if (snake.get(0).getX() < 0) { // akan game over jika snake menabrak batas kiri
					isGameOver = true;
					running = false;
				}
				break;
			case right:
				snake.get(0).addX(1);;
				if (snake.get(0).getX() > board.getWidth()) { // akan game over jika snake menabrak batas kanan
					isGameOver = true;
					running = false;
				}
				break;

			}
		}

		// fruit eaten akan mengecek apakah buah termakan oleh snake
		if (fruit.getFruitX() == snake.get(0).getX() && fruit.getFruitY() == snake.get(0).getY()) {
			snake.add(new Point(-1, -1));
			fruitEaten++;
			newFruit();
		}

		// self destroy akan mengecek apakah snake menabrak dirinya sendiri atau tidak, jika ya maka game over
		if(!isNewGame){
			for (int i = 1; i < snake.size(); i++) {
				if (snake.get(0).getX() == snake.get(i).getX() && snake.get(0).getY() == snake.get(i).getY()) {
					isGameOver = true;
					running = false;
				}
			}
		}

		// background
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, board.getWidth()*pointSize, board.getHeight()*pointSize);

		// score, papan score saat game dimainkan
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("Sans-Serif", 24));
		gc.fillText("Score: " + fruitEaten, 10, 25);

		// random fruit color, memberikan warna buah yang berbeda setiap memunculkan buah yang baru
		Color cc = Color.WHITE;

		switch (fruit.getColor()) {
		case 0:
			cc = Color.PURPLE;
			break;
		case 1:
			cc = Color.LIGHTBLUE;
			break;
		case 2:
			cc = Color.YELLOW;
			break;
		case 3:
			cc = Color.PINK;
			break;
		case 4:
			cc = Color.ORANGE;
			break;
		}
		gc.setFill(cc);
		gc.fillOval(fruit.getFruitX()*pointSize, fruit.getFruitY()*pointSize, pointSize, pointSize); // ukuran dan bentuk buah

		// snake color, memberikan warna dan bentuk pada snake
		for (Point c : snake) {
			gc.setFill(Color.LIGHTGREEN);
			gc.fillRect(c.getX() * pointSize, c.getY()*pointSize, pointSize-1, pointSize-1);
			gc.setFill(Color.GREEN);
			gc.fillRect(c.getX() * pointSize, c.getY()*pointSize, pointSize-2, pointSize-2);

		}

	}

	// new fruit, memunculkan buah baru secara randon
	public static void newFruit() {
		start: while (true) {
			fruit.setFruitX(rand.nextInt(board.getWidth()));
			fruit.setFruitY(rand.nextInt(board.getHeight()));

			for (Point c : snake) {
				if (c.getX() == fruit.getFruitX() && c.getY() == fruit.getFruitY()) {
					continue start;
				}
			}
			fruit.setColor(rand.nextInt(5));
			break;

		}
	}

	public static void main(String[] args) {
		launch();
	}
}
