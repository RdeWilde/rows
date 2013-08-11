package org.rows;


import java.util.regex.Pattern;

public interface IRequestMatcher
{
    public void addParam(String paramname, Pattern parampattern, boolean required);
    public void setMethod(String method);
    public boolean matches(IContext context);
    public void parse(IContext context);
}
