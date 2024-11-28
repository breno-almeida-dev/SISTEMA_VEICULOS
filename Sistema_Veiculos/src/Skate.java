/*
 * Uma sub classe da super classe Veiculos, herdando os atributos da super classe e
 * define os atributos únicos presentes em skates.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class Skate extends Veiculo {
    private String marca;
    private String tipoRodas;
    
    
    /*
     * Método construtor da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente.
     * Além disso herda os atributos da super classe.
     */
    public Skate(String modelo, int anoFabricacao, String cor, String marca, String tipoRodas) {
        super(modelo, anoFabricacao, cor);
        this.marca = marca;
        this.tipoRodas = tipoRodas;
    }

    
    /*
     * Setters para instanciar os atributos da classe.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setTipoRodas(String tipoRodas) {
        this.tipoRodas = tipoRodas;
    }
    

    /*
     * Getters para retornar os valores dos atributos para o método que constrói
     * o comando INSERT do SQL, ou para acesso de fora da classe.
     */
    public String getMarca() {
        return 
        		marca;
    }

    public String getTipoRodas() {
        return 
        		tipoRodas;
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
                "INSERT INTO Skate (modelo, anoFabricacao, marca, tipoRodas) VALUES ('" 
                + getModelo() + "', " + getAnoFabricacao() + ", '" + getMarca() + "', '" + getTipoRodas() + "')";
    }
    
}
