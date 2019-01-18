package com.interstellar.transport.system.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.interstellar.transport.system.model.ShortestPath;

/*
 * SOAP service interface to return the shortest path info
 * 
 * */
@WebService
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL)
public interface ShortestPathSOAPService {

	@WebMethod
	ShortestPath getShortestPath(String source, String target);
}
