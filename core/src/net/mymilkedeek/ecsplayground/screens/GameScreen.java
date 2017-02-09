package net.mymilkedeek.ecsplayground.screens;

import com.artemis.World;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
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
        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        this.entityWorld.setDelta(delta);
        this.entityWorld.process();
    }

    @Override
    public void show() {
        super.show();
    }
}