package com.blakers.mothernature.entities.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Pool;
import com.blakers.mothernature.TileManager;
import com.blakers.mothernature.entities.DrawableEntity;

public class Projectile extends DrawableEntity implements Pool.Poolable {
    private final TextureRegion bulletTexture;

    public Projectile(int x, int y) {
        this(x, y, TileManager.GetTextureFromTilemap(2, 10));
    }

    public Projectile(int x, int y, TextureRegion bulletTexture) {
        pos = new Rectangle();
        pos.x = x;
        pos.y = y;

        this.bulletTexture = bulletTexture;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(bulletTexture, pos.x, pos.y, 8 * SPRITE_MULTIPLIER, 8 * SPRITE_MULTIPLIER);
    }

    @Override
    public void update(float delta) {

    }

    /**
     * Callback method when the object is freed (should reset all fields of projectile used in gameplay)
     */
    @Override
    public void reset() {

    }

}
