package org.rows;

import java.io.IOException;
import java.io.Writer;

public abstract class Template<T extends IModel> implements ITemplate {	
	abstract public void render(T subject, Writer writer) throws IOException;
}
