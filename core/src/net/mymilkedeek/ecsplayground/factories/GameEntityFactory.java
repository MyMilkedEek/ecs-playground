package net.mymilkedeek.ecsplayground.factories;

import com.artemis.ComponentMapper;
import com.artemis.World;
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
    }
}