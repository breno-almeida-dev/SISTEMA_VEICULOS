/*
 * Uma sub classe da super classe VeiculosAutomotores, que define os atributos únicos
 * de motocicletas.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class Motocicleta extends VeiculosAutomotores {
    private int cilindradas;
    private int torque;

    
    /*
     * Método construtor da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente.
     * Além disso herda os atributos da super classe.
     */
    public Motocicleta(String modelo, int anoFabricacao, String cor, String montadora, double kmOdometro, int cilindradas, int torque) {
        super(modelo, anoFabricacao, cor, montadora, kmOdometro);
        this.cilindradas = cilindradas;
        this.torque = torque;
    }
    
    
    /*
     * Setters para instanciar os atributos da classe.
     */
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
    
    public void setTorque(int torque) {
        this.torque = torque;
    }


    /*
     * Getters para retornar os valores dos atributos para o método que constrói
     * o comando INSERT do SQL, ou para acesso de fora da classe.
     */
    public int getCilindradas() {
        return 
        		cilindradas;
    }

    public int getTorque() {
        return 
        		torque;
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
                "INSERT INTO Motocicleta (modelo, anoFabricacao, cor, montadora, kmOdometro, cilindradas, torque) VALUES ('" 
                + getModelo() + "', " + getAnoFabricacao() + ", '" + getCor() + "', '" + getMontadora() + "', " + getKmOdometro() + ", " + getCilindradas() + ", " + getTorque() + ")";
    }
    
}
