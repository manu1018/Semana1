package logica;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

	private Cliente cliente;
	private Carrito carrito;
	private Producto p1;
	private Producto p2;
	

	@BeforeEach
	void setUp() {
		cliente = new Cliente("lucho", "112233");
		p1 = new Producto(20, "Mayonesa", "Light");
		p2 = new Producto(10, "Maní", "Salado");
		carrito = new Carrito(cliente);
	}

	// Alta Producto [TEST]
	@Test
	public void testAgregarProducto() {
		carrito.agregarProducto(p1, 5);
		carrito.agregarProducto(p1, 3);
		int cantidadEsperada = 3;
		int x = carrito.obtenerCantidad(p1, p1.getNombre());
		assertTrue(cantidadEsperada == x);
	}

	@Test
	public void testAgregarProductoNulo() {
		carrito.agregarProducto(null, 1);
		int cantidadEsperada = -0;
		int x = carrito.obtenerCantidad(null, "");
		assertTrue(cantidadEsperada == x);
	}
	
	// Disminuir Producto [TEST]
	@Test
	public void testDisminuirProducto() {
		carrito.agregarProducto(p1, 5);
		carrito.disminuirProducto(p1, 3);
		int cantEsperada = 2;
		int x = carrito.obtenerCantidad(p1, p1.getNombre());
		assertTrue(cantEsperada==x);
	}

	@Test
	public void testDisminuirProductoResta() {
		carrito.agregarProducto(p1, 5);
		carrito.disminuirProducto(p1, 6);
		int cantEsperada = 0;
		int x = carrito.obtenerCantidad(p1, p1.getNombre());
		assertTrue(cantEsperada==x);
	}
	
	// Obtener Precio Total [TEST]
	@Test
	public void testObtenerPrecioTotal() {
		carrito.agregarProducto(p2, 3); // 10 * 3
		carrito.agregarProducto(p1, 2); // 20 * 2
		double totalEsperado = 30 + 40;
		double total = carrito.obtenerPrecioTotal();
		assertTrue(total == totalEsperado);
	}

	@Test
	public void testPrecioTotal() {
		carrito.agregarProducto(p1, 2); // 20 * 2
		double totalEsperado = 40.0;
		double total = carrito.obtenerPrecioTotal();
		assertTrue(total == totalEsperado);
	}
	
	
	// Obtener Cantidad [TEST]
	@Test
	public void testObtenerCantidad() {
		int cantidad = 2;
		carrito.agregarProducto(p1, cantidad);
		int x = carrito.obtenerCantidad(p1, p1.getNombre());
		assertTrue(x == cantidad);
	}

	@Test
	public void testObtenerCantidadNula() {
		int resultado = 0;
		int x = carrito.obtenerCantidad(null, "No existe el producto");
		assertTrue(x == resultado);
	}
	
}
