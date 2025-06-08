# Objetivo general

Diseñar una aplicación en Java que permita registrar, mostrar y gestionar productos, así como crear pedidos que involucren varios productos. El sistema deberá hacer uso de variables, operadores, colecciones (listas), POO (clases, objetos, encapsulamiento, herencia, polimorfismo), excepciones y organización de código en paquetes/módulos.

# Requisitos

## ✅Ingreso de productos

### El sistema debe permitir agregar productos con la siguiente información mínima:

- Nombre del producto (string, por ejemplo "Café Premium").
- Precio (double, puede tener decimales).
- Cantidad en Stock (int).

**Estos productos deben almacenarse en una colección (por ejemplo, ArrayList<Producto>).**

## ✅Visualización de productos

- Debe haber una funcionalidad que liste en pantalla todos los productos registrados, mostrando su ID (o posición), Nombre, Precio y Cantidad en Stock.
- El ID puede ser autogenerado (por ejemplo, un contador estático) o la posición en la lista.

## ✅Búsqueda y actualización de productos

- El sistema permitirá buscar un producto por su nombre o ID.
- Si se encuentra el producto, se mostrará su información completa.
- Opcionalmente, se podrá actualizar alguno de sus datos (precio o stock), validando que los valores sean coherentes (por ejemplo, que el stock no sea negativo).

## ✅Eliminación de productos

- El sistema debe permitir eliminar un producto de la lista, identificándolo por su ID o posición en la colección.
- Antes de eliminar, el sistema podría pedir confirmación (opcionales).

## 🟡 Creación de pedidos

- Además de manejar productos, se sugiere agregar la clase Pedido (o Orden) que contenga:
  - Una lista de productos asociados.
  - Cantidad deseada de cada producto (por ejemplo, usando un objeto intermedio LineaPedido o similar).
- El sistema debe permitir crear un pedido nuevo:
  - Solicitar al usuario qué productos desea y en qué cantidad (validar que haya suficiente stock).
  - Calcular el costo total (sumando precio \* cantidad de cada producto).
  - Disminuir el stock de cada producto si el pedido se confirma.
- Debe haber una funcionalidad para mostrar los pedidos realizados y su costo total, así como la lista de productos asociados.

## Menú principal interactivo

El programa presentará un menú con opciones, por ejemplo:

- Agregar producto
- Listar productos
- Buscar/Actualizar producto
- Eliminar producto
- Crear un pedido
- Listar pedidos (opcionales)
- Salir
  El menú se repetirá hasta que se elija la opción de Salir.

# Consideraciones

## Tipos de datos y variables

Emplear variables de tipo int (para cantidades e IDs), double (para precios), String (para nombres/descripciones), y boolean si fuera necesario.
Asegurate de usar operadores aritméticos, lógicos y relacionales en las funciones de cálculo y validación.

## Colecciones (Arrays, Listas)

Para manejar los productos, se sugiere un ArrayList<Producto>.
Para manejar los productos dentro de un pedido, podría usarse otra lista, por ejemplo ArrayList<LineaPedido>.
O bien, un Map<Integer, Integer> si querés asociar ID de producto con cantidad solicitada (detalles a tu elección).

## POO y Colaboración de Clases

- Clase Producto: con atributos id, nombre, precio, stock, getters y setters.
- Clase Pedido (u Orden): con atributos id, lista de productos/lineas, metodos para calcular total, etc.
- Clase Principal (Main): orquesta el menú, invoca métodos de servicios (por ejemplo, un ProductoService que encapsule la lógica de agregar/buscar/eliminar).

## Herencia/Polimorfismo (opcional, para extender)

Si deseás, podés crear subclases de Producto (por ejemplo, Bebida, Comida) con atributos específicos (fecha de vencimiento, volumen en litros, etc.).

Mostrar cómo el polimorfismo ayuda a tratar distintos productos de forma genérica.

## Excepciones

Manejar errores con try/catch. Por ejemplo, al convertir datos ingresados por la usuaria o usuario, podrías atrapar NumberFormatException si ingresa texto en lugar de un número.

Podrías crear una excepción personalizada como StockInsuficienteException y lanzarla cuando se intenta crear un pedido con cantidad mayor al stock disponible.

## Paquetes/módulos (organización de código)

Dividir las clases en paquetes lógicos:

- com.techlab.productos (para Producto, Bebida, etc.)
- com.techlab.pedidos (para Pedido, LineaPedido)
- com.techlab.excepciones (para excepciones personalizadas)
