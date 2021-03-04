package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Administrador;
import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Cliente;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class CinemaService implements iCinemaService{
    private Cinema cinema;
	private CinemaDAO cinemaDAO;

    @Override
    public int inserirCliente(Cliente cliente){
    	try {
    		if(cliente.getNome() != null && !(cinema.getListaClientesCpf().contains(cliente.getCpf()))) {
				cinemaDAO.inserirCliente(Cliente cliente);
    			return 0;
    		}else {
    			throw new NumberFormatException();
    		}
    	}catch(NumberFormatException e) {
    		return -1;
    	}
    }
     @Override
    public int removerCliente(Cliente cliente, Cinema cinema){
    	try {
     		if(cinema.getListaClientesCpf().contains(cliente.getCpf())) {
				cinemaDAO.removerCliente(Cliente cliente, Cinema cinema);
     			return 0;
     		}else {
     			throw new NumberFormatException();
     		}
     	}catch(NumberFormatException e) {
     		return -1;
     	}
    }
    @Override
    public Cliente buscarCliente(String cpf, Cinema cinema){
    	try {
      		if(cinema.getListaClientesCpf().contains(cpf)) {
      			return (cinemaDAO.buscarCliente(String cpf, Cinema cinema));
      		}else {
      			throw new NumberFormatException();
      		}
      	}catch(NumberFormatException e) {
      		return null;
      	}

    } 
    @Override
    public List <Cliente> buscarTodosCliente(){
		return cinemaDAO.buscarTodosCliente();
    }

    @Override
    public int inserirADM(Administrador ADM){
    	 try {
     		if(ADM.getNome() != null && !(cinema.getListaAdministradorCpf().contains(ADM.getCpf()))) {
				cinemaDAO.inserirADM(Administrador ADM);
     			return 0;
     		}else {
     			throw new NumberFormatException();
     		}
     	}catch(NumberFormatException e) {
     		return -1;
     	}
    }
    @Override
    public int removerADM(Administrador ADM, Cinema cinema){
    	try {
     		if(cinema.getListaAdministradorCpf().contains(ADM.getCpf())) {
				cinemaDAO.removerADM(Administrador ADM, Cinema cinema);
     			return 0;
     		}else {
     			throw new NumberFormatException();
     		}
     	}catch(NumberFormatException e) {
     		return -1;
     	}
    }
     @Override
    public Administrador buscarADM(String cpf, Cinema cinema){
    	try {
    		if(cinema.getListaAdministradorCpf().contains(cpf)){
       			return (cinemaDAO.buscarADM(String cpf, Cinema cinema));
       		}else {
       			throw new NumberFormatException();
       		}
       	}catch(NumberFormatException e){
       		return null;
       	}
    } 
    @Override
    public List <Administrador> buscarTodosADM(){
		return buscarTodosADM();
    }

    @Override
    public Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico){
    	 return ((double)avaliacoesServico/(double)quantAvServico);

    }
    public List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz){
    	List<Double> valor = new ArrayList<>();
		for (Filme filme : filmesEmCartaz) {
			valor.add((double) ((filme.getAvaliacoes()) / (filme.getQuantAvaliacoes())));
		}
    	return valor;
    }
    public List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
    	List<Double> valor  = new ArrayList<>();
    	for(int i=0; i < avaliacoesHorarios.size(); i++){
    		valor.add((double)(avaliacoesHorarios.get(i)/quantAvHorarios.get(i)));
    	}
    	return valor;
    }
}
