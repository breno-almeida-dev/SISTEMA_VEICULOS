package br.com.sistemaveiculos.main;

import br.com.sistemaveiculos.conexao.*;
import br.com.sistemaveiculos.manipularveiculos.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * A classe Main abriga o terminal CLI que através de loops "while" e
 * blocos "switch-case" disponibilizam para o usuário a navegação entre os
 * Menus de cada método CRUD e de cada comando SQL de cada veículo.
 */
public class Main {
    public static void main(String[] args) {
    	/*
    	 * Faz a tentativa de conexão com o banco de dados e dentro
    	 * da condição "if" verifica se a conexão foi estabelecida para
    	 * então iniciar o Menu ao usuário.
    	 */
        Connection conexao = ConexaoBD.conectar();
        if(conexao != null) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                    System.out.println("\n=== Menu Principal ===");
                    System.out.println("1. Inserir Veículo");
                    System.out.println("2. Atualizar Veículo");
                    System.out.println("3. Deletar Veículo");
                    System.out.println("4. Ler Registro de Veículo");
                    System.out.println("0. Sair");
                    System.out.print("Escolha uma opção: ");

                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    /*
                     * Através do número da opção selecionada pelo usuário, o 
                     * "switch-case" faz o direcionamento para o método CRUD.
                     */
                    switch (opcao) {
                        case 1: // Inserir
                            while (true) {
                                /*
                                 * Caso seja selecionado para inrerir um veículo, um menu de
                                 * inserir cada tipo de veículo é disponibilizado ao usuário
                                 * para que ele escolha qual deseja inserir no banco de dados. 
                                 */
                                System.out.println("\n=== Menu Inserir Veículo ===");
                                System.out.println("1. Inserir Bicicleta");
                                System.out.println("2. Inserir Skate");
                                System.out.println("3. Inserir Caminhão");
                                System.out.println("4. Inserir Motocicleta");
                                System.out.println("5. Inserir Veículo Doméstico");
                                System.out.println("0. Voltar ao menu anterior.");
                                System.out.print("Escolha uma opção: ");
                                int opcaoInsert = scanner.nextInt();
                                scanner.nextLine();  // Limpar o buffer

                                /*
                                 * Após escolher qual veículo ele deseja inserir, este bloco
                                 * "switch-case" faz a chamada do método estático específico
                                 * de cada veículo. 
                                 */
                                switch (opcaoInsert) {
                                    case 1:
                                        ManipularBicicleta.inserir(scanner, conexao);
                                        break;
                                    case 2:
                                        ManipularSkate.inserir(scanner, conexao);
                                        break;
                                    case 3:
                                        ManipularCaminhao.inserir(scanner, conexao);
                                        break;
                                    case 4:
                                        ManipularMotocicleta.inserir(scanner, conexao);
                                        break;
                                    case 5:
                                        ManipularVeiculoDomestico.inserir(scanner, conexao);
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                }
                                if (opcaoInsert == 0) break; // Sai do loop de inserção
                            }
                            break;
                        case 2: // Atualizar
                            while (true) {
                                /*
                                 * Caso seja selecionado para atualizar um veículo, um menu de
                                 * atualizar cada tipo de veículo é disponibilizado ao usuário
                                 * para que ele escolha qual deseja atualizar no banco de dados. 
                                 */
                                System.out.println("\n=== Menu Atualizar Veículo ===");
                                System.out.println("1. Atualizar Bicicleta");
                                System.out.println("2. Atualizar Skate");
                                System.out.println("3. Atualizar Caminhão");
                                System.out.println("4. Atualizar Motocicleta");
                                System.out.println("5. Atualizar Veículo Doméstico");
                                System.out.println("0. Voltar ao menu anterior.");
                                System.out.print("Escolha uma opção: ");
                                int opcaoAtualizar = scanner.nextInt();
                                scanner.nextLine();  // Limpar o buffer

                                /*
                                 * Após escolher qual veículo ele deseja atualizar, este bloco
                                 * "switch-case" faz a chamada do método estático específico
                                 * de cada veículo. 
                                 */
                                switch (opcaoAtualizar) {
                                    case 1:
                                        ManipularBicicleta.atualizar(scanner, conexao);
                                        break;
                                    case 2:
                                        ManipularSkate.atualizar(scanner, conexao);
                                        break;
                                    case 3:
                                        ManipularCaminhao.atualizar(scanner, conexao);
                                        break;
                                    case 4:
                                        ManipularMotocicleta.atualizar(scanner, conexao);
                                        break;
                                    case 5:
                                        ManipularVeiculoDomestico.atualizar(scanner, conexao);
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                }
                                if (opcaoAtualizar == 0) break; // Sai do loop de atualização
                            }
                            break;
                        case 3: // Deletar
                            while (true) {
                                /*
                                 * Caso seja selecionado para deletar um veículo, um menu de
                                 * deletar cada tipo de veículo é disponibilizado ao usuário
                                 * para que ele escolha qual deseja deletar no banco de dados. 
                                 */
                                System.out.println("\n=== Menu Deletar Veículo ===");
                                System.out.println("1. Deletar Bicicleta");
                                System.out.println("2. Deletar Skate");
                                System.out.println("3. Deletar Caminhão");
                                System.out.println("4. Deletar Motocicleta");
                                System.out.println("5. Deletar Veículo Doméstico");
                                System.out.println("0. Voltar ao menu anterior.");
                                System.out.print("Escolha uma opção: ");
                                int opcaoDeletar = scanner.nextInt();
                                scanner.nextLine();  // Limpar o buffer

                                /*
                                 * Após escolher qual veículo ele deseja deletar, este bloco
                                 * "switch-case" faz a chamada do método estático específico
                                 * de cada veículo. 
                                 */
                                switch (opcaoDeletar) {
                                    case 1:
                                        ManipularBicicleta.deletar(scanner, conexao);
                                        break;
                                    case 2:
                                        ManipularSkate.deletar(scanner, conexao);
                                        break;
                                    case 3:
                                        ManipularCaminhao.deletar(scanner, conexao);
                                        break;
                                    case 4:
                                        ManipularMotocicleta.deletar(scanner, conexao);
                                        break;
                                    case 5:
                                        ManipularVeiculoDomestico.deletar(scanner, conexao);
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                }
                                if (opcaoDeletar == 0) break; // Sai do loop de deletação
                            }
                            break;
                        case 4: // Ler
                            while (true) {
                                /*
                                 * Caso seja selecionado para ler um veículo, um menu de
                                 * ler cada tipo de veículo é disponibilizado ao usuário
                                 * para que ele escolha qual deseja ler no banco de dados. 
                                 */
                                System.out.println("\n=== Menu Ler Registro de Veículo ===");
                                System.out.println("1. Ler Registro de Bicicleta");
                                System.out.println("2. Ler Registro de Skate");
                                System.out.println("3. Ler Registro de Caminhão");
                                System.out.println("4. Ler Registro de Motocicleta");
                                System.out.println("5. Ler Registro de Veículo Doméstico");
                                System.out.println("0. Voltar ao menu anterior.");
                                System.out.print("Escolha uma opção: ");
                                int opcaoLerRegistro = scanner.nextInt();
                                scanner.nextLine();  // Limpar o buffer

                                /*
                                 * Após escolher qual veículo ele deseja ler, este bloco
                                 * "switch-case" faz a chamada do método estático específico
                                 * de cada veículo. 
                                 */
                                switch (opcaoLerRegistro) {
                                    case 1:
                                        ManipularBicicleta.ler(scanner, conexao);
                                        break;
                                    case 2:
                                        ManipularSkate.ler(scanner, conexao);
                                        break;
                                    case 3:
                                        ManipularCaminhao.ler(scanner, conexao);
                                        break;
                                    case 4:
                                        ManipularMotocicleta.ler(scanner, conexao);
                                        break;
                                    case 5:
                                        ManipularVeiculoDomestico.ler(scanner, conexao);
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                }
                                if (opcaoLerRegistro == 0) break; // Sai do loop de leitura
                            }
                            break;
                        case 0:
                        	/*
                        	 * Caso o usuário opte por sair do Menu, a conexão é
                        	 * encerrada, o scanner é fechado e assim finaliza o loop.
                        	 */
                            System.out.println("Saindo...");
                            try {
                                conexao.close(); // Fecha a conexão com o banco de dados
                            } catch (SQLException e) {
                                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                            }
                            scanner.close();
                            return;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número.");
                    scanner.nextLine(); // Limpar o buffer
                }
            }
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    }
}