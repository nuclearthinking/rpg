package com.nuclearthinking.game.engines;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuclearthinking.game.obj.jsonpojo.Messages;
import com.nuclearthinking.game.utils.ResourceUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * Date: 24.12.2015
 * Time: 15:10
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class MessagesReader {
    private ResourceUtil res = new ResourceUtil();

    private MessagesReader() {

    }

    public static MessagesReader getInstance() {
        return Holder.INSTANCE;
    }

    public Messages getMessages() {
        Messages messages = null;
        InputStream is = res.getResourceAsStream("json/messages.json");
        try {
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(is);
            ObjectMapper mapper = new ObjectMapper();
            MappingIterator<Messages> messagesMappingIterator = mapper.readValues(jsonParser, Messages.class);
            messages = messagesMappingIterator.next();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return messages;
    }

    private static class Holder {
        private static final MessagesReader INSTANCE = new MessagesReader();
    }
}
