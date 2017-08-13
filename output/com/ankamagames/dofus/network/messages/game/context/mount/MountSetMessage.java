package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.MountClientData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountSetMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5968;
    private boolean _isInitialized = false;
    private MountClientData mountData;
    private FuncTree _mountDatatree;


    public void serialize(ICustomDataOutput param1) {
         this.mountData.serializeAs_MountClientData(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.mountData = new MountClientData();
         this.mountData.deserialize(param1);
    }

}