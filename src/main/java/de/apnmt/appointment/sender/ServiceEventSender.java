package de.apnmt.appointment.sender;

import de.apnmt.common.event.ApnmtEvent;
import de.apnmt.common.event.value.ServiceEventDTO;
import de.apnmt.common.sender.ApnmtEventSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceEventSender implements ApnmtEventSender<ServiceEventDTO> {

    private static final Logger log = LoggerFactory.getLogger(ServiceEventSender.class);

    @Override
    public void send(String topic, ApnmtEvent<ServiceEventDTO> event) {
        log.info("Send event {} to Service Bus topic {}", event, topic);
    }
}
