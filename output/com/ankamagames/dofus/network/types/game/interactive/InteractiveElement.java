package package com.ankamagames.dofus.network.types.game.interactive;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class InteractiveElement extends Object implements INetworkType {

    private int protocolId = 80;
    private int elementId = 0;
    private int elementTypeId = 0;
    private Vector.<InteractiveElementSkill> enabledSkills = ;
    private Vector.<InteractiveElementSkill> disabledSkills = ;
    private boolean onCurrentMap = false;
    private FuncTree _enabledSkillstree = ;
    private FuncTree _disabledSkillstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private InteractiveElementSkill _loc7_ = null;
    private int _loc8_ = 0;
    private InteractiveElementSkill _loc9_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private InteractiveElementSkill _loc3_ = ProtocolTypeManager.getInstance(InteractiveElementSkill,_loc2_);
    private int _loc3_ = 0;
    private InteractiveElementSkill _loc3_ = ProtocolTypeManager.getInstance(InteractiveElementSkill,_loc2_);


    public int getTypeId() {
         return 80;
    }

    public InteractiveElement initInteractiveElement(int param1,int  param2,Vector.<InteractiveElementSkill>  param3,Vector.<InteractiveElementSkill>  param4,boolean  param5) {
         this.elementId = param1;
         this.elementTypeId = param2;
         this.enabledSkills = param3;
         this.disabledSkills = param4;
         this.onCurrentMap = param5;
         return this;
    }

    public void reset() {
         this.elementId = 0;
         this.elementTypeId = 0;
         this.enabledSkills = new Vector.<InteractiveElementSkill>();
         this.disabledSkills = new Vector.<InteractiveElementSkill>();
         this.onCurrentMap = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_InteractiveElement(param1);
    }

    public void serializeAs_InteractiveElement(ICustomDataOutput param1) {
         if(this.elementId < 0)
            throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveElement(param1);
    }

    public void deserializeAs_InteractiveElement(ICustomDataInput param1) {
         int _loc6_ = 0;
         InteractiveElementSkill _loc7_ = null;
         int _loc8_ = 0;
         InteractiveElementSkill _loc9_ = null;
         this._elementIdFunc(param1);
         this._elementTypeIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(InteractiveElementSkill,_loc6_);
            _loc7_.deserialize(param1);
            this.enabledSkills.push(_loc7_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InteractiveElement(param1);
    }

    public void deserializeAsyncAs_InteractiveElement(FuncTree param1) {
         param1.addChild(this._elementIdFunc);
         param1.addChild(this._elementTypeIdFunc);
         this._enabledSkillstree = param1.addChild(this._enabledSkillstreeFunc);
         this._disabledSkillstree = param1.addChild(this._disabledSkillstreeFunc);
         param1.addChild(this._onCurrentMapFunc);
    }

    private void _elementIdFunc(ICustomDataInput param1) {
         this.elementId = param1.readInt();
         if(this.elementId < 0)
            throw new Exception("Forbidden value (" + this.elementId + ") on element of InteractiveElement.elementId.");
    }

    private void _elementTypeIdFunc(ICustomDataInput param1) {
         this.elementTypeId = param1.readInt();
    }

    private void _enabledSkillstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._enabledSkillstree.addChild(this._enabledSkillsFunc);
            _loc3_++;
    }

    private void _enabledSkillsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         InteractiveElementSkill _loc3_ = ProtocolTypeManager.getInstance(InteractiveElementSkill,_loc2_);
         _loc3_.deserialize(param1);
         this.enabledSkills.push(_loc3_);
    }

    private void _disabledSkillstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._disabledSkillstree.addChild(this._disabledSkillsFunc);
            _loc3_++;
    }

    private void _disabledSkillsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         InteractiveElementSkill _loc3_ = ProtocolTypeManager.getInstance(InteractiveElementSkill,_loc2_);
         _loc3_.deserialize(param1);
         this.disabledSkills.push(_loc3_);
    }

    private void _onCurrentMapFunc(ICustomDataInput param1) {
         this.onCurrentMap = param1.readBoolean();
    }

}