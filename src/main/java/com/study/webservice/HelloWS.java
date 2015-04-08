package com.study.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**S
 * 
 * SEII
 * @author BULL
 *
 */
@WebService
public interface HelloWS {
	@WebMethod
	public String sayHello(String name);
}
