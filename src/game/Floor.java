package game;


import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Floor implements BaseSharer{

	private static final String FLOOR_NORMAL = "normal";
	private static final String FLOOR_ICE = "ice";
	private static final String FLOOR_ROLL = "roll";
	private static final String FLOOR_SLIDE = "slide";

	private final String FLOOR_NORMAL_PATH = "../images/floorNormal.png";
	private final String FLOOR_ICE_PATH = "../images/floorIce.png";
	private final String FLOOR_ROLL_PATH = "../images/floorRoll.png";
	private final String FLOOR_SLIDE_PATH = "../images/floorSlide.png";

	private Group group = new Group(); // 床をグループ化する
	//階段をリスト化
	private List<Group> floorList = new ArrayList<>();

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
	private List<Group> generate(Image image, double x, double y, int blocks) {
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
		floorList.add(group);
		return floorList;
	}
	//最初の床を置く
	public void putFirstFloors() {
		base = owner.getBase();
		base.getChildren().addAll(generate(assignImage("normal"), 0, 500, 13));

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
