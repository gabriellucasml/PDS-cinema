package PDSCinema.Controller;

import PDSCinema.model.Cupom;
import PDSCinema.model.Filme;
import PDSCinema.model.Premio;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.service.AdministradorService;

import java.util.ArrayList;

public class AdministradorController {
    private final AdministradorService adm;
    public AdministradorController(){
        this.adm = new AdministradorService();
    }
    public String cadastrarFilmes(CinemaRepository cinema, String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
                        String diaDeEstreia){
        System.out.println(name);
        System.out.println(duracao);
        System.out.println(sinopse);
        System.out.println(classificacaoIndicativa);
        System.out.println(diaDeEstreia);
        int status = adm.cadastrarFilmes(cinema, name, duracao, sinopse, classificacaoIndicativa, genero, diaDeEstreia);
        if(status == 0){
            return ("Filme cadastrado com sucesso");
        }else if(status == -1){
            return ("A duração não pode ser menor que 0!");
        }else if(status == -2){
            return ("Algum valor passado está nulo!");
        }
        return "Filme não cadastrado!";
    }
    public String cadastrarCupons(CinemaRepository cinema, String _Cupom, double tipoDeCupom){
        int status = adm.cadastrarCupons(cinema, _Cupom, tipoDeCupom);
        if(status == 0){
            return ("Cupom cadastrado com sucesso");
        }else{
            return ("Nome do cupom ou tipo do cupom inválido!");
        }
    }
    public String cadastrarPremios(CinemaRepository cinema, String descricao, int id){
        int status = adm.cadastrarPremios(cinema, descricao, id);
        if(status == 0){
            return ("Premio cadastrado com sucesso");
        }else if(status == -1){
            return ("Este cupom já existe!");
        }else{
            return ("Valor para o nome do cupom inválido!");
        }
    }

    public Filme buscarFilme(CinemaRepository cinema, String nome){
        Filme filme = adm.buscarFilme(cinema, nome);
        if(filme != null){
            System.out.println("Filme encontrado com sucesso");
            return filme;
        }
        System.out.println("Filme não encontrado");
        return null;
    }
    public ArrayList<Filme> buscarFilmeGenero(CinemaRepository cinema, String genero){
        ArrayList<Filme> filmes = adm.buscarFilmeGenero(cinema, genero);
        if(filmes != null){
            System.out.println("Filmes do gênero " + genero + " encontrados com sucesso");
            return filmes;
        }
        System.out.println("Nenhum filme com esse gênero encontrado!");
        return null;
    }
    public Cupom buscarCupons(CinemaRepository cinema, String codigo){
        Cupom cupom = adm.buscarCupons(cinema, codigo);
        if(cupom != null){
            System.out.println("Cupom encontrados com sucesso");
            return cupom;
        }
        System.out.println("Nenhum cupom encontrado!");
        return null;
    }
    public Premio buscarPremio(CinemaRepository cinema, int codigo){
        Premio premio = adm.buscarPremio(cinema, codigo);
        if(premio != null){
            System.out.println("Premio encontrados com sucesso");
            return premio;
        }
        System.out.println("Nenhum premio encontrado!");
        return null;
    }

    public String removerFilmes(CinemaRepository cinema, Filme filme){
        int status = adm.removerFilmes(cinema, filme);
        if(status == 0){
            return ("Filme removido com sucesso");
        }else{
            return ("Filme não cadastrado!");
        }
    }
    public String removerCupons(CinemaRepository cinema, Cupom cupom){
        int status = adm.removerCupons(cinema, cupom);
        if(status == 0){
            return ("Cupom removido com sucesso");
        }else{
            return ("Cupom não cadastrado!");
        }
    }
    public String removerPremios(CinemaRepository cinema, Premio premio){
        int status = adm.removerPremios(cinema, premio);
        if(status == 0){
            return ("Premio removido com sucesso");
        }else{
            return ("Premio não cadastrado!");
        }
    }
}