package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Form extends BlockElement {
	private List<FormField> fields = new ArrayList<FormField>();
	
	public Form(AbstractElement parent) {
		super(parent);
	}
	
	public void addField(FormField field) {
		this.fields.add(field);
	}
	
	public void render(Writer writer) throws IOException {
		writer.write("<form>");
		
		for (FormField field : this.fields)
			field.render(writer);
			
		writer.write("</form>");
	}

}
