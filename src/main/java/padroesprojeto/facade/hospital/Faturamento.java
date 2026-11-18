package padroesprojeto.facade.hospital;

public class Faturamento extends Setor {

    private static Faturamento faturamento = new Faturamento();

    private Faturamento() {};

    public static Faturamento getInstancia() {
        return faturamento;
    }
}
