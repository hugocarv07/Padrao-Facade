package padroesprojeto.facade.hospital;

public class Laboratorio extends Setor {

    private static Laboratorio laboratorio = new Laboratorio();

    private Laboratorio() {};

    public static Laboratorio getInstancia() {
        return laboratorio;
    }
}
