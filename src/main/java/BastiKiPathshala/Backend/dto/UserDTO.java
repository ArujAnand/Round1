package BastiKiPathshala.Backend.dto;

import BastiKiPathshala.Backend.enums.role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "Username cannot be null")
    private String username;

    @NotNull(message = "Password cannot be null")
    private String password;

    @NotNull(message = "List of roles cannot be null")
    @Size(min = 1, message = "Roles cannot be empty")
    @JsonProperty(required = true)
    private List<role> roles;
}
