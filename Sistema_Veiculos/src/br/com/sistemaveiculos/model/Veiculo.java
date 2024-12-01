package br.com.sistemaveiculos.model;

/*
 * Super classe Veiculo que define os atributos presentes em todos os veículos,
 * para assim serem herdados pelas sub classes.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public abstract class Veiculo {
    private String modelo;
    private int anoFabricacao;
    private String cor;
    private int id;
    
    /*
     * Métodos construtores da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente.
     * Definindo os atributos que serão herdados pelas sub classes que extendem essa super classe. 
     */
    public Veiculo() {
    }
    
    public Veiculo(String modelo, int anoFabricacao, String cor, int id) {
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.id = id;
    }
    
    /*
     * Setters para atribuir os valores dos atributos da classe.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    
    public void setCor(String cor) {
    	this.cor = cor;
    }
    
    public void setId(int id) {
        this.id = id;
    }    
    
    /*
     * Getters que retornam os valores dos atributos quando
     * são acessados.
     */
    public String getModelo() {
        return 
        		modelo;
    }

    public int getAnoFabricacao() {
        return 
        		anoFabricacao;
    }
    
    public String getCor() {
    	return
    			cor;
    }
    
    public int getId() {
        return id;
    }
}
