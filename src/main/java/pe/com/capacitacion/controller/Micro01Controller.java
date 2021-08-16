package pe.com.capacitacion.controller;
 
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j; 
 
/**
 * Micro01Controller
 * @author cguerra
 **/
 @Slf4j      //Autogenerar LOG4J. 
 @RestController
 @RequestMapping( "/dummy-micro-01" )   //NO USAR: [server.servlet.context-path], 'BOOT-ADMIN' reconocera el 'ACTUATOR'.
 public class Micro01Controller{

        private String vPersona_01 = "{ 'nombre': 'PAOLO GUERRERO', 'edad': 35, 'rol': 'CONSULTOR'   }";
        private String vPersona_02 = "{ 'nombre': 'LUIS GUADALUPE', 'edad': 40, 'rol': 'PROGRAMADOR' }";     	 
        private String vPersona_03 = "{ 'nombre': 'PEDRO SALAZAR',  'edad': 30, 'rol': 'ARQUITECTO'  }"; 
        private String vPersona_04 = "[" + vPersona_01 + "," + vPersona_02 + "," + vPersona_03 + "]";	 
	 
        private List<String> listaPersonas = new ArrayList<String>();  
        
	   /**
	    * consultarPersonaPorId	
	    * @param  id
	    * @return String 
	    **/
		@GetMapping( "/get/personas/{id}" )
		public String  consultarPersonaPorId( @PathVariable( "id" ) long id ){
			   log.info( "'consultarPersonaPorId': id={}", id );
    
	           this.listaPersonas.add( this.vPersona_01 );	   
	           this.listaPersonas.add( this.vPersona_02 );
	           this.listaPersonas.add( this.vPersona_03 );
 	           
	           String vDatoJson = "";
	           for( int i=0; i<this.listaPersonas.size(); i++ ){	        	   
	        	    if( (i+1) == id ){
	        	    	vDatoJson = this.listaPersonas.get( i ); 
	        	    	break; 
	        	    }  
			   }
 
			   String objResponseMsg = vDatoJson;
			   return objResponseMsg; 
		} 
		
	   /**
	    * consultarPersonaPorId	
	    * @return String 
	    **/
		@GetMapping( "/get/personas" )
		public String  consultarPersonas(){
			   log.info( "'consultarPersonas'" );
 
			   String objResponseMsg = vPersona_04;
			   return objResponseMsg; 
		} 
		
 }

 