package com.ankamagames.dofus.network.messages.game.chat.channel;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChannelEnablingMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 890;
    private boolean _isInitialized = false;
    private int channel = 0;
    private boolean enable = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.channel);
         param1.writeBoolean(this.enable);
    }

    public void deserialize(ICustomDataInput param1) {
         this.channel = param1.readByte();
         if(this.channel < 0)
         {
            throw new Exception("Forbidden value (" + this.channel + ") on element of ChannelEnablingMessage.channel.");
         }
         this.enable = param1.readBoolean();
    }

}