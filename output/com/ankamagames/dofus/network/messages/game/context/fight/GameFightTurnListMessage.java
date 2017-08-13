package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightTurnListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 713;
    private boolean _isInitialized = false;
    private Number[] ids;
    private Number[] deadsIds;
    private FuncTree _idstree;
    private FuncTree _deadsIdstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.ids.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ids.length)
         {
            if(this.ids[_loc2_] < -9.007199254740992E15 || this.ids[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.ids[_loc2_] + ") on element 1 (starting at 1) of ids.");
            }
            param1.writeDouble(this.ids[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.deadsIds.length);
         int _loc3_ = 0;
         while(_loc3_ < this.deadsIds.length)
         {
            if(this.deadsIds[_loc3_] < -9.007199254740992E15 || this.deadsIds[_loc3_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.deadsIds[_loc3_] + ") on element 2 (starting at 1) of deadsIds.");
            }
            param1.writeDouble(this.deadsIds[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc6_ = NaN;
         Object _loc7_ = NaN;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readDouble();
            if(_loc6_ < -9.007199254740992E15 || _loc6_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of ids.");
            }
            this.ids.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readDouble();
            if(_loc7_ < -9.007199254740992E15 || _loc7_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of deadsIds.");
            }
            this.deadsIds.push(_loc7_);
            _loc5_++;
         }
    }

}