package org.archetypeUma.services;

import javax.jws.WebService;
import org.archetypeUma.model.pojos.City;

@WebService(endpointInterface = "org.archetype.model.pojos.City")
public class CityServicesImpl implements ICityServices {

    public String example(String name) {
        return "I'm from..." + name;
    }

    public City getCity(String name) {
        City city = new City("MA", "Málaga");
        return city;
    }
}