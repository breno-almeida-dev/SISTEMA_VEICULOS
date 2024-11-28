/*
 * Uma sub classe da super classe Veículo, essa herda os atributos presentes em
 * todos os veículos, e adiciona os atributos únicos de bicicletas.
 * Define os atributos como privados para serem processados apenas de dentro da classe.
 */
public class Bicicleta extends Veiculo {
    private String marca;
    private String material;
    private int marchas;
    private String amortecedor;
    

    /*
     * Método construtor da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente.
     * Além disso herda os atributos da super classe.
     */
    public Bicicleta(String modelo, int anoFabricacao, String cor, String marca, String material, int marchas, String amortecedor) {
        super(modelo, anoFabricacao, cor);
        this.marca = marca;
        this.material = material;
        this.marchas = marchas;
        this.amortecedor = amortecedor;
    }


    /*
     * Setters para instanciar os atributos da classe.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public void setMarchas(int marchas) {
        this.marchas = marchas;
    }
    
    public void setAmortecedor(String amortecedor) {
        this.amortecedor = amortecedor;
    }
    
    
    /*
     * Getters para retornar os valores dos atributos para o método que constrói
     * o comando INSERT do SQL, ou para acesso de fora da classe.
     */
    public String getMarca() {
        return 
        		marca;
    }

    public String getMaterial() {
        return 
        		material;
    }

    public int getMarchas() {
        return 
        		marchas;
    }

    public String getAmortecedor() {
        return 
        		amortecedor;
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
                "INSERT INTO Bicicleta (modelo, anoFabricacao, marca, material, marchas, amortecedor) VALUES ('" 
                + getModelo() + "', " + getAnoFabricacao() + ", '" + getMarca() + "', '" + getMaterial() + "', " + getMarchas() + ", '" + getAmortecedor() + "')";
    }
    
}
