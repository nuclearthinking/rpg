package com.nuclearthinking.game.engines;

import com.nuclearthinking.game.model.StatsSet;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kuksin-mv on 24.12.2015.
 */
public abstract class Base
{
    protected final Logger LOG = Logger.getLogger(Base.class.getName());

    private final InputStream _file;

    protected Base(InputStream pFile)
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

    protected abstract void parseDocument(Document doc);

    protected abstract StatsSet getStatsSet();
}
