package PDSCinema.service.ClienteStrategy;

import PDSCinema.model.Evento;

public class ClienteEvMusical extends ClienteStrategyAbstractEvento{

    PDSCinema.DAO.ClienteStrategy.ClienteEvMusical clienteEvMusical = (PDSCinema.DAO.ClienteStrategy.ClienteEvMusical) SingletonEventoDAO.getCliente().getClienteStrategyEventoDAO();

    @Override
    public Evento buscarEvento(String nome){
        try {
            if(!EvMusicalRepository.getShowsEmCartaz().isEmpty()) {
                return SingletonEventoDAO.getAdm().buscarEvento(nome);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }
}
