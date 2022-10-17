package utilidadesArchivos;

import java.io.File;
import java.io.IOException;

import modelo.Zapatilla;


public class GestorArchivos {

	public static void guardarFotoZapatilla(Zapatilla z, String rutaReal) {
		String nombreArchivo = z.getId() + ".jpg";
		String rutaSubidas = rutaReal + "/subidas";
		//si rutaSubidas no existe, crearla:
		File fileRutaSubidas = new File(rutaSubidas);
		if( ! fileRutaSubidas.exists() ) {
			fileRutaSubidas.mkdirs();
		}
		//si existe el archivo subido
		if(z.getFoto().getSize() > 0) {
			try {
				z.getFoto().transferTo(new File(rutaSubidas,nombreArchivo));
				System.out.println("archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("no pude mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("se subio un libro sin portada, no hay problema,"
					+ "de momento la imagen es opcional");
		}
	}
	
	public static void guardarFotoCajaZapatilla(Zapatilla z, String rutaReal) {
		String nombreArchivo = z.getId() + "-caja.jpg";
		String rutaSubidas = rutaReal + "/subidas";
		//si rutaSubidas no existe, crearla:
		File fileRutaSubidas = new File(rutaSubidas);
		if( ! fileRutaSubidas.exists() ) {
			fileRutaSubidas.mkdirs();
		}
		//si existe el archivo subido
		if(z.getFotoCaja().getSize() > 0) {
			try {
				z.getFotoCaja().transferTo(new File(rutaSubidas,nombreArchivo));
				System.out.println("archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("no pude mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
			System.out.println("se subio un libro sin portada, no hay problema,"
					+ "de momento la imagen es opcional");
		}
	}
	
}
