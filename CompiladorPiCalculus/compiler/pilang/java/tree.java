package pilang.tree;
 import pilang.src.*; 
 import java.util.concurrent.ConcurrentLinkedQueue; 
 import java.util.HashMap; 
 import java.util.Map;
 public class tree{  
 	 private static Agente nil ; 
 	 private static Agente tree ; 
 	 private static Agente p ; 
 	 private static Agente s ; 
 	 private static Agente q ; 
 	 private static Agente v ; 
 	 private static Agente c ; 
 	 private static Agente u ; 
 	 private static Agente x ; 
 	 private static Agente t ; 
 	 private static Agente rchild ; 
 	 private static Agente lchild ; 
 	 private static Agente info ;
 	 public static void main(String[] args){
 	 	 	 nil = new Agente("nil") ;
 	 	 	 tree = new Agente("tree") ;
 	 	 	 p = new Agente("p") ;
 	 	 	 s = new Agente("s") ;
 	 	 	 q = new Agente("q") ;
 	 	 	 v = new Agente("v") ;
 	 	 	 c = new Agente("c") ;
 	 	 	 u = new Agente("u") ;
 	 	 	 x = new Agente("x") ;
 	 	 	 t = new Agente("t") ;
 	 	 	 rchild = new Agente("rchild") ;
 	 	 	 lchild = new Agente("lchild") ;
 	 	 	 info = new Agente("info") ; 
 	 	 	 	 // Processo 0 
 	 	 	 Processo t0 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 p.send(tabela,q);
 	 	 	 	 	 p.send(tabela,s);
 	 	 	 	 	 p.send(tabela,p); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 1 
 	 	 	 Processo t1 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 s.send(tabela,v);
 	 	 	 	 	 s.send(tabela,x);
 	 	 	 	 	 s.send(tabela,s); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 2 
 	 	 	 Processo t2 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 q.send(tabela,t);
 	 	 	 	 	 q.send(tabela,u);
 	 	 	 	 	 q.send(tabela,q); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 3 
 	 	 	 Processo t3 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 v.send(tabela,nil);
 	 	 	 	 	 v.send(tabela,nil);
 	 	 	 	 	 v.send(tabela,v); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 4 
 	 	 	 Processo t4 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 x.send(tabela,nil);
 	 	 	 	 	 x.send(tabela,nil);
 	 	 	 	 	 x.send(tabela,x); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 5 
 	 	 	 Processo t5 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 t.send(tabela,nil);
 	 	 	 	 	 t.send(tabela,nil);
 	 	 	 	 	 t.send(tabela,t); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 6 
 	 	 	 Processo t6 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 u.send(tabela,nil);
 	 	 	 	 	 u.send(tabela,nil);
 	 	 	 	 	 u.send(tabela,u); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 7 
 	 	 	 Processo t7 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 nil.send(tabela,nil);
 	 	 	 	 	 nil.send(tabela,nil);
 	 	 	 	 	 nil.send(tabela,nil); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 8 
 	 	 	 Processo t8 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 	 tree.send(tabela,p); 
 	 	 	 	 } 
 	 	 	 } ; 
 	 	 	 	 // Processo 9 
 	 	 	 Processo t9 = new Processo() {  
 	 	 	 	 public void run() { 
 
 	 	 	 	 // começo execução ;;;
 	 	 	 	 boolean retorno = true;
 	 	 	 	 while (retorno){ 
 	 	 	 	 	 Agente p = new Agente("p");
 	 	 	 	 	 setParam("p",p);
 	 	 	 	 	 Agente lchild = new Agente("lchild");
 	 	 	 	 	 setParam("lchild",lchild);
 	 	 	 	 	 Agente rchild = new Agente("rchild");
 	 	 	 	 	 setParam("rchild",rchild);
 	 	 	 	 	 Agente info = new Agente("info");
 	 	 	 	 	 setParam("info",info);
 	 	 	 	 	 tree.receive(tabela,p);
 	 	 	 	 	 p.receive(tabela,lchild);
 	 	 	 	 	 p.receive(tabela,rchild);
 	 	 	 	 	 p.receive(tabela,info);
 	 	 	 	 	 info.print(tabela);
 	 	 	 	 	 tree.send(tabela,lchild);
 	 	 	 	 	 tree.send(tabela,rchild);
 	 	 	 	 	 if(p.equal(tabela,nil)){
 	 	 	 	 	 retorno = false; 
 	 	 	 	 	 }; 
 	 	 	 	 } 
 	 	 	 	 } 
 	 	 	 } ;
 	 	 // Execução processos .... 
 	  	 t0.start(); 
 	  	 t1.start(); 
 	  	 t2.start(); 
 	  	 t3.start(); 
 	  	 t4.start(); 
 	  	 t5.start(); 
 	  	 t6.start(); 
 	  	 t7.start(); 
 	  	 t8.start(); 
 	  	 t9.start();
 	 	 try{ 
 	  	 t0.join(); 
 	  	 t1.join(); 
 	  	 t2.join(); 
 	  	 t3.join(); 
 	  	 t4.join(); 
 	  	 t5.join(); 
 	  	 t6.join(); 
 	  	 t7.join(); 
 	  	 t8.join(); 
 	  	 t9.join();
 	 	 } catch(InterruptedException e){
 	 	 System.out.println(e);
 	 	 };
 	 	 } 
 } 