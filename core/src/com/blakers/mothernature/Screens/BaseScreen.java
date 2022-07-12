package com.blakers.mothernature.Screens;

import com.badlogic.gdx.Screen;
import com.blakers.mothernature.MotherNature;

public abstract class BaseScreen implements Screen {
    MotherNature game;

    public BaseScreen(MotherNature game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
