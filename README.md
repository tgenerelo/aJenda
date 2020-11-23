# aJenda 1.0

## Descripción
aJenda (con J de Java) es una sencilla aplicación de almacenamiento de contactos realizada como práctica de clase. El programa posee almacenamiento para 10 contactos de los que 9 vienen ocupados por defecto directamente en el código.

## Funcionalidades
* La agenda organiza automáticamente los contactos para que siempre ocupen posiciones correlativas y no queden huecos vacíos entre contactos. Esta operación se realiza cada vez que se ejecuta el programa y cuando se elimina un contacto existente.
* No se permite crear un nuevo contacto cuando la lista está completa.
* La función de búsqueda es capaz de encontrar el término introducido tanto en el nombre del contacto como en el número de teléfono, sin necesidad de hacer dos búsquedas distintas.

## Menú
1. Ver contactos: Imprime la lista de todos los contactos guardados en memoria, precedidos por un número de ID.
2. Buscar un contacto: Permite encontrar contactos a partir de un término de búsqueda introducido por el usuario.
3. Añadir un contacto: Permite agregar un nuevo contacto, que se almacenará en la primera posición libre del listado.
4. Modificar un contacto: Permite modificar la información de un contacto existente introduciendo su ID de contacto.
5. Eliminar un contacto: Elimina un contacto introduciendo su ID y posteriormente reorganiza los contactos.
6. Salir: Sale del programa.
