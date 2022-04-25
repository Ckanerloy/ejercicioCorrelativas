package ar.edu.utn.link.correlativas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Alumno {

	private String nombre;
	private List<Curso> cursos;
	private Collection<Materia> materias;
	
	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
		this.cursos = new ArrayList<>();
		this.materias = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public Collection<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(Collection<Materia> materias) {
		this.materias = materias;
	}

	public void inscribir(Curso curso) throws NoCumpleCorrelativasException{
		if(!curso.getMateria().cumpleCorrelativas(this.materias)) {
			throw new NoCumpleCorrelativasException("No cumple con todas las correlativas");
		}else {
			curso.inscribir(this);
		}
		
	}
	
	
}
