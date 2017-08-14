package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.inventory.preset.Preset;
import com.ankamagames.dofus.network.types.game.inventory.preset.IdolsPreset;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryContentAndPresetMessage extends InventoryContentMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<Preset> presets;
  public Vector<IdolsPreset> idolsPresets;
  private FuncTree _presetstree;
  private FuncTree _idolsPresetstree;
  public static final int protocolId = 6162;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.objects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objects.length) {
      ((ObjectItem) this.objects[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.kamas + ") on element kamas.");
    }
    param1.writeVarLong(this.kamas);

    param1.writeShort(this.presets.length);
    int _loc2_ = 0;
    while (_loc2_ < this.presets.length) {
      ((Preset) this.presets[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    param1.writeShort(this.idolsPresets.length);
    int _loc3_ = 0;
    while (_loc3_ < this.idolsPresets.length) {
      ((IdolsPreset) this.idolsPresets[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    Preset _loc6_ = null;
    IdolsPreset _loc7_ = null;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = new Preset();
      _loc6_.deserialize(param1);
      this.presets.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = new IdolsPreset();
      _loc7_.deserialize(param1);
      this.idolsPresets.push(_loc7_);
      _loc5_++;
    }
  }
}
