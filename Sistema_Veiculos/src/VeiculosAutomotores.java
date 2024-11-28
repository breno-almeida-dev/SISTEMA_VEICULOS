/*
 * Uma sub classe da super classe Veiculo, mas que também é uma Super classe para suas próprias
 * sub classes. No caso serve como Super classe por definir atributos únicos de veículos automotores.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class VeiculosAutomotores extends Veiculo {
	private String montadora;
	private double kmOdometro;
	
	
    /*
     * Método construtor da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente.
     * Além disso herda os atributos da super classe.
     * Também define os atributos que serão herdados posteriormente pelos veículos automotores
     * que extendem essa super classe.
     */
	public VeiculosAutomotores(String modelo, int anoFabricacao, String cor, String montadora, double kmOdometro) {
		super(modelo, anoFabricacao, cor);
		this.montadora = montadora;
		this.kmOdometro = kmOdometro;
	}
	
	
    /*
     * Setters para instanciar os atributos da classe.
     */
	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}
	
	public void setKmOdometro(double kmOdometro) {
		this.kmOdometro = kmOdometro;
	}
	
	
    /*
     * Getters para retornar os valores dos atributos para o método que constrói
     * o comando INSERT do SQL, ou para acesso de fora da classe.
     */
	public String getMontadora() {
		return
				montadora;
	}
	
	public double getKmOdometro() {
		return
				kmOdometro;
	}
	
	
    /*
     * Método que constrói o comando INSERT para inserir os dados do veículo no SQL.
     * Puxando os valores dos atributos através dos Getters.
     * Utiliza o @Override para sobrescrever o método criarInsert vindo da super classe Veiculo.
     * Adiciona os atributos únicos dessas classes.
     */
	@Override
    public String criarInsert() {
        return 
                "INSERT INTO VeiculosAutomotores (modelo, anoFabricacao, cor, montadora, kmOdometro) VALUES ('"
        		+ getModelo() + "', " + getAnoFabricacao() + ", '" + getCor() + "', '" + getMontadora() + "', " + getKmOdometro() + ")";
	}

}
