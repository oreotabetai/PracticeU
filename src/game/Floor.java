package game;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Floor implements BaseSharer {

	private static final String FLOOR_NORMAL = "normal";
	private static final String FLOOR_ICE = "ice";
	private static final String FLOOR_ROLL = "roll";
	private static final String FLOOR_SLIDE = "slide";

	private final String FLOOR_NORMAL_PATH = "../images/floorNormal.png";
	private final String FLOOR_ICE_PATH = "../images/floorIce.png";
	private final String FLOOR_ROLL_PATH = "../images/floorRoll.png";
	private final String FLOOR_SLIDE_PATH = "../images/floorSlide.png";

	// 階段をリスト化
	private ArrayList<Group> floorList = new ArrayList<>();

	private Image image;

	private String type;

	private BaseOwner owner;

	private AnchorPane base;

	private Image assignImage(String type) {
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put(FLOOR_NORMAL, FLOOR_NORMAL_PATH);
		hashmap.put(FLOOR_ICE, FLOOR_ICE_PATH);
		hashmap.put(FLOOR_ROLL, FLOOR_ROLL_PATH);
		hashmap.put(FLOOR_SLIDE, FLOOR_SLIDE_PATH);

		try {
			this.type = getClass().getResource(hashmap.get(type)).toURI().toString();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return new Image(this.type);
	}

	// 床を座標(x, y)にblocks 分生成する
	private void generate(Image image, double x, double y, int blocks) {
		// blocks 分
		Group group = new Group(); // 床をグループ化する
		double width = image.getWidth();
		for (int i = 0; i < blocks; i++) {
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setX(x);
			imageView.setY(y);
			group.getChildren().add(imageView);
			x += width;
		}
		floorList.add(group);
	}

	// 最初の床を置く
	public void putFirstFloors() {
		base = owner.getBase();
		generate(assignImage("normal"), 0, 500, 13);
		generate(assignImage("normal"), 50, 100, 5);
		generate(assignImage("normal"), 70, 300, 5);

		base.getChildren().addAll(floorList);

		//baseに新しい床を追加する
		generate(assignImage("ice"), 70, -20, 5);
		base.getChildren().add(floorList.get(floorList.size()-1));

		fallFloors();
	}

	// 床を加える
	private void addNewFloor() {

	}

	// 床を落とす ボールのジャンプの値だけ
	private void fallFloors() {
		Timeline floorTimer = new Timeline(new KeyFrame(Duration.millis(60), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for (Group floors : floorList) {
					floors.setTranslateY(floors.getTranslateY() + 1);
				}
			}
		}));
		floorTimer.setCycleCount(Timeline.INDEFINITE);
		floorTimer.play();
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
