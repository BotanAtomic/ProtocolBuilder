package com.ankamagames.dofus.network.messages.game.almanach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlmanachCalendarDateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6341;
    private boolean _isInitialized = false;
    private int date = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.date);
    }

    public void deserialize(ICustomDataInput param1) {
         this.date = param1.readInt();
    }

}