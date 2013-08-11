package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;

public class ListItem extends BlockElement {
	// protected String content = "Default text content"; // Replace with TextNode
	
	public ListItem(ListElement list)
	{
		super(list);
		
		list.addListItem(this);
	}
	
	public void render(Writer writer) throws IOException {
		writer.write("<li>");
		
		if (elements != null) {
			for (AbstractElement element : elements)		
				element.render(writer);
		}
			
		writer.write("</li>");
	}

}
