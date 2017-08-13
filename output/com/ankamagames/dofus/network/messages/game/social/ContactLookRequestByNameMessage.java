package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ContactLookRequestByNameMessage extends ContactLookRequestMessage implements INetworkMessage {

    private int protocolId = 5933;
    private boolean _isInitialized = false;
    private String playerName = "";


    public void serialize(ICustomDataOutput param1) {
         if(this.requestId < 0 || this.requestId > 255)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeByte(this.requestId);
         param1.writeByte(this.contactType);
         param1.writeUTF(this.playerName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ContactLookRequestMessage(param1);
         this.playerName = param1.readUTF();
    }

}