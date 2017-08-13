package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatAdminServerMessage extends ChatServerMessage implements INetworkMessage {

    private int protocolId = 6135;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ChatAbstractServerMessage(param1);
         if(this.senderId < -9.007199254740992E15 || this.senderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.senderId + ") on element senderId.");
         }
         param1.writeDouble(this.senderId);
         param1.writeUTF(this.senderName);
         if(this.senderAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.senderAccountId + ") on element senderAccountId.");
         }
         param1.writeInt(this.senderAccountId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChatServerMessage(param1);
    }

}