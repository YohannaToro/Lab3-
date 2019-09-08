# Servidor Web (tipo Apache)

Servidor web (tipo Apache) que recibe multiples solicitudes no concurentes, con capacidad de responder paginas html e imagenes tipo Html, adicionala a esto debe proveer un framework IoC para contruir aplicaciones web a partir de POJOS.


### Pre-requisitos

Es necesario tener instalado:


```
*  Maven 3.6 en caso de no tener istalado maven siga el siguiente tutorial dependiendo del sistema operativo que posea https://maven.apache.org/install.html
* Java 1.8 si no tiene instalado java en su dispositivo siga el sigueinte tutorial https://java.com/en/download/help/download_options.xml
* Git tutorial: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git
* Heroku 
```

## Instalaciòn y ejecucion del proyecto

### De forma local
Descargue el repositorio lo puede realizar de dos formas descargando el .zip o usando git 

En caso de usar git la linea de comando para clonar el repositiorio es:

```
git clone https://github.com/YohannaToro/ServiceWeb.git
```
Abrir terminal y dirigirse a la siguiente carpeta:

```
cd ServicioApache
```

Descargar dependencias

```
mvn package
```

Ejecutar aplicaciòn

```
java -cp target/classes:target/dependency/* edu.escuelaing.arem.project.app.Controlador
```
Ejecutar heroku de forma local

```
Heroku local web
```

### Despliegue en  Heroku

[![Servidor Apache](https://www.herokucdn.com/deploy/button.png)](https://yohanna-framework.herokuapp.com/yowis.html)

Uso de metodos con POJOs
```
https://yohanna-framework.herokuapp.com/apps/test
https://yohanna-framework.herokuapp.com/apps/hola:profe
```
Imagenes PNG y HTML
```
https://yohanna-framework.herokuapp.com/yowis.html
https://yohanna-framework.herokuapp.com/github.png
```


### Ejecutar pruebas y aplicaciòn

Ejecutra pruebas
```
mvn test
```


## Built With
* [Maven](https://maven.apache.org/) - Dependency Management


## Autor

* **Yohanna Toro**  - [YohannaToro](https://github.com/YohannaToro)


## Licencia

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
