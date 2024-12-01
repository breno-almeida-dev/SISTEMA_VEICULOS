package br.com.sistemaveiculos.manipularveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.sistemaveiculos.model.Bicicleta;

/*
 * Classe específica para manipular os dados da bicicleta.
 * A classe abriga os métodos CRUD responsáveis por executar
 * os comandos SQL no banco de dados.
 */
public class ManipularBicicleta {

    /*
     * Método estático para Inserir uma Bicicleta no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void inserir(Scanner scanner, Connection conexao) {
        System.out.println("Insira os dados da bicicleta:");

        Bicicleta bicicleta = new Bicicleta();

        System.out.print("Modelo: ");
        bicicleta.setModelo(scanner.nextLine());

        System.out.print("Ano de Fabricação: ");
        bicicleta.setAnoFabricacao(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cor: ");
        bicicleta.setCor(scanner.nextLine());

        System.out.print("Marca: ");
        bicicleta.setMarca(scanner.nextLine());

        System.out.print("Material: ");
        bicicleta.setMaterial(scanner.nextLine());

        System.out.print("Marchas: ");
        bicicleta.setMarchas(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Amortecedor (Sim/Não): ");
        bicicleta.setAmortecedor(scanner.nextLine());

        // Comando SQL para inserir o veículo no banco de dados.
        String sqlInserir = "INSERT INTO bicicleta (modelo, ano_fabricacao, cor, marca, material, marchas, amortecedor) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, bicicleta.getModelo());
            stmt.setInt(2, bicicleta.getAnoFabricacao());
            stmt.setString(3, bicicleta.getCor());
            stmt.setString(4, bicicleta.getMarca());
            stmt.setString(5, bicicleta.getMaterial());
            stmt.setInt(6, bicicleta.getMarchas());
            stmt.setString(7, bicicleta.getAmortecedor());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    System.out.println("Bicicleta inserida com sucesso! ID gerado: " + idGerado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir bicicleta: " + e.getMessage());
        }
    }

    /*
     * Método estático para atualizar uma Bicicleta no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void atualizar(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID da bicicleta a ser atualizada: ");
        int idAtualizar = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.println("Atualize os dados da bicicleta:");

        Bicicleta bicicleta = new Bicicleta();

        System.out.print("Modelo: ");
        bicicleta.setModelo(scanner.nextLine());

        System.out.print("Ano de Fabricação: ");
        bicicleta.setAnoFabricacao(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cor: ");
        bicicleta.setCor(scanner.nextLine());

        System.out.print("Marca: ");
        bicicleta.setMarca(scanner.nextLine());

        System.out.print("Material: ");
        bicicleta.setMaterial(scanner.nextLine());

        System.out.print("Marchas: ");
        bicicleta.setMarchas(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Amortecedor (Sim/Não): ");
        bicicleta.setAmortecedor(scanner.nextLine());

        // Comando SQL para atualizar o veículo no banco de dados.
        String sqlAtualizar = "UPDATE bicicleta SET modelo = ?, ano_fabricacao = ?, cor = ?, marca = ?, material = ?, marchas = ?, amortecedor = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar)) {
            stmt.setString(1, bicicleta.getModelo());
            stmt.setInt(2, bicicleta.getAnoFabricacao());
            stmt.setString(3, bicicleta.getCor());
            stmt.setString(4, bicicleta.getMarca());
            stmt.setString(5, bicicleta.getMaterial());
            stmt.setInt(6, bicicleta.getMarchas());
            stmt.setString(7, bicicleta.getAmortecedor());
            stmt.setInt(8, idAtualizar);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Bicicleta atualizada com sucesso.");
            } else {
                System.out.println("Nenhuma bicicleta encontrada com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar bicicleta: " + e.getMessage());
        }
    }

    /*
     * Método estático para deletar uma Bicicleta no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void deletar(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID da bicicleta a ser deletada: ");
        int idDeletar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para deletar o veículo no banco de dados.
        String sqlDeletar = "DELETE FROM bicicleta WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlDeletar)) {
            stmt.setInt(1, idDeletar);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Bicicleta deletada com sucesso.");
            } else {
                System.out.println("Nenhuma bicicleta encontrada com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar bicicleta: " + e.getMessage());
        }
    }

    /*
     * Método estático para ler uma Bicicleta no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void ler(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID da bicicleta a ser consultada: ");
        int idConsultar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para buscar o veículo no banco de dados.
        String sqlConsultar = "SELECT id, modelo, ano_fabricacao, cor, marca, material, marchas, amortecedor FROM bicicleta WHERE id = ?";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlConsultar);
            stmt.setInt(1, idConsultar);

            ResultSet rs = stmt.executeQuery();

            System.out.println("Consulta realizada para o ID: " + idConsultar);

            // Verifica se existem resultados
            if (rs.next()) {
                // Recupera os dados do ResultSet
                int id = rs.getInt("id");
                String modelo = rs.getString("modelo");
                int anoFabricacao = rs.getInt("ano_fabricacao");
                String cor = rs.getString("cor");
                String marca = rs.getString("marca");
                String material = rs.getString("material");
                int marchas = rs.getInt("marchas");
                String amortecedor = rs.getString("amortecedor");

                // Exibe os dados do produto
                System.out.println("ID: " + id + ", Modelo: " + modelo + ", Ano de Fabricação: " + anoFabricacao + ", Cor: " + cor + ", Marca: " + marca + ", Material: " + material + ", Marchas: " + marchas + ", Amortecedor: " + amortecedor);
            } else {
                System.out.println("Nenhuma bicicleta encontrada com o ID fornecido.");
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao ler dados: " + e.getMessage());
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
