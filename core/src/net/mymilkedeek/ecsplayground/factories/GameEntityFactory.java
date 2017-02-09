package net.mymilkedeek.ecsplayground.factories;

import com.artemis.ComponentMapper;
import com.artemis.World;
import net.mymilkedeek.ecsplayground.components.Bounds;
import net.mymilkedeek.ecsplayground.components.Color;
import net.mymilkedeek.ecsplayground.components.PlayerTag;

/**
 * @author Michaël
 */
public class GameEntityFactory {

    public static void initializeGame(World world) {
        int playerId = world.create();

        ComponentMapper<PlayerTag> playerTagComponentMapper = world.getMapper(PlayerTag.class);
        PlayerTag playerTag = playerTagComponentMapper.create(playerId);
        playerTag.playerName = "MyMilkedEek";

        ComponentMapper<Color> colorComponentMapper = world.getMapper(Color.class);
        Color color = colorComponentMapper.create(playerId);
        color.color = com.badlogic.gdx.graphics.Color.CYAN;

        ComponentMapper<Bounds> boundsComponentMapper = world.getMapper(Bounds.class);
        Bounds bounds = boundsComponentMapper.create(playerId);
        bounds.x = 50;
        bounds.y = 50;
        bounds.width = 50;
        bounds.height = 50;
    }
}