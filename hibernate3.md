# What´s it? #

Hibernate es un ORM (Object-Relational Mapping) para Java.  Es una capa de persistencia objeto/relacional y un generador de sentencias sql. Permite diseñar objetos persistentes que podrán incluir polimorfismo, relaciones, colecciones, y un gran número de tipos de datos. De una manera muy rápida y optimizada puede generar BBDD en cualquiera de los entornos soportados : Oracle, DB2, MySql, Postgresql.
Es software libre y su código es abierto, bajo licencia LGPL. Actualmente el proyecto pertenece a  Red Hat pero esta cedido a la fundación Apache.

Fue creado en 2001 por Gavin King.

Un ORM es una tecnología capaz de entender que una clase de Java se corresponde con una tabla de la base de datos y que un objeto de Java se corresponde con una tupla de la base de datos.

Hibernate ha estado mejorando. La mejora más significativa la consiguió cuando cambio los engorrosos XML por anotaciones, después de que saliera el estándar JPA.

El estándar JPA (Java Persistence API) fue descrito en la Java Specification Request (JSR) 220.

Con el fin de meter al lector en conocimiento de la utilizad de hibernate se va a exponer un ejemplo de como se insertaba un usuario en base de datos antes de hibernate y después de hibernate.

  * Sin hibernate:
```
Class.forName("org.hsqldb.jdbcDriver");
String url = "jdbc:hsqldb:./Databases/ejemplo";
Connection connection = DriverManager.getConnection(url, "root", "pass");
String ins = "INSERT INTO TABLE_USER VALUES("jcisneros", "javier")";
Statement stmt = null;
stmt = connection.createStatement();
stmt.executeUpdate(ins);
```
  * Con hibernate y spring:
```
User user = new User("jcisneros", "javier");
userDao.save(user);
```

# How does it work? #

Hibernate funciona con dos tipos de anotaciones. Las suyas propias y las que provienen del estándar JPA. Las del estándar son suficientes para la mayoría de las aplicaciones que se quieran producir y las de hibernate añaden funcionalidad para problemas más concretos.

El HQL (Hibernate Query Language) es un lenguaje de interrogación. En el mundo relacional
disponemos del SQL (Structured Query Language) que nos permite obtener información haciendo
preguntas basadas en las tablas y sus columnas. El equivalente en el mundo actual es el HQL, que
nos permite hacer preguntas basadas en los objetos y sus propiedades.
Hibernate se encarga traducir las consultas que hacemos desde las clases en HQL al lenguaje de interrogación de la base de datos relacional, el SQL, y transforma los resultados obtenidos en la base de datos relacional (filas y columnas) en objetos de Java.

Además, Hibernate hace uso de APIs de Java, tales como JDBC, JTA (Java Transaction Api)
y JNDI (Java Naming Directory Interface).

Los objetos más importantes definidos en hibernate son:

  * La interfaz Session es una de las interfaces primarias en cualquier aplicación Hibernate. Una instancia de Session es "poco pesada" y su creación y destrucción es muy "barata". Esto es importante, ya que la aplicación necesitará crear y destruir sesiones todo el tiempo, quizá en cada petición. Puede ser útil pensar en una sesión como en una caché o colección de objetos cargados (desde una base de datos) relacionados con una única unidad de trabajo. Hibernate puede detectar cambios en los objetos pertenecientes a una unidad de trabajo.
  * La interfaz SessionFactory permite obtener instancias Session. Esta interfaz no es "ligera", y debería compartirse entre muchos hilos de ejecución. Típicamente hay una única SessionFactory para toda la aplicación, creada durante la inicialización de la misma. Sin embargo, si la aplicación accede a varias bases de datos se necesitará una SessionFactory por cada base de datos.
  * La interfaz Configuration se utiliza para configurar y "arrancar" Hibernate. La aplicación utiliza una instancia de Configuration para especificar la ubicación de los documentos que indican el mapeado de los objetos y propiedades específicas de Hibernate, y a continuación crea la sessionFactory.
  * La interfaz Query permite realizar peticiones a la base de datos y controla cómo se ejecuta dicha petición (query). Las peticiones se escriben en HQL o en el dialecto SQL nativo de la base de datos que estemos utilizando. Una instancia Query se utiliza para enlazar los parámetros de la petición, limitar el número de resultados devueltos por la petición, y para ejecutar dicha petición.

Si se quiere llegar a entender el funcionamiento de hibernate hay que empezar por comprender el ciclo de vida que sigue un objeto que es manipulado por hibernate.

Los estados son Transient, Persistent y Detached y los procesos por los que cambia de estado un objeto son esos métodos que se invocan desde el código y que hacen que el objeto cambie. El estado más importante es el de Persistent al que se llega cuando se invoca un save sobre el objeto.

