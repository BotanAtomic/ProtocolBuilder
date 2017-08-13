package com.ankamagames.dofus.network.messages.handshake;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ProtocolRequired extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1;
    private boolean _isInitialized = false;
    private int requiredVersion = 0;
    private int currentVersion = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.requiredVersion < 0)
         {
            throw new Exception("Forbidden value (" + this.requiredVersion + ") on element requiredVersion.");
         }
         param1.writeInt(this.requiredVersion);
         if(this.currentVersion < 0)
         {
            throw new Exception("Forbidden value (" + this.currentVersion + ") on element currentVersion.");
         }
         param1.writeInt(this.currentVersion);
    }

    public void deserialize(ICustomDataInput param1) {
         this.requiredVersion = param1.readInt();
         if(this.requiredVersion < 0)
         {
            throw new Exception("Forbidden value (" + this.requiredVersion + ") on element of ProtocolRequired.requiredVersion.");
         }
         this.currentVersion = param1.readInt();
         if(this.currentVersion < 0)
         {
            throw new Exception("Forbidden value (" + this.currentVersion + ") on element of ProtocolRequired.currentVersion.");
         }
    }

}