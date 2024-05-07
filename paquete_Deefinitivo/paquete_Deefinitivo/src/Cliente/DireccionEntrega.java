package Cliente;

public class DireccionEntrega {

    private int idDir;
    private String calle1;
    private String calle2;
    private String referencia;
    private boolean actual;

    public DireccionEntrega(int idDir, String calle1, String calle2, String referencia) {
        this.idDir = idDir;
        this.calle1 = calle1;
        this.calle2 = calle2;
        this.referencia = referencia;
        this.actual = true;
    }

    public DireccionEntrega() {
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public String getCalle1() {
        return calle1;
    }

    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }
}
