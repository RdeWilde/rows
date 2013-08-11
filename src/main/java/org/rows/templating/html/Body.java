package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Body extends AbstractElement {
	protected List<BlockElement> elements = new ArrayList<BlockElement>();
	
	
	public Body(Html parent)
	{
		super(parent);
		
		parent.setBody(this);
	}
	
	public void addElement(BlockElement element)
	{
		this.elements.add(element);
	}
	
	public void addBlockElement(BlockElement element) {
		this.elements.add(element);
	}

	
	public void render(Writer writer) throws IOException 
	{
		writer.write("<body>");
		
		for (BlockElement element : this.elements)
			element.render(writer);
		
		writer.write("</body>");
	}
}
