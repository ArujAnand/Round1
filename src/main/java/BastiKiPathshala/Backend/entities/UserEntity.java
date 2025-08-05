package BastiKiPathshala.Backend.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "users")
public class UserEntity {

    @Id
    private ObjectId id;

    @NonNull
    private String name;

    @NotNull(message = "Username cannot be null")
    private String username;

    @NotNull(message = "Password cannot be null")
    private String password;

    @NotNull(message = "List of roles cannot be null")
    @Size(min = 1, message = "List of roles cannot be empty" )
    private List<String> roles;
}
