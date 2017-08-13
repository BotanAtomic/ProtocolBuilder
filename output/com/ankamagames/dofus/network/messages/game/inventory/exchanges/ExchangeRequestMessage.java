package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5505;
    private boolean _isInitialized = false;
    private int exchangeType = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.exchangeType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.exchangeType = param1.readByte();
    }

}