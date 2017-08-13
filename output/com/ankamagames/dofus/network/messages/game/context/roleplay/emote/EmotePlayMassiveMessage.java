package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class EmotePlayMassiveMessage extends EmotePlayAbstractMessage implements INetworkMessage {

    private int protocolId = 5691;
    private boolean _isInitialized = false;
    private Number[] actorIds;
    private FuncTree _actorIdstree;


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
         param1.writeShort(this.actorIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.actorIds.length)
         {
            if(this.actorIds[_loc2_] < -9.007199254740992E15 || this.actorIds[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.actorIds[_loc2_] + ") on element 1 (starting at 1) of actorIds.");
            }
            param1.writeDouble(this.actorIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = NaN;
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
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readDouble();
            if(_loc4_ < -9.007199254740992E15 || _loc4_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of actorIds.");
            }
            this.actorIds.push(_loc4_);
            _loc3_++;
         }
    }

}