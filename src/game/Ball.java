package game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Ball {
	private ImageView ballImage;
	public static boolean isAir = true;

	public void leftSide() {
		if (isAir) {
			System.out.print(ballImage);
			ballImage.setLayoutX(ballImage.getLayoutX() - 1);
		}
	}

	public void rightSide() {
		if (isAir) {
			System.out.print(ballImage);
			ballImage.setLayoutX(ballImage.getLayoutX() + 1);
		}
	}

	public void gravity(ImageView ballImage) {
		Timeline ballTimer = new Timeline(new KeyFrame(Duration.millis(60), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (isAir) {
					ballImage.setLayoutY(ballImage.getLayoutY() + 1);
				}
			}
		}));
		ballTimer.setCycleCount(Timeline.INDEFINITE);
		ballTimer.play();
	}

	public void jump() {

	}

}
