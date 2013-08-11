package org.rows;

public class Param implements IParam
{
    private String name;
    private String value;
    
    
    public Param(String name, String value)
    {
        this.name = name;
        this.value = value;
    }
    
    
    public String getName()
    {
        return this.name;
    }
    
    
    public String getValue()
    {
        return this.value;
    }
}
