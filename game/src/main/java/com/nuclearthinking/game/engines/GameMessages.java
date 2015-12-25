package com.nuclearthinking.game.engines;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuclearthinking.game.obj.Messages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Date: 24.12.2015
 * Time: 15:10
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class GameMessages {

    private GameMessages() {

    }

    public static GameMessages getInstance() {
        return Holder.INSTANCE;
    }

    public Messages getMessages() {
        Messages messages = null;
        File file = new File("game" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "json" + File.separator + "messages.json");
        try {

            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(bufferedReader);
            ObjectMapper mapper = new ObjectMapper();
            MappingIterator<Messages> messagesMappingIterator = mapper.readValues(jsonParser, Messages.class);
            messages = messagesMappingIterator.next();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return messages;
    }

    private static class Holder {
        private static final GameMessages INSTANCE = new GameMessages();
    }
}
