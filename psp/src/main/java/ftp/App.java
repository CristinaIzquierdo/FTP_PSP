package ftp;

import org.apache.commons.net.ftp.FTPClient;

public class App 
{
    public static void main( String[] args ){
	    
    FTPClient clienteFTP = new FTPClient();	
	    
		int opcion;
		do {
			opcion = imprimirMenu();	
			switch (opcion) {
			case 1: AppFTP.conectar(clienteFTP);
				break;
			case 2: AppFTP.listarFicheros(clienteFTP);
				break;
			case 3: AppFTP.guardarFicheros(clienteFTP);
				break;
			case 4: AppFTP.descargarFicheros(clienteFTP);
				break;
			case 5: AppFTP.eliminarFichero(clienteFTP);
				break;
			case 6: AppFTP.eliminarDirectorio(clienteFTP);
				break;
			case 7: AppFTP.crearDirectorio(clienteFTP);
				break;
			case 8: AppFTP.cambiarDirectorioActual(clienteFTP);
				break;
			case 9: AppFTP.desconectar(clienteFTP);
			
			} 
		}while(opcion != 0);					
	}
	
	public static int imprimirMenu() {
		System.out.println(" *******************************");
		System.out.println("***************** MENÚ ******************");
		System.out.println(" *******************************");
		System.out.println("1- Iniciar sesión.");
		System.out.println("2- Listar ficheros y directorios.");
		System.out.println("3- Subir fichero.");
		System.out.println("4- Descargar fichero del servidor.");
		System.out.println("5- Eliminar fichero.");
		System.out.println("6- Eliminar directorio.");
		System.out.println("7- Crear directorio.");
		System.out.println("8- Cambiar directorio actual.");
		System.out.println("9- Cerrar sesión.");
		System.out.println("0- Salir.");
		int opcion = Leer.pedirEnteroValidar();		
		
		return opcion;
	}
}
