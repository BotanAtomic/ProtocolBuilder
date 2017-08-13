package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class WrapperObjectErrorMessage extends SymbioticObjectErrorMessage implements INetworkMessage {

    private int protocolId = 6529;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_SymbioticObjectErrorMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this._errorCodeFunc(param1);
         this.preview = param1.readBoolean();
         this.errorCode = param1.readByte();
         this._errorCodeFunc(param1);
         this.preview = param1.readBoolean();
         this.errorCode = param1.readByte();
         super.deserialize(param1);
    }

}