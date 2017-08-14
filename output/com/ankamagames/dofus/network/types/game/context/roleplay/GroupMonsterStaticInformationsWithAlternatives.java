package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GroupMonsterStaticInformationsWithAlternatives extends GroupMonsterStaticInformations
    implements INetworkType {

  public Vector<AlternativeMonstersInGroupLightInformations> alternatives;
  private FuncTree _alternativestree;
  public static final int protocolId = 396;

  @Override
  public void serialize(ICustomDataOutput param1) {
    this.mainCreatureLightInfos.serializeAs_MonsterInGroupLightInformations(param1);
    param1.writeShort(this.underlings.length);
    int _loc2_ = 0;
    while (_loc2_ < this.underlings.length) {
      ((MonsterInGroupInformations) this.underlings[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }

    param1.writeShort(this.alternatives.length);
    int _loc2_ = 0;
    while (_loc2_ < this.alternatives.length) {
      ((AlternativeMonstersInGroupLightInformations) this.alternatives[_loc2_])
          .serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    AlternativeMonstersInGroupLightInformations _loc4_ = null;
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
      _loc4_ = new AlternativeMonstersInGroupLightInformations();
      _loc4_.deserialize(param1);
      this.alternatives.push(_loc4_);
      _loc3_++;
    }
  }
}
