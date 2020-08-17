package pilang.src;

import java.util.concurrent.ConcurrentLinkedQueue; 
import java.util.HashMap; 
import java.util.Map;

public class Tabela{
	private Map<String, Canal> tabela_canais;
	public Tabela(){
		tabela_canais = new HashMap<String, Canal>();
	}
	public void insert(String vinculo, Canal canal){
		tabela_canais.put(vinculo, canal);
	}
	public Canal get(String vinculo){
		return tabela_canais.get(vinculo);
	}
}