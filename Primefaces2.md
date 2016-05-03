# What´s it? #

Primefaces es una galería de componentes JSF 2. Ha tenido una gran aceptación en su primera versión cuando funcionaba bajo JSF 1.2. Ahora han sido los primeros en adaptar sus componentes a  JSF 2.0. Lo que les da cierta ventaja en pruebas y optimización que el resto de librerías de uso similar.
Es desarrollado por una empresa Turca, denominada Prime Technology, que ofrece su software como código abierto y software libre.

# How does it work? #

Primefaces esta compuesto de 3 módulos:

  * UiComponents : es el módulo que contiene los componentes JSF.
  * Optimus: en este módulo se aglutinan un conjunto de utilidades que optimizan el rendimiento del proyecto en JSF2.
  * FacesTrace : Aporta un sistema detallado para las trazas que se pueden requerir de JSF.

# Instalation #

**Requisitos obligatorios:** Myfaces 2.0 o una implementación de JSF 2.0 como Mojarra 2.0

Para instalarlo hay que meter la dependencia en el pom.xml de la capa web.
```
<dependency>
<groupId>org.primefaces</groupId>
<artifactId>primefaces</artifactId>
<version>2.0.2</version>
</dependency>
```
En el fichero web.xml hay que declarar que se va a utilizar el servlet de primefaces:
```
	<servlet>
		<servlet-name>Resource Servlet</servlet-name>
		<servlet-class>org.primefaces.resource.ResourceServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>Resource Servlet</servlet-name>
		<url-pattern>/primefaces_resource/*</url-pattern>
	</servlet-mapping>
```
# Use #

Teniendo la dependencia de primefaces 2.0 en el lib del proyecto, este tiene la declaración de todos los componentes en su fichero

Primefaces tiene definido en la librería UIComponents muchos componentes, los cuales se pueden utilizar. Por ejemplo esta el componente:
```
<component>
<component-type>org.primefaces.component.Menu</component-type>
<component-class>org.primefaces.component.menu.Menu</component-class>
</component>
```
En la cabecera de cada página donde se quiera utilizar este componente hay que establecer que se va a utilizar esta librería de primefaces.

```
xmlns:p="http://primefaces.prime.com.tr/ui"
```

Ahora se puede utilizar el componente:
```
<p:menu styleClass="menu">
<p:submenu label="Menu">
<p:menuitem value="Create User" url="/pages/users/form.html"/>
<p:menuitem value="List Users" url="/pages/users/list.html"/>
<p:menuitem value="Uma" url="http://www.uma.es"/>
</p:submenu>
</p:menu>
```
Pintaría un menú en la página.

El uso es muy extenso lo mejor es que si se esta utilizando la arquitectura y se necesita algo, se abra la documentación de primefaces que se encuentra en los downloads de este proyecto y se obtenga la documentación que se necesite, o bien en la documentación de Primefaces.

# Links #

  * http://www.primefaces.org/

# ¿Qué es? #

Primefaces es una galería de componentes JSF 2. Ha tenido una gran aceptación en su primera versión cuando funcionaba bajo JSF 1.2. Ahora han sido los primeros en adaptar sus componentes a  JSF 2.0. Lo que les da cierta ventaja en pruebas y optimización que el resto de librerías de uso similar.
Es desarrollado por una empresa Turca, denominada Prime Technology, que ofrece su software como código abierto y software libre.

# ¿Como funciona ? #

Primefaces esta compuesto de 3 módulos:

  * UiComponents : es el módulo que contiene los componentes JSF.
  * Optimus : en este módulo se aglutinan un conjunto de utilidades que optimizan el rendimiento del proyecto en JSF2.
  * FacesTrace : Aporta un sistema detallado para las trazas que se pueden requerir de JSF.

# Instalación #

**Requisitos obligatorios:** Myfaces 2.0 o una implementación de JSF 2.0 como Mojarra 2.0

Para instalarlo hay que meter la dependencia en el pom.xml de la capa web.
```
<dependency>
<groupId>org.primefaces</groupId>
<artifactId>primefaces</artifactId>
<version>2.0.2</version>
</dependency>
```
En el fichero web.xml hay que declarar que se va a utilizar el servlet de primefaces:
```
	<servlet>
		<servlet-name>Resource Servlet</servlet-name>
		<servlet-class>org.primefaces.resource.ResourceServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>Resource Servlet</servlet-name>
		<url-pattern>/primefaces_resource/*</url-pattern>
	</servlet-mapping>
```
# Uso #

Teniendo la dependencia de primefaces 2.0 en el lib del proyecto, este tiene la declaración de todos los componentes en su fichero

Primefaces tiene definido en la librería UIComponents muchos componentes, los cuales se pueden utilizar. Por ejemplo esta el componente:
```
<component>
<component-type>org.primefaces.component.Menu</component-type>
<component-class>org.primefaces.component.menu.Menu</component-class>
</component>
```
En la cabecera de cada página donde se quiera utilizar este componente hay que establecer que se va a utilizar esta librería de primefaces.
```
xmlns:p="http://primefaces.prime.com.tr/ui"
```

Ahora se puede utilizar el componente:

```
<p:menu styleClass="menu">
<p:submenu label="Menu">
<p:menuitem value="Create User" url="/pages/users/form.html"/>
<p:menuitem value="List Users" url="/pages/users/list.html"/>
<p:menuitem value="Uma" url="http://www.uma.es"/>
</p:submenu>
</p:menu>
```
Pintaría un menú en la página.

El uso es muy extenso lo mejor es que si se esta utilizando la arquitectura y se necesita algo, se abra la documentación de primefaces que se encuentra en los downloads de este proyecto y se obtenga la documentación que se necesite, o bien en la documentación de Primefaces.

# Enlaces #

  * http://www.primefaces.org/