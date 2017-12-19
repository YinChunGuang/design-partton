package com.chun.netty.client.e1;


 

import com.alibaba.fastjson.JSONObject;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class TcpClient {

	static Bootstrap bootstrap = new Bootstrap();
	static ChannelFuture future ;
	static {
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		bootstrap.group(eventLoopGroup);
		bootstrap.channel(NioSocketChannel.class);
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
		bootstrap.handler(new ChannelInitializer<Channel>() {

			@Override
			protected void initChannel(Channel ch) throws Exception {
				ch.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
                ch.pipeline().addLast(new StringDecoder());
            	ch.pipeline().addLast(new SimpleClientHandler());
            	ch.pipeline().addLast(new StringEncoder());
				
			}
		});
		
		try {
			future = bootstrap.connect("",10).sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static Response  send(Request request) {
		
		future.channel().writeAndFlush(JSONObject.toJSONString(request));
		future.channel().writeAndFlush("\r\n");
		
		
		DefaultFuture defaultFuture = new DefaultFuture(request);
		
		
		return defaultFuture.get();
	}

}
