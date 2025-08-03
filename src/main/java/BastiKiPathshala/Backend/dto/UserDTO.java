package BastiKiPathshala.Backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    @Id
    private ObjectId id;

    @NonNull
    private String name;

    @NonNull
    private String username;

    private List<String> roles;
}
