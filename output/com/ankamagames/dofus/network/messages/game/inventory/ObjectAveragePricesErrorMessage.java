package com.ankamagames.dofus.network.messages.game.inventory;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectAveragePricesErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6336;


    public void serialize(ICustomDataOutput param1) {
    }

    public void deserialize(ICustomDataInput param1) {
    }

}