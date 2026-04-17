public static void main(String[] args) {
    ContaBanco conta1 = new ContaBanco(false,0f);

    separador();
    System.out.println("BANCO");
    System.out.println("Faça seu cadastro: ");
    System.out.println("Digite o número da sua conta: ");
    int numConta = conta1.sc.nextInt();
    System.out.println("Digite o tipo de conta (Corrente ou Poupança): ");
    String tipoConta = conta1.sc.next().toLowerCase().trim();
    System.out.println("Digite seu nome: ");
    String nomeDono = conta1.sc.next();

    // settar o scanner no banco

    conta1.setNumConta(numConta);
    conta1.setTipo(tipoConta);
    conta1.setDono(nomeDono);

    // abrir conta
    conta1.abrirConta(tipoConta);

    // mostrar se a pessoa quer depositar ou sacar e mostrar o saldo
    int opcao = 0;
    while (opcao!=4){
        conta1.painelBanco();
        System.out.println("Insira a opção que você deseja: ");
        opcao = conta1.sc.nextInt();

        switch (opcao){
            case 1:
                separador();
                conta1.depositar();
                break;
            case 2:
                separador();
                conta1.sacar();
                break;
            case 3:
                separador();
                conta1.pagarMensal();
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            case 5:
                separador();
                String resultado = conta1.fecharConta();
                System.out.println(resultado);
                if (resultado.equals("A conta foi fechada!")){
                    opcao = 4;
                }
                break;
            default:
                System.out.println("Opção Inválida!");
        }
    }
}

public static void separador(){
    System.out.println("===============================================================");
}