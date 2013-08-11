package org.rows;

import java.util.List;

public interface IContentType
{
    public void addMime(String mime);
    public boolean hasMime(String mime);
    public void addExtension(String ext);
    public boolean hasExtension(String ext);
    public List<String> getExtensions();
    public List<String> getMimes();
    public boolean matchContentType(IContentType contentType);
}
