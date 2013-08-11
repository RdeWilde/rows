package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;

public abstract class BlockElement extends AbstractElement {

	public BlockElement(AbstractElement parent) {
		super(parent);
	}
	
	
	public abstract void render(Writer writer)  throws IOException ;
}
