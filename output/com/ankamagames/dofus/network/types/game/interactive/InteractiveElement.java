package com.ankamagames.dofus.network.types.game.interactive;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveElement extends Object implements INetworkType {

  public int elementId = 0;
  public int elementTypeId = 0;
  public Vector<InteractiveElementSkill> enabledSkills;
  public Vector<InteractiveElementSkill> disabledSkills;
  public boolean onCurrentMap = false;
  private FuncTree _enabledSkillstree;
  private FuncTree _disabledSkillstree;
  public static final int protocolId = 80;

  public void serialize(ICustomDataOutput param1) {
    if (this.elementId < 0) {
      throw new Error("Forbidden value (" + this.elementId + ") on element elementId.");
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
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    InteractiveElementSkill _loc7_ = null;
    int _loc8_ = 0;
    InteractiveElementSkill _loc9_ = null;
    this.elementId = param1.readInt();
    if (this.elementId < 0) {
      throw new Error(
          "Forbidden value (" + this.elementId + ") on element of StatedElement.elementId.");
    }

    this.elementTypeId = param1.readInt();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readUnsignedShort();
      _loc7_ = ProtocolTypeManager.getInstance(InteractiveElementSkill, _loc6_);
      _loc7_.deserialize(param1);
      this.enabledSkills.push(_loc7_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc8_ = param1.readUnsignedShort();
      _loc9_ = ProtocolTypeManager.getInstance(InteractiveElementSkill, _loc8_);
      _loc9_.deserialize(param1);
      this.disabledSkills.push(_loc9_);
      _loc5_++;
    }
    this.onCurrentMap = param1.readBoolean();
  }
}
