package org.archetypeUma.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@ContextConfiguration(locations={"classpath:com/dosideas/cxf/applicationTest.xml"})
public class ClienteHolaMundoTest {

    @Autowired
    private HolaMundo instance;

    /**
     * Test of decirHola method, of class HolaMundo.
     */
    @Test
    public void testDecirHola() {
        System.out.println("decirHola");
        String nombre = "Zim";
        String expResult = "Hola, " + nombre;

        String result = instance.decirHola(nombre);

        assertEquals(expResult, result);
    }

    /**
     * Test of buscarPersona method, of class HolaMundo.
     */
    @Test
    public void testBuscarPersona() {
        System.out.println("buscarPersona");
        long legajo = 29L;

        Persona result = instance.buscarPersona(legajo);

        assertNotNull(result);
        assertEquals(legajo, result.getLegajo());
        assertNotNull(result.getNombre());
        assertTrue(!result.getNombre().isEmpty());
    }

}