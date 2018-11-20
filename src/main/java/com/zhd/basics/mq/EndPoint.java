package com.zhd.basics.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public abstract class EndPoint {
	protected Channel channel;

	protected Connection connection;

	protected String endPointName;

	public EndPoint(String endpointName) throws IOException, TimeoutException {
		super();
		this.endPointName = endpointName;

		ConnectionFactory factory = new ConnectionFactory();
		// 与RabbitMQ Server建立连接
		// 连接到的broker在本机localhost上
		factory.setHost("localhost");

		// getting a connection
		connection = factory.newConnection();
		// creating a channel
		channel = connection.createChannel();

		// declaring a queue for this channel. If queue does not exist,
		// it will be created on the server.
		// queueDeclare的参数：queue 队列名；durable true为持久化；exclusive
		// 是否排外，true为队列只可以在本次的连接中被访问，
		// autoDelete true为connection断开队列自动删除；arguments 用于拓展参数
		// 第一个参数表示队列名称、
		// 第二个参数为是否持久化（true表示是，队列将在服务器重启时生存）、
		// 第三个参数为是否是独占队列（创建者可以使用的私有队列，断开后自动删除）、
		// 第四个参数为当所有消费者客户端连接断开时是否自动删除队列、
		// 第五个参数为队列的其他参数
		channel.queueDeclare(endpointName, false, false, false, null);
	}

	/**
	 * 关闭channel和connection。并非必须，因为隐含是自动调用的。
	 * 
	 * @throws IOException
	 * @throws TimeoutException
	 */
	public void close() throws IOException, TimeoutException {
		this.channel.close();
		this.connection.close();
	}
}
