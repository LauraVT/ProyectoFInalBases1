package co.edu.uniquindio.proyectoBases1.servicio;

import co.edu.uniquindio.proyectoBases1.entidades.Tema;
import co.edu.uniquindio.proyectoBases1.repositorios.TemaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaServicioImpl implements TemaServicio {
    @Autowired
    private TemaRepo temaRepo;

    @Override
    public Tema crearTema(Tema tema) throws Exception {
        Tema temaEncotrado = temaRepo.ObtenerTema(tema.getCodigo());
        if (temaEncotrado != null){
            throw new Exception("Este tema ya existe");
        }
        return temaRepo.save(tema);
    }

    @Override
    public void eliminarTema(Integer codigo) throws Exception {
        Tema temaEliminado = obtenerTema(codigo);
        temaRepo.delete(temaEliminado);
    }

    @Override
    public Tema modificarTema(Tema tema) throws Exception {
        Tema temaModificado = obtenerTema(tema.getCodigo());
        return temaRepo.save(tema);
    }

    @Override
    public Tema obtenerTema(Integer codigo) throws Exception {
        Tema temaEncotrado = temaRepo.ObtenerTema(codigo);
        if (temaEncotrado== null){
            throw new Exception("Ningun tema tiene este codigo");
        }
        return temaEncotrado;
    }

    @Override
    public List<Tema> listarTemas() {
        return temaRepo.findAll();
    }

}
