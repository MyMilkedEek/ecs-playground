package net.mymilkedeek.ecsplayground.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import net.mymilkedeek.ecsplayground.components.Bounds;
import net.mymilkedeek.ecsplayground.components.PlayerTag;

/**
 * @author Michaël
 */
public class InputSystem extends EntityProcessingSystem {

    private ComponentMapper<PlayerTag> playerTagComponentMapper;
    private ComponentMapper<Bounds> boundsComponentMapper;

    private float horizontalMovement;
    private float verticalMovement;

    public InputSystem() {
        super(Aspect.all(Bounds.class, PlayerTag.class));
    }

    @Override
    protected void begin() {
        if ( Gdx.input.isKeyPressed(Input.Keys.RIGHT) ) {
            this.horizontalMovement = 10;
        } else if ( Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.horizontalMovement = -10;
        } else {
            this.horizontalMovement = 0;
        }

        if ( Gdx.input.isKeyPressed(Input.Keys.UP) ) {
            this.verticalMovement = 10;
        } else if ( Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.verticalMovement = -10;
        } else {
            this.verticalMovement = 0;
        }
    }

    @Override
    protected void process(Entity e) {
        Bounds bounds = boundsComponentMapper.get(e.getId());

        bounds.x += horizontalMovement;
        bounds.y += verticalMovement;
    }
}