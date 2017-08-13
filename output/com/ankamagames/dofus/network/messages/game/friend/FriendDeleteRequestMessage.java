package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FriendDeleteRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5603;
    private boolean _isInitialized = false;
    private int accountId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of FriendDeleteRequestMessage.accountId.");
         }
    }

}