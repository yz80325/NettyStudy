package netty_1.netty_1_9.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import netty_1.netty_1_9.codec.MyDecoder;
import netty_1.netty_1_9.codec.MyEncoder;

public class MyCI9 extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //自定义解码器
        channel.pipeline().addLast(new MyDecoder());
        //编码器
        channel.pipeline().addLast(new MyEncoder());
        channel.pipeline().addLast(new MyH9());
    }
}
