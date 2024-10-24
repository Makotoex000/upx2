import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class CidadeRiscoId implements Serializable {

    private int id_cidade;
    private int id_risco;
    public int getId_cidade() {
        return id_cidade;
    }
    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }
    public int getId_risco() {
        return id_risco;
    }
    public void setId_risco(int id_risco) {
        this.id_risco = id_risco;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_cidade;
        result = prime * result + id_risco;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CidadeRiscoId other = (CidadeRiscoId) obj;
        if (id_cidade != other.id_cidade)
            return false;
        if (id_risco != other.id_risco)
            return false;
        return true;
    }

    
    
}
