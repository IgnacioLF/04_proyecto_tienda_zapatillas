package utilidadesArchivos;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import modelo.Usuario;
import modelo.Zapatilla;


public class GestorArchivos {
	
	public static boolean borrarImagenesZapatilla(String idZapatilla, String rutaRealDelProyecto) {
		File f = new File(rutaRealDelProyecto+"\\subidas\\"+idZapatilla+".png");
		File f2 = new File(rutaRealDelProyecto+"\\subidas\\"+idZapatilla+"-caja.png");
		if(f.delete() && f2.delete()) {
			System.out.println("archivo borrado correctamente");
			return true;
		}else {
			System.out.println("no se pudo borrar el archivo");
			return false;
		}
	}

	public static void guardarFotoZapatilla(Zapatilla z, String rutaReal) {
		String nombreArchivo = z.getId() + ".png";
		String rutaSubidas = rutaReal + "\\subidas";
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
		String nombreArchivo = z.getId() + "-caja.png";
		String rutaSubidas = rutaReal + "\\subidas";
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
	
	public static void guardarFotoUsuario(Usuario u, CommonsMultipartFile foto, String rutaRealDelProyecto) {
		String nombreArchivo = "u" + u.getId() + ".png";
		String rutaSubidas = rutaRealDelProyecto + "/subidas";
		//si rutaSubidas no existe, crearla:
		File fileRutaSubidas = new File(rutaSubidas);
		if( ! fileRutaSubidas.exists() ) {
			fileRutaSubidas.mkdirs();
		}
		//si existe el archivo subido
		if(foto.getSize() > 0) {
			try {
				foto.transferTo(new File(rutaSubidas,nombreArchivo));
				System.out.println("archivo movido a: " + rutaSubidas);
			} catch (IllegalStateException | IOException e) {
				System.out.println("no pude mover el archivo a la ruta de subidas");
				e.printStackTrace();
			}
		}else {
		}
	}//end guardarFotoUsuario
	
	
}
