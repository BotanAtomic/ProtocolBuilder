package com.ankamagames.dofus.network.messages.game.interactive.meeting;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TeleportBuddiesRequestedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6302;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private Number inviterId = 0;
    private Number[] invalidBuddiesIds;
    private FuncTree _invalidBuddiesIdstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
         }
         param1.writeVarShort(this.dungeonId);
         if(this.inviterId < 0 || this.inviterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.inviterId + ") on element inviterId.");
         }
         param1.writeVarLong(this.inviterId);
         param1.writeShort(this.invalidBuddiesIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.invalidBuddiesIds.length)
         {
            if(this.invalidBuddiesIds[_loc2_] < 0 || this.invalidBuddiesIds[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.invalidBuddiesIds[_loc2_] + ") on element 3 (starting at 1) of invalidBuddiesIds.");
            }
            param1.writeVarLong(this.invalidBuddiesIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = NaN;
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of TeleportBuddiesRequestedMessage.dungeonId.");
         }
         this.inviterId = param1.readVarUhLong();
         if(this.inviterId < 0 || this.inviterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.inviterId + ") on element of TeleportBuddiesRequestedMessage.inviterId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhLong();
            if(_loc4_ < 0 || _loc4_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of invalidBuddiesIds.");
            }
            this.invalidBuddiesIds.push(_loc4_);
            _loc3_++;
         }
    }

}