# What´s it? #

Myfaces en la versión 2.0 es una implementación de JSF 2. Sólo es un estándar, define un marco de trabajo.
Lo mejor es empezar con una breve introducción de JSF y myfaces para entender mejor Myfaces.

JSF es un estándar de programación web basado en eventos. Es decir, intenta aplicar el modelo tradicional de eventos, tan utilizados en Delphi y VisualBasic, al entorno web.
JSF abre a la web el modelo tradicional de componentes. Aprovechando que debe de crear estos componentes hace que estos sean reproducibles en diferentes dispositivos no solo en el html típico de un explorador web. Siendo ampliable así a pda, móviles y otros dispositivos.
El paso de transformación de un componente JSF en el elemento resultante, que puede ser otro cualquiera pero que en este proyecto será el html, se hace a partir de un proceso que se conoce como renderizado.
JSF separa el renderizado del componente para poder adaptarlo a cualquier dispositivo de salida.

Las principales características de JSF son:
  * Permite modificar o incorporar componentes propios o de terceros.
  * Permite configurar y definir externamente el flujo de navegación entre las pantallas.
  * Aporta un ciclo de vida claro y estándar.
  * Incluye validadores, eventos, javabeans, conversores.

Como mejora importante hay que incluir que myfaces 2.0 ya trae integrada la tecnología de facelets. Ya que jsf es una tecnología orientada a componentes y las JSP es una tecnología orientada a generar serlets. Pero al no coincidir había que hacer que alguien las casará. Es por lo que facelets, una tecnología orientada a construir árboles de componentes en JSF era tan habitual en los proyectos y por lo que ha sido incluida como estándar en myfaces2.0.

# How does it work? #

Las fases del ciclo de vida de JSF es el siguiente:

  * Restore View :El servidor recibe una llamada y recompone los objetos de la vista en el servidor. Su principal objetivo es encontrar que vista esta asociada a la petición hecha por el usuario. Examina si FacesContext tiene un UIViewRoot para asignarle un locale y para recoger los valuebinding y asociarlo con el setValue(). Si la petición es por get y no contiene parámetros por la url puede pasar al último paso del ciclo de vida, si lo necesita pasará al siguiente.

  * Apply Request Values: Deja que los componentes actualicen los valores que le vienen por la request. Se llama al método processDecodes de todos los componentes.

  * Process validations: Se procesan las validaciones llamando a processValidators.

•	Update Model Values: Ahora que están los datos y son válidos se llaman a los métodos que modifican los valores del modelo. Esto se produce recursivamente en el método processUpdates.

  * Invoke Application: La actualización del modelo ha sido completada, se llama al metodo processApplication de UIViewRoot. Se llama a todos los eventos encolaos con phaseId.INVOKE\_APPLICATION.

  * Render Response: Se renderiza la respuesta al cliente. Se invoca al método encode de cada componente del árbol de renderizado.

Los listeners son clases que se instancia entre los diferentes ciclos de vida de JSF2. Se declaran de la siguiente forma:

```
<lifecycle>
<phase-listener>org.archetypeUma.listener.selection.PruebaPhaseListener</phase-listener>
</lifecycle>
```

El fichero de configuración de myfaces es faces-config.xml, aunque se puede cambiar el nombre no es necesario.

En el se pueden incluir las configuraciones de:
  * Managed Beans o Backend Beans: es un bean como los de spring que será instanciado desde un componente de JSF. Estas clases deben de tener las propiedades y métodos que sean necesaria para cumplir las necesidades del componente desde el que este siendo llamado.

  * Bundles: Declara los ficheros de internacionalización de la aplicación. Deben de estar en el classpath de la aplicación y ser declarados con el mismo nombre aquí. El idioma lo cogerá directamente del idioma en el que este instalado el navegador.

  * Validadores propios: Son validadores del formulario. Se creará una clase para este fin y luego se aprovechara por toda la aplicación.

  * Conversores propios: Se puede disponer de conversores en algunos componentes para que muestren determinado texto de otra forma dependiendo de algún valor. Es muy utilizado en tema de horas, fechas y cosas por el estilo.

  * Reglas de navegación: Permite crear unas reglas de navegación a partir de una determinada salida del Managed Bean. Es mejor verlo con un ejemplo:

  * Componentes propios:

El servlet de myfaces guarda toda la información relacionada con la petición en un objeto llamado
FacesContest. Las principales características de este objeto son:
  * Encapsula los posibles mensajes.
  * Permite acceder al singleton de la aplicación.
  * Encapsula al elemento raíz de la aplicación.
  * Contiene toda la información relativa al estado de la llamada y la renderización de la respuesta.
  * Solo debe de existir durante la llamada y hasta que se invoque a su método release.
  * Encapsula ResponseWriter, salida de caracteres, y RespondeStream, salida binaria, como flujos de escritura para los renderizadores.
  * Permite acceder al entorno de información por medio del ExternalContext.

