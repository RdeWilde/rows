package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ListElement extends BlockElement {
		public static enum ListType {
		ORDERED,
		UNORDERED,
		NUMBERED
	};
	protected List<ListItem> listItems = new ArrayList<ListItem>();
	protected ListType type = ListType.UNORDERED;
	
	public ListElement(Body parent) {
		super(parent);
		
		parent.addBlockElement(this);
	}
	
	// Downcast to block-element general constructor
	

	public void addListItem(ListItem... items)
	{
		for (ListItem item : items)
			this.listItems.add(item);
	}			

	
	public void render(Writer writer) throws IOException {
		// switch list type
		// super.writeOpenTag..
		writer.write("<ul>");
		
		for(ListItem listItem : this.listItems)
			listItem.render(writer);
		
		writer.write("</ul>");
	}

}
