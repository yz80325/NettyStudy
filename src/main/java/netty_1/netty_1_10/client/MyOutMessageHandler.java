package netty_1.netty_1_10.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class MyOutMessageHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("Out.read 发来一条信息\n");
        super.read(ctx);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ctx.writeAndFlush("ChannelOutboundHandlerAdapter.write 发来一条消息\r\n");
        super.write(ctx, msg, promise);
    }
}
