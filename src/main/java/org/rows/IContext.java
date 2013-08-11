package org.rows;

public interface IContext
{
	public IRequest getRequest(); 
    
    public IResponse getResponse();    
    
    public RequestHandler getHandler();
}
