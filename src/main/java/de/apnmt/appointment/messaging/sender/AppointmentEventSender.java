package de.apnmt.appointment.messaging.sender;

import de.apnmt.common.event.ApnmtEvent;
import de.apnmt.common.event.value.AppointmentEventDTO;
import de.apnmt.common.sender.ApnmtEventSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentEventSender implements ApnmtEventSender<AppointmentEventDTO> {

    private static final Logger log = LoggerFactory.getLogger(AppointmentEventSender.class);

    private JmsTemplate jmsTemplate;

    public AppointmentEventSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void send(String topic, ApnmtEvent<AppointmentEventDTO> event) {
        log.info("Send event {} to Service Bus topic {}", event, topic);
        jmsTemplate.convertAndSend(topic, event);
    }
}
