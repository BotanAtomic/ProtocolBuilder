package com.ankamagames.dofus.network.messages.game.chat.community;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatCommunityChannelCommunityMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6730;
    private boolean _isInitialized = false;
    private int communityId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.communityId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.communityId = param1.readShort();
    }

}