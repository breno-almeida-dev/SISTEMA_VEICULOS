package br.com.sistemaveiculos.model;

/*
 * Uma subclasse da superclasse Veiculos, herdando os atributos da superclasse e
 * define os atributos únicos presentes em skates.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class Skate extends Veiculo {
    private String marca;
    private String tipoRodas;
    private int id;

    /*
     * Métodos construtores da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente. Além disso, herda os atributos da superclasse.
     */
    public Skate() {
    }
    
    public Skate(String modelo, int anoFabricacao, String cor, int id) {
        super(modelo, anoFabricacao, cor, id);
    }
    
    public Skate(String modelo, int anoFabricacao, String cor, int id, String marca, String tipoRodas) {
        super(modelo, anoFabricacao, cor, id);
        this.marca = marca;
        this.tipoRodas = tipoRodas;
    }

    /*
     * Setters para atribuir os valores dos atributos da classe.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipoRodas(String tipoRodas) {
        this.tipoRodas = tipoRodas;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
     * Getters que retornam os valores dos atributos quando
     * são acessados.
     */
    public String getMarca() {
        return marca;
    }

    public String getTipoRodas() {
        return tipoRodas;
    }

    public int getId() {
        return id;
    }
}
