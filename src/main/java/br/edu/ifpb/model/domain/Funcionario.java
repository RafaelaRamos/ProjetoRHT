

package  br.edu.ifpb.model.domain;
import br.edu.ifpb.imagem.Imagem;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@AllArgsConstructor
@Entity
@EqualsAndHashCode
public class Funcionario implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    @OneToOne
    private Imagem foto;
    private String filiacao;
    private String dataDeNascimento;
    private String genero;
    private String naturalidade;
    private String nacionalidade;
    private String dataDeAdmissao;
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

    public Funcionario(){
        this.dependentes = new ArrayList<>();
    }
    
    public Funcionario(String nome, Imagem foto, String filiacao) {
        this();
        this.nome = nome;
        this.foto = foto;
        this.filiacao = filiacao;
    }
}
