package  br.edu.ifpb.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
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
    private String cpf;
    private String nome;
    private String foto;
    private String filiacao;
    private String dataDeNascimento;
    private String genero;
    private String naturalidade;
    private String nacionalidade;
    private String dataDeAdmissao;
    private String jornadaDeTrabalho;
    private String ctps;
    private String pasepPis;
    private String cargo;
    private String departamento;
    private String ferias;
    private long remuneracao; 
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
    @JoinColumn(name = "funcionario_id")
    private List<Dependente> dependentes;
   // @OneToOne
    //@JoinColumn(name = "funcionario_id")
   // private DocumentoPDF documento;
    private String documento;

    public Funcionario(){
        this.dependentes = new ArrayList<>();
    }
    
    public Funcionario(String nome, String foto, String filiacao) {
        this();
        this.nome = nome;
        this.foto = foto;
        this.filiacao = filiacao;
    }

}
