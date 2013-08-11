package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;

public class Link extends AbstractElement {
	protected String title;
	protected String href;
	
	public Link(AbstractElement parent) {
		super(parent);
		
		parent.addElement(this);
	}


	public void render(Writer writer) throws IOException {
		writer.write("<a href=\""+ this.href + "\" title=\""+ this.title + "\">"+ this.title + "</a>");
	}

}
