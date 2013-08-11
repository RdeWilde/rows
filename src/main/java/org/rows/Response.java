package org.rows;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class Response extends HttpServletResponseWrapper implements IResponse
{
    public Response(HttpServletResponse resp)
    {
        super(resp);
    }
    
    
    public PrintWriter getWriter()
    {
        try
        {
            return super.getWriter();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            
            return null;
        }        
    }
    
    
    public ServletOutputStream getOutputStream()
    {
        try
        {
            return super.getOutputStream();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void write(String in) throws IOException
    {
        /*ServletOutputStream os = this.servletResponse.getOutputStream();
        
        os.print(in);
        os.flush();*/
        this.getWriter().write(in);
    }
}
