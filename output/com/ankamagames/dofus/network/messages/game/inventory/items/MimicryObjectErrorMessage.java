package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MimicryObjectErrorMessage extends SymbioticObjectErrorMessage implements INetworkMessage {

    private int protocolId = 6461;
    private boolean _isInitialized = false;
    private boolean preview = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ObjectErrorMessage(param1);
         param1.writeByte(this.errorCode);
         param1.writeBoolean(this.preview);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SymbioticObjectErrorMessage(param1);
         this.preview = param1.readBoolean();
    }

}