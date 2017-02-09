package net.mymilkedeek.ecsplayground.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.mymilkedeek.ecsplayground.components.Bounds;
import net.mymilkedeek.ecsplayground.components.Color;

/**
 * @author Michaël
 */
public class RenderingSystem extends EntityProcessingSystem {

    private ShapeRenderer shapeRenderer;

    private ComponentMapper<Color> colorComponentMapper;
    private ComponentMapper<Bounds> boundsComponentMapper;

    public RenderingSystem(ShapeRenderer shapeRenderer) {
        super(Aspect.all(Color.class, Bounds.class));

        this.shapeRenderer = shapeRenderer;
    }

    @Override
    protected void process(Entity e) {
        com.badlogic.gdx.graphics.Color originalColor = this.shapeRenderer.getColor();

        Color color = this.colorComponentMapper.get(e.getId());
        Bounds bounds = this.boundsComponentMapper.get(e.getId());

        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        this.shapeRenderer.setColor(color.color);
        this.shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        this.shapeRenderer.end();

        this.shapeRenderer.setColor(originalColor);
    }
}