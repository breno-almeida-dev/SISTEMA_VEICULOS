package br.com.sistemaveiculos.manipularveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.sistemaveiculos.model.Caminhao;

/*
 * Classe específica para manipular os dados do caminhão.
 * A classe abriga os métodos CRUD responsáveis por executar
 * os comandos SQL no banco de dados.
 */
public class ManipularCaminhao {

    /*
     * Método estático para Inserir um caminhão no banco
     * de dados, através do comando "PreparedStatement".
     */
    public static void inserir(Scanner scanner, Connection conexao) {
        System.out.println("Insira os dados do caminhão:");

        Caminhao caminhao = new Caminhao();

        System.out.print("Modelo: ");
        caminhao.setModelo(scanner.nextLine());

        System.out.print("Ano de Fabricação: ");
        caminhao.setAnoFabricacao(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cor: ");
        caminhao.setCor(scanner.nextLine());

        System.out.print("Montadora: ");
        caminhao.setMontadora(scanner.nextLine());

        System.out.print("Km Odômetro: ");
        caminhao.setKmOdometro(scanner.nextDouble());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Eixos: ");
        caminhao.setEixos(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Peso Bruto: ");
        caminhao.setPesoBruto(scanner.nextDouble());
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para inserir o veículo no banco de dados.
        String sqlInserir = "INSERT INTO caminhao (modelo, ano_fabricacao, cor, montadora, km_odometro, eixos, peso_bruto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, caminhao.getModelo());
            stmt.setInt(2, caminhao.getAnoFabricacao());
            stmt.setString(3, caminhao.getCor());
            stmt.setString(4, caminhao.getMontadora());
            stmt.setDouble(5, caminhao.getKmOdometro());
            stmt.setInt(6, caminhao.getEixos());
            stmt.setDouble(7, caminhao.getPesoBruto());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    System.out.println("Caminhão inserido com sucesso! ID gerado: " + idGerado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir caminhão: " + e.getMessage());
        }
    }

    /*
     * Método estático para atualizar um caminhão no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void atualizar(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID do caminhão a ser atualizado: ");
        int idAtualizar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        System.out.println("Atualize os dados do caminhão:");

        Caminhao caminhao = new Caminhao();

        System.out.print("Modelo: ");
        caminhao.setModelo(scanner.nextLine());

        System.out.print("Ano de Fabricação: ");
        caminhao.setAnoFabricacao(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cor: ");
        caminhao.setCor(scanner.nextLine());

        System.out.print("Montadora: ");
        caminhao.setMontadora(scanner.nextLine());

        System.out.print("Km Odômetro: ");
        caminhao.setKmOdometro(scanner.nextDouble());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Eixos: ");
        caminhao.setEixos(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Peso Bruto: ");
        caminhao.setPesoBruto(scanner.nextDouble());
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para atualizar o veículo no banco de dados.
        String sqlAtualizar = "UPDATE caminhao SET modelo = ?, ano_fabricacao = ?, cor = ?, montadora = ?, km_odometro = ?, eixos = ?, peso_bruto = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar)) {
            stmt.setString(1, caminhao.getModelo());
            stmt.setInt(2, caminhao.getAnoFabricacao());
            stmt.setString(3, caminhao.getCor());
            stmt.setString(4, caminhao.getMontadora());
            stmt.setDouble(5, caminhao.getKmOdometro());
            stmt.setInt(6, caminhao.getEixos());
            stmt.setDouble(7, caminhao.getPesoBruto());
            stmt.setInt(8, idAtualizar);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Caminhão atualizado com sucesso.");
            } else {
                System.out.println("Nenhum caminhão encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar caminhão: " + e.getMessage());
        }
    }

    /*
     * Método estático para deletar um caminhão no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void deletar(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID do caminhão a ser deletado: ");
        int idDeletar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para deletar o veículo no banco de dados.
        String sqlDeletar = "DELETE FROM caminhao WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlDeletar)) {
            stmt.setInt(1, idDeletar);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Caminhão deletado com sucesso.");
            } else {
                System.out.println("Nenhum caminhão encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar caminhão: " + e.getMessage());
        }
    }

    /*
     * Método estático para ler um caminhão no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void ler(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID do caminhão a ser consultado: ");
        int idConsultar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para buscar o veículo no banco de dados.
        String sqlConsultar = "SELECT id, modelo, ano_fabricacao, cor, montadora, km_odometro, eixos, peso_bruto FROM caminhao WHERE id = ?";
        
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
                String montadora = rs.getString("montadora");
                double kmOdometro = rs.getDouble("km_odometro");
                int eixos = rs.getInt("eixos");
                double pesoBruto = rs.getDouble("peso_bruto");

                // Exibe os dados do produto
                System.out.println("ID: " + id + ", Modelo: " + modelo + ", Ano de Fabricação: " + anoFabricacao + ", Cor: " + cor + ", Montadora: " + montadora + ", KM Odômetro: " + kmOdometro + ", Eixos: " + eixos + ", Peso Bruto: " + pesoBruto);
            } else {
                System.out.println("Nenhum caminhão encontrado com o ID fornecido.");
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
