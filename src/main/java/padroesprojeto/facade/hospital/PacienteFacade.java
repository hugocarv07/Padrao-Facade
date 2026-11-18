package padroesprojeto.facade.hospital;

public class PacienteFacade {

    public static boolean verificarPendenciasAlta(Paciente paciente) {
        if (Laboratorio.getInstancia().verificarPacienteComPendencia(paciente)) {
            return false;
        }
        if (Farmacia.getInstancia().verificarPacienteComPendencia(paciente)) {
            return false;
        }
        if (Faturamento.getInstancia().verificarPacienteComPendencia(paciente)) {
            return false;
        }
        return true;
    }
}
