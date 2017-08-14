package com.ankamagames.dofus.network.types.game.idol;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyIdol extends Idol implements INetworkType {

  public Vector<Number> ownersIds;
  private FuncTree _ownersIdstree;
  public static final int protocolId = 490;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarShort(this.id);
    if (this.xpBonusPercent < 0) {
      throw new Error("Forbidden value (" + this.xpBonusPercent + ") on element xpBonusPercent.");
    }
    param1.writeVarShort(this.xpBonusPercent);
    if (this.dropBonusPercent < 0) {
      throw new Error(
          "Forbidden value (" + this.dropBonusPercent + ") on element dropBonusPercent.");
    }
    param1.writeVarShort(this.dropBonusPercent);

    param1.writeShort(this.ownersIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.ownersIds.length) {
      if (this.ownersIds[_loc2_] < 0 || this.ownersIds[_loc2_] > 9.007199254740992E15) {
        throw new Error(
            "Forbidden value ("
                + this.ownersIds[_loc2_]
                + ") on element 1 (starting at 1) of ownersIds.");
      }
      param1.writeVarLong(this.ownersIds[_loc2_]);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = NaN;
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
      _loc4_ = param1.readVarUhLong();
      if (_loc4_ < 0 || _loc4_ > 9.007199254740992E15) {
        throw new Error("Forbidden value (" + _loc4_ + ") on elements of ownersIds.");
      }
      this.ownersIds.push(_loc4_);
      _loc3_++;
    }
  }
}
