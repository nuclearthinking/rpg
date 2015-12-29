package com.nuclearthinking.game.utils;

import com.nuclearthinking.game.engines.MessagesReader;
import org.apache.commons.io.IOUtils;

import java.io.*;
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

                InputStream in33put = System.in;
                BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
                input = is.readLine();
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


    //Попытка конвертировать строку в строку изменив кодировку, неудачно
    private String convert(String input) {
        Charset charset = Charset.forName("cp1251");
        byte[] string = input.getBytes(charset);
        try {
            String newString = new String(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return input;

    }

    //Попытка получить IS при пользовательском вводе, пока не вышло.
    private String convertIs(InputStream inputStream){

        Charset charset = Charset.forName("Utf-8");
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(inputStream, writer, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String theString = writer.toString();
        return theString;
    }


}
