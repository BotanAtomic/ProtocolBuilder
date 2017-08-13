package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6021;
    private boolean _isInitialized = false;
    private boolean allow = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.allow);
    }

    public void deserialize(ICustomDataInput param1) {
         this.allow = param1.readBoolean();
    }

}