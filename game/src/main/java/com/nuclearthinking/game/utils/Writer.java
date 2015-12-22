package com.nuclearthinking.game.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by onifent
 */

public class Writer {

    public String getUserInput() {
        String input = null;
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            input = is.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    private boolean checkInput(String input) {
        boolean valid = true;

        if (input.trim().length() == 0) {
            valid = false;
        }


        return valid;
    }

}
