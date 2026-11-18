package padroesprojeto.facade.hospital;

public class Paciente {

    public boolean darAlta() {
        return PacienteFacade.verificarPendenciasAlta(this);
    }
}
