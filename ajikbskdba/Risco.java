import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "risco")
public class Risco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_risco;

    private String nivel_gravidade;
    private String descricao;
    private String tipo_risco;

    @ManyToOne
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade cidade;

    @OneToMany(mappedBy = "risco")
    private List<Alocacao> alocacoes;

    @OneToMany(mappedBy = "risco")
    private List<CidadeRisco> cidadeRiscos;

    @OneToMany(mappedBy = "risco")
    private List<Paciente> pacientes;

    public int getId_risco() {
        return id_risco;
    }

    public void setId_risco(int id_risco) {
        this.id_risco = id_risco;
    }

    public String getNivel_gravidade() {
        return nivel_gravidade;
    }

    public void setNivel_gravidade(String nivel_gravidade) {
        this.nivel_gravidade = nivel_gravidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo_risco() {
        return tipo_risco;
    }

    public void setTipo_risco(String tipo_risco) {
        this.tipo_risco = tipo_risco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Alocacao> getAlocacoes() {
        return alocacoes;
    }

    public void setAlocacoes(List<Alocacao> alocacoes) {
        this.alocacoes = alocacoes;
    }

    public List<CidadeRisco> getCidadeRiscos() {
        return cidadeRiscos;
    }

    public void setCidadeRiscos(List<CidadeRisco> cidadeRiscos) {
        this.cidadeRiscos = cidadeRiscos;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    
}
