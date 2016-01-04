package com.nuclearthinking.game.engines;

import com.nuclearthinking.game.model.StatsSet;
import com.nuclearthinking.game.model.skills.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
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

    private final InputStream _file;

    protected Base(InputStream pFile) {
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

    protected abstract StatsSet getStatsSet();

    protected void parseBeanSet(Node n, StatsSet set, Integer level)
    {
        String name = n.getAttributes().getNamedItem("name").getNodeValue().trim();
        String value = n.getAttributes().getNamedItem("val").getNodeValue().trim();
        char ch = value.isEmpty() ? ' ' : value.charAt(0);
        if ((ch == '#') || (ch == '-') || Character.isDigit(ch))
        {
            set.set(name, String.valueOf(getValue(value, level)));
        }
        else
        {
            set.set(name, value);
        }
    }

     /**
      * Тут запил на будущее, если в value вместо значения будет символ #
      * то значения можно будет брать из таблицы
      * <table name="#dmg"> 100 150 200 </table>
      * <set name="dmg" val="#dmg" />
     */
    protected String getValue(String value, Object template)
    {
        // is it a table?
        if (value.charAt(0) == '#')
        {
            if (template instanceof Skill)
            {
                return getTableValue(value);
            }
            else if (template instanceof Integer)
            {
                return getTableValue(value, ((Integer) template).intValue());
            }
            else
            {
                throw new IllegalStateException();
            }
        }
        return value;
    }

    protected abstract String getTableValue(String name);

    protected abstract String getTableValue(String name, int idx);
}
