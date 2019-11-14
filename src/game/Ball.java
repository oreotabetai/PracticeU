package game;

import javafx.scene.image.ImageView;

public class Ball {
	private ImageView ballImage;
	public static boolean isAir;

	public Ball(ImageView ballImage) {
		this.ballImage = ballImage;
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

}
