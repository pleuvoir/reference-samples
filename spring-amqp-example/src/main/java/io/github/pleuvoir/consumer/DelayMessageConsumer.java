package io.github.pleuvoir.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import io.github.pleuvoir.kit.RabbitConst;
import io.github.pleuvoir.model.DelayMessage;


@RabbitListener(
		bindings = @QueueBinding(
				value = @Queue(RabbitConst.BeginArrival.QUEUE),
				exchange = @Exchange(RabbitConst.BeginArrival.EXCHANGE),
				key = RabbitConst.BeginArrival.ROUTING_KEY
		)
)
@Component
public class DelayMessageConsumer {

	private static Logger logger = LoggerFactory.getLogger(DelayMessageConsumer.class);

	
	@RabbitHandler
	public void handler(String data) {
		
		logger.info("【延迟消息消费者】已接收到消息，payload：{}", JSON.parseObject(data, DelayMessage.class).toJSON());
	}

}
