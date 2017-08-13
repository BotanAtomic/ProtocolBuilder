package com.ankamagames.dofus.network.messages.game.initialization;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterLoadingCompleteMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6471;


    public void serialize(ICustomDataOutput param1) {
    }

    public void deserialize(ICustomDataInput param1) {
    }

}