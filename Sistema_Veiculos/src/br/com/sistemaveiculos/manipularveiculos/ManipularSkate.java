package br.com.sistemaveiculos.manipularveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.sistemaveiculos.model.Skate;

/*
 * Classe específica para manipular os dados do skate.
 * A classe abriga os métodos CRUD responsáveis por executar
 * os comandos SQL no banco de dados.
 */
public class ManipularSkate {

    /*
     * Método estático para Inserir um skate no banco
     * de dados, através do comando "PreparedStatement".
     */
    public static void inserir(Scanner scanner, Connection conexao) {
        System.out.println("Insira os dados do skate:");

        Skate skate = new Skate();

        System.out.print("Modelo: ");
        skate.setModelo(scanner.nextLine());

        System.out.print("Ano de Fabricação: ");
        skate.setAnoFabricacao(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cor: ");
        skate.setCor(scanner.nextLine());

        System.out.print("Marca: ");
        skate.setMarca(scanner.nextLine());

        System.out.print("Tipo de Rodas: ");
        skate.setTipoRodas(scanner.nextLine());

        // Comando SQL para inserir o veículo no banco de dados.
        String sqlInserir = "INSERT INTO skate (modelo, ano_fabricacao, cor, marca, tipo_rodas) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, skate.getModelo());
            stmt.setInt(2, skate.getAnoFabricacao());
            stmt.setString(3, skate.getCor());
            stmt.setString(4, skate.getMarca());
            stmt.setString(5, skate.getTipoRodas());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    System.out.println("Skate inserido com sucesso! ID gerado: " + idGerado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir skate: " + e.getMessage());
        }
    }

    /*
     * Método estático para atualizar um skate no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void atualizar(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID do skate a ser atualizado: ");
        int idAtualizar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        System.out.println("Atualize os dados do skate:");

        Skate skate = new Skate();

        System.out.print("Modelo: ");
        skate.setModelo(scanner.nextLine());

        System.out.print("Ano de Fabricação: ");
        skate.setAnoFabricacao(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cor: ");
        skate.setCor(scanner.nextLine());

        System.out.print("Marca: ");
        skate.setMarca(scanner.nextLine());

        System.out.print("Tipo de Rodas: ");
        skate.setTipoRodas(scanner.nextLine());

        // Comando SQL para atualizar o veículo no banco de dados.
        String sqlAtualizar = "UPDATE skate SET modelo = ?, ano_fabricacao = ?, cor = ?, marca = ?, tipo_rodas = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar)) {
            stmt.setString(1, skate.getModelo());
            stmt.setInt(2, skate.getAnoFabricacao());
            stmt.setString(3, skate.getCor());
            stmt.setString(4, skate.getMarca());
            stmt.setString(5, skate.getTipoRodas());
            stmt.setInt(6, idAtualizar);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Skate atualizado com sucesso.");
            } else {
                System.out.println("Nenhum skate encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar skate: " + e.getMessage());
        }
    }

    /*
     * Método estático para deletar um skate no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void deletar(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID do skate a ser deletado: ");
        int idDeletar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para deletar o veículo no banco de dados.
        String sqlDeletar = "DELETE FROM skate WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlDeletar)) {
            stmt.setInt(1, idDeletar);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Skate deletado com sucesso.");
            } else {
                System.out.println("Nenhum skate encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar skate: " + e.getMessage());
        }
    }

    /*
     * Método estático para ler um skate no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void ler(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID do skate a ser consultado: ");
        int idConsultar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para buscar o veículo no banco de dados.
        String sqlConsultar = "SELECT id, modelo, ano_fabricacao, cor, marca, tipo_rodas FROM skate WHERE id = ?";
        
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
                String tipoRodas = rs.getString("tipo_rodas");

                // Exibe os dados do produto
                System.out.println("ID: " + id + ", Modelo: " + modelo + ", Ano de Fabricação: " + anoFabricacao + ", Cor: " + cor + ", Marca: " + marca + ", Tipo de Rodas: " + tipoRodas);
            } else {
                System.out.println("Nenhum skate encontrado com o ID fornecido.");
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