Si lo que se necesita es crear un componente propio. Hay 3 pasos mínimos que hay que seguir:

  * Declara el componente: Lleva la lógica del componente. Debe de heredar de la clase UIComponentBase. Hay que asignarle el renderer y el tag. Los métodos más importantes son:

> - setRenderType: en el constructor para asignar el render.

> - getFamily: devuelve el tipo del componte.

> - object getBean: devuelve el objeto para obtener los valores a pintar.

> - restoreState y saveState: mantienen los valores al recomponer el árbol de componentes.

> - processUpdates: Actualización del BackBean.

  * Declarar el tag: Extiende de UIComponentTag. Los métodos más importantes que hay que implementar son:
> - getComponentType: tipo de componente.

> - getRendererType: tipo de render que lo pinta.

  * Declarar el render: Recupera los parámetros de la request y se los pasa al componente. Existe la posibilidad de tener distintos RenderKits en función de la salida. Debe de heredar de la clase Renderer. Los métodos más importantes que debe de implementar al heredar de esta clase son:

> - decode: extrae los parámetros de la request.

> - EncodeBegin, encodeEnd, encodeChildren: pintan las etiquetas inicial, final y anidadas, respectivamente.

# Instalation #

Se añade en el pom.xml del proyecto web las dependencias al core de myfaces 2.0:

```
<dependency>
<groupId>org.apache.myfaces.core</groupId>
<artifactId>myfaces-api</artifactId>
<version>2.0.2</version>
</dependency>

<dependency>
<groupId>org.apache.myfaces.core</groupId>
<artifactId>myfaces-impl</artifactId>
<version>2.0.2</version>
</dependency>
```

Junto a las galerías de componentes JSF que quieran insertarse. En este caso Tomahawk:
```
<dependency>
<groupId>org.apache.myfaces.tomahawk</groupId>
<artifactId>tomahawk20</artifactId>
<version>1.1.10</version>
</dependency>
```
El servlet encargado del funcionamiento de myfaces es FacesServlet, hay que declararlo en web.xml junto a unos parámetros de configuración de myfaces2.0.
```
<servlet>
<servlet-name>Faces Servlet</servlet-name>
<servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
<load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
<servlet-name>Faces Servlet</servlet-name>
<url-pattern>*.html</url-pattern>
</servlet-mapping>
```
Hace falta añadir un fichero faces-config.xml con las reglas de navegación de las páginas jsf. También se declara otros elementos y componentes de jsf.
```
<faces-config xmlns="http://java.sun.com/xml/ns/javaee"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-facesconfig_2_0.xsd"
              version="2.0">

</faces-config>
```
Se añade la internacionalización, en este caso se ha decidido que el fichero se llame i18n.properties
```
<application>
<variable-resolver>org.springframework.web.jsf.DelegatingVariableResolver</variable-resolver>
<el-resolver>org.springframework.web.jsf.el.SpringBeanFacesELResolver</el-resolver>
<resource-bundle>
<base-name>i18n</base-name>
<var>i18n</var>
</resource-bundle>
<message-bundle>i18n</message-bundle>
<locale-config>
<default-locale>es</default-locale>
<supported-locale>es</supported-locale>
<supported-locale>en</supported-locale>
</locale-config>
</application>
```
Se crea un template por defecto que será actualizado llegado el momento de arrancar el proyecto ya que ahora mismo es muy básico:

template.xhtml
```
<f:view contentType="text/html">
		<h:head>
			<title><h:outputText value="#{i18n['title']}" /></title>
			<meta content='text/html; charset=UTF-8' http-equiv="Content-Type"/a>
			<ui:insert name="head"></ui:insert>
			<h:outputStylesheet name="styles.css" library="css"/>
			<h:outputStylesheet name="skin.css" library="css"/>
		</h:head>
		<h:body syleClass="body">
			<t:div id="column1" styleClass="column1"><br/></t:div>
			<t:div id="column2" styleClass="column2">
<ui:include src="/common/header.xhtml" />
<t:div id="page" styleClass="page">
						<t:div id="content" styleClass="content">
							<ui:insert name="content"></ui:insert>
						</t:div>
					</t:div>
			<ui:include src="/common/footer.xhtml" />
			</t:div>
		<t:div id="column3" styleClass="column3"><br/></t:div>
		</h:body>
</f:view>
```
En el fichero meta.xhtml se especifican todos los metas de la aplicación.

meta.xhtml
```
<html>
<head>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
</html>
```

# Use #

El uso de JSF se explicará en el apartado de descripción de la arquitectura, si el lector quiere más detalle puede bajarse la guía oficial de Myfaces2 que le será muy útili para desarrollar con JSF2.

# Links #

http://myfaces.apache.org/core20/index.html

