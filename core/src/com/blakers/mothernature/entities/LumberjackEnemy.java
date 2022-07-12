package com.blakers.mothernature.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.blakers.mothernature.TileManager;

import java.util.HashMap;

public class LumberjackEnemy extends DrawableEntity {
    HashMap<EntityState, TextureRegion> lumberjackImages = new HashMap<>();
    EntityState state = EntityState.DOWN;

    public LumberjackEnemy(int x, int y) {
        pos.x = x;
        pos.y = y;

        pos.width = 8 * SPRITE_MULTIPLIER;
        pos.height = 8 * SPRITE_MULTIPLIER;

        lumberjackImages.put(EntityState.UP, TileManager.GetTextureFromTilemap(0, 6));
        lumberjackImages.put(EntityState.DOWN, TileManager.GetTextureFromTilemap(0, 4));
        lumberjackImages.put(EntityState.RIGHT, TileManager.GetTextureFromTilemap(0, 5));
        lumberjackImages.put(EntityState.LEFT, TileManager.GetTextureFromTilemap(0, 5, true));
    }


    @Override
    public void update(float delta) {
        // move towards target
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(lumberjackImages.get(state), pos.x, pos.y, 8 * SPRITE_MULTIPLIER, 8 * SPRITE_MULTIPLIER);
    }
}