# Instalation #


Requisitos obligatorios: Mysql o postgresql
Requisitos opcionales: Spring frameworks

Hibernate necesita estas dependencias para funcionar correctamente dentro de un proyecto.
```
<dependency>
<groupId>org.hibernate</groupId>
<artifactId>hibernate-core</artifactId>
<version>3.5.0-CR-2</version>
</dependency>

<dependency>
<groupId>org.hibernate</groupId>
<artifactId>hibernate-annotations</artifactId>
<version>3.5.0-CR-2</version>
</dependency>

<dependency>
<groupId>org.hibernate</groupId>
<artifactId>hibernate-entitymanager</artifactId>
<version>3.5.0-CR-2</version>
</dependency>

<dependency>
<groupId>javassist</groupId>
<artifactId>javassist</artifactId>
<version>3.9.0.GA</version>
<scope>runtime</scope>
</dependency>

<dependency>
<groupId>org.slf4j</groupId>
<artifactId>slf4j-api</artifactId>
<version>1.6.1</version>
</dependency>

<dependency>
<groupId>net.sf.ehcache</groupId>
<artifactId>ehcache</artifactId>
<version>1.5.0</version>
</dependency> 
```

Es necesario crear una serie de beans para que la aplicación sepa cual es el datasource y demás configuraciones de eclipse. Esto se ha explicado en el apartado de arquitectura y aquí se hace referencia para que sea más fácil la lectura del documento.

# Use #

A conticuación se listan las anotaciones más utilizadas:

|Anotación|Descripción|
|:--------|:----------|
|@Entity  |Declara la entidad que será persistida|
|@Table(name=”TABLE\_USER”);|Asigna el nombre de la tabla|
|@Id      |Representa la clave primaria de la tabla|
|@GeneratedValue|Generá la clave primaria, en esta ocasión se creará una secuencia, pero hibernate da varias posibilidades.|
|@Lob     |Corresponden a los campos del tipo BLOB y CLOB.|
|@Temporal|@Temporal(TemporalType.DATE) definido para el tipo java.sql.Date. @Temporal(TemporalType.TIME) definido para el tipo java.sql.Time. @Temporal(TemporalType.TIMESTAMP) definido para el tipo java.sql.Timestamp.|
|@Transient|Se marca así un atributo no será persistido.|
|@OneToOne, @ManyToOne, @OneToMany, @ManyToMany|Relaciones entre tablas. A la izquierda del To se entiende que es esa misma clase y a la derecha la otra clase.|
|@JoinColumn (ManyToOne), @JoinTable (ManyToMany)|Indica como se relacionan las dos tablas.|
|@Inheritance|Expresa herencia, se puede utilizar de varias formas según la estrategia para recuperar los datos: strategy=InheritanceType.TABLE\_PER\_CLASS, strategy=InheritanceType.JOINED, (strategy=InheritanceType.SINGLE\_TABLE)|


Hay que tener en cuenta como hibernate recupera los elementos, para eso existen dos atributos en las anotaciones:

  * FetchType.LAZY: recuperación tardía. Valor por defecto para:
> - OneToMany
> - ManyToMany
  * FetchType.EAGER: recuperación temprana. Valor por defecto para:
> - OneToOne
> - ManyToOne

Y se pueden utilizar los métodos para recuperarlos:
  * session.get() hace recuperación temprana.
  * session.load() hace recuperación tardía

Existen muchas formas de interactuar con la base de datos por medio de hibernate. Todas distintas en esencia aunque la mayoría hacen lo mismo.

  * Criterias: Son unos objetos que definen búsquedas condicionales contra algunos objetos. Es decir, si se esta buscando las vuelos con salida de málaga y destino granada, en las que estas son elegidas en combos, lo ideal sería ponerlo en este tipo de búsquedas.
  * HQL: Es un lenguaje creado para ser utilizado desde hibernate. Tiene una nomenclatura sencilla y parecida al sql pero con algunas diferencias para que se interactúe con objetos y no con tablas.
  * Query: son un tipo de búsqueda especial en hibernate, la cual se puede definir en una anotación o ponerla directamente.

Lo que se pretende es hacer que búsqueda sea lo más fácil posible de crear y de entender, pero no queremos confundir al lector, con los tres tipos de búsqueda se puede hacer las mismas búsquedas.

# Links #

  * http://www.hibernate.org/

Documentation core
  * http://docs.jboss.org/hibernate/stable/core/reference/en/html/

Documentation entityManager
  * http://docs.jboss.org/hibernate/stable/entitymanager/reference/en/html/

Documentation annotation
  * http://docs.jboss.org/hibernate/stable/annotations/reference/en/html/

