package BastiKiPathshala.Backend.entities;


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

    @NonNull
    private String username;

    private List<String> roles;
}