# ¿Qué es? #

Myfaces en la versión 2.0 es una implementación de JSF 2. Sólo es un estándar, define un marco de trabajo.
Lo mejor es empezar con una breve introducción de JSF y myfaces para entender mejor Myfaces.

JSF es un estándar de programación web basado en eventos. Es decir, intenta aplicar el modelo tradicional de eventos, tan utilizados en Delphi y VisualBasic, al entorno web.
JSF abre a la web el modelo tradicional de componentes. Aprovechando que debe de crear estos componentes hace que estos sean reproducibles en diferentes dispositivos no solo en el html típico de un explorador web. Siendo ampliable así a pda, móviles y otros dispositivos.
El paso de transformación de un componente JSF en el elemento resultante, que puede ser otro cualquiera pero que en este proyecto será el html, se hace a partir de un proceso que se conoce como renderizado.
JSF separa el renderizado del componente para poder adaptarlo a cualquier dispositivo de salida.

Las principales características de JSF son:
  * Permite modificar o incorporar componentes propios o de terceros.
  * Permite configurar y definir externamente el flujo de navegación entre las pantallas.
  * Aporta un ciclo de vida claro y estándar.
  * Incluye validadores, eventos, javabeans, conversores.

Como mejora importante hay que incluir que myfaces 2.0 ya trae integrada la tecnología de facelets. Ya que jsf es una tecnología orientada a componentes y las JSP es una tecnología orientada a generar serlets. Pero al no coincidir había que hacer que alguien las casará. Es por lo que facelets, una tecnología orientada a construir árboles de componentes en JSF era tan habitual en los proyectos y por lo que ha sido incluida como estándar en myfaces2.0.

# ¿Como funciona ? #

Las fases del ciclo de vida de JSF es el siguiente:

  * Restore View :El servidor recibe una llamada y recompone los objetos de la vista en el servidor. Su principal objetivo es encontrar que vista esta asociada a la petición hecha por el usuario. Examina si FacesContext tiene un UIViewRoot para asignarle un locale y para recoger los valuebinding y asociarlo con el setValue(). Si la petición es por get y no contiene parámetros por la url puede pasar al último paso del ciclo de vida, si lo necesita pasará al siguiente.

  * Apply Request Values: Deja que los componentes actualicen los valores que le vienen por la request. Se llama al método processDecodes de todos los componentes.

  * Process validations: Se procesan las validaciones llamando a processValidators.

•	Update Model Values: Ahora que están los datos y son válidos se llaman a los métodos que modifican los valores del modelo. Esto se produce recursivamente en el método processUpdates.

  * Invoke Application: La actualización del modelo ha sido completada, se llama al metodo processApplication de UIViewRoot. Se llama a todos los eventos encolaos con phaseId.INVOKE\_APPLICATION.

  * Render Response: Se renderiza la respuesta al cliente. Se invoca al método encode de cada componente del árbol de renderizado.

Los listeners son clases que se instancia entre los diferentes ciclos de vida de JSF2. Se declaran de la siguiente forma:

```
<lifecycle>
<phase-listener>org.archetypeUma.listener.selection.PruebaPhaseListener</phase-listener>
</lifecycle>
```

El fichero de configuración de myfaces es faces-config.xml, aunque se puede cambiar el nombre no es necesario.

En el se pueden incluir las configuraciones de:
  * Managed Beans o Backend Beans: es un bean como los de spring que será instanciado desde un componente de JSF. Estas clases deben de tener las propiedades y métodos que sean necesaria para cumplir las necesidades del componente desde el que este siendo llamado.

  * Bundles: Declara los ficheros de internacionalización de la aplicación. Deben de estar en el classpath de la aplicación y ser declarados con el mismo nombre aquí. El idioma lo cogerá directamente del idioma en el que este instalado el navegador.

  * Validadores propios: Son validadores del formulario. Se creará una clase para este fin y luego se aprovechara por toda la aplicación.

  * Conversores propios: Se puede disponer de conversores en algunos componentes para que muestren determinado texto de otra forma dependiendo de algún valor. Es muy utilizado en tema de horas, fechas y cosas por el estilo.

  * Reglas de navegación: Permite crear unas reglas de navegación a partir de una determinada salida del Managed Bean. Es mejor verlo con un ejemplo:

  * Componentes propios:

El servlet de myfaces guarda toda la información relacionada con la petición en un objeto llamado
FacesContest. Las principales características de este objeto son:
  * Encapsula los posibles mensajes.
  * Permite acceder al singleton de la aplicación.
  * Encapsula al elemento raíz de la aplicación.
  * Contiene toda la información relativa al estado de la llamada y la renderización de la respuesta.
  * Solo debe de existir durante la llamada y hasta que se invoque a su método release.
  * Encapsula ResponseWriter, salida de caracteres, y RespondeStream, salida binaria, como flujos de escritura para los renderizadores.
  * Permite acceder al entorno de información por medio del ExternalContext.

