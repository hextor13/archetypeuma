# What´s it? #

JSF is a Web Framework that facilitates to build web applications.
JSF defines three features: an architecture based on components, a standar set of UI widgets, and an application infrastructure . The architecture based on components of JSF defines a common way to build UI  widgets (buttons, hyperlinks, checkboxes, text fields, among others.), but it establishes guidelines for thirds´s components. These components are oriented to events and JSF allows to manage clients´s events (for example, to change the value of a textbox or to make click on a button).

Faces can keep your UI components automatically and sinchronize them with your Java Objects which collectio  the values indicates by the user, and response to events named backing beans. Additionally, they have a powerful navigation system and full support to several languages.


# How does it work? #

JSF is executed on the Server, for example a Faces application will be executed in a web container like Tomcat, Oracle Application or Jboss, and will show HTML or another client´s tags.
When we make click on a button, Face executes an request which is sending from our browser to the Server. Faces brings that request to the event which will be procesed by our Server´s logic. Faces must to display in the browser too each UI widget defined by us.

# Instalation #

Necessary requirements: JRE de JAVA, version 1.6 recommended

JSF is a standard which has several implementations of its specification. Through this link we can to install myfaces 2.0 implementation:
Instalation of myfaces 2.0.

# Use #

The most important components of the specification are:

|Component|Description|
|:--------|:----------|
|UI Component (user´s component or simply named component)|An object saved in the server, which provides the specific functionality to interact with final user. UI components are JavaBeans with properties, methods and events. They are organized in a view which is a tree of components usually display like a page.|
|Renderer |It´s responsible to display a UI component and translate the user´s input in a component´s inner value. The Renderers can be designed to work with one or more UI components.|
|Validator|It´s responsible to validate the value indicated by user being correct. One or more validators can be asociated with a simple UI component.|
|Backing Beans|They are JavaBeans which are specialized to collect values from UI componets and implement methods that are relationated with events of UI components. They can too storing references to UI components. |
|Converter| It converts the value from and for a component which will be displayed. All UI components can be associated with a simple converter.|
|Events y Listeners|	JSF uses event/listener model (it´s used by Swing too). UI components (and other objects) generate events, and the listeners can be registrated to manage these events.|
|Messages | Information that is back displayed to users. Only some parts of the application(backing beans, validators, converters) can generate information or error messages which can be returned to users.|
|Navigation|The ability to move from one page to another. JSF has a powerful navigation system that is integrated with specialized event listeners.|

# Links #

  * http://javaserverfaces.java.net/nonav/rlnotes/2.0.0/index.html
  * http://jcp.org/aboutJava/communityprocess/edr/jsr314/index2.html

# ¿Qué es? #

JSF es un frameworks web que facilita la construcción de aplicaciones web.
JSF define tres características: una arquitectura de componentes, un conjunto estándar de UI widgets, y una infraestructura de aplicación. La arquitectura de componentes JSF define una manera común para construir UI widgets (botones, hyperlinks, checkboxes, cajas de texto, entre otros), pero también establece las pautas para componentes de terceros. Estos componentes con orientados a eventos y JSF nos permite manejar eventos del cliente (cambiar el valor de un textbox o hacer clic en un botón).

Faces puede automáticamente mantener tus componentes UI en sincronización con tus
objetos Java que coleccionan los valores ingresados por el usuario y responder a eventos, los cuales
son llamados backing beans. Adicionalmente, también tiene un sistema poderoso de navegación y
soporte completo para múltiples lenguajes.


# ¿Como funciona ? #

JSF se ejecuta en el Server, por ejemplo una aplicación Faces se ejecutara en un contenedor web
como Tomcat, Oracle Application Server o Jboss, y mostrar HTML u otras marcas en el cliente.
Cuando nosotros hacemos un clic en un botón, Faces ejecuta un request que es enviado desde nuestro web browser hacia el Server. Faces es responsable por trasladar ese request hacia el evento que será procesado por nuestra lógica en el Server. Es responsable también por mostrar en el browser cada UI widget que hayamos definido.

# Instalación #

Requisitos obligatorios: JRE de JAVA, recomendada la versión 1.6

JSF es un estándar por lo que cuenta con varias implementaciones de su especificación. El enlace a la instalación de la implementación de myfaces 2.0 es:
Instalación de myfaces 2.0.

# Uso #

Los componentes más importantes de la especificación son:

