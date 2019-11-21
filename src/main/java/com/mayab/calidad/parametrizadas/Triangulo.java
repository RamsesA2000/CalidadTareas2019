package com.mayab.calidad.parametrizadas;

public class Triangulo {
	int lado1, lado2, lado3;
	
	public Triangulo(int lado1, int lado2, int lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	
	public String Tipo(){
		if(lado1 >0 || lado2 >0 || lado3 >0){
			if(lado1 == lado2 && lado2 == lado3){
				return "Triangulo equilatero";
			}else if(lado1 == lado2 && lado2 != lado3 || lado1 == lado3 && lado3 != lado2){
				return "Triangulo isoceles";
			}else if(lado1 != lado2 && lado2 != lado3){
				return "Triangulo escaleno";
			}
		}
		return "No es un triangulo";
	}
}
