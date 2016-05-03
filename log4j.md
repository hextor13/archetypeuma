# What's it? #

Log4j is an API for monitoring of traces in Java source code. In their beginings, the Java programers writting in standar output using Sytem.out.println(arg). That wasn't very flexible because the programers need some mechanism to allow write in certain way and in several places. So,it started including Log4j into all projects as the library to manage the traces.

# How does it work? #

Log4j provide interfaces which do that can be called from any moment during the project and it has as mision  write on the output which is defined into the log4j.xml file or log4j.properties file, depending version that it is using.

Log4j has two more important parts: appenders and layouts.
Appenders: they serve to define what do with the information, where must it be written.
Layouts: they serve to define the information which will be enclosed to each new trace line and give it a format.
We can define different Layouts. For example, we have a output to file and another to send an email, we may to define one for each.

# Instalation #

We include into the project the dependency through the ,jar file. It's probably, and especially if our application is large, this dependency is already included into the project because it is contained into another .jar file which is already in pom.xml file.
```
<dependency>
<groupId>log4j</groupId>
<artifactId>log4j</artifactId>
<version>1.2.16</version>
</dependency>
```
It's essential to have a properties file or a xml file that is defined in project´s classpath. The log4j.xml file serves as a configuration file for log4j file. In 'Use' section there's an example about configuration file.

# Use #

Log4j provide different trace levels depending their methods:

public void debug(Object message); → This is the lowest level, it must be used for programers during the development and testing.

public void info(Object message); → This is an intermediate level. It offers traces about important events occured while the applicating is running.

public void warn(Object message); → This is the highest level which warns that should not be producing the event.

public void error(Object message); → This is the highest level which reports an error should not be producing in the application. Note that error should not be producing. If it´s a known error, we must go down to lower level.

public void fatal(Object message); → This is the highest error level. If this type of error occurs, it´s probable some system has stopped working into the application.

When our application is in production, the trace level should be the highest posible, because the input and output of the server is too slow and it makes that the application performance in production is too slow.

```
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    <appender name="CONSOLE" class="org.apache.log4j.ConsoleAppender">
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%p [%t] %c{1}.%M(%L) | %m%n"/>
        </layout>
    </appender>
    <appender name="FILE" class="org.apache.log4j.RollingFileAppender">
        <param name="Threshold" value="INFO" />
        <param name="File" value="librae.log" />
        <param name="Append" value="true" />
        <param name="MaxFileSize" value="500KB" />
        <param name="MaxBackupIndex" value="1" />
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%d %-5p [%c] %m%n" />
        </layout>
    </appender>
    <logger name="org.hibernate">
        <level value="INFO/>
    </logger>
    <logger name="org.apache">
        <level value="INFO"/>
    </logger>
    <root>
       <level value="ERROR"/>
       <appender-ref ref="CONSOLE"/>
       <appender-ref ref="FILE"/>
    </root>
</log4j:configuration>
```
In study case, will be declarated two appenders. One of them for standar output, usually the monitor, and the other one for a file. Obviously the best option is use the file for systems in production or similar and the monitor for development systems.
Default traces are in error level, these are defined in:
```
<root>
<level value="ERROR"/>
<appender-ref ref="CONSOLE"/>
<appender-ref ref="FILE"/>
</root>
```
But org.hibnate and org.apache packages are into INFO. Here we are several examples with different trace levels which can be done with log4j.
```
<logger name="org.hibernate">
<level value="INFO"/>
</logger>
<logger name="org.apache">
<level value="INFO"/>
</logger>
```
Only it must be added the following lines in the header of the Java class which should print traces into the logs:
```
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
```
Create the class variable:
```
protected final Log  log = LogFactory .getLog(this.getClass());
```
and the following lines into the Java method:
```
log.error(“mensaje”);
```

# Links #

http://jakarta.apache.org/log4j/

# ¿Qué es? #

Log4j es una API para la monitorización de trazas en el código Java. En sus inicios los programadores en Java escribían en la salida estándar por medio de Sytem.out.println(arg). Esto era muy poco flexible ya que los programadores exigían poder escribir de determinadas formas y en diferentes sitios. Fue entonces cuando log4j se empezó a incluir en todos los proyectos como la librería que gestionaba las trazas.

# ¿Como funciona? #

