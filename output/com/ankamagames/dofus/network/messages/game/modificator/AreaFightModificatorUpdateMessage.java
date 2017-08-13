package com.ankamagames.dofus.network.messages.game.modificator;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AreaFightModificatorUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6493;
    private boolean _isInitialized = false;
    private int spellPairId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.spellPairId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.spellPairId = param1.readInt();
    }

}