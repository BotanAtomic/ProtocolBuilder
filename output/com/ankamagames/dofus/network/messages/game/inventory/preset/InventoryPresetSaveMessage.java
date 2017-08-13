package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.dofus.network.messages.game.inventory.AbstractPresetSaveMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryPresetSaveMessage extends AbstractPresetSaveMessage implements INetworkMessage {

    private int protocolId = 6165;
    private boolean _isInitialized = false;
    private boolean saveEquipment = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractPresetSaveMessage(param1);
         param1.writeBoolean(this.saveEquipment);
    }

    public void deserialize(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of AbstractPresetSaveMessage.presetId.");
         }
         this.symbolId = param1.readByte();
         if(this.symbolId < 0)
         {
            throw new Exception("Forbidden value (" + this.symbolId + ") on element of AbstractPresetSaveMessage.symbolId.");
         }
         this.saveEquipment = param1.readBoolean();
    }

}