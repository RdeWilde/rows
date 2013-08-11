package org.rows.templating.html;


import java.io.IOException;
import java.io.Writer;

import org.rows.IModel;
import org.rows.Template;


public class HtmlTemplate<T extends IModel> extends Template<T> {
	protected Html root;
	private T model;
	
	public HtmlTemplate() {
	}
	
	public T getModel() {
		return this.model;
	}
	
	public void setDocumentRoot(Html element) {
		this.root = element;
	}
	
	public void render(Writer writer) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(T subject, Writer writer) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
