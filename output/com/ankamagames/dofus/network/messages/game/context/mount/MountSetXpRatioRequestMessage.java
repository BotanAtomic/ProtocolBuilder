package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MountSetXpRatioRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5989;
    private boolean _isInitialized = false;
    private int xpRatio = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.xpRatio < 0)
         {
            throw new Exception("Forbidden value (" + this.xpRatio + ") on element xpRatio.");
         }
         param1.writeByte(this.xpRatio);
    }

    public void deserialize(ICustomDataInput param1) {
         this.xpRatio = param1.readByte();
         if(this.xpRatio < 0)
         {
            throw new Exception("Forbidden value (" + this.xpRatio + ") on element of MountSetXpRatioRequestMessage.xpRatio.");
         }
    }

}