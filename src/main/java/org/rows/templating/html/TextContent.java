package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;

public class TextContent extends AbstractElement { // Should not extend AbstractElement, can't have child elements
	private String content = "";
	
	public TextContent(AbstractElement parent, String content) {
		super(parent);
		
		parent.addElement(this);
		
		this.content = content;
	}
	
	public void render(Writer writer) throws IOException {
		writer.write(this.content);
	}

}
