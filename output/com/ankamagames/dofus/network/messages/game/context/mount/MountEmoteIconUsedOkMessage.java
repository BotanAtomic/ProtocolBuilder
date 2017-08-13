package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MountEmoteIconUsedOkMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5978;
    private boolean _isInitialized = false;
    private int mountId = 0;
    private int reactionType = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeVarInt(this.mountId);
         if(this.reactionType < 0)
         {
            throw new Exception("Forbidden value (" + this.reactionType + ") on element reactionType.");
         }
         param1.writeByte(this.reactionType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.mountId = param1.readVarInt();
         this.reactionType = param1.readByte();
         if(this.reactionType < 0)
         {
            throw new Exception("Forbidden value (" + this.reactionType + ") on element of MountEmoteIconUsedOkMessage.reactionType.");
         }
    }

}