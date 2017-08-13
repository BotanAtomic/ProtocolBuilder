package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PaddockToSellFilterMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6161;
    private boolean _isInitialized = false;
    private int areaId = 0;
    private int atLeastNbMount = 0;
    private int atLeastNbMachine = 0;
    private Number maxPrice = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.areaId);
         param1.writeByte(this.atLeastNbMount);
         param1.writeByte(this.atLeastNbMachine);
         if(this.maxPrice < 0 || this.maxPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.maxPrice + ") on element maxPrice.");
         }
         param1.writeVarLong(this.maxPrice);
    }

    public void deserialize(ICustomDataInput param1) {
         this.areaId = param1.readInt();
         this.atLeastNbMount = param1.readByte();
         this.atLeastNbMachine = param1.readByte();
         this.maxPrice = param1.readVarUhLong();
         if(this.maxPrice < 0 || this.maxPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.maxPrice + ") on element of PaddockToSellFilterMessage.maxPrice.");
         }
    }

}