Si lo que se necesita es crear un componente propio. Hay 3 pasos mínimos que hay que seguir:

  * Declara el componente: Lleva la lógica del componente. Debe de heredar de la clase UIComponentBase. Hay que asignarle el renderer y el tag. Los métodos más importantes son:

> - setRenderType: en el constructor para asignar el render.

> - getFamily: devuelve el tipo del componte.

> - object getBean: devuelve el objeto para obtener los valores a pintar.

> - restoreState y saveState: mantienen los valores al recomponer el árbol de componentes.

> - processUpdates: Actualización del BackBean.

  * Declarar el tag: Extiende de UIComponentTag. Los métodos más importantes que hay que implementar son:
> - getComponentType: tipo de componente.

> - getRendererType: tipo de render que lo pinta.

  * Declarar el render: Recupera los parámetros de la request y se los pasa al componente. Existe la posibilidad de tener distintos RenderKits en función de la salida. Debe de heredar de la clase Renderer. Los métodos más importantes que debe de implementar al heredar de esta clase son:

> - decode: extrae los parámetros de la request.

> - EncodeBegin, encodeEnd, encodeChildren: pintan las etiquetas inicial, final y anidadas, respectivamente.

# Instalación #

Se añade en el pom.xml del proyecto web las dependencias al core de myfaces 2.0:

```
<dependency>
<groupId>org.apache.myfaces.core</groupId>
<artifactId>myfaces-api</artifactId>
<version>2.0.2</version>
</dependency>

<dependency>
<groupId>org.apache.myfaces.core</groupId>
<artifactId>myfaces-impl</artifactId>
<version>2.0.2</version>
</dependency>
```

Junto a las galerías de componentes JSF que quieran insertarse. En este caso Tomahawk:
```
<dependency>
<groupId>org.apache.myfaces.tomahawk</groupId>
<artifactId>tomahawk20</artifactId>
<version>1.1.10</version>
</dependency>
```
El servlet encargado del funcionamiento de myfaces es FacesServlet, hay que declararlo en web.xml junto a unos parámetros de configuración de myfaces2.0.
```
<servlet>
<servlet-name>Faces Servlet</servlet-name>
<servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
<load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
<servlet-name>Faces Servlet</servlet-name>
<url-pattern>*.html</url-pattern>
</servlet-mapping>
```
Hace falta añadir un fichero faces-config.xml con las reglas de navegación de las páginas jsf. También se declara otros elementos y componentes de jsf.
```
<faces-config xmlns="http://java.sun.com/xml/ns/javaee"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-facesconfig_2_0.xsd"
              version="2.0">

</faces-config>
```
Se añade la internacionalización, en este caso se ha decidido que el fichero se llame i18n.properties
```
<application>
<variable-resolver>org.springframework.web.jsf.DelegatingVariableResolver</variable-resolver>
<el-resolver>org.springframework.web.jsf.el.SpringBeanFacesELResolver</el-resolver>
<resource-bundle>
<base-name>i18n</base-name>
<var>i18n</var>
</resource-bundle>
<message-bundle>i18n</message-bundle>
<locale-config>
<default-locale>es</default-locale>
<supported-locale>es</supported-locale>
<supported-locale>en</supported-locale>
</locale-config>
</application>
```
Se crea un template por defecto que será actualizado llegado el momento de arrancar el proyecto ya que ahora mismo es muy básico:

template.xhtml
```
<f:view contentType="text/html">
		<h:head>
			<title><h:outputText value="#{i18n['title']}" /></title>
			<meta content='text/html; charset=UTF-8' http-equiv="Content-Type"/a>
			<ui:insert name="head"></ui:insert>
			<h:outputStylesheet name="styles.css" library="css"/>
			<h:outputStylesheet name="skin.css" library="css"/>
		</h:head>
		<h:body syleClass="body">
			<t:div id="column1" styleClass="column1"><br/></t:div>
			<t:div id="column2" styleClass="column2">
<ui:include src="/common/header.xhtml" />
<t:div id="page" styleClass="page">
						<t:div id="content" styleClass="content">
							<ui:insert name="content"></ui:insert>
						</t:div>
					</t:div>
			<ui:include src="/common/footer.xhtml" />
			</t:div>
		<t:div id="column3" styleClass="column3"><br/></t:div>
		</h:body>
</f:view>
```
En el fichero meta.xhtml se especifican todos los metas de la aplicación.

meta.xhtml
```
<html>
<head>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
</html>
```


# Uso #

El uso de JSF se explicará en el apartado de descripción de la arquitectura, si el lector quiere más detalle puede bajarse la guía oficial de Myfaces2 que le será muy útili para desarrollar con JSF2.

# Enlaces #

http://myfaces.apache.org/core20/index.html