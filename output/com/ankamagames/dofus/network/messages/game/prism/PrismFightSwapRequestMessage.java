package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PrismFightSwapRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5901;
    private boolean _isInitialized = false;
    private int subAreaId = 0;
    private Number targetId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         if(this.targetId < 0 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeVarLong(this.targetId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PrismFightSwapRequestMessage.subAreaId.");
         }
         this.targetId = param1.readVarUhLong();
         if(this.targetId < 0 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of PrismFightSwapRequestMessage.targetId.");
         }
    }

}