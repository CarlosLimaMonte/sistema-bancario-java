package sistema.bancario.simples;

public class Conta {
    private String titular;
    private double saldo;
    private int senha;

    public Conta(String titular, double saldo, int senha){
        this.titular = titular;
        this.saldo = saldo;
        this.senha = senha;
    }
    public String getTitular(){
        return this.titular;
    }

    public double getSaldo(){
        return this.saldo;
    }
    public String Depositar(double valor){
        this.saldo += valor;
        return "Depositado com sucesso!";
    }
    public String Sacar(double valor){
        this.saldo -= valor;
        return "Valor de " + valor + "sacado com sucesso!";
    }
    public boolean autenticar(int senha){
        return this.senha == senha;
    }


}
