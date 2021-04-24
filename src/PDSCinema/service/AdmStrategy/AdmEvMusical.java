package PDSCinema.service.AdmStrategy;

import PDSCinema.model.Evento;

public class AdmEvMusical extends AdmStrategyAbstractEvento{

    @Override
    public int removerEvento(Evento evento){
        if(EvMusicalRepository.getShowEmCartaz().contains(evento)) {
            SingletonEventoDAO.getAdm().removerEvento(evento);
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public Evento buscarEvento(String evento){
        if(!EvMusicalRepository.getShowEmCartaz().isEmpty()) {
            return SingletonEventoDAO.getAdm().buscarEvento(evento);
        }else{
            return null;
        }
    }
}
