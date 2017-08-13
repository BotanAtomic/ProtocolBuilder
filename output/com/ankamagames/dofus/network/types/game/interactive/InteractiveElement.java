package com.ankamagames.dofus.network.types.game.interactive;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InteractiveElement extends Object implements INetworkType {

    private int protocolId = 80;
    private int elementId = 0;
    private int elementTypeId = 0;
    private InteractiveElementSkill[] enabledSkills;
    private InteractiveElementSkill[] disabledSkills;
    private boolean onCurrentMap = false;
    private FuncTree _enabledSkillstree;
    private FuncTree _disabledSkillstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
         }
         param1.writeInt(this.elementId);
         param1.writeInt(this.elementTypeId);
         param1.writeShort(this.enabledSkills.length);
         int _loc2_ = 0;
         while(_loc2_ < this.enabledSkills.length)
         {
            param1.writeShort((this.enabledSkills[_loc2_] as InteractiveElementSkill).getTypeId());
            (this.enabledSkills[_loc2_] as InteractiveElementSkill).serialize(param1);
            _loc2_++;
         }
         param1.writeShort(this.disabledSkills.length);
         int _loc3_ = 0;
         while(_loc3_ < this.disabledSkills.length)
         {
            param1.writeShort((this.disabledSkills[_loc3_] as InteractiveElementSkill).getTypeId());
            (this.disabledSkills[_loc3_] as InteractiveElementSkill).serialize(param1);
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
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element of InteractiveElement.elementId.");
         }
         this.elementTypeId = param1.readInt();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(InteractiveElementSkill,_loc6_);
            _loc7_.deserialize(param1);
            this.enabledSkills.push(_loc7_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc8_ = param1.readUnsignedShort();
            _loc9_ = ProtocolTypeManager.getInstance(InteractiveElementSkill,_loc8_);
            _loc9_.deserialize(param1);
            this.disabledSkills.push(_loc9_);
            _loc5_++;
         }
         this.onCurrentMap = param1.readBoolean();
    }

}