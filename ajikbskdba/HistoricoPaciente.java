import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historico_paciente")
public class HistoricoPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paciente_paciente;

    private Date data_antendimento;

    @ManyToOne
    @JoinColumn(name = "id_alocacao", nullable = false)
    private Alocacao alocacao;

    @ManyToOne
    @JoinColumn(name = "id_profissional", nullable = false)
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    public HistoricoPaciente(String id_paciente_paciente, Date data_antendimento, Alocacao alocacao, Profissional profissional, Paciente paciente) {
        this.id_paciente_paciente = Integer.parseInt(id_paciente_paciente);
        this.data_antendimento = data_antendimento;
        this.alocacao = alocacao;
        this.profissional = profissional;
        this.paciente = paciente;
    }

    public int getId_paciente_paciente() {
        return id_paciente_paciente;
    }

    public void setId_paciente_paciente(int id_paciente_paciente) {
        this.id_paciente_paciente = id_paciente_paciente;
    }

    public Date getData_antendimento() {
        return data_antendimento;
    }

    public void setData_antendimento(Date data_antendimento) {
        this.data_antendimento = data_antendimento;
    }

    public Alocacao getAlocacao() {
        return alocacao;
    }

    public void setAlocacao(Alocacao alocacao) {
        this.alocacao = alocacao;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