# ¿Qué es? #

Hibernate es un ORM (Object-Relational Mapping) para Java.  Es una capa de persistencia objeto/relacional y un generador de sentencias sql. Permite diseñar objetos persistentes que podrán incluir polimorfismo, relaciones, colecciones, y un gran número de tipos de datos. De una manera muy rápida y optimizada puede generar BBDD en cualquiera de los entornos soportados : Oracle, DB2, MySql, Postgresql.
Es software libre y su código es abierto, bajo licencia LGPL. Actualmente el proyecto pertenece a  Red Hat pero esta cedido a la fundación Apache.

Fue creado en 2001 por Gavin King.

Un ORM es una tecnología capaz de entender que una clase de Java se corresponde con una tabla de la base de datos y que un objeto de Java se corresponde con una tupla de la base de datos.

Hibernate ha estado mejorando. La mejora más significativa la consiguió cuando cambio los engorrosos XML por anotaciones, después de que saliera el estándar JPA.

El estándar JPA (Java Persistence API) fue descrito en la Java Specification Request (JSR) 220.

Con el fin de meter al lector en conocimiento de la utilizad de hibernate se va a exponer un ejemplo de como se insertaba un usuario en base de datos antes de hibernate y después de hibernate.

  * Sin hibernate:
```
Class.forName("org.hsqldb.jdbcDriver");
String url = "jdbc:hsqldb:./Databases/ejemplo";
Connection connection = DriverManager.getConnection(url, "root", "pass");
String ins = "INSERT INTO TABLE_USER VALUES("jcisneros", "javier")";
Statement stmt = null;
stmt = connection.createStatement();
stmt.executeUpdate(ins);
```
  * Con hibernate y spring:
```
User user = new User("jcisneros", "javier");
userDao.save(user);
```

# ¿Como funciona ? #

Hibernate funciona con dos tipos de anotaciones. Las suyas propias y las que provienen del estándar JPA. Las del estándar son suficientes para la mayoría de las aplicaciones que se quieran producir y las de hibernate añaden funcionalidad para problemas más concretos.

El HQL (Hibernate Query Language) es un lenguaje de interrogación. En el mundo relacional
disponemos del SQL (Structured Query Language) que nos permite obtener información haciendo
preguntas basadas en las tablas y sus columnas. El equivalente en el mundo actual es el HQL, que
nos permite hacer preguntas basadas en los objetos y sus propiedades.
Hibernate se encarga traducir las consultas que hacemos desde las clases en HQL al lenguaje de interrogación de la base de datos relacional, el SQL, y transforma los resultados obtenidos en la base de datos relacional (filas y columnas) en objetos de Java.

Además, Hibernate hace uso de APIs de Java, tales como JDBC, JTA (Java Transaction Api)
y JNDI (Java Naming Directory Interface).

Los objetos más importantes definidos en hibernate son:

  * La interfaz Session es una de las interfaces primarias en cualquier aplicación Hibernate. Una instancia de Session es "poco pesada" y su creación y destrucción es muy "barata". Esto es importante, ya que la aplicación necesitará crear y destruir sesiones todo el tiempo, quizá en cada petición. Puede ser útil pensar en una sesión como en una caché o colección de objetos cargados (desde una base de datos) relacionados con una única unidad de trabajo. Hibernate puede detectar cambios en los objetos pertenecientes a una unidad de trabajo.
  * La interfaz SessionFactory permite obtener instancias Session. Esta interfaz no es "ligera", y debería compartirse entre muchos hilos de ejecución. Típicamente hay una única SessionFactory para toda la aplicación, creada durante la inicialización de la misma. Sin embargo, si la aplicación accede a varias bases de datos se necesitará una SessionFactory por cada base de datos.
  * La interfaz Configuration se utiliza para configurar y "arrancar" Hibernate. La aplicación utiliza una instancia de Configuration para especificar la ubicación de los documentos que indican el mapeado de los objetos y propiedades específicas de Hibernate, y a continuación crea la sessionFactory.
  * La interfaz Query permite realizar peticiones a la base de datos y controla cómo se ejecuta dicha petición (query). Las peticiones se escriben en HQL o en el dialecto SQL nativo de la base de datos que estemos utilizando. Una instancia Query se utiliza para enlazar los parámetros de la petición, limitar el número de resultados devueltos por la petición, y para ejecutar dicha petición.

Si se quiere llegar a entender el funcionamiento de hibernate hay que empezar por comprender el ciclo de vida que sigue un objeto que es manipulado por hibernate.

Los estados son Transient, Persistent y Detached y los procesos por los que cambia de estado un objeto son esos métodos que se invocan desde el código y que hacen que el objeto cambie. El estado más importante es el de Persistent al que se llega cuando se invoca un save sobre el objeto.

