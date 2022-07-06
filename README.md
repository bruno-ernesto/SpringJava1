# SpringJava1
parte1 Spring Java.
# Instrucciones para correr el código. 
En la carpeta de h2.api se creo utilizando el programa de Spring Initializr como se muestra en la imagen Creación proyecto spring.png.
El archivo base de datos empleados.sql es la creación de la base en MySQL con algunas consultas para la revision del mismo.
El archivo  ejercicio1.mwb es el diagrama creado a partir de las tablas en MySQL Workbench.
Al momento en que se ejecuta el código en ''h2.api'' los datos en h2 no se quedan guardados  es de un solo uso al momento en hacer incerción,eliminación, búsqueda de datos y actualizar datos.
Para ver la consola h2 es necesario escribir : [h2-console:](http://localhost:8080/h2-console/)  y para ingresar es necesario escribir en el User Name: h2 y en el passowrd: h2 para ingresar a la bd 
Dentro de h2 del lado izquierdo se verán las tablas creadas,ahí se le puede agregar, modificar, eliminar los datos y para verlos desde html es necesario escribir el [Employee:](http://localhost:8080/employee/1) para ver a los employee y cambiando el numero se pueden ver a los que se agregán en ese momento, de la misma manera se escriben para[Airport:]( http://localhost:8080/airport/1) para los datos de la tabla Airport, [Country:](http://localhost:8080/country/1) para la tabla Country y para la tabla Language entra con la direccion [Language:](http://localhost:8080/language/1)
