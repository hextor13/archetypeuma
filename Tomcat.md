# What´s it? #

Apache Tomcat is a Servlets and JSP (Java Server Page) container. It´s an Open Source Code created and y maintained for Apache community. Its license is "Apache License version 2".
Today, it´s the most commonly used Servlets container because of its speed and robustness.
The last version is 7.1, which supports the most modern specifications:Servlet 3.0, JSP 2.2 and EL 2.2.
Tomcat isn´t a Applications Server, like JBoss. It´s includes Jasper Compiler, which compiles JSP pages and makes them servlets. The Tomcat Servlets Engine often presents in combination with Apache 2.0 Web Server.


# How does it work? #

This is the Tomcat´s folder structure and a little description about each folder:

  * bin: this folder contains all Software Applications which has Apache Tomcat. Here we get Sotfware Applications to startup the server, to stop the server and others.
  * Conf: it´s configuration directory. In this folder, there are three very important files: server.xml, web.xml and context.xml. These files control the characteristics that our Tomcat is going to take.
  * Lib: here we find Java´s libraries which Tomcat uses for its ejecution. This folder is used too in some projects when we want to share libraries between different applications deployed in Tomcat.
  * Logs: in this folder are created the log files. It´s recommended save the log files into this folder to centralize.
  * Temp: it´s temporal folder of Tomcat that will probably unnoticed by the user
  * Webapps: this folder is used by Tomcat to deploy the applications. It contains several test projects and the management Tomcat application.

# Instalation #

Get the file from the following download link. Later, unzip it and move to the folder you want in your file system:
http://code.google.com/p/archetypeuma/downloads/detail?name=apache-tomcat-7.0.0.zip

Apache Tomcat uses relative paths to an environment variable. You must declare this variable in your Operating System:

  * _In Linux_:
```
export CATALINA_HOME=/home/user/carpetasInstalacion/apache-tomcat-7.0.0
```

  * _In Windows_:
```
set CATALINA_HOME=/C:/carpetasInstalacion/apache-tomcat-7.0.0
```

# Use #

There are several ways to use Tomcat Server. The most used are startup from command console or from Eclipse IDE.

Startup Tomcat from command console:
  * _In linux_:
```
/carpetaInstalacion/apache-tomcat-7.0.0/bin/catalina.sh run
```

  * _In windows_:
```
/carpetaInstalacion/apache-tomcat-7.0.0/bin/catalina.bat run
```

Thus  the startup all projects which are into Webapps and those which are defined into the file named context.xml.

The Server stops using shutdown.bat when you work with Windows or shutdown.sh when you work in Linux.

Startup from Eclipse IDE:
Eclipse IDE includes a plugin that allows interincluye un plugin con el que se permite interaction with the server from within Eclipse.
To include this plugin in our Eclipse, we can download it from http://www.eclipse.org/webtools/
To relate Eclipse with Tomcat from Eclipse, we must to clicking in New - Server – and then selecting Apache Tomcat. In this way, we obtain a new project into the Workspace which was named Server.
This new project named Server contains a file named context.xml. When we want add a new proyect which is based in the archetype, a new context'll appear into that file on the following way:

```
<Context autoDeploy="true" cookies="true" crossContext="false" docBase="/home/user/archetypeUma/web/target/archetypeUma" path="/archetypeUma" reloadable="true"/>
```


Creating a context for archetypeUma project in the path defined on docBase.




#summary Apache Tomcat.

# What´s it? #

Apache Tomcat es un contenedor de servlets y JSP. Es un software de código abierto creado y mantenido por la comunidad de Apache. Tiene licencia Apache License version 2.
Actualmente es el contenedor de servlets más utilizado por su velocidad y su robustez.
La última versión es la 7.1 que soporta la especificaciones más modernas, Servlet 3.0, JSP 2.2 and EL 2.2.
Tomcat no es un servidor de aplicaciones, como JBoss. Incluye el compilador Jasper, que compila JSPs convirtiendolas en servlets. El motor de servlets de Tomcat a menudo se presenta en combinación con el servidor web Apache 2.0.


# Como funciona ? #

Esta es la es la estructura de carpetas que tiene el Apache Tomcat:

Una breve descripción de la utilizad de cada carpeta:

  * bin: Se guardan todas las aplicaciones software que trae Apache Tomcat. Encontramos aplicaciones para arrancar el servidor, para pararlo y algunas más.
  * Conf: es el directorio de configuración. Destacan los ficheros server.xml, web.xml y context.xml ya que son los que controlan las características que va a tener el Tomcat definido.
  * Lib: aquí tiene cabida las librerías Java que utiliza Tomcat para su ejecución. Este directorio también es utilizado en algunos proyectos cuando se quiere compartir libreríaas entre diferentes aplicaciones desplegadas en Tomcat.
  * Logs: se crean los ficheros de logs. Es bueno mandar los ficheros de logs a esta carpeta para tener centralizados los logs.
  * Temp: Carpeta temporal de Tomcat que seguramente pasará de desapercibida para el usuario.
  * Webapps: en esta carpeta es la que utiliza Tomcat para desplegar las aplicaciones. Contiene varios proyectos de prueba y la aplicación de administración de Tomcat.

# Instalation #

Descargaremos el fichero del enlace, lo descomprimiremos  y moveremos  a la carpeta que queramos dentro de nuestro sistema de ficheros:
http://code.google.com/p/archetypeuma/downloads/detail?name=apache-tomcat-7.0.0.zip

Las rutas que utiliza Apache Tomcat son relativas a una variable de entorno. Tenemos que declararla en nuestro sistema operativo:

  * _En linux_:
```
export CATALINA_HOME=/home/user/carpetasInstalacion/apache-tomcat-7.0.0
```

  * _En windows_:
```
set CATALINA_HOME=/C:/carpetasInstalacion/apache-tomcat-7.0.0
```

# Use #

A varias formas de utilizar el servidor de Tomcat. Las más utilizadas son el arranque desde la consola de comandos y desde el eclipse.

Arranque desde la consola de comandos:
  * _En linux_:
```
/carpetaInstalacion/apache-tomcat-7.0.0/bin/catalina.sh run
```

  * _En windows_:
```
/carpetaInstalacion/apache-tomcat-7.0.0/bin/catalina.bat run
```

Arrancará todos los proyectos que hay en la carpeta de webapps de tomcat y los que se definan en el fichero context.xml

El servidor se detiene con el programa shutdown.bat o shutdown.sh según estemos en Windows o en Linux.

Arranque desde el Eclipse:
Eclipse incluye un plugin con el que se permite interactuar directamente con el servidor desde el propio Eclipse.
Si el eclipse que esta utilizando el usuario no lo incluye se puede descargar desde http://www.eclipse.org/webtools/
Para relacionar el Eclipse con Tomcat desde Eclipse hay que clickear en New - Server – Seleccionar Apache Tomcat. Esto creará un nuevo proyecto en el workspace llamado server.
Este proyecto contiene un fichero llamado context.xml. Se añade un contexto nuevo cuando queramos añadir un nuevo proyecto basado en el arquetipo. De la siguiente forma:

```
<Context autoDeploy="true" cookies="true" crossContext="false" docBase="/home/user/archetypeUma/web/target/archetypeUma" path="/archetypeUma" reloadable="true"/>
```


Creando un contexto para el proyecto archetypeUma en la ruta que se define en docBase.