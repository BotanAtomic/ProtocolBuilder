package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class BasicAckMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6362;
    private boolean _isInitialized = false;
    private int seq = 0;
    private int lastPacketId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.seq < 0)
         {
            throw new Exception("Forbidden value (" + this.seq + ") on element seq.");
         }
         param1.writeVarInt(this.seq);
         if(this.lastPacketId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastPacketId + ") on element lastPacketId.");
         }
         param1.writeVarShort(this.lastPacketId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.seq = param1.readVarUhInt();
         if(this.seq < 0)
         {
            throw new Exception("Forbidden value (" + this.seq + ") on element of BasicAckMessage.seq.");
         }
         this.lastPacketId = param1.readVarUhShort();
         if(this.lastPacketId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastPacketId + ") on element of BasicAckMessage.lastPacketId.");
         }
    }

}