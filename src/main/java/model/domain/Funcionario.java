

package  main.java.model.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String foto;
    private String filiacao;
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;
    private String genero;
    private String naturalidade;
    private String nacionalidade;
    @Temporal(TemporalType.DATE)
    private  Date dataDeAdmissao;
    //@Temporal(TemporalType.TIME)
   // private Time jornadaDeTrabalho;
    private String ctps;
    private String pasepPis;
    private String cargo;
    private String departamento;
    private String ferias;
    private long remuneracao;
    private String cpf;
    private String rg;
    private String estadoCivil;
    private String tituloEleitoral;
    private String telefone;
    private String escolaridade;
    private String CertificadoReservista;
    private String pnE;
    private String tipoSanguineo;
    @OneToOne
    private Endereco endereco;
    @OneToMany
    private List<Dependente> dependentes;

    public Funcionario(String nome, String foto, String filiacao) {
        this.nome = nome;
        this.foto = foto;
        this.filiacao = filiacao;
    }
}
