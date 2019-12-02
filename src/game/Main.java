package game;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage stage = new Stage();
	private static Scene scene;
	private int time = 0;
	Floor floor = new Floor();
	Ball ball = new Ball();

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Scene.fxml"));
			scene = new Scene(root, 400, 800);
			scene.setOnKeyPressed(e -> keyPressedEvent(e));
			scene.setOnKeyReleased(e -> keyReleasedEvent(e));
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void keyPressedEvent(KeyEvent e) {
		switch (e.getCode()) {
		case SPACE:
			time += 20;
			break;
		default:
			break;
		}
	}

	private void keyReleasedEvent(KeyEvent e) {
		switch (e.getCode()) {
		case SPACE:
			//System.out.print(time);
			if (ball.isAir == false) {
				floor.jump(time);
			}
			time = 0;
			break;
		default:
			break;
		}
	}
}
