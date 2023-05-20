package com.sistema.examenes.excepciones;

public class UsuarioFoundException extends Exception {

	public UsuarioFoundException() {
		super("Este usuario ya existe, pruebe otro nombre de usuario");
	}
	
	public UsuarioFoundException(String mensaje) {
		super(mensaje);
	}
}
