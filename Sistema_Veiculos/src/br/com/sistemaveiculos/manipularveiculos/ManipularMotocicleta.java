package br.com.sistemaveiculos.manipularveiculos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.sistemaveiculos.model.Motocicleta;

/*
 * Classe específica para manipular os dados da motocicleta.
 * A classe abriga os métodos CRUD responsáveis por executar
 * os comandos SQL no banco de dados.
 */
public class ManipularMotocicleta {

    /*
     * Método estático para Inserir uma motocicleta no banco
     * de dados, através do comando "PreparedStatement".
     */
	public static void inserir(Scanner scanner, Connection conexao) {
        System.out.println("Insira os dados da motocicleta:");

        Motocicleta motocicleta = new Motocicleta();

        System.out.print("Modelo: ");
        motocicleta.setModelo(scanner.nextLine());

        System.out.print("Ano de Fabricação: ");
        motocicleta.setAnoFabricacao(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cor: ");
        motocicleta.setCor(scanner.nextLine());

        System.out.print("Montadora: ");
        motocicleta.setMontadora(scanner.nextLine());

        System.out.print("Km Odômetro: ");
        motocicleta.setKmOdometro(scanner.nextDouble());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cilindradas: ");
        motocicleta.setCilindradas(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Torque: ");
        motocicleta.setTorque(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para inserir o veículo no banco de dados.
        String sqlInserir = "INSERT INTO motocicleta (modelo, ano_fabricacao, cor, montadora, km_odometro, cilindrada, torque) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlInserir, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, motocicleta.getModelo());
            stmt.setInt(2, motocicleta.getAnoFabricacao());
            stmt.setString(3, motocicleta.getCor());
            stmt.setString(4, motocicleta.getMontadora());
            stmt.setDouble(5, motocicleta.getKmOdometro());
            stmt.setInt(6, motocicleta.getCilindradas());
            stmt.setInt(7, motocicleta.getTorque());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    System.out.println("Motocicleta inserida com sucesso. ID: " + generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir motocicleta: " + e.getMessage());
        }
    }

    /*
     * Método estático para atualizar uma motocicleta no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void atualizar(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID da motocicleta a ser atualizada: ");
        int idAtualizar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        System.out.println("Atualize os dados da motocicleta:");

        Motocicleta motocicleta = new Motocicleta();

        System.out.print("Modelo: ");
        motocicleta.setModelo(scanner.nextLine());

        System.out.print("Ano de Fabricação: ");
        motocicleta.setAnoFabricacao(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cor: ");
        motocicleta.setCor(scanner.nextLine());

        System.out.print("Montadora: ");
        motocicleta.setMontadora(scanner.nextLine());

        System.out.print("Km Odômetro: ");
        motocicleta.setKmOdometro(scanner.nextDouble());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Cilindradas: ");
        motocicleta.setCilindradas(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        System.out.print("Torque: ");
        motocicleta.setTorque(scanner.nextInt());
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para atualizar o veículo no banco de dados.
        String sqlAtualizar = "UPDATE motocicleta SET modelo = ?, ano_fabricacao = ?, cor = ?, montadora = ?, km_odometro = ?, cilindrada = ?, torque = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlAtualizar)) {
            stmt.setString(1, motocicleta.getModelo());
            stmt.setInt(2, motocicleta.getAnoFabricacao());
            stmt.setString(3, motocicleta.getCor());
            stmt.setString(4, motocicleta.getMontadora());
            stmt.setDouble(5, motocicleta.getKmOdometro());
            stmt.setInt(6, motocicleta.getCilindradas());
            stmt.setInt(7, motocicleta.getTorque());
            stmt.setInt(8, idAtualizar);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Motocicleta atualizada com sucesso.");
            } else {
                System.out.println("Nenhuma motocicleta encontrada com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar motocicleta: " + e.getMessage());
        }
    }

    /*
     * Método estático para deletar uma motocicleta no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void deletar(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID da motocicleta a ser deletada: ");
        int idDeletar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para deletar o veículo no banco de dados.
        String sqlDeletar = "DELETE FROM motocicleta WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sqlDeletar)) {
            stmt.setInt(1, idDeletar);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Motocicleta deletada com sucesso.");
            } else {
                System.out.println("Nenhuma motocicleta encontrada com o ID fornecido.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar motocicleta: " + e.getMessage());
        }
    }

    /*
     * Método estático para ler uma motocicleta no banco
     * de dados, através do método "PreparedStatement".
     */
    public static void ler(Scanner scanner, Connection conexao) {
        System.out.print("Informe o ID da motocicleta a ser consultada: ");
        int idConsultar = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer.

        // Comando SQL para buscar o veículo no banco de dados.
        String sqlConsultar = "SELECT id, modelo, ano_fabricacao, cor, montadora, km_odometro, cilindrada, torque FROM motocicleta WHERE id = ?";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlConsultar);
            stmt.setInt(1, idConsultar); // Limpar o buffer.

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
                int cilindradas = rs.getInt("cilindradas");
                int torque = rs.getInt("torque");

                // Exibe os dados do produto
                System.out.println("ID: " + id + ", Modelo: " + modelo + ", Ano de Fabricação: " + anoFabricacao + ", Cor: " + cor + ", Montadora: " + montadora + ", KM Odômetro: " + kmOdometro + ", Cilindradas: " + cilindradas + ", Torque: " + torque);
            } else {
                System.out.println("Nenhuma motocicleta encontrada com o ID fornecido.");
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
