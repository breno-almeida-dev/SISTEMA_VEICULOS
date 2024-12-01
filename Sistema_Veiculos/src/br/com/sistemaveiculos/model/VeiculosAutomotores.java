package br.com.sistemaveiculos.model;

/*
 * Uma subclasse da superclasse Veiculo, mas que também é uma superclasse para suas próprias
 * subclasses. No caso, serve como superclasse por definir atributos únicos de veículos automotores.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public abstract class VeiculosAutomotores extends Veiculo {
    private String montadora;
    private double kmOdometro;
    private int id;

    /*
     * Métodos construtores da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente. Além disso, herda os atributos da superclasse.
     * Também define os atributos que serão herdados posteriormente pelos veículos automotores
     * que extendem essa superclasse.
     */
    public VeiculosAutomotores(){
    }
    
    public VeiculosAutomotores(String modelo, int anoFabricacao, String cor, int id) {
        super(modelo, anoFabricacao, cor, id);
    }
    
    public VeiculosAutomotores(String modelo, int anoFabricacao, String cor, int id, String montadora, double kmOdometro) {
        super(modelo, anoFabricacao, cor, id);
        this.montadora = montadora;
        this.kmOdometro = kmOdometro;
    }

    /*
     * Setters e Getters para instanciar e acessar os atributos da classe.
     */
    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public void setKmOdometro(double kmOdometro) {
        this.kmOdometro = kmOdometro;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /*
     * Getters que retornam os valores dos atributos quando
     * são acessados.
     */
    public String getMontadora() {
        return montadora;
    }

    public double getKmOdometro() {
        return kmOdometro;
    }

    public int getId() {
        return id;
    }
}
