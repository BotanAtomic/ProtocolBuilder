package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PrismUseRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6041;
    private boolean _isInitialized = false;
    private int moduleToUse = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.moduleToUse);
    }

    public void deserialize(ICustomDataInput param1) {
         this.moduleToUse = param1.readByte();
         if(this.moduleToUse < 0)
         {
            throw new Exception("Forbidden value (" + this.moduleToUse + ") on element of PrismUseRequestMessage.moduleToUse.");
         }
    }

}