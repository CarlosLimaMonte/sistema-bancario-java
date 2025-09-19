package sistema.bancario.simples;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Conta c1 = null;
        int op = 0;
        do{
            System.out.println("Bem vindo! Ao sistema do banco, o que o senhor deseja fazer?");
            System.out.println("1 - Criar conta | 2 - Consultar | 3 - Depositar | 4 - Sacar | 5 - Sair");
            op = scanner.nextInt();
            scanner.nextLine();
            if (op == 1){
                System.out.print("Digite seu nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite sua senha: ");
                int senha = scanner.nextInt();
                c1 = new Conta (nome, 0, senha);
                System.out.println("Conta criada com sucesso!");
            }else if(op == 2){
                if (c1 == null){
                    System.out.println("Nenhuma conta foi criada ainda!");
                }else {
                    System.out.println("Sua conta tem o valor de: " + c1.getSaldo());
                }
            }else if(op == 3) {
                System.out.print("Digite o valor que deseja depositar: ");
                double depositoValor = scanner.nextDouble();
                System.out.print("Digite sua senha: ");
                int senhaDeposito = scanner.nextInt();
                while (c1.autenticar(senhaDeposito) == false) {
                    System.out.print("Senha incorreta! Repita novamente: ");
                    senhaDeposito = scanner.nextInt();
                }
                System.out.println(c1.Depositar(depositoValor));
            }else if(op == 4){
                System.out.print("Digite o valor que deseja sacar: ");
                double sacarValor = scanner.nextDouble();
                System.out.println("Digite sua senha: ");
                int senhaSacar = scanner.nextInt();
                while (c1.autenticar(senhaSacar) == false){
                    System.out.print("Senha incorreta! Repita novamente: ");
                    senhaSacar = scanner.nextInt();
                }
                while (c1.getSaldo() < sacarValor){
                    System.out.print("Valor superior ao seu saldo, seu saldo é: " + c1.getSaldo() + "insira um novo valor: ");
                    sacarValor = scanner.nextDouble();
                }
                System.out.println(c1.Sacar(sacarValor));
            }
        }while (op != 5);
    }
}
