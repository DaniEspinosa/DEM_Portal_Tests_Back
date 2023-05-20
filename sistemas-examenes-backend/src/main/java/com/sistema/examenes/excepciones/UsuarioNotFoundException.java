package com.sistema.examenes.excepciones;

public class UsuarioNotFoundException extends Exception {

	public UsuarioNotFoundException() {
		super("Este usuario no existe en la base de datos");
	}
	
	public UsuarioNotFoundException(String mensaje) {
		super(mensaje);
	}
}
