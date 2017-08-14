package com.ankamagames.dofus.network.types.game.inventory.preset;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class Preset extends Object implements INetworkType {

  public int presetId = 0;
  public int symbolId = 0;
  public boolean mount = false;
  public Vector<PresetItem> objects;
  private FuncTree _objectstree;
  public static final int protocolId = 355;

  public void serialize(ICustomDataOutput param1) {
    if (this.presetId < 0) {
      throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
    }
    param1.writeByte(this.presetId);
    if (this.symbolId < 0) {
      throw new Exception("Forbidden value (" + this.symbolId + ") on element symbolId.");
    }
    param1.writeByte(this.symbolId);
    param1.writeBoolean(this.mount);
    param1.writeShort(this.objects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objects.length) {
      ((PresetItem) this.objects[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    PresetItem _loc4_ = null;
    this.presetId = param1.readByte();
    if (this.presetId < 0) {
      throw new Exception(
          "Forbidden value (" + this.presetId + ") on element of ShortcutObjectPreset.presetId.");
    }

    this.symbolId = param1.readByte();
    if (this.symbolId < 0) {
      throw new Exception("Forbidden value (" + this.symbolId + ") on element of Preset.symbolId.");
    }

    this.mount = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new PresetItem();
      _loc4_.deserialize(param1);
      this.objects.push(_loc4_);
      _loc3_++;
    }
  }
}
