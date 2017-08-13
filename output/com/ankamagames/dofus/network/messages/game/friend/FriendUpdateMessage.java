package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.FriendInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class FriendUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5924;
    private boolean _isInitialized = false;
    private FriendInformations friendUpdated;
    private FuncTree _friendUpdatedtree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.friendUpdated.getTypeId());
         this.friendUpdated.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.friendUpdated = ProtocolTypeManager.getInstance(FriendInformations,_loc2_);
         this.friendUpdated.deserialize(param1);
    }

}