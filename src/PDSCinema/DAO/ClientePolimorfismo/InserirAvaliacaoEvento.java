package PDSCinema.DAO.ClientePolimorfismo;

import PDSCinema.DAO.SingletonEventoDAO;
import PDSCinema.model.Evento;

public class InserirAvaliacaoEvento {
    public void inseriAvaliacaoEvento(Evento evento, int avaliacao) {
       
    }
    public void inseriAvaliacaoEvento(Evento evento,int avaliacao, int avaliacaoLocal) {
        int avaliacoes = evento.getAvaliacoes();
        evento.setAvaliacoes(avaliacoes+avaliacao);
        evento.setQuantAvaliacoes(evento.getQuantAvaliacoes()+1);
        int avaliacaoL =  EvMusicalRepository.getAvaliacoesLocal();
        EvMusicalRepository.setAvaliacoesLocal(avaliacaoL + avaliacaoLocal);
        EvMusicalRepository.QntAvaliacoesLocal(1 + getQntAvaliacoesLocal());
    }
}
