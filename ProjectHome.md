Es un archetype maven para el desarrollo ágil de proyectos en j2ee

Puedes descargarlo desde...

```
mvn archetype:generate -DremoteRepositories=https://archetypeuma.googlecode.com/svn/trunk/archetype-catalog.xml
 -DarchetypeGroupId=org.archetypeUma -DarchetypeArtifactId=archetypeUma-archetype -DarchetypeVersion=1.0-SNAPSHOT
```

según la versión de maven te funcionará con la llamada anterior o con la siguiente:

```
mvn archetype:generate -DarchetypeRepository=https://archetypeuma.googlecode.com/svn/trunk 
-DarchetypeGroupId=org.archetypeUma -DarchetypeArtifactId=archetypeUma-archetype -DarchetypeVersion=1.0-SNAPSHOT
```

Sigue la guía de instalación si tienes problemas. [QuickStart](QuickStart.md)

Características del arquetipo:

  * Trazabilidad: Log4j
  * Validaciones: Myfaces 2
  * Internacionalización: Myfaces 2
  * Threads: Spring 3 – Myfaces 2
  * Transaccionalidad: Spring 3
  * Seguridad: Spring Security 3
  * Sesión: J2SE
  * Excepciones: J2SE
  * Pool: Conexiones BD: Spring 3 - Pool-DBCP
  * Cache: OSCache+hibernate  3
  * Plantillas: Faceslets en myfaces 2.0
  * Componentes JSF2: Primefaces2 y Tomahawh2
  * ORM: Hibernate 3