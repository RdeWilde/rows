package org.rows;

public class URI {
	
	
	public String getQueryParam(String id)
	{
		return null;
	}
	public QueryParam addQueryParam(String id)
	{
		return new QueryParam();
	}
	
	
	public String getPathParam(String id)
	{
		return null;
	}
	public PathParam addPathParam(String id, String pattern)
	{
		return new PathParam();
	}
	
	
	public String getHeaderParam(String id)
	{
		return null;
	}
	public HeaderParam addHeaderParam(String id)
	{
		return new HeaderParam();
	}
	
}
