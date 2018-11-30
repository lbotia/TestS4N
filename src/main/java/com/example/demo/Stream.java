package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Stream {
	
	private List<String> lista;
	private List<String> numeros;
	
	public Stream() {
		// TODO Auto-generated constructor stub
		
		lista = new ArrayList<>();
		lista.add("Mite");
		lista.add("Code");
		lista.add("Jaime");
		lista.add("MitoCode");
		
		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("5");
		
		
	}
	
	
	public void filtrar() {
		
		/*
		 * todos los que empiezan con recorrer la lista
		 * expresion lambdan
		 */
		
		lista.stream().filter(x -> x.startsWith("M")).forEach(x-> System.out.println(x));
		
	}
	
	public void ordenar() {
		
		lista.stream().sorted().forEach(System.out::println);
		
		System.out.println("------------");
		
		lista.stream().sorted((a,b) -> b.compareTo(a) ).forEach(System.out::println);
		
		
	}
	public void trasformar() {
		
		lista.stream().map(String::toUpperCase).forEach(System.out::println);
		
		numeros.stream().map(x -> Integer.parseInt(x)+1).forEach(System.out::println);
		
		
	}
	public void limitar() {
		
		
		
		lista.stream().limit(2).forEach(System.out::println);
		
	}
	public void contar() {
		
		long x = lista.stream().count();
		System.out.println(x);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream app = new Stream();
		//app.filtrar();
		//app.ordenar();
		//app.trasformar();
		//app.limitar();
		app.contar();
		

	}

}
