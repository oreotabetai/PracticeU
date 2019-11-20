package game;


import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SceneController {

	@FXML
	private ImageView ballImage;
	@FXML
	private AnchorPane base;

	private Image image;
	private Floor floor = new Floor();
	public Ball ball = new Ball();

	@FXML
	void initialize() {
		System.out.print(ballImage);
		image = floor.assignImage("normal");
		base.getChildren().add(floor.generate(image, 0, 500, 13));
		ball.gravity(ballImage);
	}

}
