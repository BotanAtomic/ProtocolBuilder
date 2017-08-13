package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.inventory.preset.Preset;
import com.ankamagames.dofus.network.types.game.inventory.preset.IdolsPreset;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryContentAndPresetMessage extends InventoryContentMessage implements INetworkMessage {

    private int protocolId = 6162;
    private boolean _isInitialized = false;
    private Preset[] presets;
    private IdolsPreset[] idolsPresets;
    private FuncTree _presetstree;
    private FuncTree _idolsPresetstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.objects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objects.length)
         {
            (this.objects[_loc2_] as ObjectItem).serializeAs_ObjectItem(param1);
            _loc2_++;
         }
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element kamas.");
         }
         param1.writeVarLong(this.kamas);
         param1.writeShort(this.presets.length);
         int _loc2_ = 0;
         while(_loc2_ < this.presets.length)
         {
            (this.presets[_loc2_] as Preset).serializeAs_Preset(param1);
            _loc2_++;
         }
         param1.writeShort(this.idolsPresets.length);
         int _loc3_ = 0;
         while(_loc3_ < this.idolsPresets.length)
         {
            (this.idolsPresets[_loc3_] as IdolsPreset).serializeAs_IdolsPreset(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Preset _loc6_ = null;
         IdolsPreset _loc7_ = null;
         this.deserializeAs_InventoryContentMessage(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new Preset();
            _loc6_.deserialize(param1);
            this.presets.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new IdolsPreset();
            _loc7_.deserialize(param1);
            this.idolsPresets.push(_loc7_);
            _loc5_++;
         }
    }

}