package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InventoryPresetItemUpdateErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6211;
    private boolean _isInitialized = false;
    private int code = 1;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.code);
    }

    public void deserialize(ICustomDataInput param1) {
         this.code = param1.readByte();
         if(this.code < 0)
         {
            throw new Exception("Forbidden value (" + this.code + ") on element of InventoryPresetItemUpdateErrorMessage.code.");
         }
    }

}