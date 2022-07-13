package com.blakers.mothernature.entities.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Pool;
import com.blakers.mothernature.TileManager;
import com.blakers.mothernature.entities.DrawableEntity;

public class Projectile extends DrawableEntity implements Pool.Poolable {
    TextureRegion bulletTexture;
    int damage;
    public boolean alive;

    public Projectile() {
        this(0, 0, TileManager.GetTextureFromTilemap(2, 10), 1);
    }

    public Projectile(int x, int y, TextureRegion bulletTexture, int damage) {
        pos = new Rectangle();
        pos.x = x;
        pos.y = y;



        alive = false;

        this.damage = damage;
        this.bulletTexture = bulletTexture;
    }

    public void init(int x, int y) {
        pos.setPosition(x, y);
        alive = true;

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(bulletTexture, pos.x, pos.y, 8 * SPRITE_MULTIPLIER, 8 * SPRITE_MULTIPLIER);
    }

    @Override
    public void update(float delta) {
        if (!alive) return;

    }

    /**
     * Callback method when the object is freed (should reset all fields of projectile used in gameplay)
     */
    @Override
    public void reset() {
        pos.x = 0;
        pos.y = 0;
    }

}
