package cn.com.ratpack.settings.kafka;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.kafka.inbound.KafkaMessageDrivenChannelAdapter;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.messaging.PollableChannel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Howell on 28/2/17.
 * e-mail:th15817161961@gmail.com
 * kafka 消费
 */
@Configuration
public class KafkaConsumerConfig {

    public static final String TEST_TOPIC_ID = "test.topic";

    @Value("${kafka.topic:" + TEST_TOPIC_ID + "}")
    private String topic;

    @Value("${kafka.address:localhost:9092}")
    private String brokerAddress;

    @Bean
    public KafkaMessageListenerContainer<String, String> container() throws Exception {

        Map<String, Object> props = new HashMap();
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "testGroup");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.brokerAddress);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 100);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 15000);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new KafkaMessageListenerContainer<String, String>(new DefaultKafkaConsumerFactory<String, String>(props), new ContainerProperties(topic));
    }

    @Bean
    public KafkaMessageDrivenChannelAdapter<String, String>
    adapter(KafkaMessageListenerContainer<String, String> container) {
        KafkaMessageDrivenChannelAdapter<String, String> kafkaMessageDrivenChannelAdapter =
                new KafkaMessageDrivenChannelAdapter<>(container);
        kafkaMessageDrivenChannelAdapter.setOutputChannel(pollableChannel());
        return kafkaMessageDrivenChannelAdapter;
    }

    @Bean
    public PollableChannel pollableChannel() {
        return new QueueChannel();
    }

}
