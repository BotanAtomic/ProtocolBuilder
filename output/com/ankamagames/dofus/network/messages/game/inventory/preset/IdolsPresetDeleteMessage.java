package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.dofus.network.messages.game.inventory.AbstractPresetDeleteMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdolsPresetDeleteMessage extends AbstractPresetDeleteMessage implements INetworkMessage {

    private int protocolId = 6602;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of AbstractPresetDeleteMessage.presetId.");
         }
    }

}