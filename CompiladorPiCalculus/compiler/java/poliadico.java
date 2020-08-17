package pilang.poliadico ;
 import pilang.src.*; 
 import java.util.concurrent.ConcurrentLinkedQueue; 
 import java.util.HashMap; 
 import java.util.Map;
 public class poliadico{  
 	 private static Agente canal ; 
 	 private static Agente receptor ; 
 	 private static Agente recebe ; 
 	 private static Agente um ; 
 	 private static Agente dois ; 
 	 private static Agente tres ; 
 	 private static Agente quatro ;
 	 public static void main(String[] args){
 	 	 	 canal = new Agente("canal") ;
 	 	 	 receptor = new Agente("receptor") ;
 	 	 	 recebe = new Agente("recebe") ;
 	 	 	 um = new Agente("um") ;
 	 	 	 dois = new Agente("dois") ;
 	 	 	 tres = new Agente("tres") ;
 	 	 	 quatro = new Agente("quatro") ; 
 	 	 	 	 // Processo 0 
 	 	 	 Processo t0 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 canal.receive(tabela,receptor);
 	 	 	 	 	 receptor.receive(tabela,recebe);
 	 	 	 	 	 recebe.print(tabela);
 	 	 	 	 	 receptor.receive(tabela,recebe);
 	 	 	 	 	 recebe.print(tabela); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 1 
 	 	 	 Processo t1 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 Agente receptor = new Agente("receptor");
 	 	 	 	 	 setParam("receptor",receptor);
 	 	 	 	 	 canal.send(tabela,receptor);
 	 	 	 	 	 receptor.send(tabela,um);
 	 	 	 	 	 receptor.send(tabela,dois); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 2 
 	 	 	 Processo t2 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 Agente receptor = new Agente("receptor");
 	 	 	 	 	 setParam("receptor",receptor);
 	 	 	 	 	 canal.send(tabela,receptor);
 	 	 	 	 	 receptor.send(tabela,tres);
 	 	 	 	 	 receptor.send(tabela,quatro); 
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