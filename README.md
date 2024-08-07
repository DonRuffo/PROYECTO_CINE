Objetivo General
Desarrollar un sistema de reservas para cine que permita a los usuarios reservar y administrar películas de un cine en específico, mejorando la experiencia del cliente y optimizando la gestión operativa del cine.
Objetivos Específicos
1.	Implementar funcionamientos de administrador para el sistema de reservas, como ver estadísticas, gestionar clientes y gestionar películas para facilitar a el administrador de la empresa el manejo correcto de la base de datos.
2.	Implementar funcionamientos de cliente para el sistema de reservas, como registrarse, acceder a la cartelera del cine y reservar un asiento para una película en específico 

Justificación
La implementación de un sistema de reservas para cine es fundamental en la era digital actual, donde la conveniencia y la eficiencia son prioridades para los consumidores. Este sistema ofrecerá múltiples beneficios tanto para los usuarios como para la administración del cine:
1.	Mejora de la Experiencia del Cliente:
	Los usuarios podrán consultar la cartelera y reservar sus boletos desde la comodidad de su hogar o desde cualquier dispositivo móvil, evitando largas filas y esperas en taquilla.
	La posibilidad de elegir sus asientos preferidos mejora la satisfacción del cliente y su experiencia general.
2.	Optimización de la Gestión Operativa:
	El sistema permitirá una mejor gestión de la capacidad de las salas, facilitando la asignación y control de los asientos disponibles.
	Automatizará el proceso de venta de boletos, reduciendo errores y aumentando la eficiencia del personal de taquilla.
3.	Incremento de las Ventas:
	Al ofrecer un canal de ventas adicional, se espera un incremento en la venta de boletos, ya que los clientes pueden comprar en cualquier momento y lugar.
4.	Seguridad y Comodidad:
	El sistema proporcionará opciones de pago seguras y variadas, aumentando la confianza del usuario en el proceso de compra.
	La entrega de boletos digitales reduce el riesgo de pérdida o falsificación de boletos físicos.
5.	Análisis y Toma de Decisiones:
	La recopilación de datos sobre las reservas y ventas permitirá a la administración del cine realizar análisis detallados y tomar decisiones informadas para mejorar su oferta y servicio.
En resumen, la implementación de un sistema de reservas para cine no solo responde a la demanda de los usuarios por mayor comodidad y eficiencia, sino que también optimiza la operación interna del cine, aumentando su competitividad y capacidad de adaptación a un mercado en constante cambio.
Herramientas Swing Utilizadas
	JComboBox: Permite tener una barra de valores predeterminados por el sistema y desarrollador.

	JTextField: El ingreso por teclado es factible gracias a este elemento, ayuda a los usuarios a ingresar valores que son necesarios para avanzar dentro del sistema.

	JButton: Permiten realizar acciones dentro de los JFrame como navegar por el sistema, generar información, ejecutar una petición, etc.

	JLabel: Ayuda a predeterminar un texto dentro de la pantalla, mayormente usado como guía para los usuarios en cuanto a que acción deben realizar en cada pantalla.

	Spacers: Son útiles para mover a los elementos dentro del JPanel entre sí, con el objetivo de achicar o aprovechar de mejor manera los espacios visuales.

	JFrame: El componente de mayor nivel, permite crear frames (pantallas) como lienzo para agregar componentes y funcionalidades dentro del sistema.

	JPanel: Permite agregar componentes y elementos dentro de un JFrame, en cada uno de estos hay al menos un JPanel.

	JCheckBox: Herramienta para seleccionar y deseleccionar una función o acción dentro del sistema.

	JScrollPanel: Peculiar componente que se relaciona con el uso de los JTables para la asignación de datos múltiples. Facilita la navegación en la información 
independientemente de la cantidad de datos que existan y del tamaño del JFrame.

	JTables: Como su nombre lo indica, son tablas que se pueden generar dentro de los frames, van acompañadas, comúnmente, de un ScrollPanel para su visualización y manipulación de los datos.

	JPasswordField: Similar a un JTextField, con la característica de cifrar el texto que el usuario introduce, ideal para la implementación de contraseñas en el sistema.

	Imágenes: Dentro del proyecto se creó una carpeta como repositorio de imágenes para su uso en los frames a crear.

