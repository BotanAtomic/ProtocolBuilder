package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.version.Version;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentificationFailedForBadVersionMessage extends IdentificationFailedMessage implements INetworkMessage {

    private int protocolId = 21;
    private boolean _isInitialized = false;
    private Version requiredVersion;
    private FuncTree _requiredVersiontree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.reason);
         this.requiredVersion.serializeAs_Version(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdentificationFailedMessage(param1);
         this.requiredVersion = new Version();
         this.requiredVersion.deserialize(param1);
    }

}