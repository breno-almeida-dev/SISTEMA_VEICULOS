/*
 * Uma sub classe da super classe VeiculoAutomotores, que define atributos únicos de veículos
 * domésticos.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class VeiculoDomestico extends VeiculosAutomotores {
    private int maxPassageiros;
    private String tipoFreio;
    private String airbag;
    

    /*
     * Método construtor da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente.
     * Além disso herda os atributos da super classe.
     */
    public VeiculoDomestico(String modelo, int anoFabricacao, String cor, String montadora, double kmOdometro, int maxPassageiros, String tipoFreio, String airbag) {
        super(modelo, anoFabricacao, cor, montadora, kmOdometro);
        this.maxPassageiros = maxPassageiros;
        this.tipoFreio = tipoFreio;
        this.airbag = airbag;
    }

    
    /*
     * Setters para instanciar os atributos da classe.
     */
    public void setMaxPassageiros(int maxPassageiros) {
        this.maxPassageiros = maxPassageiros;
    }
    
    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }
    
    public void setAirbag(String airbag) {
        this.airbag = airbag;
    }
    

    /*
     * Getters para retornar os valores dos atributos para o método que constrói
     * o comando INSERT do SQL, ou para acesso de fora da classe.
     */
    public int getMaxPassageiros() {
        return 
        		maxPassageiros;
    }

    public String getTipoFreio() {
        return 
        		tipoFreio;
    }

    public String getAirbag() {
        return 
        		airbag;
    }    
    
    
    /*
     * Método que constrói o comando INSERT para inserir os dados do veículo no SQL.
     * Puxando os valores dos atributos através dos Getters.
     * Utiliza o @Override para sobrescrever o método criarInsert vindo da super classe VeiculosAutomotores.
     * Adiciona os atributos únicos dessas classes.
     */
    @Override
    public String criarInsert() {
        return 
                "INSERT INTO VeiculoDomestico (modelo, anoFabricacao, cor, montadora, kmOdometro, maxPassageiros, tipoFreio, airbag) VALUES ('" 
                + getModelo() + "', " + getAnoFabricacao() + ", '" + getCor() + "', '" + getMontadora() + "', " + getKmOdometro() + ", " + getMaxPassageiros() + ", '" + getTipoFreio() + "', '" + getAirbag() + "')";
    }
    
}
