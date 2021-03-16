package ftp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class AppFTP {

    public static void conectar(FTPClient clienteFTP) {

		try {
			clienteFTP.connect("localhost");
			
			System.out.println("Introduce nombre de usuario: ");
			String nombreUsuario = Leer.pedirCadena();
			
			System.out.println("Introduce tu contraseña: ");
			String contraUsuario = Leer.pedirCadena();
			
			if(clienteFTP.login(nombreUsuario, contraUsuario) == true) {
				System.out.println("********** LOGIN CORRECTO **********");
			}else {
				System.out.println("********** LOGIN INCORRECTO **********");
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void desconectar(FTPClient clienteFTP) {
		try {
			clienteFTP.logout();
			clienteFTP.disconnect();
			
			System.out.println("Se ha desconectado.");
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void listarFicheros(FTPClient clienteFTP) {
		try {
			FTPFile[] files = clienteFTP.listFiles();
			for (FTPFile file : files) {
	            String name = file.getName();	           	 
	            System.out.println(name);
	        }		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void guardarFicheros(FTPClient clienteFTP) {
		try {
			String texto = "Prueba, guardar";
			InputStream is = new ByteArrayInputStream(texto.getBytes(StandardCharsets.UTF_8));
			
			if(clienteFTP.storeFile("pruebaGuardar.txt", is)) {
				System.out.println(" ************** Fichero guardado correctamente **************");
			}else {
				System.out.println("Ha habido un problema al guardar el fichero");
			}		
			is.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void descargarFicheros(FTPClient clienteFTP) {
		try {
			System.out.println("Introduce el nombre del fichero que va a descargar: ");
			String nombreFichero = Leer.pedirCadena();
			
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("C:/Users/Alef/Documents/FTPFile/descargas/" + nombreFichero));
            if(clienteFTP.retrieveFile(nombreFichero, os)) {
            	System.out.println("************** Fichero descargado correctamente **************");
            }else {
            	System.out.println("Ha habido un problema al descargar el fichero");
            }
            os.close();		
        }catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarFichero(FTPClient clienteFTP) {
		try {
			System.out.println("Introduce el nombre del fichero que va a eliminar: ");
			String nombreFichero = Leer.pedirCadena();
			
			if(clienteFTP.deleteFile(nombreFichero)) {
				System.out.println("************** Fichero eliminado correctamente **************");
			}else {
				System.out.println("Ha habido un problema al eliminar el fichero");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarDirectorio(FTPClient clienteFTP) {
		try {
			System.out.println("Introduce el nombre del directorio que va a eliminar: ");
			String nombreDirectorio = Leer.pedirCadena();
			
			if(clienteFTP.removeDirectory(nombreDirectorio)) {
				System.out.println("************** Directorio eliminado correctamente **************");
			}else {
				System.out.println("Ha habido un problema al eliminar el directorio");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void crearDirectorio(FTPClient clienteFTP) {
		try {
			System.out.println("Introduce el nombre del directorio que va a crear:");
			String nombreDirectorio = Leer.pedirCadena();
			
			if(clienteFTP.makeDirectory("/" + nombreDirectorio)) {
				System.out.println("************** Directorio creado correctamente **************");
			} else {
				System.out.println("Ha habido un problema al crear el directorio");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void cambiarDirectorioActual(FTPClient clienteFTP) {
		try {
			System.out.println("Escriba el nombre del directorio que quiere ir."
					+ " Si escribe .. volverá al directorio anterior.");
			String nombreDirectorio = Leer.pedirCadena();
			
			if(nombreDirectorio == "..") {
				if(clienteFTP.changeWorkingDirectory(nombreDirectorio)) {
					System.out.println("************** Ha cambiado de directorio correctamente **************");
				}else {
					System.out.println("Ha habido un problema al cambiar de directorio");
				}
			} else {
				if(clienteFTP.changeWorkingDirectory("/" + nombreDirectorio)) {
					System.out.println("************** Ha cambiado de directorio correctamente **************");
				}else {
					System.out.println("Ha habido un problema al cambiar de directorio");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
