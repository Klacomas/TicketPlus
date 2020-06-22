package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Cliente extends Persona {
	
	protected LocalDate fechaNacimiento;

	public Cliente(String rut, String nombre, LocalDate fechaNacimiento) {
		super(rut, nombre);
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public static int calcularEdad(LocalDate fechaNacimiento2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
