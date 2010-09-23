package org.archetypeUma.ws.interfaces;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import org.archetypeUma.model.pojos.City;

@WebService
public interface ICityWS {

    String example(String name);

    @WebResult(name="city")
    City getCity(@WebParam(name="city") String name);

}
