package org.rows;


public class Server extends org.eclipse.jetty.server.Server {	
	private IConfiguration config;
	
	
	public Server()
	{
		this(80);
	}
	
	
	public Server(int port)
	{
		super(port);
	}	
}
