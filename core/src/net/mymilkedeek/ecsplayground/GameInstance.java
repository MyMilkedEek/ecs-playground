package net.mymilkedeek.ecsplayground;

import com.badlogic.gdx.Game;
import net.mymilkedeek.ecsplayground.screens.GameScreen;

public class GameInstance extends Game {

	@Override
	public void create() {
        setScreen(new GameScreen(this));
	}
}
