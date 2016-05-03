# What´s it? #

Maven es una herramienta para la gestión del ciclo de vida de las aplicaciones. Funciona como una aplicación en Java y es un Opensource de la fundación Apache. Bajo una licencia Apache Licence 2.0.

¿Pero que es gestionar el ciclo de vida de un software? Maven tiene las virtudes de poder crear un proyecto o descargárselo de algún repositorio, construirlo, definir las dependencias, integrar el proyecto con los IDE's, compilación, empaquetado, pruebas unitarias, pruebas de estrés y funcionalidad, calidad y documentación del código.
Maven tiene su opositor en Ant también de Apache. Ant tiene menos funcionalidad que Maven es ya que solo es un constructor de proyectos, una funcionalidad de las muchas que tiene Maven. Es fácil pensar que maven es un complemento de Ant, al tener más funcionalidad y por poder invocarse desde Maven.
Las ventajas de Maven en la producción de proyectos software:

  * Hacer el proceso de construcción fácil.
  * Proveer un proceso de construcción uniforme.
  * Proveer una cantidad de información sobre el proyecto.
  * Servir como guía de buenas practicas de desarrollo de software.
  * Permitir una migración transparente a nuevas funcionalidades.
  * Setup simple de proyectos siguiendo buenas practicas de software. Generar un proyecto nuevo en pocos segundos.
  * Manejo de dependencias incluyendo actualizaciones automáticas. Tanto dependencias primarias como transitivas.
  * Permite trabajar de una forma fácil con múltiples proyectos al mismo tiempo.
  * Grande y creciente repositorio de librerías y metadatos externo a nuestro proyecto. Liberando así el sistema de control de versiones de contener jar´s.
  * Es extensible. Haciendo uso de sus sistema de plugins en java o en lenguajes de scripts.
  * Acceso instantáneo a nueva funcionalidades con una mínima o ninguna configuración.
  * Posibilidad del uso de tareas ant para manejar dependencias y despliegue fuera de maven.
  * Maven esta preparado para un gran número de builds para proyectos, ya sea tipo jar, war, ear.
  * Usando los metadatos asociados al proyecto, maven es genera un sitio web o pdf incluyendo cualquier documentación que se quiera. Además de toda la información que maven añade como api, java doc, información sobre desarrolladores, informes de test, etc.
  * Manejo de release y publicación de distribuciones. Maven pude ser integrado con el sistema de control de versiones y manejar las releases de un proyecto en un tag concreto. Maven puede publicar distribuciones basadas en jar, en un archivo incluyendo dependencias y documentación, o una distribución de fuentes.
  * Manager de dependencias: Maven impulsa el uso de un repositorio central de JAR´s y otras.
  * Los inconvenientes de maven en la gestión de proyectos software:
  * Su curva de aprendizaje es muy pronunciada. Los informáticos que desarrollen el proyecto deben de estar muy preparados en conocimientos de Java.

# How does it work? #

A continuación se van a describir unos conceptos importantes de maven:

  * Los ficheros POM (Project Object Model) son ficheros en formato XML obligatorio en todo proyecto Maven, donde se incluye la información (meta-datos) necesaria para que éste pueda construir y gestionar el proyecto.
  * Artefacto: Es para maven la unidad mínima con la que trabaja a la hora de gestionar sus dependencias.
  * Coordenadas: Sistema con el maven determina de forma única a cada uno de sus artefactos.
  * Goal: Son las unidades de mínimas de ejecución. Las tareas más simples.
  * Ciclo de vida: Secuencia de etapas que propone maven para la gestión de un proyecto.

Las fases del ciclo de vida de maven son:

  * pre-clean: ejecuta los procesos necesarios para la limpieza.
  * clean: elimina todos los ficheros generados en la construcción previa.
  * post-clean: ejecuta los procesos necesarios al finalizar la limpieza del proyecto.
  * validate: valida que el proyecto es correcto y tiene toda la información necesaria.
  * inicializate: Inicializa la construcción, modificando propiedades o creando directorios.
  * generate-sources: Genera algún código fuente para utilizarlo en la compilación.
  * process-sources: Procesa el código fuente anterior.
  * generate-resources: Genera los recursos para incluirlos en el paquete.
  * process-resources: Copia y procesa los recursos al directorio de trabajo.
  * compile: Compila el código fuente.
  * process-classes: Ejecuta unas tareas después del la generación de los códigos compilados, por ejemplo por si hubiera que cambiar el bytecode de las clases.
  * generate-test-sources: Genera algunos códigos fuentes de los test para la inclusión en la compilación.
  * process-test-sources: Procesa el código fuente de los test, por ejemplo filtrar algunas variables.
  * generate-test-resources: Crea los recursos para el test.
  * process-test-resources: Copia y procesa los recursos dentro del directorio destino de los test.
  * test-compile: Compila el código fuente de los test dentro del directorio destino de los test.
  * process-test-classes: Hace un postprocesado de la generación de ficheros de la compilación de los test. Por ejemplo se cambia el bytecode.
  * test: compila el código y ejecuta los unit test correspondientes. Sin embargo no es requisito para que el proyecto sea desplegado.
  * prepare-package: Prepara algunas operaciones necesarias antes del empaquetado.
  * package: toma el código compilado y lo empaqueta en un formato distribuible como JAR o WAR.
  * pre-integration-test: prepara algunas operaciones antes que se ejecuten los test de integración.
  * integration-test: Despliega el proyecto si es necesario en ambiente de pruebas donde se puedan correr pruebas de integración.
  * post-integration-test: prepara algunas operaciones después que se ejecuten los test de integración. Esto puede incluir la limpieza del entorno.
  * verify: ejecuta cualquier verificación para cumplir los parámetros de calidad.
  * install: instala el jar o war en el repositorio local para que otras aplicaciones locales la puedan usar.
  * deploy: copia el jar o war a un repositorio remoto para que pueda ser usado por otro desarrollador o proyecto.
  * pre-site: ejecuta los procesos necesarios para la generación del site.
  * site: genera la documentación del site proyecto
  * post-site: ejecuta los procesos necesarios al finalizar la documentación del site y prepara para el despliegue.
  * site-deploy: despliega la generación del site al servidor especificado.

