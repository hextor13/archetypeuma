# What´s it? #

En la web oficial de Eclipse (www.eclipse.org), se define como “An IDE for everything and nothing in particular” (un IDE para todo y para nada en particular). Eclipse es, en el fondo, únicamente un armazón (workbench) sobre el que se pueden montar herramientas de desarrollo para cualquier lenguaje, mediante la implementación de los plugins adecuados.
La arquitectura de plugins de Eclipse permite, demás de integrar diversos lenguajes sobre un mismo IDE, introducir otras aplicaciones accesorias que pueden resultar útiles durante el proceso de desarrollo como: herramientas UML, editores visuales de interfaces, ayuda en línea para librerías, etc.
En su origen, el Proyecto Eclipse era un proyecto de desarrollo OpenSource, soportado y mantenido en su totalidad por IBM. Bajo la dirección de IBM, se fundó el Consorcio Eclipse al cual se unieron algunas empresas importantes como Rational, HP o Borlan
Desde el día 2 de febrero de 2004, el Consorcio Eclipse es independiente de IBM y entre otras, está formado por las empresas: HP, QNX, IBM, Intel, SAP, Fujitsu, Hitachi, Novell, Oracle, Palm, Ericsson y RedHat, además de algunas universidades e institutos tecnológicos.

# How does it work? #

Eclipse es una aplicación Java que se ejecuta en una maquina virtual. Tiene dos ficheros de arranque dependiendo de si estamos en Windows (eclipse.exe) o en Linux (eclipse.sh) que ejecutaremos cuando se instale el programa.
Si lo lanzamos desde un ejecutable también puede que se cree la variable global ECLIPSE\_HOME.

Esta es la estructura de directorios que tiene eclipse:

Si se pretende ampliar la funcionalidad de eclipse con un nuevo plugin hay que pegar la carpeta que traiga el plugin en las carpetas de plugins y features.

# Instalation #

Requisitos obligatorios: JRE de JAVA, recomendada la versión 1.6

Se puede obtener una versión del IDE desde la página web de la fundación en  www.eclipse.org.
O desde el enlace:

  * Para Windows:
Se descarga un zip y se descomprime en la carpeta en la que se desee instalar.

  * Para Linux:
Se descarga un tar y se descomprime en la carpeta en la que se desee instalar.

Es importante seleccionar una carpeta de trabajo. Ya que eclipse se rige en todas sus rutas relativas por este "workspace".

# Use #

Eclipse permite una gran variedad de aplicaciones webs, aplicaciones standalone, plugins y más para desarrollar.
Si se quiere importar un proyecto de Maven, como es el caso de estudio, hay que ir a nuevo proyecto y presionar en el menú - “Seleccionar proyecto desde el espacio de trabajo”. Se selecciona el proyecto y “Aceptar”.
Esto insertará en el espacio de trabajo el proyecto un proyecto Maven con el que eclipse solo nos servirá de editor.
Como eclipse en este caso no compilará y solo lo servirá de editor de fichero se continuará la explicación de como se usa en el apartado QuickStart.
El proyecto en maven hay que importarlo a eclipse mediante un mvn eclipse:eclipse. Esto trae los códigos fuentes de los jars y los relaciona con el proyecto. A continuación habría que importar el proyecto en eclipse como un “Project exist in workspace”.
Esto hace que todas las referencias de eclipse dependan de una variable local que hay que insertar  en eclipse. Es M2\_REPO y se mete en el menú de herramientas


# Links #

  * http://www.eclipse.org

# ¿Qué es? #

En la web oficial de Eclipse (www.eclipse.org), se define como “An IDE for everything and nothing in particular” (un IDE para todo y para nada en particular). Eclipse es, en el fondo, únicamente un armazón (workbench) sobre el que se pueden montar herramientas de desarrollo para cualquier lenguaje, mediante la implementación de los plugins adecuados.
La arquitectura de plugins de Eclipse permite, demás de integrar diversos lenguajes sobre un mismo IDE, introducir otras aplicaciones accesorias que pueden resultar útiles durante el proceso de desarrollo como: herramientas UML, editores visuales de interfaces, ayuda en línea para librerías, etc.
En su origen, el Proyecto Eclipse era un proyecto de desarrollo OpenSource, soportado y mantenido en su totalidad por IBM. Bajo la dirección de IBM, se fundó el Consorcio Eclipse al cual se unieron algunas empresas importantes como Rational, HP o Borlan
Desde el día 2 de febrero de 2004, el Consorcio Eclipse es independiente de IBM y entre otras, está formado por las empresas: HP, QNX, IBM, Intel, SAP, Fujitsu, Hitachi, Novell, Oracle, Palm, Ericsson y RedHat, además de algunas universidades e institutos tecnológicos.

# ¿Como funciona ? #

Eclipse es una aplicación Java que se ejecuta en una maquina virtual. Tiene dos ficheros de arranque dependiendo de si estamos en Windows (eclipse.exe) o en Linux (eclipse.sh) que ejecutaremos cuando se instale el programa.
Si lo lanzamos desde un ejecutable también puede que se cree la variable global ECLIPSE\_HOME.

Esta es la estructura de directorios que tiene eclipse:

Si se pretende ampliar la funcionalidad de eclipse con un nuevo plugin hay que pegar la carpeta que traiga el plugin en las carpetas de plugins y features.

# Instalación #

Requisitos obligatorios: JRE de JAVA, recomendada la versión 1.6

Se puede obtener una versión del IDE desde la página web de la fundación en  www.eclipse.org.
O desde el enlace:

  * Para Windows:
Se descarga un zip y se descomprime en la carpeta en la que se desee instalar.

  * Para Linux:
Se descarga un tar y se descomprime en la carpeta en la que se desee instalar.

Es importante seleccionar una carpeta de trabajo. Ya que eclipse se rige en todas sus rutas relativas por este "workspace".

# Uso #

Eclipse permite una gran variedad de aplicaciones webs, aplicaciones standalone, plugins y más para desarrollar.
Si se quiere importar un proyecto de Maven, como es el caso de estudio, hay que ir a nuevo proyecto y presionar en el menú - “Seleccionar proyecto desde el espacio de trabajo”. Se selecciona el proyecto y “Aceptar”.
Esto insertará en el espacio de trabajo el proyecto un proyecto Maven con el que eclipse solo nos servirá de editor.
Como eclipse en este caso no compilará y solo lo servirá de editor de fichero se continuará la explicación de como se usa en el apartado QuickStart.
El proyecto en maven hay que importarlo a eclipse mediante un mvn eclipse:eclipse. Esto trae los códigos fuentes de los jars y los relaciona con el proyecto. A continuación habría que importar el proyecto en eclipse como un “Project exist in workspace”.
Esto hace que todas las referencias de eclipse dependan de una variable local que hay que insertar  en eclipse. Es M2\_REPO y se mete en el menú de herramientas

# Enlaces #

  * http://www.eclipse.org