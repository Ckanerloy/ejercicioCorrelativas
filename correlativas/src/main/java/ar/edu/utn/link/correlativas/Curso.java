package ar.edu.utn.link.correlativas;

import java.util.HashSet;
import java.util.Set;

public class Curso {

	private Materia materia;
	private boolean abierto;
	private int anio;
	private Set<Alumno> inscriptos;
	final int cantMinAlumnos = 5;

	public Curso(Materia materia, int anio) {
		this.materia = materia;
		this.anio = anio;
		this.inscriptos = new HashSet<>();
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Set<Alumno> getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(Set<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}

	public boolean estaInscripto(Alumno alumno) {
		return this.inscriptos.contains(alumno);
	}

	public void inscribir(Alumno alumno) {
		this.inscriptos.add(alumno);	
	}

	public void abrir() throws NoCumpleConLaCantidadMinimaExcepcion{
		if(inscriptos.size()<cantMinAlumnos) {
			throw new NoCumpleConLaCantidadMinimaExcepcion("El curso no cumple con la cantidad minima de alumnos");
		}else {
			this.setAbierto(true);
		}
	}


}
