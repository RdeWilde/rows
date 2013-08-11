package org.rows.templating.html;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractElement implements IHtmlTemplate {
	public AbstractElement parent;
	protected List<AbstractElement> elements;
	
	public AbstractElement(AbstractElement parent)
	{
		this.parent = parent;
	}
	
	public void addElement(AbstractElement element) {
		if (this.elements == null)
			this.elements = new ArrayList<AbstractElement>();
		
		this.elements.add(element);
	}
	
	
	public <T extends AbstractElement> T getParentByType(Class<T> type) {
		AbstractElement elm = this.parent;
		while (elm != null) {
			elm = elm.parent;
		}
		
		return null;
	}
}
