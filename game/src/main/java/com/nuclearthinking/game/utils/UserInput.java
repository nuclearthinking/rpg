package com.nuclearthinking.game.utils;

import com.nuclearthinking.game.engines.MessagesReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

    private MessagesReader messages = MessagesReader.getInstance();

    public String getUserInput() {

        String input = null;
        boolean vaild = false;
        while (!vaild) {
            try {
                BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
                input = is.readLine();
                input = convert(input);
                vaild = checkInput(input);
                if (!vaild) {
                    if (input.trim().length() <= 0) {
                        System.out.println(messages.getMessages().getInputText());
                    } else {
                        if (input.length() > 15) {
                            System.out.println(messages.getMessages().getUnacceptableInputTooLong());
                        } else {
                            if (input.trim().length() < input.length()) {
                                System.out.println(messages.getMessages().getUnacceptableInputTooManyWhiteSpaces());
                            }
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return input;
    }

    private boolean checkInput(String input) {
        Pattern p = Pattern.compile("^[ёA-ZА-Яа-яa-z0-9_-]{1,15}$");
        Matcher m = p.matcher(input);
        return m.matches();
    }

    private String convert(String input) {
        Charset charset = Charset.forName("cp1251");
        byte[] string = input.getBytes(charset);
        String newString = new String(string);
        return input;

    }

    private String convertBR(BufferedReader w){


        return null;
    }


}
