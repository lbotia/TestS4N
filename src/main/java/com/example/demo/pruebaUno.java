package com.example.demo;

import static org.junit.Assert.assertFalse;

import java.util.Optional;
import java.util.logging.Logger;

import org.junit.Test;
import org.slf4j.LoggerFactory;

public class pruebaUno {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(pruebaUno.class);
	
	
	@Test
	public void whenCreatesEmptyOptional_thenCorrect() {
	    Optional<String> empty = Optional.empty();
	    assertFalse(empty.isPresent());
	    
	   LOGGER.info("imprimir"); 
	    
	}
	
}
