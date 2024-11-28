import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estado;

    private String nome_estado;

    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades;

    public Estado(String id_estado, String nome_estado, List<Cidade> cidades) {
        this.id_estado = Integer.parseInt(id_estado);
        this.nome_estado = nome_estado;
        this.cidades = cidades;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNome_estado() {
        return nome_estado;
    }

    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
