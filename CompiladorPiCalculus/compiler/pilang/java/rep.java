package pilang.rep;
 import pilang.src.*; 
 import java.util.concurrent.ConcurrentLinkedQueue; 
 import java.util.HashMap; 
 import java.util.Map;
 public class rep{  
 	 private static Agente canal ; 
 	 private static Agente recebe ; 
 	 private static Agente envia1 ; 
 	 private static Agente envia2 ; 
 	 private static Agente envia3 ; 
 	 private static Agente contador ; 
 	 private static Agente n1 ; 
 	 private static Agente n2 ;
 	 public static void main(String[] args){
 	 	 	 canal = new Agente("canal") ;
 	 	 	 recebe = new Agente("recebe") ;
 	 	 	 envia1 = new Agente("envia1") ;
 	 	 	 envia2 = new Agente("envia2") ;
 	 	 	 envia3 = new Agente("envia3") ;
 	 	 	 contador = new Agente("contador") ;
 	 	 	 n1 = new Agente("n1") ;
 	 	 	 n2 = new Agente("n2") ; 
 	 	 	 	 // Processo 0 
 	 	 	 Processo t0 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 canal.send(tabela,envia1); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 1 
 	 	 	 Processo t1 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 canal.send(tabela,envia2); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 2 
 	 	 	 Processo t2 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 canal.send(tabela,envia3); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 3 
 	 	 	 Processo t3 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 boolean retorno = true;
 	 	 	 	 while (retorno){ 
 	 	 	 	 	 canal.receive(tabela,recebe);
 	 	 	 	 	 recebe.print(tabela);
 	 	 	 	 	 contador.receive(tabela,recebe);
 	 	 	 	 	 if(recebe.equal(tabela,n2)){
 	 	 	 	 	 retorno = false; 
 	 	 	 	 	 }; 
 	 	 	 	 } 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 4 
 	 	 	 Processo t4 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 contador.send(tabela,n1);
 	 	 	 	 	 contador.send(tabela,n1);
 	 	 	 	 	 contador.send(tabela,n2); 
 	 	 	 	 } 
 	 	 	 } ;
 	 	 // Execução processos .... 
 	  	 t0.start(); 
 	  	 t1.start(); 
 	  	 t2.start(); 
 	  	 t3.start(); 
 	  	 t4.start();
 	 	 try{ 
 	  	 t0.join(); 
 	  	 t1.join(); 
 	  	 t2.join(); 
 	  	 t3.join(); 
 	  	 t4.join();
 	 	 } catch(InterruptedException e){
 	 	 System.out.println(e);
 	 	 };
 	 	 } 
 } 