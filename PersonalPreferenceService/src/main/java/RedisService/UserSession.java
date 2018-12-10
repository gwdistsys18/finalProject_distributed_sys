package RedisService;

import lombok.Data;
import lombok.Getter;

@Data
public class UserSession {
    private Integer id;
    private String email;
    private boolean completeness;
}
