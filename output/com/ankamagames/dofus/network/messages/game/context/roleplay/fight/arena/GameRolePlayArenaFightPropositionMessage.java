package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayArenaFightPropositionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6276;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private Number[] alliesId;
    private int duration = 0;
    private FuncTree _alliesIdtree;


    public void serialize(ICustomDataOutput param1) {
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeInt(this.fightId);
         param1.writeShort(this.alliesId.length);
         int _loc2_ = 0;
         while(_loc2_ < this.alliesId.length)
         {
            if(this.alliesId[_loc2_] < -9.007199254740992E15 || this.alliesId[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.alliesId[_loc2_] + ") on element 2 (starting at 1) of alliesId.");
            }
            param1.writeDouble(this.alliesId[_loc2_]);
            _loc2_++;
         }
         if(this.duration < 0)
         {
            throw new Exception("Forbidden value (" + this.duration + ") on element duration.");
         }
         param1.writeVarShort(this.duration);
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = NaN;
         this.fightId = param1.readInt();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of GameRolePlayArenaFightPropositionMessage.fightId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readDouble();
            if(_loc4_ < -9.007199254740992E15 || _loc4_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of alliesId.");
            }
            this.alliesId.push(_loc4_);
            _loc3_++;
         }
         this.duration = param1.readVarUhShort();
         if(this.duration < 0)
         {
            throw new Exception("Forbidden value (" + this.duration + ") on element of GameRolePlayArenaFightPropositionMessage.duration.");
         }
    }

}