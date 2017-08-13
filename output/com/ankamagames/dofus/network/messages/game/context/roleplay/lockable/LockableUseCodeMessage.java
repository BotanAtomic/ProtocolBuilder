package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LockableUseCodeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5667;
    private boolean _isInitialized = false;
    private String code = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.code);
    }

    public void deserialize(ICustomDataInput param1) {
         this.code = param1.readUTF();
    }

}