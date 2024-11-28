/*
 * Super classe Veiculo que define os atributos presentes em todos os veículos,
 * para assim serem herdados pelas sub classes.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class Veiculo {
    private String modelo;
    private int anoFabricacao;
    private String cor;

    
    /*
     * Método construtor da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente.
     * Definindo os atributos que serão herdados pelas sub classes que extendem essa super classe. 
     */
    public Veiculo(String modelo, int anoFabricacao, String cor) {
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
    }
    
    
    /*
     * Setters para instanciar os atributos da classe.
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
    
    
    /*
     * Getters para retornar os valores dos atributos para o método que constrói
     * o comando INSERT do SQL, ou para acesso de fora da classe.
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


    /*
     * Método que constrói o comando INSERT para inserir os dados do veículo no SQL.
     * Puxando os valores dos atributos através dos Getters.
     */
    public String criarInsert() {
        return 
        		"INSERT INTO Veiculo (modelo, anoFabricacao, cor) VALUES ('" + getModelo() + "', " + getAnoFabricacao() + ", '" + getCor() + "')";
    }
    
}
