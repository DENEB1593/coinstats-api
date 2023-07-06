package io.deneb.coinstats.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class JsonUtils {
    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
    private final ObjectMapper objectMapper;

    public JsonUtils(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public <T> T stringToObj(String val, Class<T> type) {
        if (ObjectUtils.isEmpty(val)) {
            return null;
        }
        try {
            return objectMapper.readValue(val, type);
        } catch (JsonProcessingException e) {
            log.error("JSON 변환 오류: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }


}
