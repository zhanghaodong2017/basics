package com.zhd.basics.mq;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class QueueConsumer extends EndPoint implements Runnable, Consumer {

	public QueueConsumer(String endpointName) throws IOException, TimeoutException {
		super(endpointName);
	}

	@Override
	public void handleConsumeOk(String consumerTag) {
		// TODO Auto-generated method stub
		System.out.println("Consumer " + consumerTag + " registered");
	}

	@Override
	public void handleCancelOk(String consumerTag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleCancel(String consumerTag) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleDelivery(String arg0, Envelope arg1, BasicProperties arg2, byte[] body) throws IOException {
		// TODO Auto-generated method stub
		Map map = (HashMap) SerializationUtils.deserialize(body);
		System.out.println("Message Number " + map.get("message number") + " received.");
	}

	@Override
	public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleRecoverOk(String consumerTag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			// start consuming messages. Auto acknowledge messages.
			channel.basicConsume(endPointName, true, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
