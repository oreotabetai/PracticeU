package game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Ball {
	private ImageView ballImage;
	public static boolean isAir;

	public Ball() {
		isAir = true;
	}

	public void leftSide() {
		if (isAir) {
			ballImage.setLayoutX(ballImage.getLayoutX() - 1);
		}
	}

	public void rightSide() {
		if (isAir) {
			ballImage.setLayoutX(ballImage.getLayoutX() + 1);
		}
	}

	public void gravity(ImageView ballImage) {
		Timeline ballTimer = new Timeline(new KeyFrame(Duration.millis(60), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (isAir) {
					ballImage.setLayoutY(ballImage.getLayoutY() + 1);
				}
			}
		}));
		ballTimer.setCycleCount(Timeline.INDEFINITE);
		ballTimer.play();
	}
}
