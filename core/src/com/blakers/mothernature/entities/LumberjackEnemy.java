package com.blakers.mothernature.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class LumberjackEnemy extends DrawableEntity {
    private HashMap<EntityState, TextureRegion> lumberjackImages = new HashMap<>();
    private EntityState state = EntityState.DOWN;

    public LumberjackEnemy(int x, int y) {
        pos.x = x;
        pos.y = y;

        pos.width = 8 * SPRITE_MULTIPLIER;
        pos.height = 8 * SPRITE_MULTIPLIER;

        TextureRegion region = new TextureRegion(
                new Texture(
                        Gdx.files.internal("spritesheet/mothernature_sprites.png")
                )
        );

        TextureRegion[][] split = region.split(8, 8);
        TextureRegion[][] splitMirrored = region.split(8, 8);
        splitMirrored[0][5].flip(true, false);

        lumberjackImages.put(EntityState.UP, split[0][6]);
        lumberjackImages.put(EntityState.DOWN, split[0][4]);
        lumberjackImages.put(EntityState.RIGHT, split[0][5]);
        lumberjackImages.put(EntityState.LEFT, splitMirrored[0][5]);

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