Estructura de directorios: Propuesta que realiza maven para organizar los distintos archivos que conforman un proyecto.

Los proyectos en maven siempre marcan una determinada estructura, esto simplifica el trabajo a la hora de migrar un equipo de desarrollo a otro proyecto de maven, ya que todos mantienen las mismas pautas.
La estructura estándar de un proyecto en Maven es:

|Directorio|Descripción|
|:---------|:----------|
|/aplicacion/pom.xml|Fichero de configuración de maven|
|/aplicacion/src/|Código fuente|
|/aplicacion/src/main/java/|Código fuente de java|
|/aplicacion/src/test/java/|Test de JUnits|
|/aplicacion/src/main/resources/|Recursos necesarios en el classpath|
|/aplicacion/src/test/resources/| Recursos necesarios en el classpath para los test|
|/aplicacion/src/main/webapp|Contiene los html, jsp y demás contenidos de una aplicación web|
|/aplicacion/target/classes/|Clases ya compiladas|
|/aplicacion/target/test-classes/|Las clases de los test ya compiladas|
|/aplicacion/target/dots|Otras salidas de documentos|
|/aplicacion/target/{#filename}|En los proyectos war tienen el contenido de la creación del war|

Tabla. Estructura de carpetas de un proyecto maven.

Archetype: Son plantillas con las definir la base de proyectos tipo con el fin de reutilizarlas.

Los archetype son simples plugins de maven, uno de ellos es el archetype create, el cual permite crear un proyecto base al proporcionar la plantilla del mismo.
El archetype create recibe una serie de parámetros los cuales son:

  * archetypeGroupId: Identificador del grupo del archetipo.

  * groupId, es usado como identificador del conjunto de librerías en este caso hemos usado org.archetypeUma como nombre para nuestro paquete de librerías.

  * artifactId, es usado como identificador particular de una librería en particular.

Cuando se usan archetypes creados por uno mismo se tiene que especificar los tres parámetros de todo archetype (groupId, artifactId, version) de la siguiente manera.

```
mvn archetype:create -DarchetypeGroupId=<archetype-groupId> -DarchetypeArtifactId=<archetype-artifactId> -DarchetypeVersion=<archetype-version> -DgroupId=<my.groupid> -DartifactId=<my-artifactId>
```

Si es la primera vez que se ejecuta un comando Maven éste tomará algo de tiempo pues Maven creará el repositorio inicial .m2 y descargará todas las librerías necesarias para construir el proyecto.
En este caso el archetype contiene la plantilla de un proyecto web.

Finalizado el proceso de construcción del artefacto, Maven lo deposita en repositorios.

  * Repositorio: Estructura de directorios y archivos que usa maven para almacenar, organizar y recuperar artefactos. Existen repositorios locales (file://) y remotos (http://)
  * Existen dos tipo de repositorios:

> - Repositorio local: situado en la máquina del desarrollador. Almacena artefactos instalados (maven install) y descargados de repositorios remotos.

> - Repositorio remotos: repositorios accesibles a través de protocolos file:// y http://.
> - internos: utilizados por las empresas para almacenar sus artefactos que son compartidos por los desarrolladores.

> - externos: repositorios públicos utilizados para almacenar artefactos de terceros.

Hay varias herramientas que permiten gestionar un repositorio. Si el lector esta interesado en profundizar en el tema le aconsejamos que siga por Archiva o Artefactory, que son software libre muy utilizado.

Profiles: Son un mecanismo (no alternativa) de configurar el proceso de construcción.
En ciertos proyectos es importante trabajar con varias bases de datos, en varios entornos diferentes o en varios servidores. Las librerías  y las variables de configuración  que se necesitan para arrancar en cada entorno son diferentes. Maven resuelve esto mediante profiles:

```
<profiles>
<profile>
<id>mysql</id>
<activation>
<property>
<name>db</name>
<value>mysql</value>
</property>
</activation>
<properties>
<driver>org.mysql.Driver</driver>
</properties>
</profile>
<profile>
<id>postgresql</id>
<activation>
<property>
<name>db</name>
<value>postgresql</value>
</property>
</activation>
<properties>
<driver>org.postgresql.Driver</driver>
</properties>
</profile>
</profiles>
```

Basta con pasarle a maven con que perfil quiere instalar.

```
mvn -Pmysql clean 
```

Los perfiles en la versión 3 de Maven hay que meterlos en el fichero M2\_HOME/conf/settings.xml,   antes maven acostumbraba meterlos en un fichero profiles.xml que acompañaba al pom.xml principal.

# Instalation #

Requisitos obligatorios: JDK de JAVA, recomendada la versión 1.6

Descargar la versión 3.0 de la web oficial de Apache Maven:
http://maven.apache.org/download.html
o desde la página de este proyecto:

Declarar las variables de entorno:

  * En linux:

> - export MAVEN\_HOME=/home/user/carpetasInstalacion/apache-maven-3.0

> - export M2\_REPO=/home/user/carpetasInstalacion/repositorioMaven

> - export M2=/home/user/carpetasInstalacion/apache-maven-3.0

> - export MAVEN\_OPTS=-Xms512 -Xmx512 -XX:MaxPermSize=512m

  * En windows:
> - set MAVEN\_HOME=/C:/carpetasInstalacion/apache-maven-3.0
> - set M2\_REPO=/C:/carpetasInstalacion/apache-maven-3.0
> - set M2=/C:/carpetasInstalacion/apache-maven-3.0
> - export MAVEN\_OPTS=-Xms512 -Xmx512 -XX:MaxPermSize=512m

Meter maven en el path del sistema operativo, para poder ejecutarlo desde cualquier punto del sistema de ficheros:
  * En linux:

> - export PATH=$PATH:$MAVEN\_HOME/bin

  * En windows:

> - set PATH=$PATH;$MAVEN\_HOME/bin

Los ficheros de configuración de maven pueden verse en diferentes niveles:
  * Global: $M2\_HOME/conf/settings.xml
  * Por usuario: ~/.m2/settings.xml
  * Por proyecto: pom.xml

# Use #


Los tag más importantes en el uso de maven son:

  * 

&lt;groupId&gt;

 El id del grupo al que pertenece el proyecto.
  * 

&lt;artifactId&gt;

 El id del artifact o proyecto (en la mayoría de los casos el nombre del proyecto).
  * 

&lt;version&gt;

 La versión del artifact en el grupo especificado.
```
<groupId>org.archetypeUma</groupId>
<artifactId>archetypeUma-model</artifactId>
<packaging>jar</packaging>
<version>1.0-SNAPSHOT</version>
```
Lo de -SNAPSHOT en el nombre de la versión hay que explicarlo detalladamente. Si dependemos de un jar que tenga -SNAPSHOT, cada vez que compilemos, aunque ese jar esté en nuestro repositorio local, maven ira a buscarlos a los repositorios comunes o de Internet, para ver si hay una versión de fecha más moderna. Si la hay, se la bajará. Por tanto, suele ser útil en un equipo de trabajo mantener la "coletilla" -SNAPSHOT en los jar que todavía están en desarrollo y sufren cambios frecuentes.
Si no ponemos -SNAPSHOT, una vez bajado el jar a nuestro repositorio local, maven NO se preocupará de buscar si hay versiones más modernas en los repositorios remotos.
En los poms se pueden definir muchos componentes. Se van a explicar los que han sido utilizados para crear esta arquitectura y los más utilizados.
Empezando por developers, sirve para especificar los desarrolladores y el equipo que ha intervenido en el proyecto.
```
<developers>
<developer>
<id>jcisneros</id>
<name>Javier Cisneros González</name>
<email>javicisneros@gmail.es</email>
</developer>
</developers>
```
scm: son las siglas de Source Code Management (Gestión de código fuente), es la revisión de múltiples versiones de una misma unidad de información. Con el siguiente XML se especifica donde esta el código del proyecto. Esto no es obligatorio pero si es muy guardarlo en el pom principal del proyecto.

```
<scm>
<connection>scm:svn:https://archetypeuma.googlecode.com/svn/trunk/</connection>
<developerConnection>scm:svn:https://archetypeuma.googlecode.com/svn/trunk/
</developerConnection>
<url></url>
</scm>
```
licenses: Las licencias del proyecto se marcan bajo la etiqueta XML llamada licences. En las siguientes líneas se especifica que el proyecto será de software libre bajo la licencia  Apache License 2.0 y  European Union Public License.
```
<licenses>
<license>
<name>EUPL v1.0</name>
<url>http://ec.europa.eu/idabc/eupl</url>
<comments>European Union Public License</comments>
</license>
<license>
<name>Apache License 2.0</name>
<url>http://www.apache.org/licenses/LICENSE-2.0</url>
<comments />
</license>
</licenses>
```
modules: La etiqueta module asigna al pom los submodulos que se ejecutarán después de ejecutarse el mismo. Es ideal para lanzar una construcción en varios modulos, ya que crearlo en uno solo puede resultar muy engorroso.
```
<modules>
<module>model</module>
<module>core</module>
<module>web</module>
</modules>
```
repositories: Maven se baja las dependencias de los servidores que sirven de repositorios. Esos repositorios pueden estar en cualquier sitio de Internet o de una red local. Hay que especificarle al proyecto donde están los repositorios desde los que se quiere descargar las dependencias del proyecto.
En el siguiente ejemplo se utiliza el repositorio público de Jboss.
```
<repositories>
<repository>
<id>jboss</id>
<name>JBoss repository</name>
<url>http://repository.jboss.org/maven2</url>
</repository>
</repositories>
```
pluginRepositories: Al igual que el caso anterior, maven busca los plugins en los repositorios remotos, en lugar de apuntar con la etiqueta repositories, se utiliza pluginRepositories.
```
<pluginRepositories>
<pluginRepository>
<id>appfuse</id>
<url>http://static.appfuse.org/repository</url>
</pluginRepository>

<pluginRepository>
<id>alfresco</id>
<url>http://maven.alfresco.com/nexus/content/repositories/sourcesense-public</url>
</pluginRepository>

<pluginRepository>
<id>maven2-repository.dev.java.net</id>
<name>Java.net Repository for Maven</name>
<url>http://download.java.net/maven/2/</url>
<layout>default</layout>
</pluginRepository>

<pluginRepository>
<id>mc-release</id>
<name>Local Maven repository of releases</name>
<url>http://mc-repo.googlecode.com/svn/maven2/releases</url>
<snapshots>
<enabled>false</enabled>
</snapshots>
<releases>
<enabled>true</enabled>
</releases>
</pluginRepository>

<pluginRepository>
<id>repo1</id>
<name>Repo-1 for Maven 2</name>
<url>http://repo1.maven.org/maven2/</url>
<layout>default</layout>
</pluginRepository>
</pluginRepositories>
```
resources: Se especifica los recursos que necesitarán las clases java para funcionar correctamente. Aquí caben muchas posibilidades... plantillas, xml, ficheros estáticos. Se suele poner el fichero de recursos de maven  src/main/resources. Al meterlo se empaquetaría en el jar, war o ear como un fichero más.
```
<resources>
<resource>
<filtering>true</filtering>
<directory>src/main/resources</directory>
</resource>
</resources>
```
testResources: Se especifica con  testResources cual será el directorio de recursos para los test. Es decir, que si un test necesita determinado fichero para utilizar, por ejemplo un xml, este se buscará en estos directorios.
```
<testResources>
<testResource>
<filtering>true</filtering>
<directory>src/test/resources</directory>
</testResource>
</testResources>
```
dependency: Los proyectos en Java se han llenado de librerías que tienen que interactuar entre si para formar los proyectos, lo más abstractos posibles. Solo hay que especificar el groupId el artifactId y la versión que se desea descargar.
Este es un ejemplo de como añadir una dependencia a un pom.xml en un proyecto de Maven.
```
<dependency>
<groupId>log4j</groupId>
<artifactId>log4j</artifactId>
<version>1.2.15</version>
</dependency>
```
  * groupId: es usado como identificador del conjunto de librerías en este caso se ha usado log4j como nombre para nuestro paquete de librerías.
  * artifactId: es usado como identificador particular de una librería en particular. Como log4j solo tiene una coincide con el groupId pero esto no debe porque ser así.
  * version: Es la versión de la librería que se desea meter como dependencia en el proyecto.
  * scope: es la fase del ciclo de vida de maven a la que se le asociará la dependencia. Existen seis ámbitos en los que una dependencia puede ser declarada limitando así su transitividad:

  * Compile, es el ámbito por defecto. Las dependencias están disponibles en el proyecto y en sus proyectos dependientes.
  * Provided, se espera que el JDK, la aplicación o el contenedor provea la dependencia.
  * Runtime, la dependencia no es requerida en tiempo de compilación pero sí para la ejecución.
  * Test, son dependencias que son requeridas solo cuando se compila y ejecuta los test.
  * System, similar a provided pero se le debe indicar el jar que contiene la dependencia
  * Import, (a partir a la version 2.0.9) solo es usado en una dependencia del tipo POM en la sección . Indica que el POM utilizado debe ser remplazado con las dependencias que éste tenga en su sección

```
<dependency>
<groupId>javassist</groupId>
<artifactId>javassist</artifactId>
<version>3.9.0.GA</version>
<scope>runtime</scope>
</dependency>
```

En el scope se añade runtime para que la dependencia este presente solo en el empaquetado final del proyecto. Ya que no es necesaria ni a la hora de compilar, ni para los test ni en el resto de fases del ciclo de vida de maven.
```
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.5</version>
<scope>test</scope>
</dependency>
```
En este scope le pasamos como argumento test, ya que solo será necesario en la fase de test y este jar no deberá de estar presente en el empaquetado final del proyecto, ni en el war ni en el ear.

La nomenclatura de las dependencias es la siguiente:

artetifacId – version – package(jar, war, aer)
En un ejemplo
myfaces-core-2.0.0.jar

La versión corresponde a mayor – minor – parches en este caso 2.0.0 Segunda versión, aún sin cambios y sin parches arreglados.

Un plugin es un programa que se ejecuta en maven. Partiendo del ejemplo de compilar, solo es necesario tener el plugin de  maven-compiler-plugin en el pom.xml para que se compilara el proyecto. Hay muchos tipos de plugins y es perfectamente ampliable por cada usuario que necesite alguna funcionalidad que no este creada.
```
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<version>2.0.2</version>
<configuration>
<source>1.5</source>
<target>1.5</target>
</configuration>
</plugin>
```
En la siguiente tabla se muestra una serie de plugins muy utilizados en los proyectos que se están utilizando hoy en día.

|Pluguins más utilizados|Descripción|
|:----------------------|:----------|
|maven-clean-plugin     |Limpia el directorio de trabajo.|
|maven-compiler-plugin  |Compila el código fuente.|
|maven-deploy-plugin    |Despliega el artefacto en un servidor remoto.|
|maven-install-plugin   |Instala el artefacto en el repositorio local.|
|maven-resources-plugin |Copia los recursos al directorio de salida.|
|maven-site-plugin      |Genera el site del proyecto|
|maven-surefire-plugin  |Ejecuta los test de Junit|

Tabla. Plugin más utilizados de maven.

A continuación se describen las órdenes más importantes de maven que todo aquel que trabaje con esta herramienta debe de conocer:

|Comando|Descripción|
|:------|:----------|
|mvn –version|Ver la versión de maven.|
|mvn clean|Limpiar el directorio de trabajo de maven de un proyecto es sencillo solo hay que añadir clean. El directorio de trabajo es la carpeta target.|
|mvn help|Mostrar la ayuda de maven con el comando.|
|mvn -X |Si hay algún problema y ha salido el mensaje BUILD FAILURE se puede comprobar que ha pasado  escribiendo -X con lo que se ven las trazas en modo DEBUG.|
|mvn test|Ejecutar la fase del ciclo de vida de maven referente a los test. |
|mvn package|Empaquetar en un jar, war o un ear. No instala los empaquetados en el repositorio local ni remoto.|
|mvn install|Instalar en el repositorio. Compila el proyecto, ejecuta los test, empaqueta los war y ear e instala el artefacto en el repositorio local de maven. (%M2\_REPO%)|
|mvn deploy|Si lo que se pretende es instalar en un repositorio remoto en vez de en el local. Se ejecuta un deploy. Esto tendría que hacerlo un sistema de integración continua como es Hudson.|
|mvn dependency:tree|Obtener el árbol de dependencias y optimizarlas para excluir las que no se necesiten.|
|mvn dependency:resolve|Muestra una listado de todos los artefactos que han sido resueltos.|
|mvn clean install -o -Dmaven.test.skip=true|En un equipo de desarrollo la orden más utilizada es la compilación, empaquetado e instalación. Con el argumento -o seleccionamos el modo offline. Algo que será útil en el equipo de desarrollo cada vez que se compile, ya que no se perderá tiempo en conectarse con los repositorios externos. Con el argumento -Dmaven.test.skip=true  nos saltamos en el al ciclo de vida la fase de test y por tanto todos los plugins asociados a este ciclo de vida. Al igual que el argumento anterior esto hará que se compile más rápidamente el proyecto.|
|mvn compile|Compila los fuentes del proyecto.|
|mvn  eclipse:eclipse|Crea un proyecto en eclipse a partir de un proyecto maven.|
|mvn idea:idea|Crea un proyecto en Intellij IDEA a partir de un proyecto maven.|

Tabla. Comandos más importantes de maven.

# Links #

  * http://maven.apache.org/
  * http://maven.apache.org/download.html

# ¿Qué es? #


Maven es una herramienta para la gestión del ciclo de vida de las aplicaciones. Funciona como una aplicación en Java y es un Opensource de la fundación Apache. Bajo una licencia Apache Licence 2.0.

¿Pero que es gestionar el ciclo de vida de un software? Maven tiene las virtudes de poder crear un proyecto o descargárselo de algún repositorio, construirlo, definir las dependencias, integrar el proyecto con los IDE's, compilación, empaquetado, pruebas unitarias, pruebas de estrés y funcionalidad, calidad y documentación del código.
Maven tiene su opositor en Ant también de Apache. Ant tiene menos funcionalidad que Maven es ya que solo es un constructor de proyectos, una funcionalidad de las muchas que tiene Maven. Es fácil pensar que maven es un complemento de Ant, al tener más funcionalidad y por poder invocarse desde Maven.
Las ventajas de Maven en la producción de proyectos software:

  * Hacer el proceso de construcción fácil.
  * Proveer un proceso de construcción uniforme.
  * Proveer una cantidad de información sobre el proyecto.
  * Servir como guía de buenas practicas de desarrollo de software.
  * Permitir una migración transparente a nuevas funcionalidades.
  * Setup simple de proyectos siguiendo buenas practicas de software. Generar un proyecto nuevo en pocos segundos.
  * Manejo de dependencias incluyendo actualizaciones automáticas. Tanto dependencias primarias como transitivas.
  * Permite trabajar de una forma fácil con múltiples proyectos al mismo tiempo.
  * Grande y creciente repositorio de librerías y metadatos externo a nuestro proyecto. Liberando así el sistema de control de versiones de contener jar´s.
  * Es extensible. Haciendo uso de sus sistema de plugins en java o en lenguajes de scripts.
  * Acceso instantáneo a nueva funcionalidades con una mínima o ninguna configuración.
  * Posibilidad del uso de tareas ant para manejar dependencias y despliegue fuera de maven.
  * Maven esta preparado para un gran número de builds para proyectos, ya sea tipo jar, war, ear.
  * Usando los metadatos asociados al proyecto, maven es genera un sitio web o pdf incluyendo cualquier documentación que se quiera. Además de toda la información que maven añade como api, java doc, información sobre desarrolladores, informes de test, etc.
  * Manejo de release y publicación de distribuciones. Maven pude ser integrado con el sistema de control de versiones y manejar las releases de un proyecto en un tag concreto. Maven puede publicar distribuciones basadas en jar, en un archivo incluyendo dependencias y documentación, o una distribución de fuentes.
  * Manager de dependencias: Maven impulsa el uso de un repositorio central de JAR´s y otras.
  * Los inconvenientes de maven en la gestión de proyectos software:
  * Su curva de aprendizaje es muy pronunciada. Los informáticos que desarrollen el proyecto deben de estar muy preparados en conocimientos de Java.

# ¿Como funciona ? #


A continuación se van a describir unos conceptos importantes de maven:

  * Los ficheros POM (Project Object Model) son ficheros en formato XML obligatorio en todo proyecto Maven, donde se incluye la información (meta-datos) necesaria para que éste pueda construir y gestionar el proyecto.
  * Artefacto: Es para maven la unidad mínima con la que trabaja a la hora de gestionar sus dependencias.
  * Coordenadas: Sistema con el maven determina de forma única a cada uno de sus artefactos.
  * Goal: Son las unidades de mínimas de ejecución. Las tareas más simples.
  * Ciclo de vida: Secuencia de etapas que propone maven para la gestión de un proyecto.

Las fases del ciclo de vida de maven son:

  * pre-clean: ejecuta los procesos necesarios para la limpieza.
  * clean: elimina todos los ficheros generados en la construcción previa.
  * post-clean: ejecuta los procesos necesarios al finalizar la limpieza del proyecto.
  * validate: valida que el proyecto es correcto y tiene toda la información necesaria.
  * inicializate: Inicializa la construcción, modificando propiedades o creando directorios.
  * generate-sources: Genera algún código fuente para utilizarlo en la compilación.
  * process-sources: Procesa el código fuente anterior.
  * generate-resources: Genera los recursos para incluirlos en el paquete.
  * process-resources: Copia y procesa los recursos al directorio de trabajo.
  * compile: Compila el código fuente.
  * process-classes: Ejecuta unas tareas después del la generación de los códigos compilados, por ejemplo por si hubiera que cambiar el bytecode de las clases.
  * generate-test-sources: Genera algunos códigos fuentes de los test para la inclusión en la compilación.
  * process-test-sources: Procesa el código fuente de los test, por ejemplo filtrar algunas variables.
  * generate-test-resources: Crea los recursos para el test.
  * process-test-resources: Copia y procesa los recursos dentro del directorio destino de los test.
  * test-compile: Compila el código fuente de los test dentro del directorio destino de los test.
  * process-test-classes: Hace un postprocesado de la generación de ficheros de la compilación de los test. Por ejemplo se cambia el bytecode.
  * test: compila el código y ejecuta los unit test correspondientes. Sin embargo no es requisito para que el proyecto sea desplegado.
  * prepare-package: Prepara algunas operaciones necesarias antes del empaquetado.
  * package: toma el código compilado y lo empaqueta en un formato distribuible como JAR o WAR.
  * pre-integration-test: prepara algunas operaciones antes que se ejecuten los test de integración.
  * integration-test: Despliega el proyecto si es necesario en ambiente de pruebas donde se puedan correr pruebas de integración.
  * post-integration-test: prepara algunas operaciones después que se ejecuten los test de integración. Esto puede incluir la limpieza del entorno.
  * verify: ejecuta cualquier verificación para cumplir los parámetros de calidad.
  * install: instala el jar o war en el repositorio local para que otras aplicaciones locales la puedan usar.
  * deploy: copia el jar o war a un repositorio remoto para que pueda ser usado por otro desarrollador o proyecto.
  * pre-site: ejecuta los procesos necesarios para la generación del site.
  * site: genera la documentación del site proyecto
  * post-site: ejecuta los procesos necesarios al finalizar la documentación del site y prepara para el despliegue.
  * site-deploy: despliega la generación del site al servidor especificado.

Estructura de directorios: Propuesta que realiza maven para organizar los distintos archivos que conforman un proyecto.

Los proyectos en maven siempre marcan una determinada estructura, esto simplifica el trabajo a la hora de migrar un equipo de desarrollo a otro proyecto de maven, ya que todos mantienen las mismas pautas.
La estructura estándar de un proyecto en Maven es:

|Directorio|Descripción|
|:---------|:----------|
|/aplicacion/pom.xml|Fichero de configuración de maven|
|/aplicacion/src/|Código fuente|
|/aplicacion/src/main/java/|Código fuente de java|
|/aplicacion/src/test/java/|Test de JUnits|
|/aplicacion/src/main/resources/|Recursos necesarios en el classpath|
|/aplicacion/src/test/resources/| Recursos necesarios en el classpath para los test|
|/aplicacion/src/main/webapp|Contiene los html, jsp y demás contenidos de una aplicación web|
|/aplicacion/target/classes/|Clases ya compiladas|
|/aplicacion/target/test-classes/|Las clases de los test ya compiladas|
|/aplicacion/target/dots|Otras salidas de documentos|
|/aplicacion/target/{#filename}|En los proyectos war tienen el contenido de la creación del war|

Tabla. Estructura de carpetas de un proyecto maven.

Archetype: Son plantillas con las definir la base de proyectos tipo con el fin de reutilizarlas.

Los archetype son simples plugins de maven, uno de ellos es el archetype create, el cual permite crear un proyecto base al proporcionar la plantilla del mismo.
El archetype create recibe una serie de parámetros los cuales son:

  * archetypeGroupId: Identificador del grupo del archetipo.

  * groupId, es usado como identificador del conjunto de librerías en este caso hemos usado org.archetypeUma como nombre para nuestro paquete de librerías.

  * artifactId, es usado como identificador particular de una librería en particular.

Cuando se usan archetypes creados por uno mismo se tiene que especificar los tres parámetros de todo archetype (groupId, artifactId, version) de la siguiente manera.

```
mvn archetype:create -DarchetypeGroupId=<archetype-groupId> -DarchetypeArtifactId=<archetype-artifactId> -DarchetypeVersion=<archetype-version> -DgroupId=<my.groupid> -DartifactId=<my-artifactId>
```

Si es la primera vez que se ejecuta un comando Maven éste tomará algo de tiempo pues Maven creará el repositorio inicial .m2 y descargará todas las librerías necesarias para construir el proyecto.
En este caso el archetype contiene la plantilla de un proyecto web.

Finalizado el proceso de construcción del artefacto, Maven lo deposita en repositorios.

  * Repositorio: Estructura de directorios y archivos que usa maven para almacenar, organizar y recuperar artefactos. Existen repositorios locales (file://) y remotos (http://)
  * Existen dos tipo de repositorios:

> - Repositorio local: situado en la máquina del desarrollador. Almacena artefactos instalados (maven install) y descargados de repositorios remotos.

> - Repositorio remotos: repositorios accesibles a través de protocolos file:// y http://.
> - internos: utilizados por las empresas para almacenar sus artefactos que son compartidos por los desarrolladores.

> - externos: repositorios públicos utilizados para almacenar artefactos de terceros.

Hay varias herramientas que permiten gestionar un repositorio. Si el lector esta interesado en profundizar en el tema le aconsejamos que siga por Archiva o Artefactory, que son software libre muy utilizado.

Profiles: Son un mecanismo (no alternativa) de configurar el proceso de construcción.
En ciertos proyectos es importante trabajar con varias bases de datos, en varios entornos diferentes o en varios servidores. Las librerías  y las variables de configuración  que se necesitan para arrancar en cada entorno son diferentes. Maven resuelve esto mediante profiles:

```
<profiles>
<profile>
<id>mysql</id>
<activation>
<property>
<name>db</name>
<value>mysql</value>
</property>
</activation>
<properties>
<driver>org.mysql.Driver</driver>
</properties>
</profile>
<profile>
<id>postgresql</id>
<activation>
<property>
<name>db</name>
<value>postgresql</value>
</property>
</activation>
<properties>
<driver>org.postgresql.Driver</driver>
</properties>
</profile>
</profiles>
```

Basta con pasarle a maven con que perfil quiere instalar.

```
mvn -Pmysql clean 
```

Los perfiles en la versión 3 de Maven hay que meterlos en el fichero M2\_HOME/conf/settings.xml,   antes maven acostumbraba meterlos en un fichero profiles.xml que acompañaba al pom.xml principal.

# Instalación #


Requisitos obligatorios: JDK de JAVA, recomendada la versión 1.6

Descargar la versión 3.0 de la web oficial de Apache Maven:
http://maven.apache.org/download.html
o desde la página de este proyecto:

Declarar las variables de entorno:

  * En linux:

> - export MAVEN\_HOME=/home/user/carpetasInstalacion/apache-maven-3.0

> - export M2\_REPO=/home/user/carpetasInstalacion/repositorioMaven

> - export M2=/home/user/carpetasInstalacion/apache-maven-3.0

> - export MAVEN\_OPTS=-Xms512 -Xmx512 -XX:MaxPermSize=512m

  * En windows:
> - set MAVEN\_HOME=/C:/carpetasInstalacion/apache-maven-3.0
> - set M2\_REPO=/C:/carpetasInstalacion/apache-maven-3.0
> - set M2=/C:/carpetasInstalacion/apache-maven-3.0
> - export MAVEN\_OPTS=-Xms512 -Xmx512 -XX:MaxPermSize=512m

Meter maven en el path del sistema operativo, para poder ejecutarlo desde cualquier punto del sistema de ficheros:
  * En linux:

> - export PATH=$PATH:$MAVEN\_HOME/bin

  * En windows:

> - set PATH=$PATH;$MAVEN\_HOME/bin

Los ficheros de configuración de maven pueden verse en diferentes niveles:
  * Global: $M2\_HOME/conf/settings.xml
  * Por usuario: ~/.m2/settings.xml
  * Por proyecto: pom.xml

# Uso #

Los tag más importantes en el uso de maven son:

  * 

&lt;groupId&gt;

 El id del grupo al que pertenece el proyecto.
  * 

&lt;artifactId&gt;

 El id del artifact o proyecto (en la mayoría de los casos el nombre del proyecto).
  * 

&lt;version&gt;

 La versión del artifact en el grupo especificado.
```
<groupId>org.archetypeUma</groupId>
<artifactId>archetypeUma-model</artifactId>
<packaging>jar</packaging>
<version>1.0-SNAPSHOT</version>
```
Lo de -SNAPSHOT en el nombre de la versión hay que explicarlo detalladamente. Si dependemos de un jar que tenga -SNAPSHOT, cada vez que compilemos, aunque ese jar esté en nuestro repositorio local, maven ira a buscarlos a los repositorios comunes o de Internet, para ver si hay una versión de fecha más moderna. Si la hay, se la bajará. Por tanto, suele ser útil en un equipo de trabajo mantener la "coletilla" -SNAPSHOT en los jar que todavía están en desarrollo y sufren cambios frecuentes.
Si no ponemos -SNAPSHOT, una vez bajado el jar a nuestro repositorio local, maven NO se preocupará de buscar si hay versiones más modernas en los repositorios remotos.
En los poms se pueden definir muchos componentes. Se van a explicar los que han sido utilizados para crear esta arquitectura y los más utilizados.
Empezando por developers, sirve para especificar los desarrolladores y el equipo que ha intervenido en el proyecto.
```
<developers>
<developer>
<id>jcisneros</id>
<name>Javier Cisneros González</name>
<email>javicisneros@gmail.es</email>
</developer>
</developers>
```
scm: son las siglas de Source Code Management (Gestión de código fuente), es la revisión de múltiples versiones de una misma unidad de información. Con el siguiente XML se especifica donde esta el código del proyecto. Esto no es obligatorio pero si es muy guardarlo en el pom principal del proyecto.

```
<scm>
<connection>scm:svn:https://archetypeuma.googlecode.com/svn/trunk/</connection>
<developerConnection>scm:svn:https://archetypeuma.googlecode.com/svn/trunk/
</developerConnection>
<url></url>
</scm>
```
licenses: Las licencias del proyecto se marcan bajo la etiqueta XML llamada licences. En las siguientes líneas se especifica que el proyecto será de software libre bajo la licencia  Apache License 2.0 y  European Union Public License.
```
<licenses>
<license>
<name>EUPL v1.0</name>
<url>http://ec.europa.eu/idabc/eupl</url>
<comments>European Union Public License</comments>
</license>
<license>
<name>Apache License 2.0</name>
<url>http://www.apache.org/licenses/LICENSE-2.0</url>
<comments />
</license>
</licenses>
```
modules: La etiqueta module asigna al pom los submodulos que se ejecutarán después de ejecutarse el mismo. Es ideal para lanzar una construcción en varios modulos, ya que crearlo en uno solo puede resultar muy engorroso.
```
<modules>
<module>model</module>
<module>core</module>
<module>web</module>
</modules>
```
repositories: Maven se baja las dependencias de los servidores que sirven de repositorios. Esos repositorios pueden estar en cualquier sitio de Internet o de una red local. Hay que especificarle al proyecto donde están los repositorios desde los que se quiere descargar las dependencias del proyecto.
En el siguiente ejemplo se utiliza el repositorio público de Jboss.
```
<repositories>
<repository>
<id>jboss</id>
<name>JBoss repository</name>
<url>http://repository.jboss.org/maven2</url>
</repository>
</repositories>
```
pluginRepositories: Al igual que el caso anterior, maven busca los plugins en los repositorios remotos, en lugar de apuntar con la etiqueta repositories, se utiliza pluginRepositories.
```
<pluginRepositories>
<pluginRepository>
<id>appfuse</id>
<url>http://static.appfuse.org/repository</url>
</pluginRepository>

<pluginRepository>
<id>alfresco</id>
<url>http://maven.alfresco.com/nexus/content/repositories/sourcesense-public</url>
</pluginRepository>

<pluginRepository>
<id>maven2-repository.dev.java.net</id>
<name>Java.net Repository for Maven</name>
<url>http://download.java.net/maven/2/</url>
<layout>default</layout>
</pluginRepository>

<pluginRepository>
<id>mc-release</id>
<name>Local Maven repository of releases</name>
<url>http://mc-repo.googlecode.com/svn/maven2/releases</url>
<snapshots>
<enabled>false</enabled>
</snapshots>
<releases>
<enabled>true</enabled>
</releases>
</pluginRepository>

<pluginRepository>
<id>repo1</id>
<name>Repo-1 for Maven 2</name>
<url>http://repo1.maven.org/maven2/</url>
<layout>default</layout>
</pluginRepository>
</pluginRepositories>
```
resources: Se especifica los recursos que necesitarán las clases java para funcionar correctamente. Aquí caben muchas posibilidades... plantillas, xml, ficheros estáticos. Se suele poner el fichero de recursos de maven  src/main/resources. Al meterlo se empaquetaría en el jar, war o ear como un fichero más.
```
<resources>
<resource>
<filtering>true</filtering>
<directory>src/main/resources</directory>
</resource>
</resources>
```
testResources: Se especifica con  testResources cual será el directorio de recursos para los test. Es decir, que si un test necesita determinado fichero para utilizar, por ejemplo un xml, este se buscará en estos directorios.
```
<testResources>
<testResource>
<filtering>true</filtering>
<directory>src/test/resources</directory>
</testResource>
</testResources>
```
dependency: Los proyectos en Java se han llenado de librerías que tienen que interactuar entre si para formar los proyectos, lo más abstractos posibles. Solo hay que especificar el groupId el artifactId y la versión que se desea descargar.
Este es un ejemplo de como añadir una dependencia a un pom.xml en un proyecto de Maven.
```
<dependency>
<groupId>log4j</groupId>
<artifactId>log4j</artifactId>
<version>1.2.15</version>
</dependency>
```
  * groupId: es usado como identificador del conjunto de librerías en este caso se ha usado log4j como nombre para nuestro paquete de librerías.
  * artifactId: es usado como identificador particular de una librería en particular. Como log4j solo tiene una coincide con el groupId pero esto no debe porque ser así.
  * version: Es la versión de la librería que se desea meter como dependencia en el proyecto.
  * scope: es la fase del ciclo de vida de maven a la que se le asociará la dependencia. Existen seis ámbitos en los que una dependencia puede ser declarada limitando así su transitividad:

  * Compile, es el ámbito por defecto. Las dependencias están disponibles en el proyecto y en sus proyectos dependientes.
  * Provided, se espera que el JDK, la aplicación o el contenedor provea la dependencia.
  * Runtime, la dependencia no es requerida en tiempo de compilación pero sí para la ejecución.
  * Test, son dependencias que son requeridas solo cuando se compila y ejecuta los test.
  * System, similar a provided pero se le debe indicar el jar que contiene la dependencia
  * Import, (a partir a la version 2.0.9) solo es usado en una dependencia del tipo POM en la sección . Indica que el POM utilizado debe ser remplazado con las dependencias que éste tenga en su sección

```
<dependency>
<groupId>javassist</groupId>
<artifactId>javassist</artifactId>
<version>3.9.0.GA</version>
<scope>runtime</scope>
</dependency>
```

En el scope se añade runtime para que la dependencia este presente solo en el empaquetado final del proyecto. Ya que no es necesaria ni a la hora de compilar, ni para los test ni en el resto de fases del ciclo de vida de maven.
```
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.5</version>
<scope>test</scope>
</dependency>
```
En este scope le pasamos como argumento test, ya que solo será necesario en la fase de test y este jar no deberá de estar presente en el empaquetado final del proyecto, ni en el war ni en el ear.

La nomenclatura de las dependencias es la siguiente:

artetifacId – version – package(jar, war, aer)
En un ejemplo
myfaces-core-2.0.0.jar

La versión corresponde a mayor – minor – parches en este caso 2.0.0 Segunda versión, aún sin cambios y sin parches arreglados.

Un plugin es un programa que se ejecuta en maven. Partiendo del ejemplo de compilar, solo es necesario tener el plugin de  maven-compiler-plugin en el pom.xml para que se compilara el proyecto. Hay muchos tipos de plugins y es perfectamente ampliable por cada usuario que necesite alguna funcionalidad que no este creada.
```
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<version>2.0.2</version>
<configuration>
<source>1.5</source>
<target>1.5</target>
</configuration>
</plugin>
```
En la siguiente tabla se muestra una serie de plugins muy utilizados en los proyectos que se están utilizando hoy en día.

|Pluguins más utilizados|Descripción|
|:----------------------|:----------|
|maven-clean-plugin     |Limpia el directorio de trabajo.|
|maven-compiler-plugin  |Compila el código fuente.|
|maven-deploy-plugin    |Despliega el artefacto en un servidor remoto.|
|maven-install-plugin   |Instala el artefacto en el repositorio local.|
|maven-resources-plugin |Copia los recursos al directorio de salida.|
|maven-site-plugin      |Genera el site del proyecto|
|maven-surefire-plugin  |Ejecuta los test de Junit|

Tabla. Plugin más utilizados de maven.

A continuación se describen las órdenes más importantes de maven que todo aquel que trabaje con esta herramienta debe de conocer:

|Comando|Descripción|
|:------|:----------|
|mvn –version|Ver la versión de maven.|
|mvn clean|Limpiar el directorio de trabajo de maven de un proyecto es sencillo solo hay que añadir clean. El directorio de trabajo es la carpeta target.|
|mvn help|Mostrar la ayuda de maven con el comando.|
|mvn -X |Si hay algún problema y ha salido el mensaje BUILD FAILURE se puede comprobar que ha pasado  escribiendo -X con lo que se ven las trazas en modo DEBUG.|
|mvn test|Ejecutar la fase del ciclo de vida de maven referente a los test. |
|mvn package|Empaquetar en un jar, war o un ear. No instala los empaquetados en el repositorio local ni remoto.|
|mvn install|Instalar en el repositorio. Compila el proyecto, ejecuta los test, empaqueta los war y ear e instala el artefacto en el repositorio local de maven. (%M2\_REPO%)|
|mvn deploy|Si lo que se pretende es instalar en un repositorio remoto en vez de en el local. Se ejecuta un deploy. Esto tendría que hacerlo un sistema de integración continua como es Hudson.|
|mvn dependency:tree|Obtener el árbol de dependencias y optimizarlas para excluir las que no se necesiten.|
|mvn dependency:resolve|Muestra una listado de todos los artefactos que han sido resueltos.|
|mvn clean install -o -Dmaven.test.skip=true|En un equipo de desarrollo la orden más utilizada es la compilación, empaquetado e instalación. Con el argumento -o seleccionamos el modo offline. Algo que será útil en el equipo de desarrollo cada vez que se compile, ya que no se perderá tiempo en conectarse con los repositorios externos. Con el argumento -Dmaven.test.skip=true  nos saltamos en el al ciclo de vida la fase de test y por tanto todos los plugins asociados a este ciclo de vida. Al igual que el argumento anterior esto hará que se compile más rápidamente el proyecto.|
|mvn compile|Compila los fuentes del proyecto.|
|mvn  eclipse:eclipse|Crea un proyecto en eclipse a partir de un proyecto maven.|
|mvn idea:idea|Crea un proyecto en Intellij IDEA a partir de un proyecto maven.|

Tabla. Comandos más importantes de maven.

# Enlaces #

  * http://maven.apache.org/
  * http://maven.apache.org/download.html