package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameActionFightTackledMessage extends AbstractGameActionMessage implements INetworkMessage {

    private int protocolId = 1004;
    private boolean _isInitialized = false;
    private Number[] tacklersIds;
    private FuncTree _tacklersIdstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionMessage(param1);
         param1.writeShort(this.tacklersIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.tacklersIds.length)
         {
            if(this.tacklersIds[_loc2_] < -9.007199254740992E15 || this.tacklersIds[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.tacklersIds[_loc2_] + ") on element 1 (starting at 1) of tacklersIds.");
            }
            param1.writeDouble(this.tacklersIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = NaN;
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of AbstractGameActionMessage.actionId.");
         }
         this.sourceId = param1.readDouble();
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element of AbstractGameActionMessage.sourceId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readDouble();
            if(_loc4_ < -9.007199254740992E15 || _loc4_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of tacklersIds.");
            }
            this.tacklersIds.push(_loc4_);
            _loc3_++;
         }
    }

}