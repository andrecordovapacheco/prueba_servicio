# Prueba Servicio
Se realizó las prueba de para el servicio restful-booker
Para este proyecto se esta utilizando BDD, Java/Cucumber/Serenity 

# Plan de prueba
* El plan de prueba esta relizado en un excel y esta en la carpeta pruebaMobile\planprueba

# Collection Postman
* La colleccion se realizo con postman y esta en la carpeta pruebaMobile\collectionpostman
* para poder visualizar toda la collección debemos de aplicar estos pasos:
* 1.- Abrir postman
* 2.- En nuestro Workspace importamos el proyecto json
* 3.- Abrimos nuestra colección Booker y ejecutamos


# Configuración de su maquina (Herramientas)
* Establecer `JAVA_HOME` como una variable de entorno
* Establecer `M2_HOME` como una variable de entorno
* Instalar Eclipse IDE
* Instalar plugin de Cucumber

# Arquitectura

* La arquitectura esta diseñada en estas capas:
* 1.- feature: creación de todos los escenarios para la pruebas de regresión
* 2.- definition: creación de las clases para la comunicación y realizar los assert
* 3.- step: creación de las clases para realizar la logica del negocio
* 4.- util: creación de las clases generales para poder utilizar programación orientada a objetos
* 5.- request: creación de clase para el parseo de objetos para mandarlos por el request del servicio
* 6.- response: creación de clase para el parseo de objetos obtenidos del response del servicio
* 7.- runner: clase de ejecución de los escenarios


# Escenarios 
* Se crearon los siguientes escenarios:
* 1.- creartoken
* 2.- GetBookingIdsAll
* 3.- GetBookingIdsFilter
* 4.- GetBooking
* 5.- CreateBooking
* 6.- UpdateBooking
* 7.- PartialUpdateBooking
* 8.- DeleteBooking
* 9.- pingHealthCheck
* 10.- UnHappyGetBooking
* 11.- UnHappyCreateBooking
* 12.- UnHappyUpdateBooking


# Modo de ejecución
* Importar el proyecto desde File/Maven/Existing Maven Projects
* Instalar las dependencias del POM: en el nombre del proyecto hacer click derecho/Maven/Update Project
* Ir al package run y abrir el archivo RunPrueba.java
* Desde el mismo archivo Run.java hacer click derecho/Run As/Junit Test
* Ejemplo 
* Deconementar "@CucumberOptions(features = { "src/test/resources/features/" }, tags = { "@creartoken" }, glue = { "auto.prueba" })"

# Reporte
* En el nombre del proyecto hacer click derecho/Show in/Terminal
* En la terminal escribir mvn serenity:aggregate y darle enter
* Verificar el reporte en la carpeta del proyecto target/site/serenity/index-html

#Integración con Jenkins 

* Para realizar la integración con el jenkins se creo un archivo plano ("Jenkinsfile") este será leido por un pipeline en el servidor que usted tenga.

*Creación de un pipeline:
* Primero es instalar el Jenkins en tu PC o Servidor
* Segundo debemos crear un pipeline 
* Tercero debemos de parametrizar los escenarios. En el nombre especificamos "ESCENARIO" y en opciones ingresamos todos nuestros escenarios automatizados (@creartoken,@GetBookingIdsAll,@GetBookingIdsFilter,@GetBooking,@CreateBooking,@UpdateBooking,@PartialUpdateBooking,@DeleteBooking,@pingHealthCheck,@UnHappyGetBooking,@UnHappyCreateBooking,@UnHappyUpdateBooking)

* Cuarto debemos de ingresar el repositorio github con las credenciales y el branch
* Quinto debemos de ingresar el script path ("Jenkinsfile")
 
