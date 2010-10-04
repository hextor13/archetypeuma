package org.archetypeUma.ws.implementations;

import javax.jws.WebService;

import org.archetypeUma.model.pojos.City;
import org.archetypeUma.ws.interfaces.ICityWS;

@WebService(endpointInterface = "org.archetypeUma.ws.interfaces.ICityWS")
public class CityWSImpl implements ICityWS {

    public String example(String name) {
        return "I'm from..." + name;
    }

    public City getCity(String name) {
        City city = new City("MA", "Málaga");
        return city;
    }
}