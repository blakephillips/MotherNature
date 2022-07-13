package com.blakers.mothernature.Screens;

import com.blakers.mothernature.MotherNature;
import com.blakers.mothernature.World;

public class GameScreen extends BaseScreen {
    private final World world;
    public GameScreen(MotherNature game) {
        super(game);
        world = new World(game);
    }

    @Override
    public void render(float delta) {
        world.render(delta);
        world.update(delta);
    }
}
