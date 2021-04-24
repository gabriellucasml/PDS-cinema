package PDSCinema.DAO.AdmPolimorfismo;

import PDSCinema.model.Filme;
import PDSCinema.repository.CinemaRepository;

public class CadastrarEvento {
    public void cadastrarEvento(String name, int duracao, String sinopse, String classificacaoIndicativa, String genero, String diaDeEstreia) {
        Filme filme = new Filme();
        filme.setName(name);
        filme.setDuracao(duracao);
        filme.setSinopse(sinopse);
        filme.setClassificacaoIndicativa(classificacaoIndicativa);
        filme.setGenero(genero);
        filme.setDiaDeEstreia(diaDeEstreia);
        CinemaRepository.getFilmesEmCartaz().add(filme);
    }
    public void cadastrarEvento(String name, int duracao, String atracaoMusical, String data) {
        Show show = new Show();
        show.setName(name);
        show.setDuracao(duracao);
        show.setAtracaoMusical(atracaoMusical);
        show.setData(data);
        EvMusicalRepository.getShowsEmCartaz().add(show);
    }
}
