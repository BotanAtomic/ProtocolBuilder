package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightResultPlayerListEntry extends FightResultFighterListEntry
    implements INetworkType {

  public int level = 0;
  public Vector<FightResultAdditionalData> additional;
  private FuncTree _additionaltree;
  public static final int protocolId = 24;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeVarShort(this.outcome);
    if (this.wave < 0) {
      throw new Error("Forbidden value (" + this.wave + ") on element wave.");
    }
    param1.writeByte(this.wave);
    this.rewards.serializeAs_FightLoot(param1);

    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
    param1.writeBoolean(this.alive);

    if (this.level < 1 || this.level > 206) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);
    param1.writeShort(this.additional.length);
    int _loc2_ = 0;
    while (_loc2_ < this.additional.length) {
      param1.writeShort(((FightResultAdditionalData) (this.additional[_loc2_])).getTypeId());
      ((FightResultAdditionalData) this.additional[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    FightResultAdditionalData _loc5_ = null;
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

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(FightResultAdditionalData, _loc4_);
      _loc5_.deserialize(param1);
      this.additional.push(_loc5_);
      _loc3_++;
    }
  }
}
