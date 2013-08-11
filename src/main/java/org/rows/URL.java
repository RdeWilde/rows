package org.rows;

import java.net.MalformedURLException;

public class URL implements IURL
{
    private java.net.URL url;
    private String filesuffix;
    
    public URL(StringBuffer url) throws MalformedURLException
    {
        this(url.toString());
    }
    
    public URL(String url) throws MalformedURLException
    {
        this.url = new java.net.URL(url);
    }
    
    public String getHost()
    {
        return this.url.getHost();
    }
    
    
    public int getPort()
    {
        return this.url.getPort();
    }
    
    
    public String getPath()
    {
        return this.url.getPath();
    }
    
    
    public String getTrimmedPath()
    {
        String path = this.getPath();
        
        if (path.contains("."))
            path = path.substring( 0, path.lastIndexOf(".") );
        
        // URL decode?
        // Trim trailing slash?
        
        return path;
    }
    
    private String getFileSuffix()
    {
        if((this.filesuffix == null)
         && this.getFile().contains(".") )
            this.filesuffix = this.getFile().substring( this.getFile().lastIndexOf(".")+1 ); 
        
        return this.filesuffix;
    }
    
    private boolean isExtension(String ext)
    {
        return this.url.getPath().endsWith("." + ext);
    }
    
    public String getExtension()
    {   
        if (this.isExtension( this.getFileSuffix() ))
            return this.getFileSuffix();
            
        return null;
    }
    
    private boolean isMime(String mime)
    {
        return this.url.getPath().endsWith(".[" + mime + "]");        
    }
    
    public String getMime()
    {
        if (this.isMime( this.getFileSuffix() ))
            return this.getFileSuffix();
        
        return null;
    }
    
    public ContentType getContentType()
    {
        return ContentType.getByURL(this);
    }
    

    public String getProtocol()
    {
        return this.url.getProtocol();
    }
    
    
    public String getFile()
    {
        return this.url.getFile();
    }
    
    
    public String getQuery()
    {
        return this.url.getQuery();
    }
    
    
    public String getRef()
    {
        return this.url.getRef();
    }
    
    public java.net.URL getURL()
    {
        return this.url;
    }
}
