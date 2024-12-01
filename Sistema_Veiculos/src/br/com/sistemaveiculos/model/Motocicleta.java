package br.com.sistemaveiculos.model;

/*
 * Uma subclasse da superclasse VeículosAutomotores, que define os atributos únicos
 * de motocicletas.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class Motocicleta extends VeiculosAutomotores {
    private int cilindradas;
    private int torque;
    private int id;

    /*
     * Métodos construtores da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente. Além disso, herda os atributos da superclasse.
     */
    public Motocicleta() {
    }
    
    public Motocicleta(String modelo, int anoFabricacao, String cor, int id, String montadora, double kmOdometro) {
        super(modelo, anoFabricacao, cor, id, montadora, kmOdometro);
    }
    
    public Motocicleta(String modelo, int anoFabricacao, String cor, int id, String montadora, double kmOdometro, int cilindradas, int torque) {
        super(modelo, anoFabricacao, cor, id, montadora, kmOdometro);
        this.cilindradas = cilindradas;
        this.torque = torque;
    }

    /*
     * Setters para atribuir os valores dos atributos da classe.
     */
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
     * Getters que retornam os valores dos atributos quando
     * são acessados.
     */
    public int getCilindradas() {
        return cilindradas;
    }

    public int getTorque() {
        return torque;
    }

    public int getId() {
        return id;
    }
}
