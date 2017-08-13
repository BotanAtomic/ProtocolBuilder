package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DareRewardConsumeRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6676;
    private boolean _isInitialized = false;
    private Number dareId = 0;
    private int type = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.dareId < -9.007199254740992E15 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
         }
         param1.writeDouble(this.dareId);
         param1.writeByte(this.type);
    }

    public void deserialize(ICustomDataInput param1) {
         this.dareId = param1.readDouble();
         if(this.dareId < -9.007199254740992E15 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element of DareRewardConsumeRequestMessage.dareId.");
         }
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of DareRewardConsumeRequestMessage.type.");
         }
    }

}