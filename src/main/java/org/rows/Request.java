package org.rows;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Request extends HttpServletRequestWrapper implements IRequest
{
    // TODO: FACBEOOK_AUTH etc.
    private Map<String, IParam> params = new HashMap<String, IParam>();
    private ContentType contenttype;
    private URL url;
    
    
    public Request(HttpServletRequest req)
    {
        super(req);

        // TODO: Iterate parameters, add as IParams
        // TODO: Add add. check for isRequired in RequestMatcher (before parsing?)
        // TODO: Parse url, parse requested response contenttype etc.
        
        try
        {
            this.url = new URL(super.getRequestURL());
        }
        catch (MalformedURLException e)
        {
            // This may not continue!
            e.printStackTrace();
        }
    }

    
    public URL getURL()
    {
        return this.url;
    }
    
    
    public boolean hasParam(String paramname)
    {
        return ( 
                this.params.containsKey(paramname) 
             /* TODO: || super.getParameterMap().containsKey(paramname)*/ 
         );
    }
    
    
    public IParam getParam(String paramname)
    {
        if ( this.params.containsKey(paramname) )
            return this.params.get(paramname);
    
        return null;
        /*else
            return super.getParameter(paramname);*/
        
        // TODO: Also add super.getParamater as real IParams
    }
    
    
    public void addParam(IParam param)
    {
        this.params.put(param.getName(), param);
    }
    
    
    public IContentType getRequestContentType()
    {
        return null;
    }
    
    
    public List<ContentType> getAcceptedContentTypes()
    {
        List<ContentType> contenttypes = new ArrayList<ContentType>();
        
        ContentType contenttype_url = this.url.getContentType();
        if (contenttype_url != null)
            contenttypes.add(contenttype_url);
        
        return contenttypes;
    }
    
    
}