|Termino|Descripción|
|:------|:----------|
|UI Component (componente de usuario o simplemente denominado componente)|Un objeto mantenido en el server, que provee funcionalidad especifica para interactuar con el usuario final. Los UI components son JavaBeans con properties, métodos y eventos. Ellos son organizados en una vista, la cual es un árbol de componentes usualmente mostrados como una página.|
|Renderer|Responsable por mostrar un componente UI y traducir la entrada del usuario en un valor al interior del componente. Los Renderers pueden ser diseñados para trabajar con uno o mas UI components.|
|Validator|Responsable por asegurarse que el valor ingresado por el usuario es aceptable. Uno o mas validadores pueden ser asociados con un simple UI component.|
|Backing Beans|Son JavaBeans especializados que coleccionan valores desde los UI components e implementan métodos relacionados a los eventos de los UI components. Ellos también pueden almacenar referencias a UI components.|
|Converter|Convierte el valor para y desde un componente para ser mostrado. Todos los UI components pueden ser asociados con un simple converter.|
|Events y Listeners|	JSF usa el modelo event/listener (también usado por Swing). UI components (y otros objetos) generan eventos, y los listeners pueden ser registrados para manejar estos eventos.|
|Mensajes|Información que es muestra de regreso al usuario. Solo ciertas partes de la aplicación (backing beans, validators, converters) pueden generar información o mensajes de error que pueden ser mostrados de regreso al usuario.|
|Navigation|La habilidad para moverse de una pagina a otra. JSF tiene un sistema poderoso de navegación que esta integrado con event listeners especializados.|

# Enlaces #

  * http://javaserverfaces.java.net/nonav/rlnotes/2.0.0/index.html
  * http://jcp.org/aboutJava/communityprocess/edr/jsr314/index2.html







#summary jsf2.0

# What´s it? #

JSF es un frameworks web que facilita la construcción de aplicaciones web.
JSF define tres características: una arquitectura de componentes, un conjunto estándar de UI widgets, y una infraestructura de aplicación. La arquitectura de componentes JSF define una manera común para construir UI widgets (botones, hyperlinks, checkboxes, cajas de texto, entre otros), pero también establece las pautas para componentes de terceros. Estos componentes con orientados a eventos y JSF nos permite manejar eventos del cliente (cambiar el valor de un textbox o hacer clic en un botón).

Faces puede automáticamente mantener tus componentes UI en sincronización con tus
objetos Java que coleccionan los valores ingresados por el usuario y responder a eventos, los cuales
son llamados backing beans. Adicionalmente, también tiene un sistema poderoso de navegación y
soporte completo para múltiples lenguajes.


# How does it work? #

JSF se ejecuta en el Server, por ejemplo una aplicación Faces se ejecutara en un contenedor web
como Tomcat, Oracle Application Server o Jboss, y mostrar HTML u otras marcas en el cliente.
Cuando nosotros hacemos un clic en un botón, Faces ejecuta un request que es enviado desde nuestro web browser hacia el Server. Faces es responsable por trasladar ese request hacia el evento que será procesado por nuestra lógica en el Server. Es responsable también por mostrar en el browser cada UI widget que hayamos definido.

# Instalation #

Requisitos obligatorios: JRE de JAVA, recomendada la versión 1.6

JSF es un estándar por lo que cuenta con varias implementaciones de su especificación. El enlace a la instalación de la implementación de myfaces 2.0 es:
Instalación de myfaces 2.0.

# Uso #

Los componentes más importantes de la especificación son:

|Termino|Descripción|
|:------|:----------|
|UI Component (componente de usuario o simplemente denominado componente)|Un objeto mantenido en el server, que provee funcionalidad especifica para interactuar con el usuario final. Los UI components son JavaBeans con properties, métodos y eventos. Ellos son organizados en una vista, la cual es un árbol de componentes usualmente mostrados como una página.|
|Renderer|Responsable por mostrar un componente UI y traducir la entrada del usuario en un valor al interior del componente. Los Renderers pueden ser diseñados para trabajar con uno o mas UI components.|
|Validator|Responsable por asegurarse que el valor ingresado por el usuario es aceptable. Uno o mas validadores pueden ser asociados con un simple UI component.|
|Backing Beans|Son JavaBeans especializados que coleccionan valores desde los UI components e implementan métodos relacionados a los eventos de los UI components. Ellos también pueden almacenar referencias a UI components.|
|Converter|Convierte el valor para y desde un componente para ser mostrado. Todos los UI components pueden ser asociados con un simple converter.|
|Events y Listeners|	JSF usa el modelo event/listener (también usado por Swing). UI components (y otros objetos) generan eventos, y los listeners pueden ser registrados para manejar estos eventos.|
|Mensajes|Información que es muestra de regreso al usuario. Solo ciertas partes de la aplicación (backing beans, validators, converters) pueden generar información o mensajes de error que pueden ser mostrados de regreso al usuario.|
|Navigation|La habilidad para moverse de una pagina a otra. JSF tiene un sistema poderoso de navegación que esta integrado con event listeners especializados.|

