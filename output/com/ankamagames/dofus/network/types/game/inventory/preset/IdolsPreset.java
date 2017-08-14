package com.ankamagames.dofus.network.types.game.inventory.preset;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdolsPreset extends Object implements INetworkType {

  public int presetId = 0;
  public int symbolId = 0;
  public Vector<uint> idolId;
  private FuncTree _idolIdtree;
  public static final int protocolId = 491;

  public void serialize(ICustomDataOutput param1) {
    if (this.presetId < 0) {
      throw new Error("Forbidden value (" + this.presetId + ") on element presetId.");
    }
    param1.writeByte(this.presetId);
    if (this.symbolId < 0) {
      throw new Error("Forbidden value (" + this.symbolId + ") on element symbolId.");
    }
    param1.writeByte(this.symbolId);
    param1.writeShort(this.idolId.length);
    int _loc2_ = 0;
    while (_loc2_ < this.idolId.length) {
      if (this.idolId[_loc2_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.idolId[_loc2_]
                + ") on element 3 (starting at 1) of idolId.");
      }
      param1.writeVarShort(this.idolId[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    this.presetId = param1.readByte();
    if (this.presetId < 0) {
      throw new Error(
          "Forbidden value (" + this.presetId + ") on element of ShortcutObjectPreset.presetId.");
    }

    this.symbolId = param1.readByte();
    if (this.symbolId < 0) {
      throw new Error("Forbidden value (" + this.symbolId + ") on element of Preset.symbolId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readVarUhShort();
      if (_loc4_ < 0) {
        throw new Error("Forbidden value (" + _loc4_ + ") on elements of idolId.");
      }
      this.idolId.push(_loc4_);
      _loc3_++;
    }
  }
}
