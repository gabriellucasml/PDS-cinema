package PDSCinema.service.EventoStrategy;

import PDSCinema.model.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoEvMusical extends EventoStrategyAbstractEvento{

   public ArrayList<String> calcularRanking(List<Evento> listaDeEventos){
        ArrayList<Show> shows = new ArrayList<>();
        for(Evento evento : listaDeEventos){
            shows.add((Show) evento);
        }
        List<Double> medias = calcularMediaAvaliacaoEvento(listaDeEventos);
        ArrayList<String> rankingShows = new ArrayList<>();
        EventoRepository.setMedias(medias);

        for(Show show : Shows)
            rankingShows.add(show.getName());

        int i, j, min;
        Double aux;
        String aux2;
        for (i = 0; i < (listaDeEventos.size())-1; i++){
            min = i;
            for (j = (i + 1); j < listaDeEventos.size(); j++) {
                if (medias.get(j) < medias.get(min))
                    min = j;
            }
            if (i != min) {
                aux = medias.get(i);
                aux2 = rankingShows.get(i);
                medias.set(i, medias.get(min));
                medias.set(min, aux);
                rankingShows.set(i, rankingShows.get(min));
                rankingShows.set(min, aux2);
            }
        }
        return rankingShows;
    }

    public List<Double> calcularMediaAvaliacaoEvento(List<Evento> eventos) {
        try{
            List<Double> valor = new ArrayList<>();
            for (Evento evento : eventos) {
                if(evento.getQuantAvaliacoes() == 0){
                    valor.add(((double)(evento.getAvaliacoes())));
                }else{
                    valor.add(((double)(evento.getAvaliacoes()) / (double)(evento.getQuantAvaliacoes())));
                }
            }
            return valor;
        }catch (ArithmeticException e){
            return null;
        }
    }
}
