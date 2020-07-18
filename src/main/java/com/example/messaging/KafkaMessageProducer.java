package com.example.messaging;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.common.protocol.types.Field.Str;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
public class KafkaMessageProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public KafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @SneakyThrows
  public SendResult<String, String> sendMessageSynchronously(String topic, String key, String message) {
    return this.sendMessage(topic, key, message).get();
  }


  public void sendMessageAsynchronously(String topic, String key, String message) {
    this.sendMessageAsynchronously(topic, key, message, new DummyListenableFutureCallback<>());
  }

  public void sendMessageAsynchronously(String topic, String key, String message,
      ListenableFutureCallback<? super SendResult<String, String>> callback) {
    this.sendMessage(topic, key, message).addCallback(callback);
  }

  public ListenableFuture<SendResult<String, String>> sendMessage(String topic,
      String key, String message) {

    return this.kafkaTemplate.send(topic, key, message);
  }

  private static class DummyListenableFutureCallback<T> implements ListenableFutureCallback<SendResult<String, String>>{
    @Override
    public void onFailure(Throwable ex) {
      log.error("Messaging exception");
    }

    @Override
    public void onSuccess(SendResult<String, String> result) {
      log.info(result.toString());
    }
  }
}
