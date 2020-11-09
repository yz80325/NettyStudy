package netty_1_2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf=(ByteBuf) msg;
        byte[]myBytes=new byte[buf.readableBytes()];
        buf.readBytes(myBytes);
        System.out.print(new Date() + "接收到消息：");
        System.out.println(new String(myBytes, Charset.forName("GBK")));
    }
}
