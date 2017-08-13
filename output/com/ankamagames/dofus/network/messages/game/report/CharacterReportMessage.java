package com.ankamagames.dofus.network.messages.game.report;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterReportMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6079;
    private boolean _isInitialized = false;
    private Number reportedId = 0;
    private int reason = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.reportedId < 0 || this.reportedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.reportedId + ") on element reportedId.");
         }
         param1.writeVarLong(this.reportedId);
         if(this.reason < 0)
         {
            throw new Exception("Forbidden value (" + this.reason + ") on element reason.");
         }
         param1.writeByte(this.reason);
    }

    public void deserialize(ICustomDataInput param1) {
         this.reportedId = param1.readVarUhLong();
         if(this.reportedId < 0 || this.reportedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.reportedId + ") on element of CharacterReportMessage.reportedId.");
         }
         this.reason = param1.readByte();
         if(this.reason < 0)
         {
            throw new Exception("Forbidden value (" + this.reason + ") on element of CharacterReportMessage.reason.");
         }
    }

}