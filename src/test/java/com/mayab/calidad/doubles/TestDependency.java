package com.mayab.calidad.doubles;

import static org.mockito.Mockito.when;

import java.util.regex.Pattern;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


public class TestDependency {
	
	Dependency dependency;
	SubDependency subDependency;
	
	@Before
	public void setUp() throws Exception {
		dependency = Mockito.mock(Dependency.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDummy() {
		assertThat(dependency.getClass(), is(nullValue()));
		assertThat(dependency.getClassNameUpperCase(), is(nullValue()));
		assertThat(dependency.getSubdependencyClassName(), is(nullValue()));
	}
	
	@Test
	public void testClassName(){
		when(dependency.getClassName()).thenReturn("Hola mundo");
		assertThat(dependency.getClassName(), is(equalTo("Hola mundo")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);
		dependency.getClassName();
	}
	
	@Test
	public void testAddtwo()
	{
		when(dependency.addTwo(anyInt())).thenReturn(3);
		assertThat(dependency.addTwo(1), is(equalTo(3)));
	}
	
	@Test
	public void testAnswerAddTwo(){
		when(dependency.addTwo(anyInt())).thenAnswer(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable{
				int arg = (Integer) invocation.getArguments()[0];
				System.out.println("El arg es: " + arg);
				return arg + 20;
			}
		});
		assertThat(dependency.addTwo(10), is(equalTo(30)));
	}
	
	@Test
	public void testGetClassNameUpperCase(){
		when(dependency.getClassNameUpperCase()).thenAnswer(
				new Answer(){
					public String answer(InvocationOnMock invocation)
					throws Throwable{
						String respuesta = "";
						respuesta = "ClaseEnMayusculas";
						String str = invocation.getMock().getClass().toString();
						String[] arr0fStr = str.split(Pattern.quote("\\$"));
						String nameClass = arr0fStr[0];
						respuesta = respuesta + ":" +nameClass.toUpperCase();
						
						return respuesta;
					}
				});
		//SE EJECUTA ESTE PARA EJECUTAR EL QUE ESTA ARRIBA
		assertThat(dependency.getClassNameUpperCase(), is(equalTo("ClaseEnMayusculas:CLASS COM.MAYAB.CALIDAD.DOUBLES.DEPENDENCY")));
	}
		
}