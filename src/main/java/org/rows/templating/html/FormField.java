package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;

public abstract class FormField extends BlockElement {
	protected String name;
	protected String value;
	
	public static enum TYPES {
		TEXT,
		CHECKBOX,
		TEXTAREA
	}
	
	
	public FormField(AbstractElement parent, FormField.TYPES type) {
		super(parent);
	}


	public abstract void render(Writer writer) throws IOException;
}
