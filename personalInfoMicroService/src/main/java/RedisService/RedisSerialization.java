package RedisService;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

@Service
public class RedisSerialization {

	public static <T> T antiSerialization(String serializedUserSession, Class<T> clazz) throws Exception {
		if(serializedUserSession == null 
				|| serializedUserSession.length() < 0 
				|| clazz == null) {
			throw new Exception("Fail to anti-serialize");
		}
		if (clazz.getName() == "RedisService.UserSession") {
			return JSON.toJavaObject(JSON.parseObject(serializedUserSession),clazz);
		}
		return null;
	}
}
