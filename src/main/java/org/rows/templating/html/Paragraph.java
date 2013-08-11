package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Paragraph extends BlockElement {	
	protected List<BlockElement> elements = new ArrayList<BlockElement>();
	
	public Paragraph(AbstractElement parent) {
		super(parent);
	}

	
	public void addElement(BlockElement element)
	{
		this.elements.add(element);
	}
	
	public void render(Writer writer) throws IOException
	{
		writer.write("<p>");
		
		for (BlockElement element : this.elements)
			element.render(writer);
		
		writer.write("</p>");
	}
}
