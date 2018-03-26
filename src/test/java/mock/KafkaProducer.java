package mock;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.e1b.entities.Incidencia;

@ManagedBean
public class KafkaProducer {
	private static final Logger logger = Logger.getLogger(KafkaProducer.class);
	@Autowired
	private KafkaTemplate<String, Incidencia> kafkaTemplate;

	public void send(String topic, Incidencia data) {
		ListenableFuture<SendResult<String, Incidencia>> future = kafkaTemplate.send(topic, data);
		future.addCallback(new ListenableFutureCallback<SendResult<String, Incidencia>>() {
			@Override
			public void onSuccess(SendResult<String, Incidencia> result) {
				logger.info("Success on sending message \"" + data + "\" to topic " + topic);
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("Error on sending message \"" + data + "\", stacktrace " + ex.getMessage());
			}
		});
	}
}