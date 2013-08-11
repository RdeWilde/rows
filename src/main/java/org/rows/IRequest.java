package org.rows;

public interface IRequest extends IInputStream
{
    public boolean hasParam(String paramname);
    public IParam getParam(String paramname);
    public void addParam(IParam param);
    public URL getURL();
}
