package game;

import java.net.URISyntaxException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Floor {
	private static final String FLOOR_NORMAL = "../images/floorNormal.png";
	private Group group = new Group(); // 床をグループ化する
	private Node ball;
	private Node floor;

	public Image assignImage(String type) {
		if (type.equals("normal")) {
			try {
				type = getClass().getResource(FLOOR_NORMAL).toURI().toString();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		return new Image(type);
	}

	// 床を座標(x, y)にblocks 分生成する
	public Group generate(Image image, double x, double y, int blocks) {
		// blocks 分
		double width = image.getWidth();
		for (int i = 0; i < blocks; i++) {
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setX(x);
			imageView.setY(y);
			group.getChildren().add(imageView);
			x += width;
		}
		return group;
	}

	// 床が自動であがる。
	public AnchorPane fallFloors(AnchorPane base) {
		ball = base.getChildren().get(0);
		floor = base.getChildren().get(1);
		if (collideObject(ball, floor) && !Ball.isAir) {
			floor.setLayoutY(floor.getLayoutY());
		} else {
			floor.setLayoutY(floor.getLayoutY() - 0.5);
		}
		return base;
	}

	public AnchorPane jump(AnchorPane base) {
		ball = base.getChildren().get(0);
		floor = base.getChildren().get(1);
		final Timeline timeline = new Timeline();
		timeline.setCycleCount(1);
		timeline.setAutoReverse(true);
		//
		timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000),
				   new KeyValue (floor.translateYProperty(), 10)));
		timeline.play();
		return base;
	}

	private boolean collideObject(Node object1, Node object2) {
		if (object1.getBoundsInParent().intersects(object2.getBoundsInParent())) {
			Ball.isAir = false;
			return true;
		}
		return false;
	}

}
