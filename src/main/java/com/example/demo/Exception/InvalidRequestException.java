package com.example.demo.Exception;

public class InvalidRequestException extends Exception{
	
	public InvalidRequestException(String msg)
	{
		super(msg);
	}
	public InvalidRequestException()
	{
		super("Invalid Request ! ");
	}

}
