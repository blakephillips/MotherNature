package com.blakers.mothernature;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.blakers.mothernature.entities.DrawableEntity;
import com.blakers.mothernature.entities.Player;

import java.util.Iterator;

public class World {
    MotherNature game;
    public Array<DrawableEntity> entities = new Array<DrawableEntity>();
    OrthographicCamera camera = new OrthographicCamera();

    TiledMap map = new TmxMapLoader().load("data/map_1.tmx");
    OrthogonalTiledMapRenderer tileMapRenderer = new OrthogonalTiledMapRenderer(map);
    public World(MotherNature game){
        this.game = game;
        camera.setToOrtho(false, 800, 800);
        Player player = new Player(entities, 250, 250);
        entities.add(player);
    }

    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        game.batch.setProjectionMatrix(camera.combined);
        camera.update();
        tileMapRenderer.setView(camera);
        tileMapRenderer.render();
        game.batch.begin();
        // render
        for (Iterator<DrawableEntity> entityIterator = entities.iterator(); entityIterator.hasNext(); ) {
            DrawableEntity entity = entityIterator.next();
            entity.render(game.batch);
        }
        game.batch.end();
    }

    public void update(float delta) {
        for (Iterator<DrawableEntity> entityIterator = entities.iterator(); entityIterator.hasNext(); ) {
            DrawableEntity entity = entityIterator.next();
            entity.update(delta);
        }
    }
}
