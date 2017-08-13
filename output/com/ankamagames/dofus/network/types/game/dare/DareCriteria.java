package com.ankamagames.dofus.network.types.game.dare;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DareCriteria extends Object implements INetworkType {

    private int protocolId = 501;
    private int type = 0;
    private int[] params;
    private FuncTree _paramstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.type);
         param1.writeShort(this.params.length);
         int _loc2_ = 0;
         while(_loc2_ < this.params.length)
         {
            param1.writeInt(this.params[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = 0;
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of DareCriteria.type.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readInt();
            this.params.push(_loc4_);
            _loc3_++;
         }
    }

}