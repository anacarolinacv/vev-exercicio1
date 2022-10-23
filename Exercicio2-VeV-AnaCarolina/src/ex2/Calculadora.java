package ex2;

import java.util.ArrayList;
import java.util.HashMap;

public class Calculadora {

    private HashMap<String, Double> salarios;
    private ArrayList<Funcionario> funcionarios;

    public Calculadora() {
        this.salarios= new HashMap<>();
        this.funcionarios = new ArrayList<>();
    }

    public boolean calculaSalario(String cpf, String nome, String email, String salarioBase, String cargo) {
        double salario;
        boolean saida = false;
        switch (cargo.toUpperCase()) {

            case "DESENVOLVEDOR":
                saida = true;
                salario = calculaSalarioDesenvolvedor(salarioBase);
                this.salarios.put(cpf, salario);
                this.funcionarios.add(new Funcionario(cpf, nome, email, salario, cargo));
                retornaSalarioFuncionario(cpf);
                break;

            case "DBA":
                saida = true;
                salario = calculaSalarioDBA(salarioBase);
                this.salarios.put(cpf, salario);
                this.funcionarios.add(new Funcionario(cpf, nome, email, salario, cargo));
                retornaSalarioFuncionario(cpf);
                break;

            case "TESTADOR":
                saida = true;
                salario = calculaSalarioTestador(salarioBase);
                this.salarios.put(cpf, salario);
                this.funcionarios.add(new Funcionario(cpf, nome, email, salario, cargo));
                retornaSalarioFuncionario(cpf);
                break;

            case "GERENTE":
                saida = true;
                salario = calculaSalarioGerente(salarioBase);
                this.salarios.put(cpf, salario);
                this.funcionarios.add(new Funcionario(cpf, nome, email, salario, cargo));
                retornaSalarioFuncionario(cpf);
                break;
        }
        return saida;
    }

    public String retornaSalarioFuncionario(String cpf) {
        String salario = "";
        if(this.salarios.containsKey(cpf)){
            salario = String.valueOf(this.salarios.get(cpf));
        } else {
            throw new NullPointerException("Erro no retorno do salario: funcionario nao existe.");
        }

        return salario.substring(0, 7);
    }

    private double calculaSalarioDesenvolvedor(String salario) {
        double salarioConvertido = Double.parseDouble(salario);
        if( salarioConvertido >= 3000.0) {
            salarioConvertido = salarioConvertido * 0.8;
        } else {
            salarioConvertido = salarioConvertido * 0.9;
        }

        return salarioConvertido;
    }

    private double calculaSalarioDBA(String salario) {
        double salarioConvertido = Double.parseDouble(salario);
        if( salarioConvertido >= 2000.0) {
            salarioConvertido = salarioConvertido * 0.75;
        } else {
            salarioConvertido = salarioConvertido * 0.85;
        }

        return salarioConvertido;
    }

    private double calculaSalarioTestador(String salario) {
        double salarioConvertido = Double.parseDouble(salario);
        if( salarioConvertido >= 2000.0) {
            salarioConvertido = salarioConvertido * 0.75;
        } else {
            salarioConvertido = salarioConvertido * 0.85;
        }

        return salarioConvertido;
    }

    private double calculaSalarioGerente(String salario) {
        double salarioConvertido = Double.parseDouble(salario);
        if(salarioConvertido>= 5000.0) {
            salarioConvertido= salarioConvertido * 0.70;
        } else {
            salarioConvertido = salarioConvertido * 0.80;
        }

        return salarioConvertido;
    }

    public int getSizeFuncionarios() {
        return this.funcionarios.size();
    }

    public int getSizeSalarios() {
        return this.salarios.size();
    }
}
