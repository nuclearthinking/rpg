package com.nuclearthinking.game.engines;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kuksin-mv on 24.12.2015.
 */
public abstract class Base
{
    protected final Logger LOG = Logger.getLogger(Base.class.getName());

    protected final Map<String, String[]> _tables = new HashMap<>();

    private final File _file;

    protected Base(File pFile)
    {
        _file = pFile;
    }

    public Document parse()
    {
        Document doc = null;
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setIgnoringComments(true);
            doc = factory.newDocumentBuilder().parse(_file);
            parseDocument(doc);
        }
        catch (Exception e)
        {
            LOG.log(Level.SEVERE, "Error loading file " + _file, e);
        }
        return doc;
    }

    protected void resetTable()
    {
        _tables.clear();
    }

    protected abstract void parseDocument(Document doc);
}
