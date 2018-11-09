package com.zhd.basics.javabase.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {
	/* 标识数字 */
	private static int flag = 0;
	/* 缓冲区大小 */
	private static int BLOCK = 4096;
	/* 接受数据缓冲区 */
	private static ByteBuffer sendbuffer = ByteBuffer.allocate(BLOCK);
	/* 发送数据缓冲区 */
	private static ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);
	/* 服务器端地址 */

	private Selector selector;

	public NIOClient(String ip, int port) throws IOException {
		// 打开socket通道
		SocketChannel socketChannel = SocketChannel.open();
		// 设置为非阻塞方式
		socketChannel.configureBlocking(false);
		// 打开选择器
		selector = Selector.open();
		// 注册连接服务端socket动作
		socketChannel.register(selector, SelectionKey.OP_CONNECT);

		InetSocketAddress SERVER_ADDRESS = new InetSocketAddress(ip, port);
		// 连接
		socketChannel.connect(SERVER_ADDRESS);
		// 分配缓冲区大小内存
	}

	private void send() throws IOException {
		SocketChannel client;
		String receiveText;
		String sendText;
		int count = 0;

		while (true) {
			// 选择一组键，其相应的通道已为 I/O 操作准备就绪。
			// 此方法执行处于阻塞模式的选择操作。
			selector.select();
			// 返回此选择器的已选择键集。
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			// System.out.println(selectionKeys.size());
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				if (selectionKey.isConnectable()) {
					System.out.println("NIOClient:client connect");
					client = (SocketChannel) selectionKey.channel();
					// 判断此通道上是否正在进行连接操作。
					// 完成套接字通道的连接过程。
					if (client.isConnectionPending()) {
						client.finishConnect();
						System.out.println("NIOClient:完成连接!");
						sendbuffer.clear();
						sendbuffer.put("Hello,Server".getBytes());
						sendbuffer.flip();
						client.write(sendbuffer);
					}
					client.register(selector, SelectionKey.OP_READ);
				} else if (selectionKey.isReadable()) {
					client = (SocketChannel) selectionKey.channel();
					// 将缓冲区清空以备下次读取
					receivebuffer.clear();
					// 读取服务器发送来的数据到缓冲区中
					count = client.read(receivebuffer);
					if (count > 0) {
						receiveText = new String(receivebuffer.array(), 0, count);
						System.out.println("NIOClient:客户端接受服务器端数据--:" + receiveText);
						client.register(selector, SelectionKey.OP_WRITE);
					}

				} else if (selectionKey.isWritable()) {
					sendbuffer.clear();
					client = (SocketChannel) selectionKey.channel();
					sendText = "message from client--" + (flag++);
					sendbuffer.put(sendText.getBytes());
					// 将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
					sendbuffer.flip();
					client.write(sendbuffer);
					System.out.println("NIOClient:客户端向服务器端发送数据--：" + sendText);
					client.register(selector, SelectionKey.OP_READ);
				}
			}
			selectionKeys.clear();
		}

	}

	private void send(String msg) throws IOException {
		SocketChannel client;
		String receiveText;
		String sendText;
		int count = 0;

		// 选择一组键，其相应的通道已为 I/O 操作准备就绪。
		// 此方法执行处于阻塞模式的选择操作。
		selector.select();
		// 返回此选择器的已选择键集。
		Set<SelectionKey> selectionKeys = selector.selectedKeys();
		// System.out.println(selectionKeys.size());
		Iterator<SelectionKey> iterator = selectionKeys.iterator();
		while (iterator.hasNext()) {
			SelectionKey selectionKey = iterator.next();
			if (selectionKey.isConnectable()) {
				System.out.println("NIOClient:client connect");
				client = (SocketChannel) selectionKey.channel();
				// 判断此通道上是否正在进行连接操作。
				// 完成套接字通道的连接过程。
				if (client.isConnectionPending()) {
					client.finishConnect();
					System.out.println("NIOClient:完成连接!");
					sendbuffer.clear();
					sendbuffer.put(msg.getBytes());
					sendbuffer.flip();
					client.write(sendbuffer);
				}
				client.register(selector, SelectionKey.OP_READ);
			} else if (selectionKey.isReadable()) {
				client = (SocketChannel) selectionKey.channel();
				// 将缓冲区清空以备下次读取
				receivebuffer.clear();
				// 读取服务器发送来的数据到缓冲区中
				count = client.read(receivebuffer);
				if (count > 0) {
					receiveText = new String(receivebuffer.array(), 0, count);
					System.out.println("NIOClient:客户端接受服务器端数据--:" + receiveText);
					client.register(selector, SelectionKey.OP_WRITE);
				}

			} else if (selectionKey.isWritable()) {
				sendbuffer.clear();
				client = (SocketChannel) selectionKey.channel();
				sendText = "message from client--" + (flag++);
				sendbuffer.put(sendText.getBytes());
				// 将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
				sendbuffer.flip();
				client.write(sendbuffer);
				System.out.println("NIOClient:客户端向服务器端发送数据--：" + sendText);
				client.register(selector, SelectionKey.OP_READ);
			}
		}
		selectionKeys.clear();

	}

	public static void main(String[] args) throws IOException {
		NIOClient nioClient = new NIOClient("127.0.0.1", 8888);
		nioClient.send("你好 我是client");
	}

}
