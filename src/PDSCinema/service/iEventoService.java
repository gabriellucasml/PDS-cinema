package PDSCinema.service;


import PDSCinema.model.Administrador;
import PDSCinema.repository.EvMusicalRepository;
import PDSCinema.model.Cliente;
import PDSCinema.model.Administrador;

import java.util.ArrayList;
import java.util.List;

public interface iEventoService {
    int inserirCliente(String cpf, String nome);
    int removerCliente(Cliente cliente);
    Cliente buscarCliente(String cpf);
    List <Cliente> buscarTodosCliente();
    int inserirADM(String nome, String cpf);
    int removerADM(Administrador ADM);
    Administrador buscarADM(String cpf);
    List <Administrador> buscarTodosADM();
    Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico);
    Double calcularMediaAvaliacaoLocal(int avaliacoesLocal, int quantAvLocal)
    List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
    ArrayList<String> calcularRankingHorarios(List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
}
