package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5515;
    private boolean _isInitialized = false;
    private boolean remote = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.remote);
    }

    public void deserialize(ICustomDataInput param1) {
         this.remote = param1.readBoolean();
    }

}