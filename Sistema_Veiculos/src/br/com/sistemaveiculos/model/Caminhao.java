package br.com.sistemaveiculos.model;

/*
 * Uma subclasse da superclasse VeiculosAutomotores, que define os atributos únicos
 * de caminhões. Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class Caminhao extends VeiculosAutomotores {
    private int eixos;
    private double pesoBruto;
    private int id;

    /*
     * Métodos construtores da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe. Os atributos são inicializados dentro do construtor 
     * para serem alterados pelos Setters posteriormente. Além disso, herda os atributos da superclasse.
     */
    public Caminhao() {
    }
    
    public Caminhao(String modelo, int anoFabricacao, String cor, int id, String montadora, double kmOdometro) {
        super(modelo, anoFabricacao, cor, id, montadora, kmOdometro);
    }
    
    public Caminhao(String modelo, int anoFabricacao, String cor, int id, String montadora, double kmOdometro, int eixos, double pesoBruto) {
        super(modelo, anoFabricacao, cor, id, montadora, kmOdometro);
        this.eixos = eixos;
        this.pesoBruto = pesoBruto;
    }

    /*
     * Setters para atribuir os valores dos atributos da classe.
     */
    public void setEixos(int eixos) {
        this.eixos = eixos;
    }

    public void setPesoBruto(double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
     * Getters que retornam os valores dos atributos quando
     * são acessados.
     */
    public int getEixos() {
        return eixos;
    }

    public double getPesoBruto() {
        return pesoBruto;
    }

    public int getId() {
        return id;
    }
}
