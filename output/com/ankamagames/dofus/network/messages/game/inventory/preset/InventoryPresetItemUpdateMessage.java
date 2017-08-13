package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.inventory.preset.PresetItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InventoryPresetItemUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6168;
    private boolean _isInitialized = false;
    private int presetId = 0;
    private PresetItem presetItem;
    private FuncTree _presetItemtree;


    public void serialize(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         this.presetItem.serializeAs_PresetItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of InventoryPresetItemUpdateMessage.presetId.");
         }
         this.presetItem = new PresetItem();
         this.presetItem.deserialize(param1);
    }

}