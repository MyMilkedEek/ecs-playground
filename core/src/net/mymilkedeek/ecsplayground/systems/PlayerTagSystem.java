package net.mymilkedeek.ecsplayground.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import net.mymilkedeek.ecsplayground.components.PlayerTag;

/**
 * @author Michaël
 */
public class PlayerTagSystem extends EntityProcessingSystem {

    // AutoWired
    private ComponentMapper<PlayerTag> playerTagComponentMapper;

    public PlayerTagSystem() {
        super(Aspect.all(PlayerTag.class));
    }

    @Override
    protected void process(Entity e) {
        PlayerTag tag = this.playerTagComponentMapper.get(e.getId());

        System.out.println("Player's name = " + tag.playerName);
    }
}