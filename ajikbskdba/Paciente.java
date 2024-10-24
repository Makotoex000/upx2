import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paciente;

    @ManyToOne
    @JoinColumn(name = "id_risco", nullable = false)
    private Risco risco;

    private String telefone;
    private String email;
    private Date data_nascimento;
    private String nome;

    @OneToMany(mappedBy = "paciente")
    private List<HistoricoPaciente> historicoPacientes;

}
