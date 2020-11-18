package netty_1.netty_1_9.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyEncoder extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        String msg = o.toString();
        byte[] bytes=msg.getBytes();

        //加上02,03
        byte[] send=new byte[bytes.length+2];
        System.arraycopy(byteBuf,0,send,1,bytes.length);
        send[0]=0x02;
        send[send.length-1]=0x03;

        byteBuf.writeInt(send.length);
        byteBuf.writeBytes(send);
    }
}
