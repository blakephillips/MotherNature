package com.blakers.mothernature;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Json;

import java.util.HashMap;

public class KeyMapping {

    private final String KEYMAP_FILE_EXTERNAL = "keys.json";
    private HashMap<KeyboardInput, Input.Keys> keys;

    public KeyMapping() {
        Json json = new Json();

        if (Gdx.files.isExternalStorageAvailable()) {
            if (Gdx.files.classpath(KEYMAP_FILE_EXTERNAL).exists()) {
                // todo
            }
        }
    }

//    static public KeyboardInput getIntent(int key) {
//         switch (key) {
//             case Input.Keys.W:
//                return KeyboardInput.UP;
//            case Input.Keys.S:
//                return KeyboardInput.DOWN;
//            case Input.Keys.A:
//                return KeyboardInput.LEFT;
//            case Input.Keys.D:
//                return KeyboardInput.RIGHT;
//             default:
//                 return KeyboardInput.UNBOUND;
//        }
//    }

    static public int GetInput(KeyboardInput input) {
        switch (input) {
            case UP:
                return Input.Keys.W;
            case DOWN:
                return Input.Keys.S;
            case LEFT:
                return Input.Keys.A;
            case RIGHT:
                return Input.Keys.D;
            default:
                return -1;
        }
    }


}

