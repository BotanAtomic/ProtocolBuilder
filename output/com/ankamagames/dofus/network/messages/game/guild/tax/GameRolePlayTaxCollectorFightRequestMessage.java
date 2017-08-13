package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayTaxCollectorFightRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5954;
    private boolean _isInitialized = false;
    private int taxCollectorId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.taxCollectorId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.taxCollectorId = param1.readInt();
    }

}