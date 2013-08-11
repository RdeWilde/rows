package org.rows.templating.html;

import java.io.IOException;
import java.io.Writer;

public class Html extends AbstractElement implements IHtmlTemplate {
	protected Head head;
	protected Body body;
		
	public Html()
	{
		super(null);
	}
	
	
	public void setHead(Head head) {
		this.head = head;		
	}
	
	public void setBody(Body body)
	{
		this.body = body;
	}
	
	
	public void render(Writer writer) throws IOException {
		writer.write("<html>");
			this.head.render(writer);
			this.body.render(writer);
		writer.write("</html>");
	}
}
