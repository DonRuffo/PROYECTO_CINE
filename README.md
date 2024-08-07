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
![image](https://github.com/user-attachments/assets/13ea5337-8213-4c6b-963d-ef9c2ef377c0)




Funcionamiento

![image](https://github.com/user-attachments/assets/41e5d958-defb-4ca3-bc75-f96174a0012c)

 

Al accionar el botón “Iniciar Sesión” el sistema hará una conexión con la base de datos y permitirá al cliente  o administrador  navegar  y usar el sistema.


Validaciones y límites
	El usuario debe llenar obligatoriamente todos los campos para la verificación de su identidad.

 ![image](https://github.com/user-attachments/assets/c7856a65-a0b8-41f1-aed4-42b917880471)



	Si el usuario ingresa sus credenciales incorrectamente, el sistema lo alertará.

 ![image](https://github.com/user-attachments/assets/d81d0e18-3c26-4536-abbd-e9b64fbec31b)




2.	Gestión como Administrador
Dentro de las funcionalidades para este apartado se encuentran: Gestión de Películas,, Gestión de Clientes,  Estadísticas y el cierre de sesión

 ![image](https://github.com/user-attachments/assets/97b94d27-ee37-4990-8c05-9ad2855b0d8b)



Funcionamiento

 ![image](https://github.com/user-attachments/assets/6299ae7a-9904-418e-9c9f-c36e1cdf6d9b)








3.	Gestionar Películas
Este Jframe cuenta con las funcionalidades necesarias para un manejo completo de las películas que se encuentran actualmente en una cartelera

 ![image](https://github.com/user-attachments/assets/e9879de8-bd0e-4d35-9581-f79c7de302ff)


Funcionamiento

 ![image](https://github.com/user-attachments/assets/a8e8e16e-b768-4f10-a4fd-5ebba3326691)




4.	Agregar Película
El administrador puede agregar una nueva película a la cartelera del cine mediante este frame, que incluye inputs para detallar el título, categoría, fecha, hora, sala, restricción de edad y precio por asiento que tendrá el film.

 ![image](https://github.com/user-attachments/assets/baf7c432-74f1-4b9b-98f2-2250f2007222)


Funcionamiento

 ![image](https://github.com/user-attachments/assets/93b34ee9-42e2-4eb8-9776-d1c9ccf137c1)





Validaciones y limitaciones
	Todos los campos deben ser llenados.

 ![image](https://github.com/user-attachments/assets/f2b58cbf-3241-4c21-a7f8-53cbed6a6fc9)



	El sistema no permitirá agregar una película si el campo de “Categoría” contiene números o sí el precio del asiento contiene algún carácter distinto a un número.

 ![image](https://github.com/user-attachments/assets/c0384e4b-38c8-4601-830b-dcf3090e039b)




	Para la restricción de edad se cuenta con únicamente 3 opciones: Familiar, +15 y +18 que identifican a el público que puede observar la película.
	Los campos “Año”, “Mes” y “Día” definirán la fecha para la función, dependiendo del mes elegido habrá una corrección en la cantidad de días que puede escoger. Ejemplo: Si elije el mes “02” tendrá opción a elegir hasta 28 días, puesto que el mes “02” identifica al mes de febrero; si elige el mes “12”, 31 días y si elije el mes “11” tendrá 30 días.

 ![image](https://github.com/user-attachments/assets/1c1efd17-0316-4ba6-b3c6-fe58454ab6a5)
 ![image](https://github.com/user-attachments/assets/0d612397-07de-46a7-b04b-65e9b1f3d8fe)


 




	El sistema identifica si el año seleccionado es bisiesto o no, controlando así el número de días para febrero. Por ejemplo: 2024 es bisiesto, por ende febrero cuenta con 29 días.

 ![image](https://github.com/user-attachments/assets/ed916256-06f9-49c8-ba6b-57efd412d3dc)



	El sistema no permite agregar una película en un horario que ya se encuentra ocupado por otra, si se intenta realizar esta acción se alertará al administrador y solicitará el cambio de horario.

 ![image](https://github.com/user-attachments/assets/e399789d-91b5-4b68-8781-e6b55a3a9a47)



	Para el campo “Sala” el administrador tiene disponibles 10 salas, no más.

![image](https://github.com/user-attachments/assets/708c5592-97f3-4837-87e7-dc783be54ed1)

 
	Existen únicamente cuatro horas disponibles para las funciones: 12:00, 15:00, 18:00, 21:00

 ![image](https://github.com/user-attachments/assets/231ccfdb-9523-4848-927e-5a89ce23baef)


Prueba de éxito

![image](https://github.com/user-attachments/assets/892142d3-987e-49bd-a95f-976879f015ea)

 
NOTA: las cuatro horas, la restricción de edad y la categoría indicada previamente son inmutables a lo largo de este sistema. No existen cambios de estos datos. 




5.	Cambiar horarios

Esta función permite a los administradores mover horarios y salas, en dónde el sistema pide seleccionar una película y el horario actual para luego seleccionar el nuevo.

 ![image](https://github.com/user-attachments/assets/756c41e3-d6cb-45d5-9932-7d6807ad80f6)





Funcionamiento

![image](https://github.com/user-attachments/assets/26c01b13-faa1-45be-96c0-be3397b2bd30)

 



Validaciones y limitaciones

	El sistema solo mostrará los horarios que cada película tiene actualmente, de esta manera se controla elegir un horario y sala que no tiene ninguna relación con el título


![image](https://github.com/user-attachments/assets/4fff548b-7863-49cd-a8bd-49445c6d0210)
![image](https://github.com/user-attachments/assets/e04df09f-1266-49dd-9639-e955a5914341)
![image](https://github.com/user-attachments/assets/34110032-c080-4012-b68a-55f6f7cc0b6f)



     


	El sistema solicitará que se llenen todos los campos de manera obligatoria, tanto en el horario actual de la película como en el nuevo.

 ![image](https://github.com/user-attachments/assets/09fd8fa1-2cb6-4f1f-9569-1a6ad44c35cc)










	El sistema validará el nuevo horario designado con el resto de películas que se encuentran en la cartelera, si coincide con un horario que ya está ocupado, se le alertará al usuario para elegir otro horario.

 ![image](https://github.com/user-attachments/assets/3bd0a58f-a7a4-4f84-9f97-fc6ad220b220)



	Al igual que el frame anterior (AgregarPelicula) el año, mes y día están controlados según la selección.

     ![image](https://github.com/user-attachments/assets/1bf9ea18-414d-4321-8c43-f476d25406e3)
     ![image](https://github.com/user-attachments/assets/ee15525d-da46-403f-aa81-b7bea72c6734)
     ![image](https://github.com/user-attachments/assets/b93c6c49-d0e5-461f-b4a4-30c4d23338d6)






	Si la pelicula ya resgistra reservas de los clientes, no se le permitirá modificar el horario

 ![image](https://github.com/user-attachments/assets/2841e727-7d9d-4d9f-9271-fbdb742b3f58)



	Prueba de éxito
 
 ![image](https://github.com/user-attachments/assets/5c95ebe1-d82d-4a78-b518-ef5796585f31)



6.	Eliminar Película
Para completar la gestión de las películas, fue implementada la función de eliminar una película de cartelera. Además, el sistema brinda dos maneras de eliminar un titulo: especificando horario y sala de la función o eliminar todas las funciones de una película.

 ![image](https://github.com/user-attachments/assets/089927f3-c0ca-4134-8493-274b46562ef0)



Funcionamiento

 ![image](https://github.com/user-attachments/assets/b08f2545-6a5f-4ba2-a51f-35f0e70b9cef)




Validaciones y limitaciones
	Como primera opción, el sistema ofrece eliminar una película del cine definitivamente, pero si el administrador desea eliminar la película de un horario y sala en específico, podrá seleccionar el JCheckBox para desplegar nuevos campos de control.

![image](https://github.com/user-attachments/assets/e0481244-cb61-4f3c-8e50-1a62524b5b9a)

 


	En este frame también se controla la disponibilidad de horarios  que tiene cada película en base a su fecha, sala y hora.

![image](https://github.com/user-attachments/assets/fe3eafe2-be86-43c6-8295-071690791800)
![image](https://github.com/user-attachments/assets/f4e3bad9-1355-468f-bf3d-e337a5d54ffa)
![image](https://github.com/user-attachments/assets/ed5d9664-4bad-4c20-b382-21d55688f25b)



     


	El sistema obliga al administrador a seleccionar todos los campos

![image](https://github.com/user-attachments/assets/a2acd60f-29f7-42c6-a90d-0422e6acf04f)

 
Prueba de éxito con Eliminar por Horario y Sala

 ![image](https://github.com/user-attachments/assets/64b5c867-f5e9-45a9-adbb-f6bd5714853b)




Prueba de éxito sin Eliminar por Horario y Sala

 ![image](https://github.com/user-attachments/assets/cc279f2f-5480-4cf0-af16-9165c560bb50)






7.	Gestionar Clientes
Una vez finalizada la gestión de películas, la concentración obtiene un enfoque sobre los clientes y las acciones que se puede realizar sobre ellos, como agregar un cliente, ver clientes y eliminar un cliente.

 ![image](https://github.com/user-attachments/assets/227863fb-26a0-4dc9-b7f0-9b2cdf3e9982)



Funcionamiento

![image](https://github.com/user-attachments/assets/19feb4cb-558a-4cf8-a248-df217ac0d040)

 







8.	Agregar Cliente
El administrador puede registrar la información de un cliente detallando: cédula, nombre, edad, teléfono, dirección, contraseña y confirmar contraseña.

 ![image](https://github.com/user-attachments/assets/7ec7a7c4-febc-4f4c-9e0f-203b7ad6402e)



Funcionamiento

![image](https://github.com/user-attachments/assets/f247bb48-829c-4f6a-960c-653c03c5e30b)

 








Validaciones y limitaciones
	El sistema no permitirá el registro si existen caracteres alfabéticos en los campos cedula y teléfono.

![image](https://github.com/user-attachments/assets/29fb3bb4-b6e1-41a0-8a32-88f826246e2b)

 



	El sistema obliga al administrador a llenar todos los campos

![image](https://github.com/user-attachments/assets/a8a6211f-4ae8-45a8-af20-eb7381754ea2)

 


	Valida las contraseñas y devuelve un error si no coinciden

 ![image](https://github.com/user-attachments/assets/d4b0d4ea-14ee-4641-83f9-bbbca7fb489b)



	El sistema permite ingresar la edad en un rango de 18 a 100 años

![image](https://github.com/user-attachments/assets/a37eed83-f463-4b1d-9d45-1806440df584)

 


	El sistema no permite registrar un cliente si el campo Nombre contiene números

![image](https://github.com/user-attachments/assets/952cf8e3-ff7e-4f7f-9484-339adc6c587b)

 
	El sistema valida que en los campos teléfono y cedula tengan exactamente 10 dígitos.

![image](https://github.com/user-attachments/assets/d72d54d5-58eb-452a-b80a-beab1048d76c)

 



Prueba de éxito

 ![image](https://github.com/user-attachments/assets/297d180c-c943-4ce8-bff7-de8dbb19c074)











9.	Ver Clientes
Un administrador debe poder ver la información de los clientes que se encuentran registrados en el sistema, incluso para poder eliminarlo después.
Este frame muestra todos los datos de cada cliente en un JTable, todo menos las contraseñas por supuesto.

![image](https://github.com/user-attachments/assets/4d0ba9b4-7468-434f-a778-dcc384dd72b2)

 





Funcionamiento

 ![image](https://github.com/user-attachments/assets/5099b850-651b-4e01-988f-aad0359fdddb)


10.	Eliminar Cliente
Completando la gestión de los clientes, damos paso a la función de eliminar uno, teniendo como llave la cédula del cliente a eliminar.

 ![image](https://github.com/user-attachments/assets/5c0eacd1-9902-492d-aeb4-2ae204c3a683)






Funcionamiento

![image](https://github.com/user-attachments/assets/a39e93bf-8e8d-4d44-b024-d9b5322ba531)

 




Validaciones y limitaciones
	La cedula ingresada debe contra con al menos 10 dígitos y el sistema validará que no existan caracteres alfabéticos.

 ![image](https://github.com/user-attachments/assets/60fcfc55-652e-4ae2-a636-8debabfd65c7)
 ![image](https://github.com/user-attachments/assets/aa2b51dc-f39e-4286-86a1-91af93f004e3)


 


	Si el sistema no encuentra al cliente con la cédula ingresada, devolverá un mensaje indicando que no existe dicho cliente

![image](https://github.com/user-attachments/assets/85ae0141-24e7-4e4c-ba62-5c43cb757570)

 
	Al presionar el botón Ver se podrá ver a información del cliente seleccionado y además activará el botón eliminar.

 ![image](https://github.com/user-attachments/assets/a031d300-b73d-4235-b33e-64ad8d3b2094)




Prueba de éxito

![image](https://github.com/user-attachments/assets/50e7187e-b433-45f6-abbd-2b316d4c7608)

 











11.	Estadísticas
Ahora se procede a implementar la función de estadísticas, donde el administrador podrá visualizar los datos financieros y de ocupación que tiene el cine.

 ![image](https://github.com/user-attachments/assets/d439b5fb-c5bd-4b78-87a9-f0ef63a4074d)



Funcionamiento

![image](https://github.com/user-attachments/assets/95d74427-ac27-4a26-8163-8fa7128aade3)

 









12.	Ventas
El administrador podrá ver las ventas del cine de dos maneras: por fecha y función o por película.

![image](https://github.com/user-attachments/assets/1909d918-e118-4966-a150-4b0dd96c27b1)

 



Funcionamiento

![image](https://github.com/user-attachments/assets/57d48707-8048-4b24-af52-3b7cfefa9f56)

 






13.	Por fecha y función
Con esta modalidad, el administrador puede navegar entre las estadísticas únicamente por fechas (anualmente, mensualmente, diariamente y en función específica.) y por salas.

 ![image](https://github.com/user-attachments/assets/05535ac9-3b4d-47c7-899d-aee4332ca492)



Funcionamiento

![image](https://github.com/user-attachments/assets/b18bf919-f00f-4fd5-a680-21364544796f)

 



Validaciones y limitaciones
	El sistema de fechas es escalable a partir del año, puede solo seleccionar el año y visualizar estadísticas anuales, o aumentar a esa selección un mes para ver la información mensual, y así hasta llegar al más ato nivel que es la Hora; si el administrador irrumpe esta secuencia de cualquier otra manera, le dará un error y solicitará corregir la fecha. Esto sucederá tanto en el apartado de “Por fecha y hora" como en el de  “Por Sala”.

![image](https://github.com/user-attachments/assets/ef0868d0-916d-4ccc-b239-107c7814c7b7)
![image](https://github.com/user-attachments/assets/1ee30acf-b7f9-40ff-824c-c414d6f2e63f)

 

	Si el sistema descubre que no ha seleccionado ni el año le advertirá de los mismo.

 ![image](https://github.com/user-attachments/assets/b217dc56-61ad-4729-a59e-4724385dc61c)


	En el apartado de  “Por Sala” el sistema validará que al menos se ingrese una sala junto a un año, más no solo la sala.

 ![image](https://github.com/user-attachments/assets/7e8b9907-cee0-4ea0-b7aa-e0284d6246ac)


		Prueba de éxito
  
 ![image](https://github.com/user-attachments/assets/68a71a71-e948-4382-a1f7-30e0ff841077)












14.	Por Película
Ahora la modalidad por Película, la cual indica el éxito de la misma independientemente de las fechas y salas, la información a desplegarse puede ser anual o mensual.

 ![image](https://github.com/user-attachments/assets/2549fcc5-c349-48cf-8fd3-ae25dd9d0ca3)



Funcionamiento

![image](https://github.com/user-attachments/assets/cf246d25-4fa7-4597-b0ad-4ff89fc53e21)

 






Validaciones y limitaciones
	El sistema obliga al administrador a seleccionar al menos un año.

 ![image](https://github.com/user-attachments/assets/ba0e9ab1-cf62-4cd2-b850-f2ea0a2d1c2a)


	La selección del mes es escalable, necesita especificar un año primero antes de solo seleccionar el mes y cargar.
	El sistema controla el año y mes en la que ha estado disponible la película, de este modo no permite ingresar fechas al azar.

   ![image](https://github.com/user-attachments/assets/282b53fa-11f3-4ddb-9fed-22f5c1bee362)
   ![image](https://github.com/user-attachments/assets/e897c02d-c428-492d-bd77-d0e1aa2e64e0)



Prueba de éxito

![image](https://github.com/user-attachments/assets/0d95d088-2fd6-42f2-8fb1-2e8b83b5927e)

 
15.	Ocupación de Salas
Ya se han visto las estadísticas de ventas, pero si el administrador desea ver la cantidad de asientos que han sido ocupados y las que no tiene esta función como su solución.

![image](https://github.com/user-attachments/assets/b4a4092a-3cd8-4e5b-a5e4-38ea8f52dc97)

 



