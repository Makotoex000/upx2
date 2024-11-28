import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alocacao")
public class Alocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_alocacao;

    @ManyToOne
    @JoinColumn(name = "id_risco", nullable = false)
    private Risco risco;

    private Date data_alocacao;

    public Alocacao(String id_alocacao, Risco risco, Date data_alocacao) {
        this.id_alocacao = Integer.parseInt(id_alocacao);
        this.risco = risco;
        this.data_alocacao = data_alocacao;
    }

    public int getId_alocacao() {
        return id_alocacao;
    }

    public void setId_alocacao(int id_alocacao) {
        this.id_alocacao = id_alocacao;
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }

    public Date getData_alocacao() {
        return data_alocacao;
    }

    public void setData_alocacao(Date data_alocacao) {
        this.data_alocacao = data_alocacao;
    }
}
