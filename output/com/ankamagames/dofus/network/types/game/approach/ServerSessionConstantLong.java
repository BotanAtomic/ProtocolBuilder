package com.ankamagames.dofus.network.types.game.approach;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ServerSessionConstantLong extends ServerSessionConstant implements INetworkType {

    private int protocolId = 429;
    private Number value = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.value < -9.007199254740992E15 || this.value > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.value + ") on element value.");
         }
         param1.writeDouble(this.value);
         if(this.value < -9.007199254740992E15 || this.value > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.value + ") on element value.");
         }
         param1.writeDouble(this.value);
         super.serializeAs_ServerSessionConstant(param1);
         if(this.value < -9.007199254740992E15 || this.value > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.value + ") on element value.");
         }
         param1.writeDouble(this.value);
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
         this.value = param1.readDouble();
         if(this.value < -9.007199254740992E15 || this.value > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.value + ") on element of ServerSessionConstantLong.value.");
         }
    }

}