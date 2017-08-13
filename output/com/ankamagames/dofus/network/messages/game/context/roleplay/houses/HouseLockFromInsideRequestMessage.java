package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.dofus.network.messages.game.context.roleplay.lockable.LockableChangeCodeMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseLockFromInsideRequestMessage extends LockableChangeCodeMessage implements INetworkMessage {

    private int protocolId = 5885;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.code);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LockableChangeCodeMessage(param1);
    }

}