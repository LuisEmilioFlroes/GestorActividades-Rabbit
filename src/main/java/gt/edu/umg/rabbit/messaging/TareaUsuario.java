package gt.edu.umg.rabbit.messaging;

import gt.edu.umg.database.model.Task;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static gt.edu.umg.rabbit.config.RabbitMQConfig.TASK_QUEUE;

@Component
public class TaskEventConsumer {

    @RabbitListener(queues = TASK_QUEUE)
    public void handleTaskCreated(Task task) {
        System.out.println("🟢 Tarea recibida desde RabbitMQ: " + task.getTitulo());
        // Aquí puedes implementar lógica adicional (correo, logs, auditoría, etc.)
    }
}
