package pilang.src;

import java.util.concurrent.ConcurrentLinkedQueue; 
import java.util.HashMap; 
import java.util.Map;

public class Numerico extends Canal implements Comunicacao{

	public Numerico(String nome, Integer valor ){
		super(nome);
		this.valor = valor;
	}

	public void send(Tabela tabela, Canal mensagem){
		Canal canal = tabela.get(this.nome);
		if (canal == null){
			tabela.insert(this.nome, this);
			canal = this;
		}
		Canal mensagem_send = tabela.get(mensagem.getNome()); 
		if (mensagem_send == null){
			tabela.insert(mensagem.getNome(), mensagem);
			mensagem_send = mensagem;
		}
		synchronized (this.lock){ 
			this.fila.add(mensagem_send); 
			this.lock.notify(); 
		} 
	}

	public void receive(Tabela tabela, Canal mensagem){
		Canal canal = tabela.get(this.nome);
		if (canal == null){
			tabela.insert(this.nome, this);
			canal = this;
		}
		try{
			synchronized (this.lock){
				while(this.fila.size() <= 0){
					this.lock.wait();
				}
				Canal recept = this.fila.poll();
				canal.setValor(canal.getValor() + recept.getValor());

			}
		}catch(InterruptedException e){
			System.out.println(e);
		}
	}

	public void print(Tabela tabela){
		Canal canal = tabela.get(this.nome);
		if (canal == null){
			tabela.insert(this.nome, this);
			canal = this;
		}
		System.out.println(canal.getValor());
	}

	public boolean equal(Tabela tabela, Canal param){
		return true;
	} 

}