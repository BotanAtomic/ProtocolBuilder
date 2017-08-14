package com.ankamagames.dofus.network.types.game.shortcut;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ShortcutObjectPreset extends ShortcutObject implements INetworkType {

  public int presetId = 0;
  public static final int protocolId = 370;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.slot < 0 || this.slot > 99) {
      throw new Exception("Forbidden value (" + this.slot + ") on element slot.");
    }
    param1.writeByte(this.slot);

    if (this.presetId < 0) {
      throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
    }
    param1.writeByte(this.presetId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.presetId = param1.readByte();
    if (this.presetId < 0) {
      throw new Exception(
          "Forbidden value (" + this.presetId + ") on element of ShortcutObjectPreset.presetId.");
    }
  }
}
