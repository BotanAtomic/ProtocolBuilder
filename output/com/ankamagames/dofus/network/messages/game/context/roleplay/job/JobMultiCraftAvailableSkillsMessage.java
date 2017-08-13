package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class JobMultiCraftAvailableSkillsMessage extends JobAllowMultiCraftRequestMessage implements INetworkMessage {

    private int protocolId = 5747;
    private boolean _isInitialized = false;
    private Number playerId = 0;
    private int[] skills;
    private FuncTree _skillstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_JobAllowMultiCraftRequestMessage(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         param1.writeShort(this.skills.length);
         int _loc2_ = 0;
         while(_loc2_ < this.skills.length)
         {
            if(this.skills[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.skills[_loc2_] + ") on element 2 (starting at 1) of skills.");
            }
            param1.writeVarShort(this.skills[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         this.enabled = param1.readBoolean();
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of JobMultiCraftAvailableSkillsMessage.playerId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of skills.");
            }
            this.skills.push(_loc4_);
            _loc3_++;
         }
    }

}