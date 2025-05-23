
# Preguntes Teòriques

## Afegiu un endpoint que cerqui per un camp de tipus String on feu servir regex. Afegiu el que calgui al servei, repositori, etc.

Añadido en el Controller.

## Què caracteritza una api reactiva com aquesta i què la fa diferent d’una api síncrona amb MVC com les treballades anteriorment?

Una API reactiva se caracteriza por:

- El uso de WebFlux y reactor-core (Mono y Flux) para manejar operaciones asincrónicas y no bloqueantes, lo que mejora la escalabilidad.

- Utiliza un modelo de programación reactiva, que maneja flujos de datos de manera asíncrona, permitiendo que la aplicación sea mucho más eficiente cuando hay múltiples operaciones concurrentes (por ejemplo, múltiples peticiones a la base de datos).

- Mono y Flux son tipos que representan operaciones asíncronas de un solo valor o múltiples valores, respectivamente.

La principal diferencia respecto a una API síncrona con MVC es que en una API reactiva, las operaciones no bloquean el hilo principal, lo que permite manejar mejor las altas cargas de usuarios y mejorar el rendimiento. En MVC, cada solicitud bloquea un hilo hasta que se obtiene la respuesta, lo que no es tan eficiente para aplicaciones que requieren manejar múltiples usuarios simultáneamente.

## Què signifiquen Mono i Flux? Per a què penseu que serveixen i per què són útils en aquest tipus de programació?

- Mono: Representa una operación que produce un único valor o ningún valor (vacío). Se utiliza para operaciones que retornan un solo resultado, como una consulta a la base de datos para obtener un solo documento.

- Flux: Representa una operación que puede retornar varios valores o ninguno. Se utiliza cuando se espera un flujo de datos, como una lista de elementos obtenidos de una base de datos.

Estos son útiles en la programación reactiva porque permiten realizar operaciones no bloqueantes, lo que mejora el rendimiento de las aplicaciones al permitir que el servidor maneje múltiples operaciones simultáneamente sin tener que esperar a que cada una termine antes de comenzar la siguiente.

## Què és record? Un record utilitza getters i setters? Justifiqueu la resposta

Un record en Java es un tipo especial de clase introducido en Java 14 que se usa principalmente para representar datos inmutables. Los records automáticamente generan un constructor, los getters y toString, equals, y hashCode según los campos definidos.

En cuanto a getters y setters:

- Un record no utiliza setters, ya que es inmutable. Los valores de los campos se establecen una sola vez a través del constructor, y no pueden modificarse después.

- Getters sí están presentes, pero no es necesario escribirlos manualmente, ya que son generados automáticamente con el mismo nombre del campo (por ejemplo, si tienes un campo id, el getter será id()).

Por lo tanto, los records no usan setters porque no permiten modificaciones después de la creación del objeto, y los getters están implícitamente disponibles para acceder a los campos.