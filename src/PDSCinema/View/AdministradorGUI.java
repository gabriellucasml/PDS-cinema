package PDSCinema.View;

import PDSCinema.Controller.AdministradorController;
import PDSCinema.model.Cupom;
import PDSCinema.model.Show;
import PDSCinema.model.Premio;
import PDSCinema.repository.EvMusicalRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class AdministradorGUI {

    public AdministradorGUI(){
        AdministradorController administradorController = new AdministradorController();
        Scanner in = new Scanner(System.in);
        System.out.println("Seja bem vindo ADM");
        int op = 99;
        do{

            System.out.println("O que deseja fazer?");
            System.out.println("1 - Inserir Show");
            System.out.println("2 - Buscar Show");
            System.out.println("4 - Remover Show");
            System.out.println("5 - Inserir Cupom");
            System.out.println("6 - Buscar Cupons");
            System.out.println("7 - Remover Cupom");
            System.out.println("8 - Inserir Premio");
            System.out.println("9 - Buscar Premio");
            System.out.println("10 - Remover Premio");
            System.out.println("11 - Sair");
            String Sop = in.nextLine();
            if(!Sop.isEmpty())
                op = Integer.parseInt(Sop);
            String name, atracaoMusical, data, status;

            int codigoPremio = 0, duracao = 0, condicaoPremio = 0;
            double tipoCupom = 0;
            switch (op){
                case 1:
                    int sel = 1;
                    do {
                        System.out.println("Digite o nome do show: ");
                        nome = in.nextLine();
                        System.out.println("Digite a duracao do show: ");
                        String Sduracao = in.nextLine();
                        if(!Sduracao.isEmpty())
                            duracao = Integer.parseInt(Sduracao);
                        System.out.println("Digite a atração Musical: ");
                        atracaoMusical = in.nextLine();
                        System.out.println("Digite a data:");
                        data = in.nextLine();
                        status = administradorController.cadastrarEvento(name,
                                duracao, atracaoMusical, data);
                        System.out.println(status);
                        System.out.println("Deseja continuar cadastrando outros shows?\n0 - não\n1 - sim");
                        String Ssel = in.nextLine();
                        if(!Ssel.isEmpty())
                            sel = Integer.parseInt(Ssel);
                        if(sel == 0) {
                            break;
                        }
                    }while(sel == 1);
                    break;
                case 2:
                    System.out.println("Digite o nome do show:");
                    nome = in.nextLine();
                    Show show = (Show) administradorController.buscarEvento(nome);
                    if(filme != null){
                        System.out.println("Informações encontradas:");
                        System.out.println("Nome: " + show.getName());
                        System.out.println("Duração do filme: " + show.getDuracao()+"min");
                        System.out.println("Atração Musical: " + show.getAtracaoMusical());
                        System.out.println("Data: " + show.getData());
                    }else{
                        System.out.println("Show não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do show:");
                    String nomeShow = in.nextLine();
                    Show f = (Show) administradorController.buscarEvento(nomeShow);
                    status = administradorController.removerEvento(f);
                    System.out.println(status);
                    break;
                case 5:
                    System.out.print("Código do cupom: ");
                    String nomeCupom = in.nextLine();
                    System.out.print("Valor do desconto: ");
                    String StipoCupom = in.nextLine();
                    if(!StipoCupom.isEmpty())
                        tipoCupom = Double.parseDouble(StipoCupom);
                    status = administradorController.cadastrarCupons(nomeCupom, tipoCupom);
                    System.out.println(status);
                    break;
                case 6:
                    System.out.print("Código do cupom: ");
                    nomeCupom = in.nextLine();
                    Cupom cupom = administradorController.buscarCupons(nomeCupom);
                    if(cupom != null) {
                        System.out.println("Código do cupom: " + cupom.getCodigo());
                        System.out.println("Valor de desconto: R$" + cupom.getTipoDeCupom());
                    }else{
                        System.out.println("Cupom não encontrado.");
                    }
                    break;
                case 7:
                    System.out.print("Código do cupom: ");
                    nomeCupom = in.nextLine();
                    cupom = administradorController.buscarCupons(nomeCupom);
                    if(cupom != null) {
                        System.out.println(administradorController.removerCupons(cupom));
                    }else{
                        System.out.println("Cupom não cadastrado.");
                    }
                    break;
                case 8:
                    System.out.println("Código do prêmio:");
                    String ScodigoPremio = in.nextLine();
                    if(!ScodigoPremio.isEmpty())
                        codigoPremio = Integer.parseInt(ScodigoPremio);
                    System.out.println("Descrição do prêmio: ");
                    String descricaoPremio = in.nextLine();
                    System.out.println("Condição: ");
                    String ScondicaoPremio = in.nextLine();
                    if(!ScondicaoPremio.isEmpty()){
                        condicaoPremio = Integer.parseInt(ScondicaoPremio);
                    }
                    status = administradorController.cadastrarPremios(descricaoPremio, codigoPremio, condicaoPremio);
                    System.out.println(status);
                    break;
                case 9:
                    System.out.print("Código do prêmio: ");
                    ScodigoPremio = in.nextLine();
                    if(!ScodigoPremio.isEmpty())
                        codigoPremio = Integer.parseInt(ScodigoPremio);
                    Premio premio = administradorController.buscarPremio(codigoPremio);
                    if(premio != null) {
                        System.out.println("Id: " + premio.getIdPremio());
                        System.out.println("Descrição: " + premio.getDescricao());
                        System.out.println("Condição: " + premio.getCondicao());
                    }else{
                        System.out.println("Premio não encontrado.");
                    }
                    break;
                case 10:
                    System.out.print("Código do premio: ");
                    ScodigoPremio = in.nextLine();
                    if(!ScodigoPremio.isEmpty())
                        codigoPremio = Integer.parseInt(ScodigoPremio);
                    premio = administradorController.buscarPremio(codigoPremio);
                    if(premio != null) {
                        System.out.println(administradorController.removerPremios(premio));
                    }else{
                        System.out.println("Premio não cadastrado.");
                    }
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Seleção inválida!");
            }
        }while (op != 11);
    }




// precisa ter um meio de voltar pro cinema no final, por exemplo perguntar se ele quer sair
}
