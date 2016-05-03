The [Java](Java.md) Virtual Machine (JVM) is an essential requirement to the program will be executed correctly. Very probably the user already has installed JVM in his computer to execute the application. But, if he hasn't that, he can obtain in [Java](Java.md). The project needs [Java](Java.md) JDK in version 1.6. More information about Java installation in the link.

Once installed Virtual Machine, already it's possible to run any Java application. El primer paso sería instalarnos [maven3](maven3.md).

Now, it's possible to invoke to [ArchetypeUma](ArchetypeUma.md) :
```
mvn archetype:generate -DremoteRepositories=https://archetypeuma.googlecode.com/svn/trunk/archetype-catalog.xml -DarchetypeGroupId=org.archetypeUma -DarchetypeArtifactId=archetypeUma-archetype -DarchetypeVersion=1.0-SNAPSHOT
```
Be created a folders and files into our directory where is the shell or Windows console. For this reason, should create into work directory where will run Eclipse.

Una vez descargado el proyecto entero, se puede continuar trabajando, pero antes hay que en trar en el fichero pom.xml y cambiar la propiedad war.name y poner el nombre del artifactId que se le haya puesto al  proyecto.

<war.name>archetypeUma</war.name>

Then, installing database, [Mysql](Mysql.md),[PostgreSql](PostgreSql.md) or another if changing the driver and the dependency which is in the main pom.xml.

Well, if it´s installed must create a database and an user with permission to that:

create database archetype\_db;

Creating user:

CREATE USER 'archetype\_user'@'localhost' IDENTIFIED BY 'archetype _pwd';_

GRANT ALL PRIVILEGES ON **.** TO 'archetype\_user'@'localhost' IDENTIFIED BY 'archetype _pwd' WITH GRANT OPTION;_

This database and user have been created in this way because in the archetype these appear with that name or that password. It's possible to put what we want if we change the lines into the main pom.xml file of the project.
These are the lines which must be changed:
```
        <jdbc.dbname>archetype_db</jdbc.dbname>
        <jdbc.username>archetype_user</jdbc.username>
        <jdbc.password>archetype_pwd</jdbc.password>
```
Depending IDE installed must be integrated. To do that, must use the following goals of [maven3](maven3.md):

  * Eclipse
mvn eclipse:clean eclipse:eclipse

  * Intellij IDEA
mvn idea:clean idea:idea

This will spends a little time because in addition to create the project and download the own dependencies of the plugin, it downloads all source code which are uses into the project. This project has many dependencies and for this reason takes long time to download all.ste proyecto al tener tantas dependencias tarda bastante en bajárselas todas.

# Versión española #

La maquina virtual de [Java](Java.md) es requisito imprescindible para que el programa se ejecute correctamente. Es muy probable que el usuario ya tenga instalado en su computadora la maquina virtual de java sobre la que se ejecuta la aplicación pero si no la tiene puede obtenerla de [Java](Java.md). El proyecto necesita la versión 1.6 de la JDK de [Java](Java.md). Más información de la instalación de Java en el enlace.

Una vez este instalada la maquina virtual ya se puede correr cualquier aplicación java. El primer paso sería instalarnos [maven3](maven3.md).

Ahora se puede invocar al arquetipo [ArchetypeUma](ArchetypeUma.md):
```
mvn archetype:generate -DarchetypeCatalog=https://archetypeuma.googlecode.com/svn/trunk/archetype-catalog.xml -DarchetypeGroupId=org.archetypeUma -DarchetypeArtifactId=archetypeUma-archetype -DarchetypeVersion=1.0-SNAPSHOT
```
Se crearán unas carpetas y ficheros en el directorio que tengamos el shell o consola de windows. Por lo que es conveniente que se cree en el directorio de trabajo en el que vaya a correr [eclipse](eclipse.md).

Una vez descargado el proyecto entero, se puede continuar trabajando, pero antes hay que en trar en el fichero pom.xml y cambiar la propiedad war.name y poner el nombre del artifactId que se le haya puesto al  proyecto.

<war.name>archetypeUma</war.name>

A continuación hay que instalar la base de datos. Ya sea [Mysql](Mysql.md), [PostgreSql](PostgreSql.md) o cualquiera si cambiarmos el driver y la dependencia que esta en el pom.xml principal.

Bien, si esta instalada hay que crear una base de datos y un usuario que tenga permisos para eso:

create database archetype\_db;

Se crea el usuario:

CREATE USER 'archetype\_user'@'localhost' IDENTIFIED BY 'archetype _pwd';_

GRANT ALL PRIVILEGES ON **.** TO 'archetype\_user'@'localhost' IDENTIFIED BY 'archetype _pwd' WITH GRANT OPTION;_

Esta base de datos y usuario se ha creado así porque en el arquetipo viene con ese nombre y ese password. Se puede poner el que quiera si se cambian las líneas en el pom.xml principal del proyecto.
Estas son las líneas que habría que sustituir:
```
        <jdbc.dbname>archetype_db</jdbc.dbname>
        <jdbc.username>archetype_user</jdbc.username>
        <jdbc.password>archetype_pwd</jdbc.password>
```
Dependiendo del IDE en el que se quiera instalar hay que integrarlo, para esto existe los goals de maven:

  * Eclipse
mvn eclipse:clean eclipse:eclipse

  * Intellij IDEA
mvn idea:clean idea:idea

Esto tardará un poco. Ya que además de crear el proyecto y descargarse las dependencias propias del plugin, se descarga todos los códigos fuentes que se utiliza en el proyecto. Este proyecto al tener tantas dependencias tarda bastante en bajárselas todas.