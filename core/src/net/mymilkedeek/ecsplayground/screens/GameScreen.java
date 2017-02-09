package net.mymilkedeek.ecsplayground.screens;

import com.artemis.World;
import com.badlogic.gdx.ScreenAdapter;
import net.mymilkedeek.ecsplayground.GameInstance;

/**
 * @author Michaël
 */
public class GameScreen extends ScreenAdapter {

    private final GameInstance gameInstance;

    private World entityWorld;

    public GameScreen(GameInstance gameInstance) {
        this.gameInstance = gameInstance;

        this.entityWorld = new World();
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