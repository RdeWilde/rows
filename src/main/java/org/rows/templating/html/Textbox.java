package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;

public class Textbox extends FormField {

	public Textbox(Form parent) {
		super(parent, FormField.TYPES.TEXT);
		
		parent.addField(this);
	}


	public void render(Writer writer) throws IOException {
		writer.write("<input type=\"text\"");
		
		if (this.name != "")
			writer.write(" name=\"" + super.name +"\"");
		
		if (this.value != "")
			writer.write(" value=\"" + super.value +"\"");
		
		writer.write(" />");
	}
}
