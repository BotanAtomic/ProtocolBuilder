package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class EmotePlayMessage extends EmotePlayAbstractMessage implements INetworkMessage {

    private int protocolId = 5683;
    private boolean _isInitialized = false;
    private Number actorId = 0;
    private int accountId = 0;


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
         if(this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.actorId + ") on element actorId.");
         }
         param1.writeDouble(this.actorId);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
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
         this.actorId = param1.readDouble();
         if(this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.actorId + ") on element of EmotePlayMessage.actorId.");
         }
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of EmotePlayMessage.accountId.");
         }
    }

}