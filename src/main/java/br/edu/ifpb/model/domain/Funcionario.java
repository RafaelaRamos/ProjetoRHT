

package  br.edu.ifpb.model.domain;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDate dataDeNascimento;
    private String genero;
    private String naturalidade;
    private String nacionalidade;
    private  LocalDate dataDeAdmissao;
    private LocalDateTime jornadaDeTrabalho;
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
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    @OneToMany
    private List<Dependente> dependentes;

    public Funcionario(String nome, String foto, String filiacao) {
        this.nome = nome;
        this.foto = foto;
        this.filiacao = filiacao;
    }
}
