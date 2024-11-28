/*
 * Uma sub classe da super classe VaiculosAutomotores, que define os atributos únicos
 * de caminhões.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class Caminhao extends VeiculosAutomotores {
    private int eixos;
    private double pesoBruto;
    

    /*
     * Método construtor da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente.
     * Além disso herda os atributos da super classe.
     */
    public Caminhao(String modelo, int anoFabricacao, String cor, String montadora, double kmOdometro, int eixos, double pesoBruto) {
        super(modelo, anoFabricacao, cor, montadora, kmOdometro);
        this.eixos = eixos;
        this.pesoBruto = pesoBruto;
    }

    
    /*
     * Setters para instanciar os atributos da classe.
     */
    public void setEixos(int eixos) {
        this.eixos = eixos;
    }
    
    public void setPesoBruto(double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }
    

    /*
     * Getters para retornar os valores dos atributos para o método que constrói
     * o comando INSERT do SQL, ou para acesso de fora da classe.
     */
    public int getEixos() {
        return 
        		eixos;
    }

    public double getPesoBruto() {
        return 
        		pesoBruto;
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
                "INSERT INTO Caminhao (modelo, anoFabricacao, cor, montadora, kmOdometro, eixos, pesoBruto) VALUES ('" 
                + getModelo() + "', " + getAnoFabricacao() + ", '" + getCor() + "', '" + getMontadora() + "', " + getKmOdometro() + ", " + getEixos() + ", " + getPesoBruto() + ")";
    }
    
}
