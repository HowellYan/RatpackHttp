package cn.com.ratpack.settings.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.kafka.outbound.KafkaProducerMessageHandler;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.messaging.MessageHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Howell on 28/2/17.
 * e-mail:th15817161961@gmail.com
 * kafka 生产
 */
@Configuration
public class KafkaProducerConfig {
    public static final String TEST_TOPIC_ID = "test.topic";

    @Value("${kafka.topic:" + TEST_TOPIC_ID + "}")
    private String topic;

    private String messageKey="test.key";

    @Value("${kafka.address:localhost:9092}")
    private String brokerAddress;

    @Bean
    @ServiceActivator(inputChannel = "inputToKafka", autoStartup="true")
    public MessageHandler handler() throws Exception {
        KafkaProducerMessageHandler<String, String> handler = new KafkaProducerMessageHandler<>(kafkaTemplate());
        handler.setTopicExpression(new SpelExpressionParser().parseExpression("headers.kafka_topic != null ? headers.kafka_topic : '"+ topic +"'"));
        handler.setMessageKeyExpression(new SpelExpressionParser().parseExpression("headers.kafka_messageKey != null ? headers.kafka_messageKey : '"+ messageKey +"'"));
        return handler;
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> props = new HashMap();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.brokerAddress);
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }

}
