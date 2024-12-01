package br.com.sistemaveiculos.model;

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
    private int id;

    /*
     * Métodos construtores da classe que determina os parâmetros de quais tipos de dados são
     * esperados para construção do objeto da classe.
     * Os atributos são inicializados dentro do construtor para serem alterados pelos Setters
     * posteriormente. Além disso, herda os atributos da superclasse.
     */
    public Bicicleta() {
    }
    
    public Bicicleta(String modelo, int anoFabricacao, String cor, int id) {
        super(modelo, anoFabricacao, cor, id);
    }

    public Bicicleta(String modelo, int anoFabricacao, String cor, int id, String marca, String material, int marchas, String amortecedor) {
        super(modelo, anoFabricacao, cor, id);
        this.marca = marca;
        this.material = material;
        this.marchas = marchas;
        this.amortecedor = amortecedor;
    }

    /*
     * Setters para atribuir os valores dos atributos da classe.
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

    public String getMaterial() {
        return material;
    }

    public int getMarchas() {
        return marchas;
    }

    public String getAmortecedor() {
        return amortecedor;
    }

    public int getId() {
        return id;
    }
}
