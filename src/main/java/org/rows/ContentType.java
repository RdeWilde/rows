package org.rows;

import java.util.ArrayList;
import java.util.List;

public enum ContentType implements IContentType
{
    XML,
    JSON;
    
    
    private List<String> mimes = new ArrayList<String>();
    private List<String> extensions = new ArrayList<String>();
    
    private ContentType()
    {
        
    }
    
    
    public void addMime(String mime)
    {
        this.mimes.add(mime);
    }
    
    public boolean hasMime(String mime)
    {
        return this.mimes.contains(mime);
    }
    
    
    public void addExtension(String extension)
    {
        this.extensions.add(extension);
    }

    
    public boolean hasExtension(String ext)
    {
        return this.extensions.contains(ext);
    }
    
    
    public List<String> getExtensions()
    {
        return this.extensions;
    }
    
    
    public List<String> getMimes()
    {
        return this.mimes;
    }
    
    
    public boolean matchContentType(IContentType contentType)
    {
        List<String> mimes = contentType.getMimes();
        for (String mime : mimes)
        {
            if (this.hasMime(mime))
            {
                return true;
            }
        }
        
        List<String> extensions = contentType.getExtensions();
        for (String extension : extensions)
        {
            if (this.hasExtension(extension))
            {
                return true;
            }
        }        
        
        return false;
    }
    
    
    public static ContentType getByURL(URL url)
    {
        for (ContentType contenttype : ContentType.values())
        {
            if (contenttype.hasExtension(url.getExtension())
             || contenttype.hasMime(url.getMime()) )
                return contenttype;
        }
        
        return null;
    }
}
