package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionEmote extends HumanOption implements INetworkType {

  public int emoteId = 0;
  public Number emoteStartTime = 0;
  public static final int protocolId = 407;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.emoteId < 0 || this.emoteId > 255) {
      throw new Error("Forbidden value (" + this.emoteId + ") on element emoteId.");
    }
    param1.writeByte(this.emoteId);
    if (this.emoteStartTime < -9.007199254740992E15 || this.emoteStartTime > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.emoteStartTime + ") on element emoteStartTime.");
    }
    param1.writeDouble(this.emoteStartTime);
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

    this.emoteStartTime = param1.readDouble();
    if (this.emoteStartTime < -9.007199254740992E15 || this.emoteStartTime > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.emoteStartTime
              + ") on element of HumanOptionEmote.emoteStartTime.");
    }
  }
}
