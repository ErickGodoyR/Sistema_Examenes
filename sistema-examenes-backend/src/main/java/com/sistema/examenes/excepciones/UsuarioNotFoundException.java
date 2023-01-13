package com.sistema.examenes.excepciones;

public class UsuarioNotFoundException extends Exception {

	public UsuarioNotFoundException() {
		super("No existe usuario con username ingresado, ingrese otro username");
	}
	
	public UsuarioNotFoundException(String mensaje) {
		super(mensaje);
	}
	
}
