package net.mymilkedeek.ecsplayground.screens;

import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.mymilkedeek.ecsplayground.GameInstance;
import net.mymilkedeek.ecsplayground.factories.GameEntityFactory;
import net.mymilkedeek.ecsplayground.systems.InputSystem;
import net.mymilkedeek.ecsplayground.systems.PlayerTagSystem;
import net.mymilkedeek.ecsplayground.systems.RenderingSystem;

/**
 * @author Michaël
 */
public class GameScreen extends ScreenAdapter {

    private final GameInstance gameInstance;

    private World entityWorld;

    public GameScreen(GameInstance gameInstance) {
        this.gameInstance = gameInstance;

        WorldConfigurationBuilder builder = new WorldConfigurationBuilder();
        builder.with(
                new PlayerTagSystem(),
                new InputSystem(),
                new RenderingSystem(new ShapeRenderer())
        );

        this.entityWorld = new World(builder.build());

        GameEntityFactory.initializeGame(this.entityWorld);
    }

    @Override
    public void render(float delta) {
        this.entityWorld.setDelta(delta);
        this.entityWorld.process();
    }

    @Override
    public void show() {
        super.show();
    }
}