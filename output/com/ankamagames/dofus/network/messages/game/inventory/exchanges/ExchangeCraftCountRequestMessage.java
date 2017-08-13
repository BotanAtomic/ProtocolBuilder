package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCraftCountRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6597;
    private boolean _isInitialized = false;
    private int count = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeVarInt(this.count);
    }

    public void deserialize(ICustomDataInput param1) {
         this.count = param1.readVarInt();
    }

}