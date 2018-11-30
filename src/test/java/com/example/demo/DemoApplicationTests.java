package com.example.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
		//Optional<String> opt = Optional.of(carro2.getColorRines());
		//logger.info("Esta inicializado ?  -> " + opt.isPresent());// false
		
		//logger.info("Prueba Objeto Carro -> " + opt.get().toString()); 
		
		//assertTrue(opt.isPresent() == true);// si es verdadero pasa el test
				
		
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
	
	/**
	 * orElseThrow
	 */
	
	@Test(expected = IllegalArgumentException.class)// test espera que bote una excepcion.
	public void orElseThrow() {
	    String nullName = null;
	    String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
	    		
	    logger.info("orElseThrow" + name);
	    		
	}
	
	
	@Test
	public void get() {
	    Optional<String> opt = Optional.ofNullable("prueba");
	    String name = opt.get();
	 
	    logger.info("get " +name);
	    
	    //assertEquals("baeldung", name);
	}
	
	@Test
	public void filter() {
	    Integer year = 2016;
	    Optional<Integer> yearOptional = Optional.of(year);
	    boolean is2016 = yearOptional.filter(anio -> anio == 2016).isPresent();
	    //assertTrue(is2016);
	    
	    logger.info("filter (2016) " + is2016);
	    
	    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
	    
	    logger.info("filter (2017) " + is2017);
	    
	    //assertFalse(is2017);
	}
	
	/**
	 * Prueba Interfaz
	 */
	
	@Test
	public void callInterfaceLambda() {
		double res = operar(3, 2);
		logger.info("Res -> " + res);
		
		
	}
	

	
	
	public double operar(double x, double y){
		pruebaUno pr = (n1,n2) -> n1*n2;
		return pr.operar(x, y);
		
	}
	
//	@Test
//	public void callByte(){
//		
//		short res = applyAsByte ((short) 2);
//	}
//	
//	public short applyAsByte (short s) {
//		
//		//pruebaInterfaz pr = (short (32.7));
//		//pruebaInterfaz pr = ((short) 2);
//		//pruebaInterfaz pr = (x1) -> (byte) s *2 ;
//		
//		pruebaInterfaz pr = "ssss";
//		return pr.applyAsByte(s);
//		
//	}
	
	@Test
	public void testHashMap() {
		
		
		Map<String, Integer> salaries = new HashMap<>();
		salaries.put("John", 40000);
		salaries.put("Freddy", 30000);
		salaries.put("Samuel", 50000);
		
		//salaros sin modificar
		
		logger.info("salaros sin modificar");
		
		salaries.forEach((n,o) -> logger.info("clave : " + n + ", Valor: " + o));
		 
		salaries.replaceAll((name, oldValue) -> 
		  name.equals("Freddy") ? oldValue : oldValue + 10000);
		
		//salarios modificados
		
		logger.info("salarios modificados");
		
		salaries.forEach((n,o) -> logger.info("clave : " + n + ", Valor: " + o));
		
		
		//logger.info(name "" +);
		
		
	}
	/**
	 * Consumidores  acepta un argumento generado y no devuelve nada.
	 */
	
	
	@Test 
	public void testConsumidores () {
		Map<String, Integer> ages = new HashMap<>();
		ages.put("John", 25);
		ages.put("Freddy", 24);
		ages.put("Samuel", 30);
		 
		ages.forEach((name, age) -> logger.info("Name " +name + " is " + age + " years old"));

	}
	
	/**
	 * predicate recibe un valor y devuelve un valor booleano.
	 */
	
	@Test
	public void testPredicate() {
		List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");
		 
		List<String> namesWithA = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
		
		logger.info("Test Predicate " +namesWithA);
	}
	
	@Test 
	public void testOperation () {
		
		List<String> names = Arrays.asList("bob", "josh", "megan");
		 
		names.replaceAll(String::toUpperCase);
		
		logger.info("test Operation : "+names);
		
	}
	
	@Test
	public void testOperatioDos() {
		List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
		 
		int sum = values.stream().reduce(0, (i1, i2) -> i1 + i2);
		logger.info("test operation dos :" +sum);
	}
	
	@Test
	public void testFuntionHere() {
		
		Thread thread = new Thread(() -> logger.info("Hello From Another Thread"));
		
		
		thread.start();
		
		
		
		
	}
	
	
	@Test
	public void OperationTres() {
		
		List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
		 
		int sum = values.stream().reduce(0, (i1, i2) -> i1 + i2);
		
		logger.info("total de la suma --> "+ sum);
		
	}
	
	
	
	/**
	 * Stream canalización de operación 
	 */
	@Test
	public void stream() {
		
		List<String> myList =
			    Arrays.asList("a1", "a2", "b1", "c2", "c1");

			myList
			    .stream()
			    .filter(s -> s.startsWith("c"))
			    .map(String::toUpperCase)
			    .sorted()
			    .forEach(System.out::println);
			
			logger.info("Stream -> " +myList);
		
	}
	
	/**
	 * Tipos de array
	 */
	
	public void tiposArroyos() {
	
	Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println); 
	
	}
	@Test
	public void intStreamRange() {
	IntStream.range(1, 4)
    .forEach(System.out::println);
		
		
	}
	/**
	 * operaciones de suma 
	 */
	@Test
	public void average() {
		
		Arrays.stream(new int[] {1, 2, 3}).map(n -> 2 * n + 1).average().ifPresent(System.out::println);
		
	}

	public void mapToInt() {
		
		Stream.of("a1", "a2", "a3").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);
		
		
	}
	@Test
	
	public void mapToObj() {
		IntStream.range(1, 4).mapToObj(i -> "a" + i).forEach(System.out::println);
	}
	@Test
	public void utilMapToIntToObj() {
		
		Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue).mapToObj(i -> "a" + i).forEach(System.out::println);
	}
	
	/**
	 * Orden de procesamiento
	 */
	@Test
	public void StreamOf() {
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        //System.out.println("filter: " + s);
	        
	    	logger.info("filter" + s);
	    	return true;
	    });
		
	}
	
	@Test
	public void streamForeach() {
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    })
	    .forEach(s -> logger.info("forEach: " + s));
		
		
	}
	
	@Test
	public void streamUpperCaseStartWith() {
		
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        logger.info("map: " + s);
	        return s.toUpperCase();
	    })
	    .anyMatch(s -> {
	        logger.info("anyMatch: " + s);
	        return s.startsWith("A");
	    });
		
	}
	
	@Test
	public void streamColeccion() {
		
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();
		
		logger.info("stream coleccion " +streamOfCollection);
		
	}
	
}
