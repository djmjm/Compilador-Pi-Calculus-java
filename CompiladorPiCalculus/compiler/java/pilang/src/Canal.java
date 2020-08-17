package pilang.src;

import java.util.concurrent.ConcurrentLinkedQueue; 
import java.util.HashMap; 
import java.util.Map;

public abstract class Canal{ 
	protected String nome; 
	public Object lock; 
	protected Integer valor;
	public ConcurrentLinkedQueue<Canal> fila; 
	
	public Canal(String nome){ 
		this.nome = nome; 
		this.lock = new Object(); 
		this.fila = new ConcurrentLinkedQueue(); 
	} 

	public String getNome(){ 
		return this.nome; 
	} 

	public Integer getValor(){
		return this.valor;
	}

	public void setValor(Integer valor){
		this.valor = valor;
	}

}