Desarrollo y pruebas
1.	Login
Para la implementación de Login se tomó en consideración los tipos de usuario que utilizará el sistema: Administrador y Cliente, además de cuáles son los valores se deben ingresar por pantalla: Usuario y Contraseña. Posterior a ello, se crea una clase Java Swing en donde se moldea el diseño del login.
 



Funcionamiento

 

Al accionar el botón “Iniciar Sesión” el sistema hará una conexión con la base de datos y permitirá al cliente  o administrador  navegar  y usar el sistema.


Validaciones y límites
	El usuario debe llenar obligatoriamente todos los campos para la verificación de su identidad.
 


	Si el usuario ingresa sus credenciales incorrectamente, el sistema lo alertará.
 



2.	Gestión como Administrador
Dentro de las funcionalidades para este apartado se encuentran: Gestión de Películas,, Gestión de Clientes,  Estadísticas y el cierre de sesión
 


Funcionamiento
 







3.	Gestionar Películas
Este Jframe cuenta con las funcionalidades necesarias para un manejo completo de las películas que se encuentran actualmente en una cartelera
 

Funcionamiento
 



4.	Agregar Película
El administrador puede agregar una nueva película a la cartelera del cine mediante este frame, que incluye inputs para detallar el título, categoría, fecha, hora, sala, restricción de edad y precio por asiento que tendrá el film.
 

Funcionamiento
 




Validaciones y limitaciones
	Todos los campos deben ser llenados.
 


	El sistema no permitirá agregar una película si el campo de “Categoría” contiene números o sí el precio del asiento contiene algún carácter distinto a un número.
 



	Para la restricción de edad se cuenta con únicamente 3 opciones: Familiar, +15 y +18 que identifican a el público que puede observar la película.
	Los campos “Año”, “Mes” y “Día” definirán la fecha para la función, dependiendo del mes elegido habrá una corrección en la cantidad de días que puede escoger. Ejemplo: Si elije el mes “02” tendrá opción a elegir hasta 28 días, puesto que el mes “02” identifica al mes de febrero; si elige el mes “12”, 31 días y si elije el mes “11” tendrá 30 días.
 
 




	El sistema identifica si el año seleccionado es bisiesto o no, controlando así el número de días para febrero. Por ejemplo: 2024 es bisiesto, por ende febrero cuenta con 29 días.
 


	El sistema no permite agregar una película en un horario que ya se encuentra ocupado por otra, si se intenta realizar esta acción se alertará al administrador y solicitará el cambio de horario.
 


	Para el campo “Sala” el administrador tiene disponibles 10 salas, no más.
 
	Existen únicamente cuatro horas disponibles para las funciones: 12:00, 15:00, 18:00, 21:00
 

Prueba de éxito
 
NOTA: las cuatro horas, la restricción de edad y la categoría indicada previamente son inmutables a lo largo de este sistema. No existen cambios de estos datos. 




5.	Cambiar horarios

Esta función permite a los administradores mover horarios y salas, en dónde el sistema pide seleccionar una película y el horario actual para luego seleccionar el nuevo.
 




Funcionamiento

 



Validaciones y limitaciones

	El sistema solo mostrará los horarios que cada película tiene actualmente, de esta manera se controla elegir un horario y sala que no tiene ninguna relación con el título
     


	El sistema solicitará que se llenen todos los campos de manera obligatoria, tanto en el horario actual de la película como en el nuevo.
 









	El sistema validará el nuevo horario designado con el resto de películas que se encuentran en la cartelera, si coincide con un horario que ya está ocupado, se le alertará al usuario para elegir otro horario.
 


	Al igual que el frame anterior (AgregarPelicula) el año, mes y día están controlados según la selección.
     




	Si la pelicula ya resgistra reservas de los clientes, no se le permitirá modificar el horario
 


	Prueba de éxito
 


6.	Eliminar Película
Para completar la gestión de las películas, fue implementada la función de eliminar una película de cartelera. Además, el sistema brinda dos maneras de eliminar un titulo: especificando horario y sala de la función o eliminar todas las funciones de una película.
 


Funcionamiento
 



