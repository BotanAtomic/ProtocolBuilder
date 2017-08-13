package com.ankamagames.dofus.network.messages.game.context.roleplay.document;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DocumentReadingBeginMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5675;
    private boolean _isInitialized = false;
    private int documentId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.documentId < 0)
         {
            throw new Exception("Forbidden value (" + this.documentId + ") on element documentId.");
         }
         param1.writeVarShort(this.documentId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.documentId = param1.readVarUhShort();
         if(this.documentId < 0)
         {
            throw new Exception("Forbidden value (" + this.documentId + ") on element of DocumentReadingBeginMessage.documentId.");
         }
    }

}