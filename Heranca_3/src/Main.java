/*
 * Classe Main para criar os objetos de cada class, informando os valores de cada atributo.
 */
public class Main {
    public static void main(String[] args) {
    	
    	/*
    	 * Cria um objeto de cada classe, e em seguida informa os valores de seus atributos, para construção do
    	 * INSERT para o SQL, de acordo com as características específicas de cada classe.
    	 */
    	VeiculoDomestico veiculoDomestico = new VeiculoDomestico("Hatch", 2022, "Vermelho", "Toyota", 7650, 5, "ABS", "Com airbag");
    	
        Motocicleta moto = new Motocicleta("Custom", 2020, "Azul", "Suzuki", 6000, 600, 120);

        Caminhao caminhao = new Caminhao("Baú", 2020, "Preto", "Scania", 15000, 3, 5000);

        Bicicleta bike = new Bicicleta("Cross", 2022, "Laranja", "Houston", "Alumínio", 15, "Sem armotecedor");

        Skate skate = new Skate("Street", 2023, "Roxo", "Drop Dead", "Poliuretano");
        
        
        
        /*
         * Apresenta no terminal de saída como ficaria a estrutura de comando cada classe
         * para inserir os dados no SQL.
         */
        System.out.println(veiculoDomestico.criarInsert());
        
        System.out.println(moto.criarInsert());
        
        System.out.println(caminhao.criarInsert());
        
        System.out.println(bike.criarInsert());
        
        System.out.println(skate.criarInsert());

        
        
    }
}
