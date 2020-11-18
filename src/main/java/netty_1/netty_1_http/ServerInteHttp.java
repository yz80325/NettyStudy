package netty_1.netty_1_http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;

public class ServerInteHttp extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(new HttpRequestDecoder());
        channel.pipeline().addLast(new HttpRequestEncoder());
        channel.pipeline().addLast(new HttpHandler());
    }
}
