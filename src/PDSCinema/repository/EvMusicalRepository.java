package PDSCinema.repository;

import PDSCinema.model.*;
import PDSCinema.service.ClienteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvMusicalRepository extends EventoRepository{

    private static List<Show> ShowsEmCartaz = new ArrayList<>();
    private static int avaliacoesLocal;
    private static int qntAvaliacoesLocal;

   
    public static List<Show> getShowsEmCartaz() {
        return ShowEmCartaz;
    }

    public static void setShowsEmCartaz(List<Show> ShowsEmCartaz) {
        EvMusicalRepository.ShowsEmCartaz = ShowEmCartaz;
    }

}

