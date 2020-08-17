package pilang.src;

import java.util.concurrent.ConcurrentLinkedQueue; 
import java.util.HashMap; 
import java.util.Map;

public interface Comunicacao{
	void send(Tabela tabela, Canal mensagem);
	boolean equal(Tabela tabela, Canal param);
	void receive(Tabela tabela, Canal mensagem);
	void print(Tabela tabela);
}