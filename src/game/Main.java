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
	public static Scene scene;

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Scene.fxml"));
			scene = new Scene(root, 400, 800);
			stage.setScene(scene);
			stage.show();

			scene.setOnKeyPressed(e -> keyPressed(e));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void keyPressed(KeyEvent e) {
		switch (e.getCode()) {
		case SPACE:
			System.out.print("space");
			break;
		default:
			break;
		}
	}
}
