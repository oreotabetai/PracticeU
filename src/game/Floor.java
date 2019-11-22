package game;

import java.net.URISyntaxException;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Floor {
	private static final String FLOOR_NORMAL = "../images/floorNormal.png";
	private Group group = new Group(); // �����O���[�v������

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

	// �������W(x, y)��blocks ����������
	public Group generate(Image image, double x, double y, int blocks) {
		// blocks ��
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

	// ���������ł�����B
	public void fallFloors() {

	}
}
