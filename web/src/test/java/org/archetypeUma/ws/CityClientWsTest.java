package org.archetypeUma.ws;

import org.archetypeUma.model.pojos.City;
import org.archetypeUma.ws.interfaces.ICityWS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 *  En este test crearemos un cliente del Web Service utilizando Apache CXF.
 *  El cliente se crea dinámicamente a través de Spring. En el archivo de
 *  configuración de Spring applicationContext.xml de este test se declara
 *  el cliente, el cual cumplirá con la interfaz del Web Service.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/applicationContext-test.xml"})
public class CityClientWsTest {

    @Autowired
    @Qualifier("citiesClient")
    private ICityWS citiesClient;

    /**
     * Test of decirHola method, of class HolaMundo.
     */
    @Test
    public void testDecirHola() {
        String nombre = "Zim";
        String expResult = "Hola, " + nombre;
        City result = citiesClient.getCity(nombre);
        assertEquals(expResult, result);
    }

    // Getters && Setters

    public void setCitiesClient(ICityWS citiesClient) {
        this.citiesClient = citiesClient;
    }

}