package com.nuclearthinking.game.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by onifent
 */

public class Writer {

    public static void main(String[] args) {
        Writer writer = new Writer();

        writer.getUserInput();
    }

    public String getUserInput() {

        String input = null;
        boolean vaild = true;
        while (vaild) {
            try {
                BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
                input = is.readLine();
                vaild = !checkInput(input);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return input;
    }

    private boolean checkInput(String input) {
        Pattern p = Pattern.compile("^[а-яa-z0-9_-]{1,15}$");
        Matcher m = p.matcher(input);
        return m.matches();
    }


}
