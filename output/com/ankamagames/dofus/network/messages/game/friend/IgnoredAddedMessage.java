package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.IgnoredInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class IgnoredAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5678;
    private boolean _isInitialized = false;
    private IgnoredInformations ignoreAdded;
    private boolean session = false;
    private FuncTree _ignoreAddedtree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.ignoreAdded.getTypeId());
         this.ignoreAdded.serialize(param1);
         param1.writeBoolean(this.session);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.ignoreAdded = ProtocolTypeManager.getInstance(IgnoredInformations,_loc2_);
         this.ignoreAdded.deserialize(param1);
         this.session = param1.readBoolean();
    }

}