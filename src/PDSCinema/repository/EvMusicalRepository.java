package PDSCinema.repository;

import PDSCinema.model.*;
import PDSCinema.service.ClienteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvMusicalRepository extends EventoRepository{

    private static List<Show> ShowEmCartaz = new ArrayList<>();

   
    public static List<Show> getShowEmCartaz() {
        return ShowEmCartaz;
    }

    public static void setShowEmCartaz(List<Show> ShowEmCartaz) {
        EvMusicalRepository.ShowEmCartaz = ShowEmCartaz;
    }

}

