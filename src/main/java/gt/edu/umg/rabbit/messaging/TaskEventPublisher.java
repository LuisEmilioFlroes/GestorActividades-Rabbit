package gt.edu.umg.taskmanager.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gt.edu.umg.database.model.Task;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskEventPublisher {

    private static final String QUEUE_NAME = "task.events";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void publicarCreacionTarea(Task tarea) {
        try {
            String mensaje = objectMapper.writeValueAsString(tarea);
            rabbitTemplate.convertAndSend(QUEUE_NAME, mensaje);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al serializar la tarea para RabbitMQ", e);
        }
    }
}
