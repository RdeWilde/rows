package org.rows;

import java.io.IOException;
import java.io.Writer;


public interface ITemplate {
	public void render(Writer writer)  throws IOException;
}
