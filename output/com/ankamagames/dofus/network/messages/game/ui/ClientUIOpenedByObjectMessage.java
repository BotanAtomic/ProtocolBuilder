package com.ankamagames.dofus.network.messages.game.ui;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ClientUIOpenedByObjectMessage extends ClientUIOpenedMessage implements INetworkMessage {

    private int protocolId = 6463;
    private boolean _isInitialized = false;
    private int uid = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.type);
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
         }
         param1.writeVarInt(this.uid);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ClientUIOpenedMessage(param1);
         this.uid = param1.readVarUhInt();
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element of ClientUIOpenedByObjectMessage.uid.");
         }
    }

}