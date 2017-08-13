package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SymbioticObjectErrorMessage extends ObjectErrorMessage implements INetworkMessage {

    private int protocolId = 6526;
    private boolean _isInitialized = false;
    private int errorCode = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ObjectErrorMessage(param1);
         param1.writeByte(this.errorCode);
    }

    public void deserialize(ICustomDataInput param1) {
         super.deserialize(param1);
         this._errorCodeFunc(param1);
         this.preview = param1.readBoolean();
         this.errorCode = param1.readByte();
    }

}