package org.rows;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestMatcher implements IRequestMatcher
{
    private Pattern pattern;
    private String method;
    private List<IParamParser> params = new ArrayList<IParamParser>();
    
  
    public RequestMatcher(Pattern pattern)
    {
        this.pattern = pattern;
    }
    
    
    public void addParam(String paramname) 
    {
        this.addParam(paramname, Pattern.compile("^.+$"));
    }
    
    public void addParam(String paramname, Pattern parampattern) 
    {
        this.addParam(paramname, Pattern.compile("^.+$"), false);
    }    
    
    public void addParam(String paramname, Pattern parampattern, boolean required) 
    {
        this.params.add(
            new ParamParser(paramname, parampattern, required)
        );
    }
    
    
    public void setMethod(String method)
    {
        this.method = method;
    }
    
    
    public boolean matches(IContext context)
    {
        IRequest req = context.getRequest();

        Matcher URIMatch = this.pattern.matcher(req.getURL().getTrimmedPath());
        if (URIMatch.lookingAt())
        {
            for (IParamParser paramparser : this.params)
            {            
                if (!paramparser.match(context) && paramparser.isRequired())
                {
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }
    
    
    private String getParamValue(IContext context, String paramname)
    {
        /*IRequest req = context.getIO().getRequest();
        if (req.hasParam(paramname))
        {
            return req.getParam(paramname);
        }
        else if (this.paramParsers.containsKey(paramname))
        {
            IParamParser parser = this.paramParsers.get(paramname);
            
            return parser.parse(context);
        }*/

        return null;
    }
    
    
    public void parse(IContext context)
    {
        IRequest req = context.getRequest();

        Matcher URIMatch = this.pattern.matcher(req.getURL().getTrimmedPath());
        if (URIMatch.lookingAt())
        {
            for (IParamParser paramparser : this.params)
            {
                req.addParam
                        (
                            paramparser.parse(context)
                        );
            }
        }
    }
}
