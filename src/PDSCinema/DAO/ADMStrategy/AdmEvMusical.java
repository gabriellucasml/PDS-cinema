package PDSCinema.DAO.ADMStrategy;

import PDSCinema.model.Evento;

public class AdmEvMusical extends AdmStrategyAbstractEvento {

    @Override
     public Evento buscarEvento(String evento){
        for(Show show : EvMusicalRepository.getShowsEmCartaz()) {
            if (show.getName().equalsIgnoreCase(evento))
                return show;
        }
        return null;

    }

    @Override
    public void removerEvento(Evento evento){

    }
}
