package org.rows;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParamParser implements IParamParser
{
    private String name;
    private Pattern pattern;
    private boolean required;
    
    public ParamParser(String name, Pattern pattern, boolean required)
    {
        this.name = name;
        this.pattern = pattern;
        this.required = required;
    }
    
    
    public String getName()
    {
        return this.name;
    }
    
    
    public boolean isRequired()
    {
        return this.required;
    }
    
    
    public boolean match(IContext context)
    {
        String URI = context.getRequest().getURL().getTrimmedPath();        
        Matcher result = this.pattern.matcher(URI);
        
        // TODO: lookingAt? RequestMatcher
        if ( result.find() )
        {
            return true;
        }
        
        return false;
    }
    
    public IParam parse(IContext context)
    {
        String URI = context.getRequest().getURL().getTrimmedPath();        
        Matcher result = this.pattern.matcher(URI);
        
        // TODO: lookingAt? RequestMatcher
        if ( result.find() 
        && ( result.group(1) != null) )
        {
            return new Param(this.getName(), result.group(1));
        }
        
        return null;
    }
}
