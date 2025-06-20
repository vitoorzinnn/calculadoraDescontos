
import java.util.ArrayList; // Importação ArrayList.
import java.util.InputMismatchException; // Importação InputMismatchException.
import java.util.Scanner; // Importação Scanner.

public class CalculadoraDescontos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Desconto> historico = new ArrayList<>(); // Array que armazena os descontos.

        while (true) { // inicia estrutura repetição;
            System.out.println("=== CALCULADORA DE DESCONTOS 3.0 ===");
            System.out.println("1. Calcular desconto");
            System.out.println("2. Ver histórico");
            System.out.println("3. Remover Desconto ");
            System.out.println("4. Limpar Histórico");
            System.out.println("5. Ver Estatistícas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = scanner.nextInt(); // Lê a opção inserida pelo usuário.
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Entrada inválida!");
                scanner.nextLine(); // Limpa o buffer
                continue;
            }

            switch (opcao) {
                case 1: // Calcular Desconto
                    try {
                        System.out.println("[NOVA COMPRA]");
                        System.out.println("Digite o valor da compra R$: ");
                        double valorCompra = scanner.nextDouble();

                        if (valorCompra <= 0) { // Verifica se o valor da compra é valido.
                            throw new DescontoInvalidoException("Valor da compra não pode ser menor que zero!");    // Se for inválido, lança a exceção.
                        }

                        scanner.nextLine(); // Limpar o buffer

                        System.out.print("Tipo de Cliente (Regular= R) ou (VIP=V): ");
                        String tipoCliente = scanner.nextLine().toUpperCase();

                        Desconto cliente;

                        if (tipoCliente.equals("V")) {  // Verifica o tipo de cliente.
                            cliente = new ClienteVIP(valorCompra); // Instancia a classe ClienteVIP.
                        } else if (tipoCliente.equals("R")) {
                            cliente = new ClienteRegular(valorCompra); // Instancia a classe ClienteRegular.
                        } else {
                            throw new DescontoInvalidoException("Tipo de Cliente inválido!"); // Se tipo de cliente for inválidp, lança a exceção.
                        }

                        cliente.calcularDesconto(); // Aplica o cálculo de desconto.

                        // exibe resultados conforme o tipo de cliente inserido pelo usuário pegando os valores com Getters.
                        System.out.println("[RESULTADO]");
                        System.out.printf("Valor original: R$ %.2f%n", cliente.getValorCompra());
                        System.out.printf("Desconto: R$ %.2f%n", cliente.getDesconto());
                        System.out.printf("Valor final: R$ %.2f%n", cliente.getValorFinal());

                        historico.add(cliente); // Adiciona os resultados no historico.

                    } catch (InputMismatchException e) {  // Tratamento para entradas inválidas ao digitar o valor da compra.
                        System.out.println("Erro: Digite um número válido!");
                        scanner.nextLine(); // Limpar entrada inválida.
                    } catch (DescontoInvalidoException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2: // Histórico
                    System.out.println("[HISTÓRICO]");
                    if (historico.isEmpty()) {
                        System.out.println("Nenhum desconto registrado.");
                    } else {
                        int i = 1;
                        // Percorre o array e informa os descontos aplicados.
                        for (Desconto d : historico) {
                            System.out.println(i + ". Desconto: R$ " + d.getDesconto() + " | Tipo: " + (d.getTipoCliente().equals("V") ? "VIP" : "Regular"));
                            i++;
                        }
                    }
                    break;

                case 3: // Remover desconto
                    System.out.print("Digite o índice do desconto para remover: ");
                    try {
                        int descontoRemover = scanner.nextInt();
                        if (descontoRemover < 1 || descontoRemover > historico.size()) {      // Verifica se o indice existe no array.
                            System.out.println("Índice inválido.");
                        } else {
                            historico.remove(descontoRemover - 1); // Remove o desconto escolhido do array.
                            System.out.println("Desconto removido com sucesso!");
                        }
                    } catch (InputMismatchException e) { // Caso o usuário digite algo que não seja número.
                        System.out.println("Erro: Digite um número válido!");
                        scanner.nextLine();
                    }
                    break;

                case 4: //  Limpar Historico
                    historico.clear(); // Limpa todo o array
                    System.out.println("Histórico Limpo!");
                    break;
                case 5: // Estatisticas
                    if (historico.isEmpty()) {
                        System.out.println("Nenhum desconto registrado!");
                    } else {
                        double totalDescontos = 0;
                        double maiorDescontos = historico.get(0).getDesconto();
                        double menorDescontos = historico.get(0).getDesconto();

                        for (int i = 0; i < historico.size(); i++) { // Percorre o historico e soma para achar o maior e menor.
                            double desconto = historico.get(i).getDesconto();
                            totalDescontos += desconto;
                            if (desconto > maiorDescontos) {
                                maiorDescontos = desconto;
                            }
                            if (desconto < menorDescontos && desconto != 0) {
                                menorDescontos = desconto;
                            }
                        }

                        double mediaDescontos = totalDescontos / historico.size(); // Calcula a média dos descontos.

                        System.out.println("[ESTATÍSTICAS]");
                        System.out.printf("Total descontos: R$ %.2f%n", totalDescontos);
                        System.out.printf("Maior desconto: R$ %.2f%n", maiorDescontos);
                        System.out.printf("Menor desconto: R$ %.2f%n", menorDescontos);
                        System.out.printf("Média: R$ %.2f%n", mediaDescontos);
                    }
                    break;
                    case 6: // Encerra o programa.
                    System.out.println("Opção escolhida (6), programa finalizado!");
                    return;

                    default: // Caso a opção seja inválida.
                    System.out.println("Opção inválida! Digite uma opção de (1 a 6)");

            }
        }
    }
}

        
    

