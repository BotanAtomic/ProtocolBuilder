package com.ankamagames.dofus.network.messages.game.interactive.skill;

import com.ankamagames.dofus.network.messages.game.interactive.InteractiveUseRequestMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveUseWithParamRequestMessage extends InteractiveUseRequestMessage implements INetworkMessage {

    private int protocolId = 6715;
    private boolean _isInitialized = false;
    private int id = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_InteractiveUseRequestMessage(param1);
         param1.writeInt(this.id);
    }

    public void deserialize(ICustomDataInput param1) {
         this.elemId = param1.readVarUhInt();
         if(this.elemId < 0)
         {
            throw new Exception("Forbidden value (" + this.elemId + ") on element of InteractiveUseRequestMessage.elemId.");
         }
         this.skillInstanceUid = param1.readVarUhInt();
         if(this.skillInstanceUid < 0)
         {
            throw new Exception("Forbidden value (" + this.skillInstanceUid + ") on element of InteractiveUseRequestMessage.skillInstanceUid.");
         }
         this.id = param1.readInt();
    }

}