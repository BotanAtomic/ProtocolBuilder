package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicWhoIsNoMatchMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 179;
    private boolean _isInitialized = false;
    private String search = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.search);
    }

    public void deserialize(ICustomDataInput param1) {
         this.search = param1.readUTF();
    }

}