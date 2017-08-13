package com.ankamagames.dofus.network.messages.security;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class RawDataMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6253;
    private boolean _isInitialized = false;
    private ByteArray content;


    public void serialize(ICustomDataOutput param1) {
         param1.writeVarInt(this.content.length);
         int _loc2_ = 0;
         while(_loc2_ < this.content.length)
         {
            param1.writeByte(this.content[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         param1.readBytes(this.content,0,_loc2_);
    }

}