package org.archetypeUma.ws.implementations;

import javax.jws.WebService;

import org.archetypeUma.model.pojos.City;
import org.archetypeUma.ws.interfaces.ICityWS;

@WebService(serviceName = "cities",
        endpointInterface = "org.archetypeUma.ws.interfaces.ICityWS",
        targetNamespace="http://localhost:8080/archetypeUma/ws", portName="citiesPort")
public class CityWSImpl implements ICityWS {

    public City getCity(String name) {
        City city = new City("MA", "Málaga");
        return city;
    }
}