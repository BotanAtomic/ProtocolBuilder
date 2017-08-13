package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;

public class HouseBuyResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5735;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int instanceId = 0;
    private boolean secondHand = false;
    private boolean bought = false;
    private Number realPrice = 0;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.secondHand);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.bought);
         param1.writeByte(_loc2_);
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
         }
         param1.writeVarInt(this.houseId);
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         if(this.realPrice < 0 || this.realPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.realPrice + ") on element realPrice.");
         }
         param1.writeVarLong(this.realPrice);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.secondHand = BooleanByteWrapper.getFlag(_loc2_,0);
         this.bought = BooleanByteWrapper.getFlag(_loc2_,1);
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseBuyResultMessage.houseId.");
         }
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseBuyResultMessage.instanceId.");
         }
         this.realPrice = param1.readVarUhLong();
         if(this.realPrice < 0 || this.realPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.realPrice + ") on element of HouseBuyResultMessage.realPrice.");
         }
    }

}