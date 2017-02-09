package net.mymilkedeek.ecsplayground.screens;

import com.badlogic.gdx.ScreenAdapter;
import net.mymilkedeek.ecsplayground.GameInstance;

/**
 * @author Michaël
 */
public class MainScreen extends ScreenAdapter {

    /**
     * Reference to the GameInstance object.
     */
    private final GameInstance gameInstance;

    public MainScreen(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void show() {
        super.show();
    }
}