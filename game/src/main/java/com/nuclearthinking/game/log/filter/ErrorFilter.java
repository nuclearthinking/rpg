package com.nuclearthinking.game.log.filter;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by kuksin-mv on 24.12.2015.
 */
public class ErrorFilter implements Filter
{
    @Override
    public boolean isLoggable(LogRecord record)
    {
        return record.getThrown() != null;
    }
}
