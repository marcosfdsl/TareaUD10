package casopractico;

import java.util.*;

public class SupermercadoMain {
	
	static Scanner sc = new Scanner(System.in);
	static int num;
	static String respuesta1;
	static String respuesta2 = "";
	static String cestaString = "";
	static String productoConsultar;
	static String productoCambiar;
	static String[] cestaArray;
	static TreeSet<String> cestaSi = new TreeSet<>();
	static TreeSet<String> cestaNo = new TreeSet<>();
	static TreeSet<String> productos = new TreeSet<>();

	public static void main(String[] args) {
		
		rellenarStock();
		
		invocarSwitch();
		
		System.out.println("¡Hasta pronto!");
		
		sc.close();

	}
	
	public static void rellenarStock () {
		
		productos.add("tomate");
		productos.add("aceite");
		productos.add("pan");
		productos.add("leche");
		productos.add("yogur");
		productos.add("queso");
		productos.add("jamón");
		productos.add("harina");
		productos.add("champú");
		productos.add("manzana");
	}
	
	public static void invocarSwitch () {
		
		do {
			mostrarMenu();
			num = sc.nextInt();
			
			while (!(num==1)&&!(num==2)&&!(num==3)&&!(num==4)&&!(num==5)&&!(num==6)) {
				System.out.println("No le he entendido, escriba un número entre el 1 y el 6");
				num = sc.nextInt();
			}
			
			switch (num) {

			case 1:
				System.out.println("Productos: " + productos);
				opcionesMenu();
				break;

			case 2:
				opcion2A();
				opcionesMenu();
				break;

			case 3:
				opcion3();				
				opcionesMenu();
				break;

			case 4:
				opcion4();
				opcionesMenu();
				break;
				
			
			case 5:
				opcion5();
				opcionesMenu();
				break;

			case 6:
				respuesta1 = "";
				break;
			}
		}
		
		while (respuesta1.equals("si"));
	}
	
	public static void mostrarMenu () {
		
		System.out.println("-----------------MENÚ-----------------");
		System.out.println("1. Mostrar productos del supermercado");
		System.out.println("2. Añadir productos al carrito");
		System.out.println("3. Mostrar carrito de la compra ordenado");
		System.out.println("4. Consultar producto de carrito");
		System.out.println("5. Cambiar un producto por otro");
		System.out.println("6. Salir");
		System.out.println("--------------------------------------");
	}
	
	public static String opcionesMenu () {
		
		System.out.println("\n¿Desea elegir otra opción de MENÚ? (si/no)");
		respuesta1 = sc.nextLine();
		if (respuesta1.isEmpty()) {
			respuesta1 = sc.nextLine();
		}
		
		while (!(respuesta1.equals("si"))&&!(respuesta1.equals("no"))) {
			System.out.println("No le he entendido, ¿desea elegir otro producto? (si/no)");
			respuesta1 = sc.nextLine();
		}
		
		return respuesta1;
	}

	public static void opcion2A () {
		
		opcion2B();

		while (!(cestaNo.isEmpty())) {
			
			System.out.println("Los productos " + cestaNo + " no están disponibles. ¿Desea elegir otro producto? (si/no)");
			cestaNo.clear();
			respuesta2 = sc.nextLine();

			while (!(respuesta2.equals("si"))&&!(respuesta2.equals("no"))) {
				System.out.println("No le he entendido, ¿desea elegir otro producto? (si/no)");
				respuesta2 = sc.nextLine();
			}
			
			if (respuesta2.equals("si")) {
				opcion2B();
			}
		}
	}
	
	public static void opcion2B () {
		
		System.out.println("Escriba sus productos separados por espacios y sin comas:");
		cestaString = sc.nextLine();
		if (cestaString.isEmpty()) {
			cestaString = sc.nextLine();
		}
		cestaArray = cestaString.split(" ");

		for (int i = 0; i < cestaArray.length; i++) {
			
			if (productos.contains(cestaArray[i])) {
				if (cestaSi.contains(cestaArray[i])) {
					System.out.println("Su cesta ya contiene el producto " + cestaArray[i]);
				}
				else {
					cestaSi.add(cestaArray[i]);
				}
			}
			
			else if (!(productos.contains(cestaArray[i]))) {
				cestaNo.add(cestaArray[i]);
			}
		}
	}
	
	public static void opcion3 () {
		
		if (!(cestaString.isEmpty())) {
			System.out.println("Su carrito contiene los siguientes productos: " + cestaSi);
		}
		
		else if (cestaString.isEmpty()) {
			System.out.println("Su carrito está vacío");
		}
	}
	
	public static void opcion4 () {
		
		System.out.println("Escriba el producto que quiere consultar:");
		productoConsultar = sc.nextLine();
		if (productoConsultar.isEmpty()) {
			productoConsultar = sc.nextLine();
		}

		if (cestaSi.contains(productoConsultar)) {
			System.out.println("Su cesta contiene el producto " + productoConsultar);
		}
		
		else {
			System.out.println("Su cesta no contiene el producto " + productoConsultar);
		}
	}
	
	public static void opcion5 () {
		
		if (cestaString.isEmpty()) {
			System.out.println("Su carrito está vacío");
		}
		
		else {
			System.out.println("Escriba el producto que quiere cambiar:");
			productoCambiar = sc.nextLine();
			if (productoCambiar.isEmpty()) {
				productoCambiar = sc.nextLine();
			}
			
			while (!(cestaSi.contains(productoCambiar))) {
				System.out.println("El producto especificado no se encuentra en su cesta, ¿desea volver a escribirlo? (si/no)");
				
				respuesta2 = sc.nextLine();
				
				while (!(respuesta2.equals("si"))&&!(respuesta2.equals("no"))) {
					System.out.println("No le he entendido, ¿desea volver a escribirlo? (si/no)");
					respuesta2 = sc.nextLine();
				}
				
				if (respuesta2.equals("si")) {
					System.out.println("Escriba el producto que quiere cambiar:");
					productoCambiar = sc.nextLine();
					if (productoCambiar.isEmpty()) {
						productoCambiar = sc.nextLine();
					}
				}
				
				else if (respuesta2.equals("no")) {
					return;
				}
			}
			
			cestaSi.remove(productoCambiar);
			
			System.out.println("Escriba el producto por el cual lo quiere cambiar:");
			productoCambiar = sc.nextLine();
			if (productoCambiar.isEmpty()) {
				productoCambiar = sc.nextLine();
			}
			
			while (!(productos.contains(productoCambiar))) {
				System.out.println("El producto especificado no se encuentra disponible, ¿desea volver a escribirlo? (si/no)");
				
				respuesta2 = sc.nextLine();
				
				while (!(respuesta2.equals("si"))&&!(respuesta2.equals("no"))) {
					System.out.println("No le he entendido, ¿desea volver a escribirlo? (si/no)");
					respuesta2 = sc.nextLine();
				}
				
				if (respuesta2.equals("si")) {
					System.out.println("Escriba el producto por el cual lo quiere cambiar:");
					productoCambiar = sc.nextLine();
					if (productoCambiar.isEmpty()) {
						productoCambiar = sc.nextLine();
					}
				}
				
				else if (respuesta2.equals("no")) {
					
					return;
				}
			}
			
			cestaSi.add(productoCambiar);
			
			System.out.println("El producto fue cambiado con éxito");
			}
	}
	
}
