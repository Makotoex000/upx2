import javax.persistence.*;

@Entity
@Table(name = "cidade_risco")
public class CidadeRisco {

    @EmbeddedId
    private CidadeRiscoId id;

    private String tipo_de_risco;

    @ManyToOne
    @MapsId("id_cidade")
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    @ManyToOne
    @MapsId("id_risco")
    @JoinColumn(name = "id_risco")
    private Risco risco;

    public CidadeRiscoId getId() {
        return id;
    }

    public void setId(CidadeRiscoId id) {
        this.id = id;
    }

    public String getTipo_de_risco() {
        return tipo_de_risco;
    }

    public void setTipo_de_risco(String tipo_de_risco) {
        this.tipo_de_risco = tipo_de_risco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }

    
}
