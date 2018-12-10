package RedisService;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

@Service
public class RedisSerialization {

    public static <T> T deSerialization(String serializedUserSession, Class<T> clazz) throws Exception {
        if(serializedUserSession == null
                || serializedUserSession.length() < 0
                || clazz == null) {
            throw new Exception("Fail to deserialize");
        }
        if (clazz.getName() == "UserSession") {
            return JSON.toJavaObject(JSON.parseObject(serializedUserSession),clazz);
        }
        return null;
    }
}