# Instalación #

Requisitos obligatorios: Mysql o postgresql
Requisitos opcionales: Spring frameworks

Hibernate necesita estas dependencias para funcionar correctamente dentro de un proyecto.
```
<dependency>
<groupId>org.hibernate</groupId>
<artifactId>hibernate-core</artifactId>
<version>3.5.0-CR-2</version>
</dependency>

<dependency>
<groupId>org.hibernate</groupId>
<artifactId>hibernate-annotations</artifactId>
<version>3.5.0-CR-2</version>
</dependency>

<dependency>
<groupId>org.hibernate</groupId>
<artifactId>hibernate-entitymanager</artifactId>
<version>3.5.0-CR-2</version>
</dependency>

<dependency>
<groupId>javassist</groupId>
<artifactId>javassist</artifactId>
<version>3.9.0.GA</version>
<scope>runtime</scope>
</dependency>

<dependency>
<groupId>org.slf4j</groupId>
<artifactId>slf4j-api</artifactId>
<version>1.6.1</version>
</dependency>

<dependency>
<groupId>net.sf.ehcache</groupId>
<artifactId>ehcache</artifactId>
<version>1.5.0</version>
</dependency> 
```

Es necesario crear una serie de beans para que la aplicación sepa cual es el datasource y demás configuraciones de eclipse. Esto se ha explicado en el apartado de arquitectura y aquí se hace referencia para que sea más fácil la lectura del documento.

# Uso #


A conticuación se listan las anotaciones más utilizadas:

|Anotación|Descripción|
|:--------|:----------|
|@Entity  |Declara la entidad que será persistida|
|@Table(name=”TABLE\_USER”);|Asigna el nombre de la tabla|
|@Id      |Representa la clave primaria de la tabla|
|@GeneratedValue|Generá la clave primaria, en esta ocasión se creará una secuencia, pero hibernate da varias posibilidades.|
|@Lob     |Corresponden a los campos del tipo BLOB y CLOB.|
|@Temporal|@Temporal(TemporalType.DATE) definido para el tipo java.sql.Date. @Temporal(TemporalType.TIME) definido para el tipo java.sql.Time. @Temporal(TemporalType.TIMESTAMP) definido para el tipo java.sql.Timestamp.|
|@Transient|Se marca así un atributo no será persistido.|
|@OneToOne, @ManyToOne, @OneToMany, @ManyToMany|Relaciones entre tablas. A la izquierda del To se entiende que es esa misma clase y a la derecha la otra clase.|
|@JoinColumn (ManyToOne), @JoinTable (ManyToMany)|Indica como se relacionan las dos tablas.|
|@Inheritance|Expresa herencia, se puede utilizar de varias formas según la estrategia para recuperar los datos: strategy=InheritanceType.TABLE\_PER\_CLASS, strategy=InheritanceType.JOINED, (strategy=InheritanceType.SINGLE\_TABLE)|


Hay que tener en cuenta como hibernate recupera los elementos, para eso existen dos atributos en las anotaciones:

  * FetchType.LAZY: recuperación tardía. Valor por defecto para:
> - OneToMany
> - ManyToMany
  * FetchType.EAGER: recuperación temprana. Valor por defecto para:
> - OneToOne
> - ManyToOne

Y se pueden utilizar los métodos para recuperarlos:
  * session.get() hace recuperación temprana.
  * session.load() hace recuperación tardía

Existen muchas formas de interactuar con la base de datos por medio de hibernate. Todas distintas en esencia aunque la mayoría hacen lo mismo.

  * Criterias: Son unos objetos que definen búsquedas condicionales contra algunos objetos. Es decir, si se esta buscando las vuelos con salida de málaga y destino granada, en las que estas son elegidas en combos, lo ideal sería ponerlo en este tipo de búsquedas.
  * HQL: Es un lenguaje creado para ser utilizado desde hibernate. Tiene una nomenclatura sencilla y parecida al sql pero con algunas diferencias para que se interactúe con objetos y no con tablas.
  * Query: son un tipo de búsqueda especial en hibernate, la cual se puede definir en una anotación o ponerla directamente.

Lo que se pretende es hacer que búsqueda sea lo más fácil posible de crear y de entender, pero no queremos confundir al lector, con los tres tipos de búsqueda se puede hacer las mismas búsquedas.

# Enlaces #

  * http://www.hibernate.org/

Documentation core
  * http://docs.jboss.org/hibernate/stable/core/reference/en/html/

Documentation entityManager
  * http://docs.jboss.org/hibernate/stable/entitymanager/reference/en/html/

Documentation annotation
  * http://docs.jboss.org/hibernate/stable/annotations/reference/en/html/