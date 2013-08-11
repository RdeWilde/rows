package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;

public class Head extends AbstractElement implements IHtmlTemplate {
	private String title = "Default title";
	
	
	public Head(Html parent)
	{
		super(parent);
		
		parent.setHead(this);
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void render(Writer writer) throws IOException {
		writer.write("<head>");
		writer.write("<title>" + this.title + "</title>");
		writer.write("</head>");
	}
}
