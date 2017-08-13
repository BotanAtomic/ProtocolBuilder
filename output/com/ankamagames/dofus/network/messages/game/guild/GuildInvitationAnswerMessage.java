package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInvitationAnswerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5556;
    private boolean _isInitialized = false;
    private boolean accept = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.accept);
    }

    public void deserialize(ICustomDataInput param1) {
         this.accept = param1.readBoolean();
    }

}