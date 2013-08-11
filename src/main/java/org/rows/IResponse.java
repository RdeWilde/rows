package org.rows;

import java.io.IOException;
import java.io.Writer;

public interface IResponse extends IOutputStream
{
    public Writer getWriter();
    public void write(String in) throws IOException;
}
