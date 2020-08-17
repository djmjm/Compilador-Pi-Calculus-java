package pilang.src;

import java.util.concurrent.ConcurrentLinkedQueue; 
import java.util.HashMap; 
import java.util.Map;


public class Agente extends Canal implements Comunicacao{

	public Agente(String nome){
		super(nome);
		this.valor = null;
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
		synchronized(canal.lock){
			canal.fila.add(mensagem_send);
			canal.lock.notify();
		}
	}

	public void receive(Tabela tabela, Canal mensagem){
		Canal canal = tabela.get(this.nome);
		if (canal == null){
			tabela.insert(this.nome, this);
			canal = this;
		}
		Canal mensagem_receive = tabela.get(mensagem.getNome()); 
		if (mensagem_receive == null){
			tabela.insert(mensagem.getNome(), mensagem);
			mensagem_receive = mensagem;
		} 
		synchronized(canal.lock){
			try{
				while(canal.fila.size() <= 0){
					canal.lock.wait();
				}
			}catch(InterruptedException e){
				System.out.println(e);
			}
			tabela.insert(mensagem.getNome(), canal.fila.poll());
		}

	}

	public void print(Tabela tabela){
		Canal canal = tabela.get(this.nome);
		if (canal == null){
			tabela.insert(this.nome, this);
			canal = this;
		}
		System.out.println(canal.getNome());
	}

	public boolean equal(Tabela tabela, Canal param){
		Canal canal = tabela.get(this.nome);
		if (canal == null){
			tabela.insert(this.nome, this);
			canal = this;
		}
		Canal canal2 = tabela.get(param.getNome());
		if (canal2 == null){ 
			tabela.insert(param.getNome(), param);
			canal2 = param;
		}

		if(canal2 == canal)
			return true;
		else return false;
	} 
}