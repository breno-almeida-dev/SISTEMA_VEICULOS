package br.com.sistemaveiculos.manipularveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.sistemaveiculos.model.VeiculoDomestico;

/*
 * Classe específica para manipular os dados do veículo doméstico.
 * A classe abriga os métodos CRUD responsáveis por executar
 * os comandos SQL no banco de dados.
 */
public class ManipularVeiculoDomestico {

    /*
     * Método estático para Inserir um veículo doméstico no banco
     * de dados, através do comando "PreparedStatement".
     */
    public static void inserir(Scanner scanner, Connection conexao) {
        System.out.println("Insira os dados do veículo doméstico:");

        VeiculoDomestico veiculoDomestico = new VeiculoDomestico();

        System.out.print("Modelo: ");
        veiculoDomestico.setModelo(scanner.nextLine());

        System.out.print("Ano de Fabricação: ");
        veiculoDomestico.setAnoFabricacao(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cor: ");
        veiculoDomestico.setCor(scanner.nextLine());

        System.out.print("Montadora: ");
        veiculoDomestico.setMontadora(scanner.nextLine());

        System.out.print("Km Odômetro: ");
        veiculoDomestico.setKmOdometro(scanner.nextDouble());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Máximo de Passageiros: ");
        veiculoDomestico.setMaxPassageiros(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Tipo de Freio: ");
        veiculoDomestico.setTipoFreio(scanner.nextLine());

        System.out.print("Airbag (Sim/Não): ");
        veiculoDomestico.setAirbag(scanner.nextLine());

        // Comando SQL para inserir o veículo no banco de dados.
        String sqlInserir = "INSERT INTO veiculo_domestico (modelo, ano_fabricacao, cor, montadora, km_odometro, max_passageiros, tipo_freio, airbag) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, veiculoDomestico.getModelo());
            stmt.setInt(2, veiculoDomestico.getAnoFabricacao());
            stmt.setString(3, veiculoDomestico.getCor());
            stmt.setString(4, veiculoDomestico.getMontadora());
            stmt.setDouble(5, veiculoDomestico.getKmOdometro());
            stmt.setInt(6, veiculoDomestico.getMaxPassageiros());
            stmt.setString(7, veiculoDomestico.getTipoFreio());
            stmt.setString(8, veiculoDomestico.getAirbag());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    System.out.println("Veículo doméstico inserido com sucesso! ID gerado: " + idGerado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir veículo doméstico: " + e.getMessage());
        }
    }

    /*
     * Método estático para atualizar um veículo doméstico no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void atualizar(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID do veículo doméstico a ser atualizado: ");
        int idAtualizar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        System.out.println("Atualize os dados do veículo doméstico:");

        VeiculoDomestico veiculoDomestico = new VeiculoDomestico();

        System.out.print("Modelo: ");
        veiculoDomestico.setModelo(scanner.nextLine());

        System.out.print("Ano de Fabricação: ");
        veiculoDomestico.setAnoFabricacao(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cor: ");
        veiculoDomestico.setCor(scanner.nextLine());

        System.out.print("Montadora: ");
        veiculoDomestico.setMontadora(scanner.nextLine());

        System.out.print("Km Odômetro: ");
        veiculoDomestico.setKmOdometro(scanner.nextDouble());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Máximo de Passageiros: ");
        veiculoDomestico.setMaxPassageiros(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Tipo de Freio: ");
        veiculoDomestico.setTipoFreio(scanner.nextLine());

        System.out.print("Airbag (Sim/Não): ");
        veiculoDomestico.setAirbag(scanner.nextLine());

        // Comando SQL para atualizar o veículo no banco de dados.
        String sqlAtualizar = "UPDATE veiculo_domestico SET modelo = ?, ano_fabricacao = ?, cor = ?, montadora = ?, km_odometro = ?, max_passageiros = ?, tipo_freio = ?, airbag = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar)) {
            stmt.setString(1, veiculoDomestico.getModelo());
            stmt.setInt(2, veiculoDomestico.getAnoFabricacao());
            stmt.setString(3, veiculoDomestico.getCor());
            stmt.setString(4, veiculoDomestico.getMontadora());
            stmt.setDouble(5, veiculoDomestico.getKmOdometro());
            stmt.setInt(6, veiculoDomestico.getMaxPassageiros());
            stmt.setString(7, veiculoDomestico.getTipoFreio());
            stmt.setString(8, veiculoDomestico.getAirbag());
            stmt.setInt(9, idAtualizar);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Veículo doméstico atualizado com sucesso.");
            } else {
                System.out.println("Nenhum veículo doméstico encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar veículo doméstico: " + e.getMessage());
        }
    }

    /*
     * Método estático para deletar um veículo doméstico no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void deletar(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID do veículo doméstico a ser deletado: ");
        int idDeletar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para deletar o veículo no banco de dados.
        String sqlDeletar = "DELETE FROM veiculo_domestico WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlDeletar)) {
            stmt.setInt(1, idDeletar);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Veículo doméstico deletado com sucesso.");
            } else {
                System.out.println("Nenhum veículo doméstico encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar veículo doméstico: " + e.getMessage());
        }
    }

    /*
     * Método estático para ler um veículo doméstico no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void ler(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID do veículo doméstico a ser consultado: ");
        int idConsultar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para buscar o veículo no banco de dados.
        String sqlConsultar = "SELECT id, modelo, ano_fabricacao, cor, montadora, km_odometro, max_passageiros, tipo_freio, airbag FROM veiculo_domestico WHERE id = ?";

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
                int maxPassageiros = rs.getInt("max_passageiros");
                String tipoFreio = rs.getString("tipo_freio");
                String airbag = rs.getString("airbag");

                // Exibe os dados do produto
                System.out.println("ID: " + id + ", Modelo: " + modelo + ", Ano de Fabricação: " + anoFabricacao + ", Cor: " + cor + ", Montadora: " + montadora + ", KM Odômetro: " + kmOdometro + ", Max Passengers: " + maxPassageiros + ", Tipo de Freio: " + tipoFreio + ", Airbag: " + airbag);
            } else {
                System.out.println("Nenhum veículo doméstico encontrado com o ID fornecido.");
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