# Links #

  * http://javaserverfaces.java.net/nonav/rlnotes/2.0.0/index.html
  * http://jcp.org/aboutJava/communityprocess/edr/jsr314/index2.html

# ¿Qué es? #

JSF es un frameworks web que facilita la construcción de aplicaciones web.
JSF define tres características: una arquitectura de componentes, un conjunto estándar de UI widgets, y una infraestructura de aplicación. La arquitectura de componentes JSF define una manera común para construir UI widgets (botones, hyperlinks, checkboxes, cajas de texto, entre otros), pero también establece las pautas para componentes de terceros. Estos componentes con orientados a eventos y JSF nos permite manejar eventos del cliente (cambiar el valor de un textbox o hacer clic en un botón).

Faces puede automáticamente mantener tus componentes UI en sincronización con tus
objetos Java que coleccionan los valores ingresados por el usuario y responder a eventos, los cuales
son llamados backing beans. Adicionalmente, también tiene un sistema poderoso de navegación y
soporte completo para múltiples lenguajes.


# ¿Como funciona ? #

JSF se ejecuta en el Server, por ejemplo una aplicación Faces se ejecutara en un contenedor web
como Tomcat, Oracle Application Server o Jboss, y mostrar HTML u otras marcas en el cliente.
Cuando nosotros hacemos un clic en un botón, Faces ejecuta un request que es enviado desde nuestro web browser hacia el Server. Faces es responsable por trasladar ese request hacia el evento que será procesado por nuestra lógica en el Server. Es responsable también por mostrar en el browser cada UI widget que hayamos definido.

# Instalación #

Requisitos obligatorios: JRE de JAVA, recomendada la versión 1.6

JSF es un estándar por lo que cuenta con varias implementaciones de su especificación. El enlace a la instalación de la implementación de myfaces 2.0 es:
Instalación de myfaces 2.0.

# Uso #

Los componentes más importantes de la especificación son:

|Termino|Descripción|
|:------|:----------|
|UI Component (componente de usuario o simplemente denominado componente)|Un objeto mantenido en el server, que provee funcionalidad especifica para interactuar con el usuario final. Los UI components son JavaBeans con properties, métodos y eventos. Ellos son organizados en una vista, la cual es un árbol de componentes usualmente mostrados como una página.|
|Renderer|Responsable por mostrar un componente UI y traducir la entrada del usuario en un valor al interior del componente. Los Renderers pueden ser diseñados para trabajar con uno o mas UI components.|
|Validator|Responsable por asegurarse que el valor ingresado por el usuario es aceptable. Uno o mas validadores pueden ser asociados con un simple UI component.|
|Backing Beans|Son JavaBeans especializados que coleccionan valores desde los UI components e implementan métodos relacionados a los eventos de los UI components. Ellos también pueden almacenar referencias a UI components.|
|Converter|Convierte el valor para y desde un componente para ser mostrado. Todos los UI components pueden ser asociados con un simple converter.|
|Events y Listeners|	JSF usa el modelo event/listener (también usado por Swing). UI components (y otros objetos) generan eventos, y los listeners pueden ser registrados para manejar estos eventos.|
|Mensajes|Información que es muestra de regreso al usuario. Solo ciertas partes de la aplicación (backing beans, validators, converters) pueden generar información o mensajes de error que pueden ser mostrados de regreso al usuario.|
|Navigation|La habilidad para moverse de una pagina a otra. JSF tiene un sistema poderoso de navegación que esta integrado con event listeners especializados.|

# Enlaces #

  * http://javaserverfaces.java.net/nonav/rlnotes/2.0.0/index.html
  * http://jcp.org/aboutJava/communityprocess/edr/jsr314/index2.html