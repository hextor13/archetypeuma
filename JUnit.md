# What´s it? #

Junit is a Frameworks to automate unitary test of Java applications. It´s Open Source Software. It was created by Erich Gamma and Kent Beck.
It has a set of Java classes which the programmers can use to build their test cases and execute them automatically.
Really, test cases are Java programs. These stay saved and can be executed so times as it´s necessary.
It´s suitable for the development para el desarrollo dirigido por las pruebas. Test-driven develoment, it's a technology was thought a few years ago which tells not to program and then pass test, but must to make a test that has inputs and outputs we need and then implement the required development code to solve the possible errors.

# How does it work? #

JUnit test are executed as a simple Java class, although those have a type of injections and annotations that do them more specials. Therefore, the best way to execute the test is through other applications which are able to interpret them. The method more usual is through Maven, Ant or any IDE which has integrated unitary tests into their properties.

Junit provides an Api to execute the tests. That has a set of Java classes and objects to facilitate the testing.

All JUnit tests must have this annotation:
@RunWith(SpringJUnit4ClassRunner.class)
This annotation expresses we going to make a JUnit test using Spring.

Next annotation:
```
@ContextConfiguration(locations = {
        "classpath:/spring/applicationContext-resources.xml",
        "classpath:/spring/applicationContext-dao.xml",
        "classpath:/spring/applicationContext-service.xml" })
```
It´s used to specify the Spring´s context which is necessary to execute the test correcty.

Each method which could be used like a test for another method must be cataloged with the next annotation:
@Test


# Instalation #

Maven uses determined life cycles for execution of tests. Having as dependency the JUnit Java:
```
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.5</version>
<scope>test</scope>
</dependency>
```
The Spring´s beans need to be injected to make the tests. Spring has resolved this mechanism but the dependency must be injected to spring-test.
```
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-test</artifactId>
<version>3.0.3.RELEASE</version>
</dependency>
```
# Use #

The example going to be presented with the Java class named ICityDao.java.
```
package org.archetypeUma.dao;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.archetypeUma.dao.interfaces.ICityDao;
import org.archetypeUma.model.pojos.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring/applicationContext-resources.xml",
        "classpath:/spring/applicationContext-dao.xml",
        "classpath:/spring/applicationContext-service.xml" })
public class ICityDaoTest {
    @Autowired
    private ICityDao cityDao;
    @Test
    public void testGetAll() {
        List<City> cities = cityDao.getAll();
        assertEquals(3, cities.size());
}
    // Getters & Setters
    public void setCityDao(ICityDao cityDao) {
        this.cityDao = cityDao;
    }
}
```
Must to inject DAO layer using annotation @Autowired and test one by one all methods belong to this layer. The following example tests the method named getAll. The conclusion of this test is the method works right cause in data base there are three towns which have been preloaded with sample-data.xml and this is that the method has returned.

# Links #

  * www.junit.org

# ¿Qué es? #

Junit es un frameworks para automatizar las pruebas unitarias de aplicaciones Java. Es un software de código abierto. Fue creado por Erich Gamma  y Kent Beck.
Consta de un conjunto de clases que el programador puede utilizar para construir sus casos de prueba y ejecutarlos automáticamente.
Los casos de prueba son realmente programas Java. Quedan archivados y pueden ser reejecutados tantas veces como sea necesario.
Es adecuado para el desarrollo dirigido por las pruebas. Test-driven develoment, tecnología planteada hace poco años que sostiene que no hay que programar y luego hacer un test que lo pruebe, sino que hay que hacer un test que tenga las entradas y las salidas que nosotros queremos y luego implementar el código que se necesite para solucionarlo.

# ¿Como funciona ? #

Los test de Junit se ejecutan como una clase Java normal, aunque tienen una clase de inyecciones y anotaciones que lo hacen un poco especial. Por lo tanto la mejor manera de ejecutar estos test es por medio de otra aplicación que sea capaz de interpretarlos de la mejor manera. La forma más utilizada es por maven, ant o por algún IDE que ya tenga bien integradas las pruebas unitarias dentro de sus características.

Junit proporciona una Api para la ejecución de los test. Tiene una serie de clases y objetos que facilitan el testeo.

Todos los test en Junit tienen que llevar la anotación:
@RunWith(SpringJUnit4ClassRunner.class)
Esta anotación expresa que vamos a realizar un test en Junit utilizando spring.

La siguiente anotación:
```
@ContextConfiguration(locations = {
        "classpath:/spring/applicationContext-resources.xml",
        "classpath:/spring/applicationContext-dao.xml",
        "classpath:/spring/applicationContext-service.xml" })
```
Se usa para especificar el contexto de Spring que es necesario para que el test se ejecute correctamente.

Cada método que sirva de test de otro método de la aplicación hay que catalogarlos con la anotación
@Test

# Instalación #

Maven utiliza determinados ciclos de vida solo para la ejecución de test. Teniendo como dependencia la Api de Junit:
```
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.5</version>
<scope>test</scope>
</dependency>
```
Los beans de spring necesitan ser inyectados para las pruebas. Spring ha resuelto este mecanismo pero hay que inyectar la dependencia a spring-test.
```
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-test</artifactId>
<version>3.0.3.RELEASE</version>
</dependency>
```
# Uso #

El ejemplo se va a presentar con la clase ICityDao.java
```
package org.archetypeUma.dao;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.archetypeUma.dao.interfaces.ICityDao;
import org.archetypeUma.model.pojos.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring/applicationContext-resources.xml",
        "classpath:/spring/applicationContext-dao.xml",
        "classpath:/spring/applicationContext-service.xml" })
public class ICityDaoTest {
    @Autowired
    private ICityDao cityDao;
    @Test
    public void testGetAll() {
        List<City> cities = cityDao.getAll();
        assertEquals(3, cities.size());
}
    // Getters & Setters
    public void setCityDao(ICityDao cityDao) {
        this.cityDao = cityDao;
    }
}
```
Hay que inyectar la capa DAO con @Autowired y probar uno a uno todos los métodos de esta capa. En este caso se ha probado el método getAll. Se ha llegado a la conclusión de que funciona correctamente ya que en la base de datos hay 3 ciudades que han sido precargada con el sample-data.xml y es lo que este método ha obtenido.

# Enlaces #

  * www.junit.org