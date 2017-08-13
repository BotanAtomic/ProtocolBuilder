package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class EmotePlayAbstractMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5690;
    private boolean _isInitialized = false;
    private int emoteId = 0;
    private Number emoteStartTime = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.emoteId < 0 || this.emoteId > 255)
         {
            throw new Exception("Forbidden value (" + this.emoteId + ") on element emoteId.");
         }
         param1.writeByte(this.emoteId);
         if(this.emoteStartTime < -9.007199254740992E15 || this.emoteStartTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.emoteStartTime + ") on element emoteStartTime.");
         }
         param1.writeDouble(this.emoteStartTime);
    }

    public void deserialize(ICustomDataInput param1) {
         this.emoteId = param1.readUnsignedByte();
         if(this.emoteId < 0 || this.emoteId > 255)
         {
            throw new Exception("Forbidden value (" + this.emoteId + ") on element of EmotePlayAbstractMessage.emoteId.");
         }
         this.emoteStartTime = param1.readDouble();
         if(this.emoteStartTime < -9.007199254740992E15 || this.emoteStartTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.emoteStartTime + ") on element of EmotePlayAbstractMessage.emoteStartTime.");
         }
    }

}