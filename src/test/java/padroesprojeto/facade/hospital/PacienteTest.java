package padroesprojeto.facade.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void deveRetornarPendenciaLaboratorioAlta() {
        Paciente paciente = new Paciente();
        Laboratorio.getInstancia().addPacientePendente(paciente);

        assertEquals(false, paciente.darAlta());
    }

    @Test
    void deveRetornarPendenciaFarmaciaAlta() {
        Paciente paciente = new Paciente();
        Farmacia.getInstancia().addPacientePendente(paciente);

        assertEquals(false, paciente.darAlta());
    }

    @Test
    void deveRetornarPendenciaFaturamentoAlta() {
        Paciente paciente = new Paciente();
        Faturamento.getInstancia().addPacientePendente(paciente);

        assertEquals(false, paciente.darAlta());
    }

    @Test
    void deveRetornarPacienteSemPendenciaAlta() {
        Paciente paciente = new Paciente();

        assertEquals(true, paciente.darAlta());
    }

    @Test
    void naoDeveDarAltaComPendenciaEmMaisDeUmSetor() {
        Paciente paciente = new Paciente();
        Farmacia.getInstancia().addPacientePendente(paciente);
        Faturamento.getInstancia().addPacientePendente(paciente);

        assertFalse(paciente.darAlta());
    }

    @Test
    void deveDarAltaDepoisDeResolverAPendencia() {
        Paciente paciente = new Paciente();
        Faturamento.getInstancia().addPacientePendente(paciente);
        assertFalse(paciente.darAlta());

        Faturamento.getInstancia().removerPacientePendente(paciente);

        assertTrue(paciente.darAlta());
    }

    @Test
    void pendenciaDeUmPacienteNaoDeveImpedirAltaDeOutro() {
        Paciente comPendencia = new Paciente();
        Paciente semPendencia = new Paciente();
        Laboratorio.getInstancia().addPacientePendente(comPendencia);

        assertFalse(comPendencia.darAlta());
        assertTrue(semPendencia.darAlta());
    }

    @Test
    void aFachadaDeveRetornarOMesmoResultadoQueDarAlta() {
        Paciente paciente = new Paciente();
        assertTrue(PacienteFacade.verificarPendenciasAlta(paciente));

        Farmacia.getInstancia().addPacientePendente(paciente);
        assertFalse(PacienteFacade.verificarPendenciasAlta(paciente));
    }

    @Test
    void oSetorDeveSerUmSingleton() {
        assertSame(Laboratorio.getInstancia(), Laboratorio.getInstancia());
        assertSame(Farmacia.getInstancia(), Farmacia.getInstancia());
        assertSame(Faturamento.getInstancia(), Faturamento.getInstancia());
    }
}
