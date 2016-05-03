# What´s it? #

Mysql is a relational databasees and a relational database manager system, multi-thread and multi-user. Being a manager system, in addition a relational database, it´s possible to create databases and manage them through CREATE, UPDATE and DELETE. Mysql is developed by MYSQL AB created in Sweden in 1995 and it founders are David Axmark, Allan Larsson, and Michael "Monty" Widenius. Currently, MYSQL AB is a subsidiary of Sun Microsystem and of Oracle Corporation too. MYSQL AB has a free source licence: GNU GPL .
Mysql uses SQL (Structure Query Language) which is a standard programming language to manage databases.
It's a very secure database, fast and easy to use.

# How does it work? #

Mysql has a database server de un servidor de bases de datos, several utilities that help to database management and some support software than the database server needs.

In addition, is interesting installing a database management more commercial, so that which comes by default mysql is for commands line and exist very elaborate tools than can support correctly database creation and management.

The data types are very important in each database because these are very joined database engine used. In this document won't go into details because the architecture recommend use maven plugin to create necessary data types. That is explained in more detail in Hibernate section.

# Instalation #

Mysql must be installed in diferent way and with a different software to each Operative System:

  * Linux: Several distributions already include a MySQL.
```
apt-get install mysql
```
  * Windows:
Load installable file and execute it.
Must choose administrator and his password and the listener port for mysql. The best is leave this defaults in root and without password to not forget them during the development.

# Use #

Mysql like the rest of relational database works through SQL sentences. It exists a large variety of sentences. Let's invite to user to learn them: que invitamos al usuario a que aprenda.

# Links #

  * http://dev.mysql.com/doc/refman/5.0/es/index.html
  * http://www.webestilo.com/mysql/


# ¿Qué es? #

Mysql es una base de datos relacional y un sistema de gestión de bases de datos relacional, multiusuario y multihilo. Al ser un sistema gestor además de una base de datos le da la virtud de poder crear bases de datos y manipularlos, por medio de creaciones, modificaciones y eliminaciones.
Mysql es desarrollada por MYSQL AB fundada en suecia en 1995 y cuyos fundadores son David Axmark, Allan Larsson, y Michael "Monty" Widenius. MYSQL AB actualmente es una subsidiaria de Sun Microsystem filial a su vez de Oracle Corporation. Tiene licencia de software libre GNU GPL.
Mysql utiliza SQL (Structure Query Language, Lenguaje de Consulta Estructurado) que es un lenguaje de programación estándar para la gestión de bases de datos.
Es una base de datos muy segura, rápida y fácil de usar.

# ¿Como funciona ? #

Mysql consta de un servidor de bases de datos, varios programas utilitarios que ayudan a la gestión de la base de datos y algún software de apoyo que necesita el servidor de base de datos.

Además es interesante instalarse un gestor de bases de datos más comercial, ya que el que trae mysql por defecto es para líneas de comandos y hay herramientas muy elaboradas que pueden apoyar bastante a la creación y manipulación de bases de datos.

Los tipos de datos son muy importantes en cada base de datos porque están muy ligados al motor de base de datos que se utiliza. En este documento no se entrara al detalle porque desde la arquitectura se recomienda utilizar el plugin de maven que crea los tipos de datos que el cree oportuno. Esto se explica en más detalle en el apartado de hibernate.

# Instalación #

Mysql se instala de diferente forma y con diferentes software para cada sistema operativo:

  * Linux: Varias distribuciones ya incluyen un Mysql.
```
apt-get install mysql
```
  * Windows:
Se descarga el instalable y se ejecuta.
Hay que elegir el usuario administrador y su contraseña y el puerto en el que se quiere que mysql este escuchando. Lo mejor es dejar estos valores por defecto en root y sin contraseña para que no se nos olvide en un entorno de desarrollo.

# Uso #

Mysql como cualquier base de datos relacional funciona mediante órdenes SQL. Existen una gran variedad de órdenes que invitamos al usuario a que aprenda.

# Enlaces #

  * http://dev.mysql.com/doc/refman/5.0/es/index.html
  * http://www.webestilo.com/mysql/