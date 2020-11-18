package netty_1.netty_1_5;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;

public class MyChannel5 extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        //解码转string，
        socketChannel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
        //编码string
        socketChannel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));

        socketChannel.pipeline().addLast(new Handler5());
    }
}
