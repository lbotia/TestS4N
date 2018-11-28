package com.example.demo;

import java.util.HashMap;
import java.util.Map;


	
@FunctionalInterface	
public interface pruebaUno {
	 
		//solo define un unico metodo
	
	
		Map<String, Integer> nameMap = new HashMap<>();
		Integer value = nameMap.computeIfAbsent("Laura", s->s.length());
		
		//return nameMap;
	public double operar(double x, double y) ;
		//public int operar2 ();
		

		 
		//public byte applyAsByte(short s);
		 
	
		
}
