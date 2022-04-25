package ar.edu.utn.link.correlativas;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class AlumnoTest {

		@Test
		public void testInscripcionOK() throws Exception{
			//Precondición	
			Alumno alumno = new Alumno("Ezequiel");
			Materia ami= new Materia("ami");
			alumno.setMaterias(Arrays.asList(ami));
			Materia amii= new Materia("amii");
			amii.setCorrelativas(Arrays.asList(ami));
			Curso curso = new Curso(amii,2022);
			
			//operatoria
			alumno.inscribir(curso);
			
			//postcondicion
			assertTrue(curso.estaInscripto(alumno));
		}
		
		@Test
		public void testInscripcionException() throws Exception{
			//Precondición	
			Alumno alumno = new Alumno("Ezequiel");
			Materia syo= new Materia("syo");
			alumno.setMaterias(Arrays.asList(syo));
			Materia ami= new Materia("ami");
			Materia amii= new Materia("amii");
			amii.setCorrelativas(Arrays.asList(ami));
			Curso curso = new Curso(amii,2022);
			
			//operatoria
			//alumno.inscribir(curso);
			
			//postcondicion
			//assertEquals("No cumple con todas las correlativas",curso.estaInscripto(alumno));
			assertThrows(NoCumpleCorrelativasException.class, ()-> {alumno.inscribir(curso);});
		}
		
		@Test
		public void testabrirCursoOk() throws NoCumpleConLaCantidadMinimaExcepcion {
			Alumno alumno = new Alumno("Ezequiel");
			Alumno alumno2 = new Alumno("Camila");
			Alumno alumno3 = new Alumno("Franco");
			Alumno alumno4 = new Alumno("Juan");
			Alumno alumno5 = new Alumno("Gabriela");
			Curso curso = new Curso(new Materia("SO"),2022);
			curso.setInscriptos(Stream.of(alumno,alumno2,alumno3,alumno4,alumno5).collect(Collectors.toSet()));
			curso.abrir();
			
			assertTrue(curso.isAbierto());
		}
		
		@Test
		public void testabrirCursoException() throws NoCumpleConLaCantidadMinimaExcepcion {
			Alumno alumno = new Alumno("Ezequiel");
			Curso curso = new Curso(new Materia("SO"),2022);
			curso.setInscriptos(Stream.of(alumno).collect(Collectors.toSet()));
			
			assertThrows(NoCumpleConLaCantidadMinimaExcepcion.class, ()-> {curso.abrir();});
		}
}
