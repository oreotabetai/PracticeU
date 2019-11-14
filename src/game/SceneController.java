package game;

import javafx.animation.KeyFrame;
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
	public Ball ball = new Ball(ballImage);
	private Timeline timer;

	@FXML
	void initialize() {
		// System.out.print(base.getChildren().get(0));
		image = floor.assignImage("normal");
		base.getChildren().add(floor.generate(image, 0, 500, 13));

		// Durationの感覚でhandleが呼び出される。
		timer = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//base.setOnKeyPressed(e -> System.out.println("キーが押されました。"));
				base = floor.fallFloors(base);
			}
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}

	private void keyPressEvent(KeyEvent e, Ball ball) {
		switch (e.getCode()) {
		case LEFT:
			ball.leftSide();
			break;
		case RIGHT:
			ball.rightSide();
			break;
		case SPACE:
			System.out.print("no");
			if(!Ball.isAir) {
				timer.stop();
				base = floor.jump(base);
				timer.play();
			}
			break;
		default:
			break;
		}
	}
}
