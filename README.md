# Taller de de modularización con virtualización e Introducción a Docker y a AWS

Arquitecturas Empresariales 2020-2

## Generalidades

http://ec2-54-210-150-219.compute-1.amazonaws.com:5000/index

Este repositorio presenta un despliegue abaja escala de un servicio usando Docker , usando las herramientas Maven, AWS, Docker, Spark, Git y JAVA para su desarrollo.

Encuentre los repositorios en Docker
https://hub.docker.com/repository/docker/wasawsky/taller5areprobin

https://hub.docker.com/repository/docker/wasawsky/taller5arep

Se puede ver el despliegue del servicio, donde ponemos el mensaje y la pagina responde con  la actualizacion de los ultimos 10 valores.

![](/resources/img/web.JPG)

Los detalles de la maquina EC2 en AWS, podemos ver la ubicacion y sus direcciones.

![](/resources/img/aws.JPG)

Los puertos que estan abiertos de esta maquina, 6 en total son utilizados para comprobar el funciomnamiento del servicio

![](/resources/img/aws2.JPG)

La conexion a la maquina de AWS se hace via SSH, con una llave especifica y suministrada por AWS

![](/resources/img/ec2.JPG)

Se puede apreciar el estado de las imagenes y contenedores que usa Docker para permitir el funcionamiento del servicio

![](/resources/img/ec21.JPG)

Puede encontrar el informe en https://github.com/Wasawsky/Arq_Emp_Taller4

### Prerrequisitos

Para poder usar este repositorio necesitara instalar Maven en su computador.
http://maven.apache.org/download.html

Puede encontrar la guía para la instalación desde:
http://maven.apache.org/download.html#Installation

También necesitara tener la versión más reciente de Java y jdk actualizados.

Se necesita Docker para la ejecucion local de las imagenes, instale Docker en su maquina o si desea en una maquina virtual.
https://www.docker.com/

Instale git si aún no lo tiene instalado en su computador.

Lo puede encontrar y seguir los pasos de su instalación en:
https://git-scm.com/book/en/v2/Getting-Started-Installing-Git

Use un framework como Visual Studio Code, IntelliJ o alguno de su preferencia para más comodidad cuando use este repositorio.


### Preparando el espacio de trabajo

Cuando esté preparado abra un directorio en su computador donde quiera trabajar.

Ejecuta la consola de comandos desde el directorio y escribe en la línea de comandos

```
git clone https://github.com/Wasawsky/Arq_Emp_Taller5.git
```

Se le creara una carpeta llamada Arq_Emp_Taller5 en el directorio, es este repositorio desde donde trabajara.

Ingrese a la carpeta y ejecute la consola de comandos, o usando un framework de desarrollo abra la carpeta.

Existen 2 implementaciones, LogService y RoundRobin, elija la carpeta que quiera trabajar.

Desde la consola de comandos y estando en el repositorio escriba

```
mvn package
```

Para que se ejecute el POM.xml del proyecto.
Se descargarán librerías que necesitara el proyecto, puede tardar algunos minutos si es la primera vez que ejecuta el comando.

## Despliegue Local

Si necesita ejecutar localmente el servidor, use el siguiente comando para ejecutarlo desde cmd de Windows

Para LogService

```
web: java -cp target/classes;target/dependency/* edu.eci.arep.sparkDocker.Log
```

Para RoundRobin

```
web: java -cp target/classes;target/dependency/* edu.eci.arep.sparkDocker.Service
```

Abra su navegador y busque la direccion web:

http://localhost:4567/hello



### Funcionalidades

Este proyecto, desplegado en heroku, permite acceder a peticiones de la aplicacion en un servidor web


## Uso

Puede ejecutar el método principal de la clase Log.java con LogService y Service.java con RoundRobin desde la consola de comandos para iniciar el programa.

Puede ejecutar localmente para ver el servicio web

Podrá visualizar la peticion web del servidor


## Construido con

* [Maven](https://maven.apache.org/) - Dependency Management
* [GIT](https://git-scm.com/) - Environment Version Control System
* [Java](https://www.java.com/es/) - General-purpose programming language
* [Docker](https://www.docker.com/) - OS-Level Virtualization
* [AWS](https://aws.amazon.com/es/) - Cloud Solutions


## Sobre el autor

*Michael Ballesteros*

Apasionado por el desarrollo y la gestión de sistemas

## Licencia

Para más información de la licencia ver LICENSE.md

Para más proyectos, Sígueme y encuentra mis repositorios :D

## Agradecimientos

Felipe Portales-Oliva

Johni0702
