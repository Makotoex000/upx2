import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cidade;

    private String nome_cidade;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @OneToMany(mappedBy = "cidade")
    private List<CidadeRisco> cidadeRiscos;

    public Cidade(String id_cidade, String nome_cidade, Estado estado, List<CidadeRisco> cidadeRiscos) {
        this.id_cidade = Integer.parseInt(id_cidade);
        this.nome_cidade = nome_cidade;
        this.estado = estado;
        this.cidadeRiscos = cidadeRiscos;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getNome_cidade() {
        return nome_cidade;
    }

    public void setNome_cidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<CidadeRisco> getCidadeRiscos() {
        return cidadeRiscos;
    }

    public void setCidadeRiscos(List<CidadeRisco> cidadeRiscos) {
        this.cidadeRiscos = cidadeRiscos;
    }
}
