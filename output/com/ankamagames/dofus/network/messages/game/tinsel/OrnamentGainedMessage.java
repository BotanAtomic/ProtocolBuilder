package com.ankamagames.dofus.network.messages.game.tinsel;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class OrnamentGainedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6368;
    private boolean _isInitialized = false;
    private int ornamentId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.ornamentId < 0)
         {
            throw new Exception("Forbidden value (" + this.ornamentId + ") on element ornamentId.");
         }
         param1.writeShort(this.ornamentId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.ornamentId = param1.readShort();
         if(this.ornamentId < 0)
         {
            throw new Exception("Forbidden value (" + this.ornamentId + ") on element of OrnamentGainedMessage.ornamentId.");
         }
    }

}