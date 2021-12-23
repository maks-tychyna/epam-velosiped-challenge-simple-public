package dev.abarmin.velosiped.task3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VelosipedJsonAdapterImpl implements VelosipedJsonAdapter {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public <T> T parse(String json, Class<T> targetClass) {
    try {
      return objectMapper.readValue(json, targetClass);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String writeAsJson(Object instance) {
    try {
      return objectMapper.writeValueAsString(instance);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
