# What´s it? #

JMock is an API for unitary system tests in Java. It uses JUnit to do some operations.

# How does it work? #
JMock allows to create unitary tests. JMock shows  determined components and replace them by his 'Mocks'. Mocks is an expression that    represents a mock. That´s the main advantage of Mocks, it´s not necessary to test what does an object of the program do if being sure the program works right. The best of create an object “Mockery” which replaces all functionality  and we do the test depending what they return.
The JMock tests are relied on Junit4 so must declare the next annotation into the header:
@RunWith(JMock.class)
Each test must be accompanied of the annotation
@test


# Instalation #

Only must introduce into the pom.xml file the dependency to JMock´s jar
```
<dependency>
<groupId>org.jmock</groupId>
<artifactId>jmock-junit4</artifactId>
<version>2.5.1</version>
<scope>test</scope>
</dependency>
```

# Use #


To program a test in JMock we must consider several factors which are very important:
  * The number of invocations to a Mock

|Method|Description|
|:-----|:----------|
|oneOf |The invocation to this method has been only once.|
|exactly(n).of|The invocation is expected n times.|
|atLeast(n).of|The invocation is expected until n times.|
|atMost(n).of|The invocation is expected at least n times.|
|between(min, max).of|The invocation is expected from a range.|
|allowing|The invocation is allowed some number of times but could not occur.|
|ignoring|Similar to previous.|
|never |The invocation to this mock should not occur.|


  * Checking arguments. Checking the arguments that enter to a method are the expecteds:
|Method|Description|
|:-----|:----------|
|equal(n)|The arguments are equal to n.|
|same(o)|The arguments are an object like o.|
|any(Class< T > type)|The argument is some instance of type established in type.|
|a(Class< T > type)|The argument is an instance of the type or of a subclass.|
|an(Class< T > type)|The argument is an instance of the type or of a subclass.|
|aNull(Class< T > type)|The argument is null.|
|aNonNull(Class< T > type)|The argument isn´t null.|
|not(m)|The arguments aren´t m.|
|anyOf(m1, m2, ..., mn)|The arguments are between m1 y mn.|
|allOf(m1, m2, ..., mn)|The arguments are which are found between m1 y mn.|

  * Actions. It´s possible to specify what return each Mock, the methods which achieve that are:
|Method|Description|
|:-----|:----------|
|will(returnValue(v))|It´s returns the object c to be called.|
|will(returnIterator(c))|It´s returns a new iterador over the collection named c by each invocation.|
|will(returnIterator(v1, v2, ..., vn))|It´s a new un nuevo iterator by each element of the invocation, from v1 to vn.|
|will(throwException(e))|It´s returns an exception.|
|will(doAll(a1, a2, ..., an))|It does many actions on an invocation.|

Example of test done with JMock:
```
package org.archetypeUma.services;
@RunWith(JMock.class)
public class IUserManagerTest {
    // Mock context
    private Mockery      context     = new Mockery();
    private IUserManager userManager = null;
    private IUserDao     userDao     = context.mock(IUserDao.class);
    private ICityDao     cityDao     = context.mock(ICityDao.class);

    @Before
    public void setUp() {
        userManager = new UserManagerImpl();
        userManager.setUserDao(userDao);
        userManager.setCityDao(cityDao);
    }

    @Test
    public void testGetAll() {
        final List<User> usuarios = new ArrayList<User>();
        usuarios.add(new User("jcisneros", "javier"));
        context.checking(new Expectations() {
            {
                one(userDao).getAll();
                will(returnValue(usuarios));
            }
        });
        assertEquals(userManager.getAll(), usuarios);
        context.assertIsSatisfied();
    }

    @Test
    public void testGetAllCity() {
        final List<City> cities = new ArrayList<City>();
        cities.add(new City("MA", "Málaga"));
        context.checking(new Expectations() {
            {
                one(cityDao).getAllCache();
                will(returnValue(cities));
            }
        });
        assertEquals(userManager.getAllCity(), cities);
        context.assertIsSatisfied();
    }
}
```
In this example of archetype there's a class to do the test for IUserManager.java.
There're two methods: one does a test for getAllCity and another for getAll. Both of them check if the dao is called to get the results and test the data from output of the method is equal the values which the dao returns.
Really the test of JUnit only have very  much difficult when there are conditions into the method which is being test.  By each 'if' that exists into the code, should to do a method to test it.


# Links #

  * http://www.jmock.org/

# ¿Qué es? #

JMock es una API para las pruebas unitarias de sistema en Java. Utiliza Junit para algunas operaciones.

# ¿Como funciona ? #

