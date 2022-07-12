package com.blakers.mothernature.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class DrawableEntity {
    // Where is the entity? Also used for collision detection
    // based on what entity type extends this class
    public Rectangle pos = new Rectangle();

    // The multiplier of the original sprite size
    // e.g. 8x8 sprite will become 8 * MULTIPLIER x 8 * MULTIPLIER
    public final int SPRITE_MULTIPLIER = 3;

    // All drawable entities must implement both a render and
    // update function
    public abstract void update(float delta);

    public abstract void render(SpriteBatch batch);
}
