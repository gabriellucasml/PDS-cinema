package PDSCinema.View;

import PDSCinema.Controller.ClienteController;
import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.service.ClienteService;

import java.util.Scanner;

public class ClienteGUI {

    public ClienteGUI(Cliente cliente){
        Scanner in = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        ClienteController clienteController = new ClienteController(clienteService);
        System.out.println("Bem vindo!");
        int op;
        int codigo;
        do{
            op = 10;
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Ver shows em cartaz");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Resgatar Cupom");
            System.out.println("4 - Resgatar Premio");
            System.out.println("5 - Avaliar show");
            System.out.println("6 - Avaliar serviço");
            System.out.println("7 - Avaliar local");
            System.out.println("8 - Compartilhar Cupom");
            System.out.println("9 - Sair");
            String Sop = in.nextLine();
            if(!Sop.isEmpty())
                op = Integer.parseInt(Sop);
            switch(op){
                case 1: codigo = 1;
                        if(EvMusicalRepository.getShowsEmCartaz().size()>0){
                            System.out.println("Filmes em cartaz:");
                            for(Show f: EvMusicalRepository.getShowsEmCartaz()){
                                System.out.println("- " + f.getName() + ". Código: " + codigo);
                                codigo++;
                            }
                        }else{
                            System.out.println("Não há nenhum show em cartaz no momento.");
                        }
                        break;
                /*case 2: System.out.println("Digite o código do show que você deseja comprar: ");
                        String Scodigo = in.nextLine();
                        codigo = Integer.parseInt(Scodigo);
                        if(codigo < 0 || codigo > EvMusicalRepository.getShowsEmCartaz().size()){
                            System.out.println("Show não encontrado!");
                            break;
                        }
                        int escolhaHorario = 10;
                        int dcup = 0;
                        do{
                            System.out.println("Deseja adicionar cupom?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            String Sdcup = in.nextLine();
                            if(!Sdcup.isEmpty())
                                dcup = Integer.parseInt(Sdcup);
                            switch (dcup){
                                case 1: break;
                                case 2: break;
                                default: System.out.println("Opção inválida");
                            }
                        }while(dcup != 1 && dcup != 2);
                        IngressoEvMusical ingresso = new IngressoEvMusical();
                        ingresso.setShow(EvMusicalRepository.getShowsEmCartaz().get(codigo-1));
                        //
                        ingresso.setPreco(25);
                        if(dcup == 1){
                            int opcao = 0;
                            do{
                                System.out.println("Deseja adicionar um cupom novo ou utilizar um cupom já resgatado?");
                                System.out.println("1 - adicionar novo");
                                System.out.println("2 - utilizar cupom já resgatado");
                                String codigoCup = in.nextLine();
                                if(!codigoCup.isEmpty())
                                    opcao = Integer.parseInt(codigoCup);
                                if(cliente.getCuponsAtivos().size() != 0 || opcao == 1){
                                    switch (opcao){
                                        case 1:
                                            System.out.println("Digite o código do cupom:");
                                            codigoCup = in.nextLine();
                                            String status = clienteController.resgatarCupom(cliente, codigoCup);
                                            System.out.println(status);
                                            if(status.equals("Cupom resgatado com sucesso")){
                                                System.out.println("Preço do ingresso: R$" + (25-cliente.getCuponsAtivos().get(cliente.getCuponsAtivos().size()-1).getTipoDeCupom()));
                                                System.out.println("Digite o valor do pagamento:");
                                                String Spagamento = in.nextLine();
                                                double pagamento = 0;
                                                if(!Spagamento.isEmpty())
                                                    pagamento = Double.parseDouble(Spagamento);
                                                status = clienteController.comprarIngresso(ingresso, cliente, pagamento, cliente.getCuponsAtivos().get(cliente.getCuponsAtivos().size()-1));
                                                System.out.println(status);
                                            }
                                            break;
                                        case 2:
                                            int x = 0;
                                            for(Cupom c: cliente.getCuponsAtivos()){
                                                System.out.println(c.getCodigo() + " Código de ativação: " + x);
                                                x++;
                                            }
                                            do{
                                                dcup = -1;
                                                System.out.println("Digite o código de ativação:");
                                                codigoCup = in.nextLine();
                                                if(!codigoCup.isEmpty())
                                                    dcup = Integer.parseInt(codigoCup);
                                                if(dcup >= 0 && dcup < cliente.getCuponsAtivos().size()){
                                                    break;
                                                }
                                            }while(true);
                                            System.out.println("Preço do ingresso: R$" + (25-cliente.getCuponsAtivos().get(dcup).getTipoDeCupom()));
                                            System.out.println("Digite o valor do pagamento:");
                                            String Spagamento = in.nextLine();
                                            double pagamento = 0;
                                            if(!Spagamento.isEmpty())
                                                pagamento = Double.parseDouble(Spagamento);
                                            status = clienteController.comprarIngresso(ingresso, cliente, pagamento, cliente.getCuponsAtivos().get(dcup));
                                            System.out.println(status);
                                    }
                                }else{
                                    System.out.println("Cliente não possui cupons cadastrados");
                                }
                            }while(opcao != 1 && opcao != 2);

                            }else{
                                System.out.println("Preço do ingresso: R$" + 25);
                                System.out.println("Digite o valor do pagamento:");
                                String Spagamento = in.nextLine();
                                double pagamento = 0;
                                if(!Spagamento.isEmpty())
                                    pagamento = Double.parseDouble(Spagamento);
                                String status = clienteController.comprarIngresso(ingresso, cliente,pagamento);
                                System.out.println(status);
                            }
                        break;*/
                case 3:
                    System.out.println("Digite o código do cupom:");
                    String codigoCup = in.nextLine();
                    String status = clienteController.resgatarCupom(cliente, codigoCup);
                    System.out.println(status);
                    break;
                case 4: System.out.println("Prêmios resgatados:");
                        for(Premio p: cliente.getPremios())
                            clienteController.resgatarPremio(cliente, p.getIdPremio());
                        break;
                /*case 5: System.out.println("Digite o código do show:");
                        int codigoFilme = -1;
                        String ScodigoFilme = in.nextLine();
                        if(!ScodigoFilme.isEmpty())
                            codigoFilme = Integer.parseInt(ScodigoFilme);
                        if(codigoFilme < 0 || codigoFilme-1 >= EvMusicalRepository.getShowsEmCartaz().size()){
                            System.out.println("Código digitado não possui show cadastrado");
                        }else{
                            System.out.println("Digite a sua avaliação de 0 a 5:");
                            int avaliacao =-1;
                            ScodigoFilme = in.nextLine();
                            if(!ScodigoFilme.isEmpty())
                                avaliacao = Integer.parseInt(ScodigoFilme);
                            status = clienteController.avaliarEvento(CinemaRepository.getFilmesEmCartaz().get(codigoFilme-1), avaliacao);
                            System.out.println(status);
                        }
                        break;*/
                case 6: System.out.println("Digite a avaliação do serviço de 0 a 5:");
                        String SavServico = in.nextLine();
                        int avSercivo = -1;
                        if(!SavServico.isEmpty())
                            avSercivo = Integer.parseInt(SavServico);
                        status = clienteController.avaliarServico(avSercivo);
                        System.out.println(status);
                        break;
                 case 7: System.out.println("Digite a avaliação do Local de 0 a 5:");
                        String SavServico = in.nextLine();
                        int avSercivo = -1;
                        if(!SavServico.isEmpty())
                            avSercivo = Integer.parseInt(SavServico);
                        status = clienteController.avaliarLocal(avSercivo);
                        System.out.println(status);
                        break;
                    break;
                case 8: clienteController.compartilharCupom(cliente);
                case 9: break;
                default: System.out.println("opção inválida");
            }
        }while(op != 9);
    }
}
