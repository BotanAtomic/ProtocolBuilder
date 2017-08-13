package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PrismSettingsRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6437;
    private boolean _isInitialized = false;
    private int subAreaId = 0;
    private int startDefenseTime = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
         if(this.startDefenseTime < 0)
         {
            throw new Exception("Forbidden value (" + this.startDefenseTime + ") on element startDefenseTime.");
         }
         param1.writeByte(this.startDefenseTime);
    }

    public void deserialize(ICustomDataInput param1) {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Exception("Forbidden value (" + this.subAreaId + ") on element of PrismSettingsRequestMessage.subAreaId.");
         }
         this.startDefenseTime = param1.readByte();
         if(this.startDefenseTime < 0)
         {
            throw new Exception("Forbidden value (" + this.startDefenseTime + ") on element of PrismSettingsRequestMessage.startDefenseTime.");
         }
    }

}