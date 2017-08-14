package com.ankamagames.dofus.network.types.game.shortcut;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ShortcutEmote extends Shortcut implements INetworkType {

  public int emoteId = 0;
  public static final int protocolId = 389;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.slot < 0 || this.slot > 99) {
      throw new Error("Forbidden value (" + this.slot + ") on element slot.");
    }
    param1.writeByte(this.slot);

    if (this.emoteId < 0 || this.emoteId > 255) {
      throw new Error("Forbidden value (" + this.emoteId + ") on element emoteId.");
    }
    param1.writeByte(this.emoteId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
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

    this.emoteId = param1.readUnsignedByte();
    if (this.emoteId < 0 || this.emoteId > 255) {
      throw new Error(
          "Forbidden value (" + this.emoteId + ") on element of ShortcutEmote.emoteId.");
    }
  }
}
