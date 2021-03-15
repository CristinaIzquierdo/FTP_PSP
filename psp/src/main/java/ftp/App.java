package ftp;

import org.apache.commons.net.ftp.FTPClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    FTPClient clienteFTP = new FTPClient();		
		int opcion;
		do {
			opcion = menu();	
			switch (opcion) {
			case 1: AppFTP.conectar(clienteFTP);
				break;
			case 2: AppFTP.desconectar(clienteFTP);
				break;
			case 3: AppFTP.listarFicheros(clienteFTP);
				break;
			case 4: AppFTP.guardarFicheros(clienteFTP);
				break;
			case 5: AppFTP.descargarFicheros(clienteFTP);
				break;
			case 6: AppFTP.eliminarFichero(clienteFTP);
				break;
			case 7: AppFTP.eliminarDirectorio(clienteFTP);
				break;
			case 8: AppFTP.crearDirectorio(clienteFTP);
				break;
			case 9: AppFTP.cambiarDirectorioActual(clienteFTP);
			break;
			} 
		}while(opcion != 0);
		
					
	}//FIN main
	
	public static int menu() {
		System.out.println("Elige una de las siguientes opciones, para salir pulse 0.");
		System.out.println("1- Iniciar sesión.");
		System.out.println("2- Cerrar sesión.");
		System.out.println("3- Listar ficheros y directorios.");
		System.out.println("4- Subir fichero.");
		System.out.println("5- Descargar fichero del servidor.");
		System.out.println("6- Eliminar fichero.");
		System.out.println("7- Eliminar directorio.");
		System.out.println("8- Crear directorio.");
		System.out.println("9- Cambiar directorio actual.");
		int opcion = Leer.pedirEnteroValidar();		
		
		return opcion;
	}
}
