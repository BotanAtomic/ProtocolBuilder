package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ContactLookRequestByIdMessage extends ContactLookRequestMessage implements INetworkMessage {

    private int protocolId = 5935;
    private boolean _isInitialized = false;
    private Number playerId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.requestId < 0 || this.requestId > 255)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeByte(this.requestId);
         param1.writeByte(this.contactType);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ContactLookRequestMessage(param1);
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of ContactLookRequestByIdMessage.playerId.");
         }
    }

}