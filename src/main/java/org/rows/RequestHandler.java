package org.rows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.handler.AbstractHandler;

public class RequestHandler extends AbstractHandler {
	private List<IEndpoint<?, ?>> endpoints = new ArrayList<IEndpoint<?, ?>>();

	
	public void handle(String uri, org.eclipse.jetty.server.Request base, HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		Context context = new Context
                (
            		new Request(request), 
                    new Response(response),
                    this
                );
		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Expires", "0");
		response.setContentType("text/html;charset=utf-8");
		
		
		for (IEndpoint<?,?> endpoint : this.endpoints)
		{
			this.delegateEndpoint(endpoint, context);
		}
		
		
        base.setHandled(true);
	}
	
	
	private <I extends IInArgs, O extends IOutArgs> void delegateEndpoint(IEndpoint<I,O> endpoint, IContext context) {
		I in = endpoint.accept(context);
		
		if (in != null) {			
			O out = endpoint.process(in);
			
			if (out != null) {
				endpoint.output(out);
			}
		}
	}
	
	
	public void addEndpoint(IEndpoint<?,?> endpoint)
	{
		this.endpoints.add(endpoint);
	}

}