Validaciones y limitaciones
	Como primera opción, el sistema ofrece eliminar una película del cine definitivamente, pero si el administrador desea eliminar la película de un horario y sala en específico, podrá seleccionar el JCheckBox para desplegar nuevos campos de control.

 


	En este frame también se controla la disponibilidad de horarios  que tiene cada película en base a su fecha, sala y hora.

     


	El sistema obliga al administrador a seleccionar todos los campos
 
Prueba de éxito con Eliminar por Horario y Sala
 



Prueba de éxito sin Eliminar por Horario y Sala
 





7.	Gestionar Clientes
Una vez finalizada la gestión de películas, la concentración obtiene un enfoque sobre los clientes y las acciones que se puede realizar sobre ellos, como agregar un cliente, ver clientes y eliminar un cliente.
 


Funcionamiento

 







8.	Agregar Cliente
El administrador puede registrar la información de un cliente detallando: cédula, nombre, edad, teléfono, dirección, contraseña y confirmar contraseña.
 


Funcionamiento

 








Validaciones y limitaciones
	El sistema no permitirá el registro si existen caracteres alfabéticos en los campos cedula y teléfono.
	
 



	El sistema obliga al administrador a llenar todos los campos
	
 


	Valida las contraseñas y devuelve un error si no coinciden
 


	El sistema permite ingresar la edad en un rango de 18 a 100 años

 


	El sistema no permite registrar un cliente si el campo Nombre contiene números

 
	El sistema valida que en los campos teléfono y cedula tengan exactamente 10 dígitos.

 



Prueba de éxito
 










9.	Ver Clientes
Un administrador debe poder ver la información de los clientes que se encuentran registrados en el sistema, incluso para poder eliminarlo después.
Este frame muestra todos los datos de cada cliente en un JTable, todo menos las contraseñas por supuesto.

 





Funcionamiento
 

10.	Eliminar Cliente
Completando la gestión de los clientes, damos paso a la función de eliminar uno, teniendo como llave la cédula del cliente a eliminar.
 





Funcionamiento

 




Validaciones y limitaciones
	La cedula ingresada debe contra con al menos 10 dígitos y el sistema validará que no existan caracteres alfabéticos.
 
 


	Si el sistema no encuentra al cliente con la cédula ingresada, devolverá un mensaje indicando que no existe dicho cliente

 
	Al presionar el botón Ver se podrá ver a información del cliente seleccionado y además activará el botón eliminar.
 



Prueba de éxito

 











11.	Estadísticas
Ahora se procede a implementar la función de estadísticas, donde el administrador podrá visualizar los datos financieros y de ocupación que tiene el cine.
 


Funcionamiento

 









12.	Ventas
El administrador podrá ver las ventas del cine de dos maneras: por fecha y función o por película.

 



Funcionamiento

 






13.	Por fecha y función
Con esta modalidad, el administrador puede navegar entre las estadísticas únicamente por fechas (anualmente, mensualmente, diariamente y en función específica.) y por salas.
 


Funcionamiento

 



Validaciones y limitaciones
	El sistema de fechas es escalable a partir del año, puede solo seleccionar el año y visualizar estadísticas anuales, o aumentar a esa selección un mes para ver la información mensual, y así hasta llegar al más ato nivel que es la Hora; si el administrador irrumpe esta secuencia de cualquier otra manera, le dará un error y solicitará corregir la fecha. Esto sucederá tanto en el apartado de “Por fecha y hora" como en el de  “Por Sala”.
 
 

	Si el sistema descubre que no ha seleccionado ni el año le advertirá de los mismo.
 

	En el apartado de  “Por Sala” el sistema validará que al menos se ingrese una sala junto a un año, más no solo la sala.
 

		Prueba de éxito
 











14.	Por Película
Ahora la modalidad por Película, la cual indica el éxito de la misma independientemente de las fechas y salas, la información a desplegarse puede ser anual o mensual.
 


Funcionamiento

 






Validaciones y limitaciones
	El sistema obliga al administrador a seleccionar al menos un año.
 

	La selección del mes es escalable, necesita especificar un año primero antes de solo seleccionar el mes y cargar.
	El sistema controla el año y mes en la que ha estado disponible la película, de este modo no permite ingresar fechas al azar.
   

Prueba de éxito
 
15.	Ocupación de Salas
Ya se han visto las estadísticas de ventas, pero si el administrador desea ver la cantidad de asientos que han sido ocupados y las que no tiene esta función como su solución.

 



