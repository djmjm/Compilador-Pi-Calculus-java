package pilang.src;

public class Processo extends Thread{
	public Tabela tabela;
	public Processo(){
		super();
		tabela = new Tabela();
	}
	public void setParam(String nome, Canal param){
		tabela.insert(nome, param);
	}
	public void run(){}

}