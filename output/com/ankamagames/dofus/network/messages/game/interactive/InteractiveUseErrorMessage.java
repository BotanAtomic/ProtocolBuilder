package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InteractiveUseErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6384;
    private boolean _isInitialized = false;
    private int elemId = 0;
    private int skillInstanceUid = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.elemId < 0)
         {
            throw new Exception("Forbidden value (" + this.elemId + ") on element elemId.");
         }
         param1.writeVarInt(this.elemId);
         if(this.skillInstanceUid < 0)
         {
            throw new Exception("Forbidden value (" + this.skillInstanceUid + ") on element skillInstanceUid.");
         }
         param1.writeVarInt(this.skillInstanceUid);
    }

    public void deserialize(ICustomDataInput param1) {
         this.elemId = param1.readVarUhInt();
         if(this.elemId < 0)
         {
            throw new Exception("Forbidden value (" + this.elemId + ") on element of InteractiveUseErrorMessage.elemId.");
         }
         this.skillInstanceUid = param1.readVarUhInt();
         if(this.skillInstanceUid < 0)
         {
            throw new Exception("Forbidden value (" + this.skillInstanceUid + ") on element of InteractiveUseErrorMessage.skillInstanceUid.");
         }
    }

}