package padroesprojeto.facade.hospital;

import java.util.ArrayList;
import java.util.List;

public abstract class Setor {

    private List<Paciente> pacientesComPendencia = new ArrayList<Paciente>();

    public void addPacientePendente(Paciente paciente) {
        this.pacientesComPendencia.add(paciente);
    }

    public void removerPacientePendente(Paciente paciente) {
        this.pacientesComPendencia.remove(paciente);
    }

    public boolean verificarPacienteComPendencia(Paciente paciente) {
        return this.pacientesComPendencia.contains(paciente);
    }
}
