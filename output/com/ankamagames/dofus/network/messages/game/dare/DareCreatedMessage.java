package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareCreatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6668;
    private boolean _isInitialized = false;
    private DareInformations dareInfos;
    private boolean needNotifications = false;
    private FuncTree _dareInfostree;


    public void serialize(ICustomDataOutput param1) {
         this.dareInfos.serializeAs_DareInformations(param1);
         param1.writeBoolean(this.needNotifications);
    }

    public void deserialize(ICustomDataInput param1) {
         this.dareInfos = new DareInformations();
         this.dareInfos.deserialize(param1);
         this.needNotifications = param1.readBoolean();
    }

}