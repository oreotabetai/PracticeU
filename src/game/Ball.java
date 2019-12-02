package game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Ball implements BaseSharer {
	private ImageView ballImage;
	private BaseOwner owner;
	public static boolean isAir = true;

	public void leftSide() {
		if (isAir) {
			// System.out.print(ballImage);
			ballImage.setLayoutX(ballImage.getLayoutX() - 1);
		}
	}

	public void rightSide() {
		if (isAir) {
			// System.out.print(ballImage);
			ballImage.setLayoutX(ballImage.getLayoutX() + 1);
		}
	}

	// ƒ^ƒCƒ€ƒ‰ƒCƒ“
	public void gravity(ImageView ballImage) {
		Timeline ballTimer = new Timeline(new KeyFrame(Duration.millis(60), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (isAir) {
					for (int i = 0; i < Floor.floorList.size(); i++) {
						Floor.floorList.get(i).setTranslateY(Floor.floorList.get(i).getTranslateY() - 1);
						if (collideObject(ballImage, Floor.floorList.get(i))) {
							System.out.print("b");
							isAir = false;
						}
					}
				}
			}
		}));
		ballTimer.setCycleCount(Timeline.INDEFINITE);
		ballTimer.play();
	}

	private boolean collideObject(Node object1, Node object2) {
		try {
			if (object1.getBoundsInParent().intersects(object2.getBoundsInParent())) {
				return true;
			}
		} catch (NullPointerException e) {

		}
		return false;
	}

	@Override
	public void setOwner(BaseOwner owner) {
		this.owner = owner;
	}

	@Override
	public AnchorPane getBase() {
		return owner.getBase();
	}

	@Override
	public void setBase(AnchorPane base) {
		owner.setBase(base);
	}

}
