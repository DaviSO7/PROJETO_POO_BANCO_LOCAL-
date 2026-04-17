import java.util.Scanner;

/* Anotações: tipo conta: Poupança ou Corrente
 * Abrir conta: retorna status como verdadeiro, abrindo com conta corrente ganha 50$ na conta se for poupança 150$
 * Fechar Conta: não pode fechar se tiver dinheiro dentro ou se estiver devendo
 * Depositar: status tem que ser verdadeiro
 * Sacar: status tem que ser verdadeiro e tenho que ter saldo na conta
 * pagar mensalidade: corrente: 12$, poupança:20$
 */
public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    public Scanner sc = new Scanner(System.in);

    public void abrirConta(String tipoDeConta){
        if (this.tipo.equals("corrente")){
            this.status = true;
            this.saldo = 50f;
        }
        else if (this.tipo.equals("poupança")){
            this.status = true;
            this.saldo = 150f;
        }
        else{
            System.out.println("Tipo de conta inválido!");
            this.status = false;
        }
    }

    public String fecharConta(){
        if (this.saldo != 0){
          return "A conta não pode ser fechada!";
        }
        else {
            this.status = false;
            return "A conta foi fechada!";
        }
    }

    public void depositar(){
        if (this.status == true){
            System.out.println("Insira o valor que deseja depositar: ");
            float novoSaldo = sc.nextFloat();
            this.saldo += novoSaldo;
            System.out.println("Depósito concluído com êxito!");
        }
        else if (this.status == false){
            System.out.println("Não existe uma conta criada!");
        }
    }

    public void sacar(){
        System.out.println("Insira o valor que deseja sacar: ");
        float valorSaque = sc.nextFloat();
        if (this.status == true && this.saldo >= valorSaque){
            this.saldo -= valorSaque;
            System.out.println("Retirada concluída com êxito!");
        }
        else{
            System.out.println("Você não tem saldo suficiente para fazer esta retirada!");
        }
    }

    public void pagarMensal(){
        if (this.tipo.equals("corrente")){
            System.out.println("A mensalidade de R$12,00 será descontada de sua conta!");
            this.saldo -= 12;
        }
        else if (this.tipo.equals("poupança")){
            System.out.println("A mensalidade de R$20,00 será descontada de sua conta!");
            this.saldo -= 20;
        }
        else {
            System.out.println("Erro");
        }
    }

    public void painelBanco(){
        System.out.println("===============================================================");
        System.out.println("PAINEL BANCO");
        System.out.printf("Bem vindo %s! \n", this.dono);
        System.out.printf("Saldo atual: R$%.2f \n", this.saldo);
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3- Pagar mensalidade");
        System.out.println("4- Sair");
        System.out.println("5- Fechar Conta");
    }


    // Getters e setters

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    // Construtor

    public ContaBanco(boolean status, float saldo) {
        this.status = status;
        this.saldo = saldo;
    }
}



