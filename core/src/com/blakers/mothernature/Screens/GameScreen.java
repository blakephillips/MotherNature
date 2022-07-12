package com.blakers.mothernature.Screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.blakers.mothernature.MotherNature;
import com.blakers.mothernature.entities.DrawableEntity;
import com.blakers.mothernature.entities.LumberjackEnemy;
import com.blakers.mothernature.entities.Player;

import java.util.Iterator;

public class GameScreen extends BaseScreen {
    OrthographicCamera camera = new OrthographicCamera();
    Array<DrawableEntity> entities = new Array<DrawableEntity>();

    public GameScreen(MotherNature game) {
        super(game);

        Player player = new Player(entities, 250, 250);
        LumberjackEnemy lumberjack = new LumberjackEnemy(250, 250);
        entities.add(lumberjack);
        entities.add(player);
        camera.setToOrtho(false, 800, 800);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        game.batch.setProjectionMatrix(camera.combined);
        camera.update();
        game.batch.begin();
        // render
        for (Iterator<DrawableEntity> entityIterator = entities.iterator(); entityIterator.hasNext(); ) {
            DrawableEntity entity = entityIterator.next();
            entity.render(game.batch);
        }
        game.batch.end();

        // update
        for (Iterator<DrawableEntity> entityIterator = entities.iterator(); entityIterator.hasNext(); ) {
            DrawableEntity entity = entityIterator.next();
            entity.update(delta);
        }
    }
}