Log4j proporciona unas interfaces que hacen que se pueda llamar desde cualquier punto del proyecto y que tiene como misión escribir en la salida que tenga definida en el fichero log4j.xml o log4j.properties según la versión que se este utilizando.

Dos partes significativas de log4j son los appenders y los layouts.
Appenders: sirven para definir que hay que hacer con la información, donde hay que escribirla.
Layouts: sirve para definir la información que acompañara a cada nueva línea de traza y para darle formato.
Se pueden definir diferentes formatos de layouts, si por ejemplo tenemos una salida para fichero y otra para que envíe un email se puede definir una para cada.

# Instalación #

Hay que incluir en el proyecto la dependencia con el jar. Es probable y sobre todo si la aplicación es  grande que la dependencia ya esta incluida en el proyecto porque sea dependencia de otro jar que ya tengamos en los pom.xml.
```
<dependency>
<groupId>log4j</groupId>
<artifactId>log4j</artifactId>
<version>1.2.16</version>
</dependency>
```
Es imprescindible tener un fichero de propiedades o un xml en el classpath del proyecto. El fichero log4j.xml es el que hará las veces de fichero de configuración de log4j. En la sección de 'Uso' hay un ejemplo de fichero de configuración.

# Uso #

Log4j proporciona diferentes niveles de trazas según sus métodos:

public void debug(Object message); → Es el nivel más bajo, debe de ser utilizado por los programadores en la fase de desarrollo y pruebas.

public void info(Object message); → Es un nivel medio en el que se intenta dejar constancia a los lectores de las trazas que el evento que acaba de ocurrir en el programa es significativo.

public void warn(Object message); → Es en nivel alto en el que se advierte que no se debería estar produciendo el evento.

public void error(Object message); → Es un nivel alto que formaliza un error que no se debería de haber producido en la aplicación. Nótese que no se debería de haber producido. Si es un error controlado lo mejor es bajar a un nivel más bajo.

public void fatal(Object message); → El nivel más alto, si ha ocurrido esta clase de error en probable que algún sistema deje de funcionar dentro de la aplicación.

Es importante en producción que el nivel de traza este lo más alto posible. Ya que la entrada-salida en un servidor esta muy penalizada y hace que se ralenticé el rendimiento de la aplicación.
```
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    <appender name="CONSOLE" class="org.apache.log4j.ConsoleAppender">
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%p [%t] %c{1}.%M(%L) | %m%n"/>
        </layout>
    </appender>
    <appender name="FILE" class="org.apache.log4j.RollingFileAppender">
        <param name="Threshold" value="INFO" />
        <param name="File" value="librae.log" />
        <param name="Append" value="true" />
        <param name="MaxFileSize" value="500KB" />
        <param name="MaxBackupIndex" value="1" />
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%d %-5p [%c] %m%n" />
        </layout>
    </appender>
    <logger name="org.hibernate">
        <level value="INFO/>
    </logger>
    <logger name="org.apache">
        <level value="INFO"/>
    </logger>
    <root>
       <level value="ERROR"/>
       <appender-ref ref="CONSOLE"/>
       <appender-ref ref="FILE"/>
    </root>
</log4j:configuration>
```
En el caso de estudio, se habrán declarado dos appenders. Uno para la salida estándar, normalmente la pantalla, y otro para fichero. Naturalmente lo mejor es dejar el fichero para los sistemas en producción o similar y la pantalla para los equipos de desarrollo.
Las trazas por defecto están a nivel de error, definidos en:
```
<root>
<level value="ERROR"/>
<appender-ref ref="CONSOLE"/>
<appender-ref ref="FILE"/>
</root>
```
Pero los paquetes org.hibnate y org.apache están a INFO. Se han puesto como ejemplo de los diferentes niveles de trazas que se pueden hacer con log4j.
```
<logger name="org.hibernate">
<level value="INFO"/>
</logger>
<logger name="org.apache">
<level value="INFO"/>
</logger>
```
Solo falta añadirlo a la clase Java que quiera imprimir algo en los logs. Esto se hace con la declaración de los imports en la cabecera:
```
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
```
Crear la variable de clase
```
protected final Log  log = LogFactory .getLog(this.getClass());
```
y con el siguiente código en el método:
```
log.error(“mensaje”);
```

# Links #

http://jakarta.apache.org/log4j/