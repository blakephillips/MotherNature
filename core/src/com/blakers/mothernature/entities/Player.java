package com.blakers.mothernature.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.blakers.mothernature.KeyMapping;
import com.blakers.mothernature.KeyboardInput;

import java.util.HashMap;

import static java.lang.Math.abs;

public class Player extends DrawableEntity {
    private HashMap<EntityState, TextureRegion> playerImages = new HashMap<>();
    private int playerSpeed = 200;
    private double playerDrag = 0.8;
    private EntityState state = EntityState.DOWN;
    private Vector2 velocity;
    private Array<DrawableEntity> entities;

    public Player(Array<DrawableEntity> entities, int x, int y) {

        //Callback to entities list, for adding new objects
        this.entities = entities;

        pos.x = x;
        pos.y = y;

        pos.width = 8 * SPRITE_MULTIPLIER;
        pos.height = 8 * SPRITE_MULTIPLIER;

        velocity = new Vector2(0, 0);

        TextureRegion region = new TextureRegion(
                new Texture(
                        Gdx.files.internal("spritesheet/mothernature_sprites.png")
                )
        );
        TextureRegion[][] split = region.split(8, 8);
        TextureRegion[][] splitMirrored = region.split(8, 8);
        splitMirrored[0][1].flip(true, false);

        playerImages.put(EntityState.UP, split[0][3]);
        playerImages.put(EntityState.DOWN, split[0][2]);
        playerImages.put(EntityState.RIGHT, split[0][1]);
        playerImages.put(EntityState.LEFT, splitMirrored[0][1]);
    }

    @Override
    public void update(float delta) {

        if (Gdx.input.isKeyPressed(KeyMapping.GetInput(KeyboardInput.UP))) {
            state = EntityState.UP;
            velocity.y += playerSpeed * delta;
        }

        if (Gdx.input.isKeyPressed(KeyMapping.GetInput(KeyboardInput.DOWN))) {
            state = EntityState.DOWN;
            velocity.y -= playerSpeed * delta;
        }

        if (Gdx.input.isKeyPressed(KeyMapping.GetInput(KeyboardInput.LEFT))) {
            state = EntityState.LEFT;
            velocity.x -= playerSpeed * delta;
        }

        if (Gdx.input.isKeyPressed(KeyMapping.GetInput(KeyboardInput.RIGHT))) {
            state = EntityState.RIGHT;
            velocity.x += playerSpeed * delta;
        }

        if (!velocity.equals(Vector2.Zero)) {
            velocity.x *= playerDrag;
            velocity.y *= playerDrag;

            if (abs(velocity.x) < 0.2) {
                velocity.x = 0;
            }
            if (abs(velocity.y) < 0.2) {
                velocity.y = 0;
            }
            //here goes collision detection
            pos.x += velocity.x;
            pos.y += velocity.y;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(playerImages.get(state), pos.x, pos.y, 8 * SPRITE_MULTIPLIER, 8 * SPRITE_MULTIPLIER);
    }
}
