package com.ankamagames.dofus.network.messages.game.script;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class URLOpenMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6266;
    private boolean _isInitialized = false;
    private int urlId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.urlId < 0)
         {
            throw new Exception("Forbidden value (" + this.urlId + ") on element urlId.");
         }
         param1.writeByte(this.urlId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.urlId = param1.readByte();
         if(this.urlId < 0)
         {
            throw new Exception("Forbidden value (" + this.urlId + ") on element of URLOpenMessage.urlId.");
         }
    }

}