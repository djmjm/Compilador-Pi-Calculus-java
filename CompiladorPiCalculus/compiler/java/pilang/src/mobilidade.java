package pilang.mobilidade;

import pilang.src.*;


import java.util.concurrent.ConcurrentLinkedQueue; 
import java.util.HashMap; 
import java.util.Map;

public class mobilidade{  
	private static Agente z ; 
	private static Agente x ; 
	private static Agente ext ; 
	private static Agente recebe ;
	public static void main(String[] args){
		z = new Agente("z") ;
		x = new Agente("x") ;
		ext = new Agente("ext") ;
		recebe = new Agente("recebe") ; 
 	 	 	 	 // Processo 0 
		Processo t0 = new Processo() {  
			public void run() { 
				
 	 	 	 	 // começo execução ;;;
				Agente z = new Agente("z");
				setParam("z",z);
				ext.send(tabela,z);
				z.receive(tabela,recebe);
				if(z.equal(tabela,recebe)){
					recebe.print(tabela); 
				}; 
			} 
		} ; 
 	 	 	 	 // Processo 1 
		Processo t1 = new Processo() {  
			public void run() { 
				
 	 	 	 	 // começo execução ;;;
				ext.receive(tabela,recebe);
				x.send(tabela,recebe); 
			} 
		} ; 
 	 	 	 	 // Processo 2 
		Processo t2 = new Processo() {  
			public void run() { 
				
 	 	 	 	 // começo execução ;;;
				x.receive(tabela,recebe);
				recebe.send(tabela,z); 
			} 
		} ;
 	 	 // Execução processos .... 
		t0.start(); 
		t1.start(); 
		t2.start();
		try{ 
			t0.join(); 
			t1.join(); 
			t2.join();
		} catch(InterruptedException e){
			System.out.println(e);
		};
	} 
} 