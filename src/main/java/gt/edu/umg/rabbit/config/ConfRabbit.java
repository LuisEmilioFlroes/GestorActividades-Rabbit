package gt.edu.umg.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String TASK_QUEUE = "taskQueue";

    @Bean
    public Queue queue() {
        return new Queue("taskQueue", false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("taskExchange");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("task.routing.key");
    }

}
