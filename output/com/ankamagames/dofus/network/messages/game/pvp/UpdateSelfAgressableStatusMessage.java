package com.ankamagames.dofus.network.messages.game.pvp;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class UpdateSelfAgressableStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6456;
    private boolean _isInitialized = false;
    private int status = 0;
    private int probationTime = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.status);
         if(this.probationTime < 0)
         {
            throw new Exception("Forbidden value (" + this.probationTime + ") on element probationTime.");
         }
         param1.writeInt(this.probationTime);
    }

    public void deserialize(ICustomDataInput param1) {
         this.status = param1.readByte();
         if(this.status < 0)
         {
            throw new Exception("Forbidden value (" + this.status + ") on element of UpdateSelfAgressableStatusMessage.status.");
         }
         this.probationTime = param1.readInt();
         if(this.probationTime < 0)
         {
            throw new Exception("Forbidden value (" + this.probationTime + ") on element of UpdateSelfAgressableStatusMessage.probationTime.");
         }
    }

}