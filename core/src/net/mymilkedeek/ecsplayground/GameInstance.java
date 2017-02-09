package net.mymilkedeek.ecsplayground;

import com.badlogic.gdx.Game;
import net.mymilkedeek.ecsplayground.screens.MainScreen;

public class GameInstance extends Game {

	@Override
	public void create() {
        setScreen(new MainScreen(this));
	}
}
