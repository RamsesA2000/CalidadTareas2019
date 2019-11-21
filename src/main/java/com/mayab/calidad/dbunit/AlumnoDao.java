package com.mayab.calidad.dbunit;

public interface AlumnoDao {
	
	public String addAlumno(Alumno alumno);
	public String removeAlumno(Alumno alumno);
	public String updatePromedioAlumno(Alumno alumno);
	public String getAlumno(Alumno alumno);
}
