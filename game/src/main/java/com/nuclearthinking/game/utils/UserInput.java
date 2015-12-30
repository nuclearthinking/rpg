package com.nuclearthinking.game.utils;

import com.nuclearthinking.game.engines.MessagesReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput
{

    private MessagesReader messages = MessagesReader.getInstance();

    public String getUserInput()
    {
        String input = null;
        boolean valid = false;
        while (!valid)
        {
            try
            {
                BufferedReader is = new BufferedReader(new InputStreamReader(System.in, Charset.forName("cp866")));
                input = is.readLine();
                valid = checkInput(input);
                if (!valid)
                {
                    //Пустое имя
                    if (input.trim().length() <= 0)
                    {
                        System.out.println(messages.getMessage("inputText"));
                    }
                    //Слишком длинное имя
                    if (input.length() > 15)
                    {
                        System.out.println(messages.getMessage("unacceptableInputTooLong"));
                    }
                    //Имя содержит пробелы
                    if (input.trim().length() < input.length() || input.contains(" "))
                    {
                        System.out.println(messages.getMessage("unacceptableInputTooManyWhiteSpaces"));
                    }
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return input;
    }

    private boolean checkInput(String input)
    {
        Pattern p = Pattern.compile("^[ёA-ZА-Яа-яa-z0-9_-]{1,15}$");
        Matcher m = p.matcher(input);
        return m.matches();
    }
}
