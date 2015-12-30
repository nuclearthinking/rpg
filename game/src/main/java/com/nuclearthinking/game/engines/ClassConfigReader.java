package com.nuclearthinking.game.engines;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuclearthinking.game.obj.jsonpojo.ClassConfig;
import com.nuclearthinking.game.utils.ResourceUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * Date: 26.12.2015
 * Time: 14:57
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class ClassConfigReader {

    private ResourceUtil res = new ResourceUtil();

    private ClassConfigReader() {
    }

    public static ClassConfigReader getInstance() {
        return ClasConfigReaderHolder.INSTANCE;
    }

    public ClassConfig getClassConfig() {
        ClassConfig classConfig = null;
        InputStream is = res.getResourceAsStream("json/class_config.json");
        try {
            JsonFactory jsonFactory = new JsonFactory();
            JsonParser jsonParser = jsonFactory.createParser(is);
            ObjectMapper mapper = new ObjectMapper();
            MappingIterator<ClassConfig> messagesMappingIterator = mapper.readValues(jsonParser, ClassConfig.class);
            classConfig = messagesMappingIterator.next();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return classConfig;
    }

    private static class ClasConfigReaderHolder {
        private static final ClassConfigReader INSTANCE = new ClassConfigReader();
    }
}
