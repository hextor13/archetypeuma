# What´s it? #

PostgreSQL is a relational database management system oriented to objects and free software, published under BSD licence. As many other Open Source projects, the development about PostgreSQL isn't managed by a company or/and a person, but it's directed by a community of developers who work disinterested, altruist, free way or/and supported by business. That community is called PGDG (PostgreSQL Global Development Group).
PostgreSQL has had a large evolution which began in 1982 with Ingres project in Berkeley's University. This project was led by Michael Stonebraker.
In 1996 joined this project people outside the University as Marc Fournier from Hub.Org Networking Services, Bruce Momjian and Vadim B. Mikheev who provided the first non-university development server to development of open source code and started to set  Postgres95 code.


# How does it work? #

The PostgreSQL's functionality is similar to Mysql but that tries to improve some aspects:
  * high concurrency
  * large variety of native types.

This database closely resembles Oracle and is a good alternative as free software tool
# Instalation #

Postgresql must be installed in different way and with different software to each Operative System:

  * Linux: several distributions already include MySQL.
```
apt-get install postgresql
```
In addition to installing the database engine, the best for the maintenance will be to installing a client which act as database manager. It's possible to use pgadmin3. For the installation write the following commands:
```
sudo apt-get install pgadmin3
```
Depending the computer's version, installling a version of PostgreSQL, for this case we has installed the next:
```
PostgreSQL 8.4.5 on x86_64-pc-linux-gnu, compiled by GCC gcc-4.4.real (Ubuntu 4.4.3-4ubuntu5) 4.4.3, 64-bit
```
To come into the program:
```
sudo su postgres -c psql
```
Once inside, put to user default the chosen password:
```
ALTER USER postgres WITH ENCRYPTED PASSWORD 'postgres';
```

It ends up creating the necessary user to the archetype installed:
```
CREATE USER archetype_user WITH ENCRYPTED PASSWORD 'archetype_pwd';
```
  * Windows:

Load the installable and execute:
To install it asks the port of installation. The port default is 5432.
It´s important to install drivers as psqlODBC and other PostgreSQL's components as pgAdmin which is an application that serves as Postgre manager.

# Use #

DBUnit has a problem with this database.DBUnit tries to delete the database schema from the own schema which is using and this causes error in PostgreSQL. It should be deleted from other database schema. The same problem could appear in other databases, for example Oracle.

# Links #

  * http://www.postgresql.org

# ¿Qué es? #

PostgreSQL es un sistema de gestión de base de datos relacional orientada a objetos y sotware libre, publicado bajo la licencia BSD.
Como muchos otros proyectos de código abierto, el desarrollo de PostgreSQL no es manejado por una empresa y/o persona, sino que es dirigido por una comunidad de desarrolladores que trabajan de forma desinteresada, altruista, libre y/o apoyados por organizaciones comerciales. Dicha comunidad es denominada el PGDG (PostgreSQL Global Development Group).
PostgreSQL ha tenido una larga evolución, la cual se inicia en 1982 con el proyecto Ingres en la Universidad de Berkeley. Este proyecto, liderado por Michael Stonebraker.
Para el año 1996 se unieron al proyecto personas ajenas a la Universidad como Marc Fournier de Hub.Org Networking Services, Bruce Momjian y Vadim B. Mikheev quienes proporcionaron el primer servidor de desarrollo no universitario para el esfuerzo de desarrollo de código abierto y comenzaron a trabajar para estabilizar el código de Postgres95.

# ¿Como funciona ? #

La funcionalidad de postgresql es parecida a la de mysql pero intenta mejorar algunos aspectos:
  * Alta concurrencia.
  * Amplia variedad de tipos nativos.

Esta base de datos se asemeja bastante a Oracle y es un buen sustituto para los que hayan trabajado con ella pero quieran software libre.

# Instalación #

Postgresql se instala de diferente forma y con diferentes software para cada sistema operativo:

  * Linux: Varias distribuciones ya incluyen un Mysql.
```
apt-get install postgresql
```
Además de instalar el motor de la base de datos, lo major para el mantenimiento, es instalarse un cliente que actue de gestor sobre la base de datos. Se puede utilizar pgadmin3. Para su instalación hay que escribir los siguientes comandos
```
sudo apt-get install pgadmin3
```
Según la vversión del ordenador se instalará una versión de postgresql, en este caso se ha instalado la:
```
PostgreSQL 8.4.5 on x86_64-pc-linux-gnu, compiled by GCC gcc-4.4.real (Ubuntu 4.4.3-4ubuntu5) 4.4.3, 64-bit
```
Para entrar en el programa:
```
sudo su postgres -c psql
```
Una vez dentro hay que ponerle al usuario por defecto la contraseña que se desee:
```
ALTER USER postgres WITH ENCRYPTED PASSWORD 'postgres';
```

Se termina creando el usuario que se necesite para el arquetipo que aquí se instala hay que utilizar:
```
CREATE USER archetype_user WITH ENCRYPTED PASSWORD 'archetype_pwd';
```
  * Windows:

Se descarga el instalable y se ejecuta.

Al instalarlo  pide el puerto en el que se va a instalar, el puerto por defecto de postgresql es 5432.
Es importante instalar los drivers como psqlODBC y demás componente de postgresql como pgAdmin, que es una aplicación que sirve de gestor de postgresql.

# Uso #

DBUnit tiene un problema con esta base de datos. Ya que DBUnit intenta eliminar el esquema de la base de datos desde el mismo esquema de base de datos que esta utilizando y eso en postgresql da error. Habría que eliminarlo desde otro esquema de base de datos. El mismo problema se puede presentar en otras bases de datos, por ejemplo en Oracle.

# Enlaces #

  * http://www.postgresql.org