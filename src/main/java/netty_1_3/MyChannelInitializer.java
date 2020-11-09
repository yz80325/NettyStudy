package netty_1_3;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.charset.Charset;

public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        /*解码器
        * */
        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 基于指定字符串【换行符，这样功能等同于LineBasedFrameDecoder】
        // e.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, false, Delimiters.lineDelimiter()));
        // 基于最大长度
        // e.pipeline().addLast(new FixedLengthFrameDecoder(4));
        socketChannel.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
        socketChannel.pipeline().addLast(new MyServerHandler());

    }
}
