package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GroupMonsterStaticInformationsWithAlternatives extends GroupMonsterStaticInformations implements INetworkType {

    private int protocolId = 396;
    private Vector.<AlternativeMonstersInGroupLightInformations> alternatives = ;
    private FuncTree _alternativestree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 396;
    }

    public GroupMonsterStaticInformationsWithAlternatives initGroupMonsterStaticInformationsWithAlternatives(MonsterInGroupLightInformations param1,Vector.<MonsterInGroupInformations>  param2,Vector.<AlternativeMonstersInGroupLightInformations>  param3) {
         super.initGroupMonsterStaticInformations(param1,param2);
         this.alternatives = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.alternatives = new Vector.<AlternativeMonstersInGroupLightInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GroupMonsterStaticInformationsWithAlternatives(param1);
    }

    public void serializeAs_GroupMonsterStaticInformationsWithAlternatives(ICustomDataOutput param1) {
         super.serializeAs_GroupMonsterStaticInformations(param1);
         param1.writeShort(this.alternatives.length);
         int _loc2_ = 0;
         while(_loc2_ < this.alternatives.length)
            (this.alternatives[_loc2_] as AlternativeMonstersInGroupLightInformations).serializeAs_AlternativeMonstersInGroupLightInformations(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GroupMonsterStaticInformationsWithAlternatives(param1);
    }

    public void deserializeAs_GroupMonsterStaticInformationsWithAlternatives(ICustomDataInput param1) {
         AlternativeMonstersInGroupLightInformations _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new AlternativeMonstersInGroupLightInformations();
            _loc4_.deserialize(param1);
            this.alternatives.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GroupMonsterStaticInformationsWithAlternatives(param1);
    }

    public void deserializeAsyncAs_GroupMonsterStaticInformationsWithAlternatives(FuncTree param1) {
         super.deserializeAsync(param1);
         this._alternativestree = param1.addChild(this._alternativestreeFunc);
    }

    private void _alternativestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._alternativestree.addChild(this._alternativesFunc);
            _loc3_++;
    }

    private void _alternativesFunc(ICustomDataInput param1) {
         AlternativeMonstersInGroupLightInformations _loc2_ = new AlternativeMonstersInGroupLightInformations();
         _loc2_.deserialize(param1);
         this.alternatives.push(_loc2_);
    }

}