package br.com.sistemaveiculos.model;

/*
 * Uma subclasse da superclasse VeiculoAutomotores, que define atributos únicos de veículos
 * domésticos.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class VeiculoDomestico extends VeiculosAutomotores {
    private int maxPassageiros;
    private String tipoFreio;
    private String airbag;
    private int id;

    /*
     * Métodos construtores da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente. Além disso, herda os atributos da superclasse.
     */
    public VeiculoDomestico(){
    }
    
    public VeiculoDomestico(String modelo, int anoFabricacao, String cor, int id, String montadora, double kmOdometro) {
        super(modelo, anoFabricacao, cor, id, montadora, kmOdometro);
    }
    
    public VeiculoDomestico(String modelo, int anoFabricacao, String cor, int id, String montadora, double kmOdometro, int maxPassageiros, String tipoFreio, String airbag) {
        super(modelo, anoFabricacao, cor, id, montadora, kmOdometro);
        this.maxPassageiros = maxPassageiros;
        this.tipoFreio = tipoFreio;
        this.airbag = airbag;
    }

    /*
     * Setters para atribuir os valores dos atributos da classe.
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

    public void setId(int id) {
        this.id = id;
    }

    /*
     * Getters que retornam os valores dos atributos quando
     * são acessados.
     */
    public int getMaxPassageiros() {
        return maxPassageiros;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public String getAirbag() {
        return airbag;
    }

    public int getId() {
        return id;
    }
}
