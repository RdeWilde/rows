package org.rows;

public class Context implements IContext
{
	private IRequest request;
    private IResponse response;
    private RequestHandler handler;
    
    
    public Context(IRequest request, IResponse response, RequestHandler handler)
    {        
        this.request = request;
        this.response = response;
        this.handler = handler;
    }

	public IRequest getRequest()
    {
    	return this.request;
    }
    
    
    public IResponse getResponse()
    {
    	return this.response;
    }
    
    
    public RequestHandler getHandler()
    {
    	return this.handler;
    }
}
