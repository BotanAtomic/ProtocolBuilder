package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorStateUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6455;
    private boolean _isInitialized = false;
    private int uniqueId = 0;
    private int state = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.uniqueId);
         param1.writeByte(this.state);
    }

    public void deserialize(ICustomDataInput param1) {
         this.uniqueId = param1.readInt();
         this.state = param1.readByte();
    }

}