package game;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SceneController {

	@FXML
	private ImageView ballImage;
	@FXML
	private AnchorPane base;

	private Image image;
	private Floor floor = new Floor();

	@FXML
	void initialize() {
		image = floor.assignImage("normal");
		base.getChildren().add(floor.generate(image, 0, 500, 13));
		//ball.gravity(ballImage);
	}

}
