package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HouseToSellFilterMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6137;
    private boolean _isInitialized = false;
    private int areaId = 0;
    private int atLeastNbRoom = 0;
    private int atLeastNbChest = 0;
    private int skillRequested = 0;
    private Number maxPrice = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.areaId);
         if(this.atLeastNbRoom < 0)
         {
            throw new Exception("Forbidden value (" + this.atLeastNbRoom + ") on element atLeastNbRoom.");
         }
         param1.writeByte(this.atLeastNbRoom);
         if(this.atLeastNbChest < 0)
         {
            throw new Exception("Forbidden value (" + this.atLeastNbChest + ") on element atLeastNbChest.");
         }
         param1.writeByte(this.atLeastNbChest);
         if(this.skillRequested < 0)
         {
            throw new Exception("Forbidden value (" + this.skillRequested + ") on element skillRequested.");
         }
         param1.writeVarShort(this.skillRequested);
         if(this.maxPrice < 0 || this.maxPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.maxPrice + ") on element maxPrice.");
         }
         param1.writeVarLong(this.maxPrice);
    }

    public void deserialize(ICustomDataInput param1) {
         this.areaId = param1.readInt();
         this.atLeastNbRoom = param1.readByte();
         if(this.atLeastNbRoom < 0)
         {
            throw new Exception("Forbidden value (" + this.atLeastNbRoom + ") on element of HouseToSellFilterMessage.atLeastNbRoom.");
         }
         this.atLeastNbChest = param1.readByte();
         if(this.atLeastNbChest < 0)
         {
            throw new Exception("Forbidden value (" + this.atLeastNbChest + ") on element of HouseToSellFilterMessage.atLeastNbChest.");
         }
         this.skillRequested = param1.readVarUhShort();
         if(this.skillRequested < 0)
         {
            throw new Exception("Forbidden value (" + this.skillRequested + ") on element of HouseToSellFilterMessage.skillRequested.");
         }
         this.maxPrice = param1.readVarUhLong();
         if(this.maxPrice < 0 || this.maxPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.maxPrice + ") on element of HouseToSellFilterMessage.maxPrice.");
         }
    }

}