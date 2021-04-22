package PDSCinema.repository;

import PDSCinema.model.*;
import PDSCinema.service.ClienteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvMusicalRepository extends EventoRepository{

    private static List<Show> ShowEmCartaz = new ArrayList<>();
    private static List<Integer> avaliacaoesShow = new ArrayList<>();
    private static int qntAvaliacoesShow;
    private static List<Integer> avaliacoesLocal;= new ArrayList<>();
    private static int qntAvaliacoesLocal;

   
    public static List<Show> getShowEmCartaz() {
        return ShowEmCartaz;
    }

    public static void setShowEmCartaz(List<Show> ShowEmCartaz) {
        EvMusicalRepository.ShowEmCartaz = ShowEmCartaz;
    }

}

