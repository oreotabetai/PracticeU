package game;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SceneController implements BaseOwner {

	@FXML
	private ImageView ballImage;
	@FXML
	private AnchorPane base;

	@FXML
	void initialize() {
		Floor floor = new Floor();
		Ball ball = new Ball();
		SceneController scene = new SceneController();

		scene.setBase(base);
		scene.setSharers(floor, ball);
		// ‚¢‚¸‚ê‚Ífloor‚É
		floor.putFirstFloors();
		scene.setBase(base);
		scene.setSharers(floor, ball);
	}

	@Override
	public AnchorPane getBase() {
		return base;
	}

	@Override
	public void setBase(AnchorPane base) {
		this.base = base;
	}

	@Override
	public void setSharers(BaseSharer... sharers) {
		for (BaseSharer sharer : sharers) {
			sharer.setOwner(this);
		}
	}
}
