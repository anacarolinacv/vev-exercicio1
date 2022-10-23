package ex2;

import java.util.Scanner;

public class Main {

    private static String exibirMenu() {
        String menu = "\n(C)alcula Salario" + System.lineSeparator() +
                      "(R)etorna Salario Do Funcionario" + System.lineSeparator() +
                      "Opção> ";

        return menu;
    }

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        String entrada;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(exibirMenu());
            entrada = sc.nextLine().toUpperCase();


            switch (entrada) {

                case "C":
                    calculaSalario(calculadora);
                    break;
                case "R":
                    retornaSalario(calculadora);
                    break;
                case "S":
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }
        } while (!entrada.equals("S"));

    }

    private static void calculaSalario(Calculadora calculadora) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Salario Base: ");
        String salarioBase = sc.nextLine();

        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        calculadora.calculaSalario(cpf, nome, email, salarioBase, cargo);
        System.out.println("CALCULO REALIZADO!");
        System.out.println(calculadora.retornaSalarioFuncionario(cpf));
    }

    private static void retornaSalario(Calculadora calculadora) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        System.out.print("CPF: ");
        String cpf = sc.nextLine();


        System.out.println("SALARIO RETORNADO!");
        System.out.println(calculadora.retornaSalarioFuncionario(cpf));
    }


}
