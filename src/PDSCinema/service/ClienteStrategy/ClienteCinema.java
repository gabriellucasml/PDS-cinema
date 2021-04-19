package PDSCinema.service.ClienteStrategy;

import PDSCinema.DAO.SingletonEventoDAO;
import PDSCinema.model.Evento;
import PDSCinema.repository.CinemaRepository;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.io.IOException;

public class ClienteCinema extends ClienteStrategyAbstractEvento{
    PDSCinema.DAO.ClienteStrategy.ClienteCinema clienteCinema = (PDSCinema.DAO.ClienteStrategy.ClienteCinema) SingletonEventoDAO.getCliente().getClienteStrategyEventoDAO();

    @Override
    public void comprarIngressoEvento(){

    }

    public int inseriAvaliacaoHorario(String horario, int avaliacao) {
        try {
            if(avaliacao > 5 || avaliacao < 0) {
                throw new NumberFormatException();
            }
            if(horario.isEmpty()){
                throw new Invalid();
            }
            clienteCinema.avaliarHorario(horario, avaliacao);
            return 0;
        }catch(NumberFormatException e) {
            return -1;
        }catch (NullPointerException e){
            return -2;
        }catch(IOException e) {
            return -3;
        } catch (Invalid e) {
            return -4;
        }
    }

    public Evento buscarEvento(String nome){
        try {
            if(!CinemaRepository.getFilmesEmCartaz().isEmpty()) {
                return SingletonEventoDAO.getAdm().buscarEvento(nome);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }


}
