package PDSCinema.DAO;

import PDSCinema.model.Administrador;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.model.Cliente;

import java.util.List;

public class CinemaDAOmemoria implements CinemaDAO {

    @Override
    public void inserirCliente(CinemaRepository cinema, String cpf, String nome){
        cinema.getListaClientesCpf().add(cpf);
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cinema.getListaClientes().add(cliente);
    }

    @Override
    public void removerCliente(CinemaRepository cinema, Cliente cliente) {
        cinema.getListaClientesCpf().remove(cliente.getCpf());
        cinema.getListaClientes().remove(cliente);
    }

    @Override
    public Cliente buscarCliente(CinemaRepository cinema, String cpf) {
        for (int i = 0; i < cinema.getListaClientesCpf().size(); i++) {
            if (cpf.equals(cinema.getListaClientesCpf().get(i))) {
                return cinema.getListaClientes().get(i);
            }
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodosCliente(CinemaRepository cinema) {
        return cinema.getListaClientes();
    }

    @Override
    public void inserirADM(CinemaRepository cinema, String cpf, String nome) {
        cinema.getListaAdministradorCpf().add(cpf);
        Administrador administrador = new Administrador();
        administrador.setNome(nome);
        administrador.setCpf(cpf);
        cinema.getListaAdministrador().add(administrador);
    }

    @Override
    public void removerADM(CinemaRepository cinema, Administrador adm) {
        cinema.getListaAdministradorCpf().remove(adm.getCpf());
        cinema.getListaAdministrador().remove(adm);
    }

    @Override
    public Administrador buscarADM(CinemaRepository cinema, String cpf) {
        for (int i = 0; i < cinema.getListaAdministradorCpf().size(); i++) {
            if (cpf.equals(cinema.getListaAdministradorCpf().get(i))) {
                return cinema.getListaAdministrador().get(i);
            }
        }
        return null;
    }

    @Override
    public List<Administrador> buscarTodosADM(CinemaRepository cinema) {
        return cinema.getListaAdministrador();
    }
}