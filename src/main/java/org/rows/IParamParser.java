package org.rows;

public interface IParamParser
{
    public String getName();
    public boolean isRequired();
    public boolean match(IContext context);
    public IParam parse(IContext context);
}
