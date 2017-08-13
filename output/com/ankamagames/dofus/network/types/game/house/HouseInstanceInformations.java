package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HouseInstanceInformations extends Object implements INetworkType {

    private int protocolId = 511;
    private int instanceId = 0;
    private boolean secondHand = false;
    private boolean isLocked = false;
    private String ownerName = "";
    private Number price = 0;
    private boolean isSaleLocked = false;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.secondHand);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.isLocked);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.isSaleLocked);
         param1.writeByte(_loc2_);
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         param1.writeUTF(this.ownerName);
         if(this.price < -9.007199254740992E15 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.secondHand = BooleanByteWrapper.getFlag(_loc2_,0);
         this.isLocked = BooleanByteWrapper.getFlag(_loc2_,1);
         this.isSaleLocked = BooleanByteWrapper.getFlag(_loc2_,2);
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseInstanceInformations.instanceId.");
         }
         this.ownerName = param1.readUTF();
         this.price = param1.readVarLong();
         if(this.price < -9.007199254740992E15 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element of HouseInstanceInformations.price.");
         }
    }

}