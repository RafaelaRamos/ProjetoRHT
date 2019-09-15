package  br.edu.ifpb.model.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity

public class Dependente implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String cpf;
    private String parentesco;

}
