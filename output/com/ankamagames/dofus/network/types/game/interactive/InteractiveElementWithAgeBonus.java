package com.ankamagames.dofus.network.types.game.interactive;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveElementWithAgeBonus extends InteractiveElement implements INetworkType {

  public int ageBonus = 0;
  public static final int protocolId = 398;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.elementId < 0) {
      throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
    }
    param1.writeInt(this.elementId);
    param1.writeInt(this.elementTypeId);
    param1.writeShort(this.enabledSkills.length);
    int _loc2_ = 0;
    while (_loc2_ < this.enabledSkills.length) {
      param1.writeShort(((InteractiveElementSkill) (this.enabledSkills[_loc2_])).getTypeId());
      ((InteractiveElementSkill) this.enabledSkills[_loc2_]).serialize(param1);
      _loc2_++;
    }
    param1.writeShort(this.disabledSkills.length);
    int _loc3_ = 0;
    while (_loc3_ < this.disabledSkills.length) {
      param1.writeShort(((InteractiveElementSkill) (this.disabledSkills[_loc3_])).getTypeId());
      ((InteractiveElementSkill) this.disabledSkills[_loc3_]).serialize(param1);
      _loc3_++;
    }
    param1.writeBoolean(this.onCurrentMap);

    if (this.ageBonus < -1 || this.ageBonus > 1000) {
      throw new Exception("Forbidden value (" + this.ageBonus + ") on element ageBonus.");
    }
    param1.writeShort(this.ageBonus);
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

    this.ageBonus = param1.readShort();
    if (this.ageBonus < -1 || this.ageBonus > 1000) {
      throw new Exception(
          "Forbidden value ("
              + this.ageBonus
              + ") on element of InteractiveElementWithAgeBonus.ageBonus.");
    }
  }
}