JMock permite la creación de test unitarios exhibiendo determinados componentes y sustituyéndolos por sus 'Mocks'. Mocks es una expresión que representa una burla. Esa es la principal ventaja de los Mocks, no hace falta probar que hace un objeto que tiene el programa si se esta seguro que el programa funciona. Lo mejor es crear un objeto “Mockery” que sustituya a toda esa funcionalidad y que hagamos el test dependiendo de lo que devuelvan.
Los test de JMock se apoyan en Junit4 por lo que hay que declarar en la cabecera la anotación:
@RunWith(JMock.class)
Cada test tiene que ir acompañado de la anotación
@test


# Instalación #

Solo hay que meter en el pom.xml la dependencia al jar de JMock.
```
<dependency>
<groupId>org.jmock</groupId>
<artifactId>jmock-junit4</artifactId>
<version>2.5.1</version>
<scope>test</scope>
</dependency>
```


# Uso #

Al programar una prueba en Jmock hay que tener en cuenta varios factores que son muy importantes:
  * El número de invocaciones a un Mock.

|Método|Descripción|
|:-----|:----------|
|oneOf |La invocación a este método se ha producido una sola vez.|
|exactly(n).of|La invocación es esperada n veces.|
|atLeast(n).of|La invocación es esperada hasta n veces.|
|atMost(n).of|La invocación es esperada al menos n veces.|
|between(min, max).of|La invocación se espera entre un intervalo.|
|allowing|La invocación es permitida algún número de veces pero no tiene porque suceder.|
|ignoring|Similar a la de permitir.|
|never |La invocación a este mock no se debería de producir.|


  * Comprobación de argumentos. Se comprueba que los argumentos que entran a un método son los esperados:
|Método|Descripción|
|:-----|:----------|
|equal(n)|Los argumentos son iguales que n.|
|same(o)|Los argumentos son un objeto como o.|
|any(Class< T > type)|El argumento es alguna instancia del tipo que se establezca en type.|
|a(Class< T > type)|El argumento es una instancia del tipo o de una subclase.|
|an(Class< T > type)|El argumento es una instancia del tipo o de una subclase.|
|aNull(Class< T > type)|El argumento es null.|
|aNonNull(Class< T > type)|El argumento no es null.|
|not(m)|Los argumentos no son m.|
|anyOf(m1, m2, ..., mn)|Los argumentos se encuentrar entre m1 y mn.|
|allOf(m1, m2, ..., mn)|Los argumentos son los que se encuentrar entre m1 y mn.|

  * Acciones. Se puede especificar que devuelve cada Mock, los métodos que lo consiguen son:
|Método|Descripción|
|:-----|:----------|
|will(returnValue(v))|Devuelve el objeto c al ser llamado.|
|will(returnIterator(c))|Devuelve un nuevo Iterador sobre la colección c para cada invocación.|
|will(returnIterator(v1, v2, ..., vn))|Devuelve un nuevo iterador para cada elemento invocación, desde v1 hasta vn.|
|will(throwException(e))|Devuelve una excepción.|
|will(doAll(a1, a2, ..., an))|Hace muchas acciones sobre una invocación.|

Ejemplo de test realizado con JMock:
```
package org.archetypeUma.services;
@RunWith(JMock.class)
public class IUserManagerTest {
    // Mock context
    private Mockery      context     = new Mockery();
    private IUserManager userManager = null;
    private IUserDao     userDao     = context.mock(IUserDao.class);
    private ICityDao     cityDao     = context.mock(ICityDao.class);

    @Before
    public void setUp() {
        userManager = new UserManagerImpl();
        userManager.setUserDao(userDao);
        userManager.setCityDao(cityDao);
    }

    @Test
    public void testGetAll() {
        final List<User> usuarios = new ArrayList<User>();
        usuarios.add(new User("jcisneros", "javier"));
        context.checking(new Expectations() {
            {
                one(userDao).getAll();
                will(returnValue(usuarios));
            }
        });
        assertEquals(userManager.getAll(), usuarios);
        context.assertIsSatisfied();
    }

    @Test
    public void testGetAllCity() {
        final List<City> cities = new ArrayList<City>();
        cities.add(new City("MA", "Málaga"));
        context.checking(new Expectations() {
            {
                one(cityDao).getAllCache();
                will(returnValue(cities));
            }
        });
        assertEquals(userManager.getAllCity(), cities);
        context.assertIsSatisfied();
    }
}
```
En el ejemplo del arquetipo hay una clase que hace el test a IUserManager.java.
Hay dos métodos uno que le hace un test a getAllCity y otro a getAll. En ambos se comprueba que se esste llamando al dao para conseguir los resultados y se comprueba que los datos que vienen por la salida del método coinciden con los valores que esta devolviendo el dao.
Realmente los test de Junit solo tienen mucha dificultad cuando hay condiciones dentro del método que se esta testeando. Por cada 'if' que hubiera en el código habría que hacer un caso de estudio o un método que lo testee.

# Enlaces #

  * http://www.jmock.org/