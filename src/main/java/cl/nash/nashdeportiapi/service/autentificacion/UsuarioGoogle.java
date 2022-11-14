package cl.nash.nashdeportiapi.service.autentificacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class UsuarioGoogle {

    private String at_hash;
    private String sub;
    private boolean email_verified;
    private String iss;
    private String given_name;
    private String locale;
    //private String nonce;
    private String picture;
    //private List<String> aud;
    //private String azp;
    private String name;
    //private String hd;
    //private String exp;
    private String family_name;
    //private String iat;
    private String email;


}
