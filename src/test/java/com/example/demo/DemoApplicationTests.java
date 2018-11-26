package com.example.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	//private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(DemoApplication.class);
	 Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);
	
	@Test
	public void contextLoads() {

		logger.info("imprimir"); 

		
		    Optional<String> empty = Optional.ofNullable("a");
		    
		    
		    //assertFalse(empty.isPresent());
		    logger.info("resultado -> " + empty.get());
		    
		    //assertTrue(empty.isPresent());
		
		
	}

	@Test
	public void optinalTest(){
		
		String str = "hola";
		
		Optional op = Optional.of(str);
		
		logger.info("test 2 -> " + op.get());
		
		
	}
	
	/**
	 * Un valor esta presente si y solo si se ha creado Optional 
	 * con un valor null
	 */
	
	@Test
	public void optionalNonNullabe() {
		
		String  nombre = "Prueba";
		Optional.of(nombre);
		
		logger.info(nombre);
		
	}
	
	@Test
	public void porProcesar() {
		
		//Carro carro1 = null;
		
		Carro carro2 = new Carro("Mazda","Negro");
		
		//carro2.getColorRines().concat(" ******");
		//carro2.setColorRines("blanco");
		Optional<String> opt = Optional.of(carro2.getColorRines());
		logger.info("Esta inicializado ?  -> " + opt.isPresent());// false
		
		logger.info("Prueba Objeto Carro -> " + opt.get().toString()); 
		
		assertTrue(opt.isPresent() == true);// si es verdadero pasa el test
				
		
	}
	
	/**
	 * si se pone un referencia nula , no lanza la excepcion sino que 
	 * devuelve un objeto opconal vacio
	 */
	
	@Test
	public void nullPoint() {
	    String name = null;
	    Optional<String> opt = Optional.ofNullable(name);
	    
	    logger.info("prueba null --> " +opt.toString());
	}
	
	@Test(expected = NullPointerException.class)
	public void givenNull() {
	    String name = null;
	    Optional<String> opt = Optional.of(name);
	    
	    logger.info("resultado3 --> "+ opt.toString());
	}
	
	
	@Test
	public void givenOptional_whenIsPresentWorks_thenCorrect() {
	
		
		Optional<String> opt = Optional.ofNullable("sss");
	   // assertTrue(opt.isPresent());
		opt.ifPresent(apellido -> logger.info("valor -> " + apellido));
		
		//opt.ifPresent(name -> logger.info(""+name.length()));
	  //  logger.info("solucion --> " + opt.isPresent());
		
		if (opt.isPresent()) {
			logger.info("valor forma 2 -> " + opt.get());
		}

	}
	
	@Test
	public void whenOrElseWorks_thenCorrect() {
	    String nullName = "aaaaaa";
	    String name = Optional.ofNullable(nullName).orElse("john");
	    	    
	    logger.info("valor por defecto : " + name );
	    
	     // assertEquals("john", name);
	}
	
	@Test
	public void whenOrElseGetWorks_thenCorrect() {
	    String nullName = null;
	    //String mensaje = String.valueOf(2+2);
	    
	    
	    String name = Optional.ofNullable(nullName).orElseGet(() -> suma());
	    
	    
	    
	    logger.info("prueba orelseget " + name);
	    
	    //assertEquals("john", name);
	}
	
	
	public String suma() {
		
		int numero1 = 3;
		int numero2 = 2;
		int resultado;
		
		resultado = numero1+numero2;
		return String.valueOf(resultado);
		
		
	}
	
	
	
	
	
}
