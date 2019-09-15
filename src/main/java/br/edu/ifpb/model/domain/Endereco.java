package  br.edu.ifpb.model.domain;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Entity
public class Endereco implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private String rua;
    private String bairro;
    private String cidade;
    private String numero;
}
