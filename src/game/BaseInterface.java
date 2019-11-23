package game;

import javafx.scene.layout.AnchorPane;

interface BaseAccessor {
	AnchorPane getBase();

	void setBase(AnchorPane base);
}

interface BaseOwner extends BaseAccessor {
	void setSharers(BaseSharer... sharers);
}

interface BaseSharer extends BaseAccessor{
	void setOwner(BaseOwner owner);
}