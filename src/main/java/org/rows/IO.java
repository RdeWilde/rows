package org.rows;

public class IO implements IIO
{
    private Request req;
    private Response resp;
    
    
    public IO(Request req, Response resp)
    {
        this.req = req;
        this.resp = resp;        
    }
    
    
    public Request getRequest()
    {
        return this.req;
    }
    
    public Response getResponse()
    {
        return this.resp;
    }
}
