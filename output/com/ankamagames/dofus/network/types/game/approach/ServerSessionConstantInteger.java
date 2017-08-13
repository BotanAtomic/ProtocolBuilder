package com.ankamagames.dofus.network.types.game.approach;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServerSessionConstantInteger extends ServerSessionConstant implements INetworkType {

    private int protocolId = 433;
    private int value = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.variables.length);
         int _loc2_ = 0;
         while(_loc2_ < this.variables.length)
         {
            param1.writeShort((this.variables[_loc2_] as ServerSessionConstant).getTypeId());
            (this.variables[_loc2_] as ServerSessionConstant).serialize(param1);
            _loc2_++;
         }
         param1.writeInt(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         ServerSessionConstant _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(ServerSessionConstant,_loc4_);
            _loc5_.deserialize(param1);
            this.variables.push(_loc5_);
            _loc3_++;
         }
         this.value = param1.readInt();
    }

}