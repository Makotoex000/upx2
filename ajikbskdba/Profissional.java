import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profissional")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_profissional;

    private String email;
    private String telefone;
    private String especialidade;
    private String nome;

    @OneToMany(mappedBy = "profissional")
    private List<HistoricoPaciente> historicoPacientes;

    @OneToMany(mappedBy = "profissional")
    private List<ProfissionalAlocacao> alocacoes;

    public int getId_profissional() {
        return id_profissional;
    }

    public void setId_profissional(int id_profissional) {
        this.id_profissional = id_profissional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<HistoricoPaciente> getHistoricoPacientes() {
        return historicoPacientes;
    }

    public void setHistoricoPacientes(List<HistoricoPaciente> historicoPacientes) {
        this.historicoPacientes = historicoPacientes;
    }

    public List<ProfissionalAlocacao> getAlocacoes() {
        return alocacoes;
    }

    public void setAlocacoes(List<ProfissionalAlocacao> alocacoes) {
        this.alocacoes = alocacoes;
    }

    
    
}
