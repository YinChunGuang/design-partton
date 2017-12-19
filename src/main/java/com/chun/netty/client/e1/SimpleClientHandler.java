package com.chun.netty.client.e1;

import com.alibaba.fastjson.JSONObject;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SimpleClientHandler  extends ChannelInboundHandlerAdapter{
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		  
		Response resp = JSONObject.parseObject(msg.toString(),Response.class);
	
		DefaultFuture.receive(resp);
	}
	
	

}
