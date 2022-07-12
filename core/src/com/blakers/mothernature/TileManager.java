package com.blakers.mothernature;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static java.lang.String.format;


public class TileManager {
    static TextureRegion tilemap;
    static TextureRegion[][] splitTilemap;
    static TextureRegion[][] splitTilemapMirrored;

    /*
     * Initialize tile maps, one normal, one reversed on the X axis.
     */
    static {
        tilemap = new TextureRegion(
                new Texture(
                        Gdx.files.internal("spritesheet/mothernature_sprites.png")
                )
        );

        splitTilemap = tilemap.split(8, 8);
        splitTilemapMirrored = tilemap.split(8, 8);
        for (TextureRegion[] row : splitTilemapMirrored) {
            for (TextureRegion region : row) {
                region.flip(true, false);
            }
        }
    }

    public static TextureRegion GetTextureFromTilemap(int col, int row) {
        return GetTextureFromTilemap(col, row, false);
    }

    public static TextureRegion GetTextureFromTilemap(int col, int row, boolean flipped) {

        TextureRegion[][] currentRegion = splitTilemap;

        if (flipped) {
            currentRegion = splitTilemapMirrored;
        }

        if (col > currentRegion.length - 1 || col < 0) {
            Gdx.app.error("Mother Nature", format("Accessing tilemap using col '%x' is out of bounds of the tilemap.", col));
            return currentRegion[0][0];
        }

        if (row > currentRegion[col].length - 1 || row < 0) {
            Gdx.app.error("Mother Nature", format("Accessing tilemap using row '%x' is out of bounds of the tilemap.", row));
            return currentRegion[0][0];
        }

        return currentRegion[col][row];
    }

}
