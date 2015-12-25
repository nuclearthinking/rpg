package com.nuclearthinking.game.utils.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by kuksin-mv on 24.12.2015.
 */
public class XMLFilter implements FileFilter
{
    @Override
    public boolean accept(File f)
    {
        if ((f == null) || !f.isFile())
        {
            return false;
        }
        return f.getName().toLowerCase().endsWith(".xml");
    }
}
