package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GroupMonsterStaticInformationsWithAlternatives extends GroupMonsterStaticInformations implements INetworkType {

    private int protocolId = 396;
    private AlternativeMonstersInGroupLightInformations[] alternatives;
    private FuncTree _alternativestree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.alternatives.length);
         int _loc2_ = 0;
         while(_loc2_ < this.alternatives.length)
         {
            (this.alternatives[_loc2_] as AlternativeMonstersInGroupLightInformations).serializeAs_AlternativeMonstersInGroupLightInformations(param1);
            _loc2_++;
         }
         param1.writeShort(this.alternatives.length);
         int _loc2_ = 0;
         while(_loc2_ < this.alternatives.length)
         {
            (this.alternatives[_loc2_] as AlternativeMonstersInGroupLightInformations).serializeAs_AlternativeMonstersInGroupLightInformations(param1);
            _loc2_++;
         }
         super.serializeAs_GroupMonsterStaticInformations(param1);
         param1.writeShort(this.alternatives.length);
         int _loc2_ = 0;
         while(_loc2_ < this.alternatives.length)
         {
            (this.alternatives[_loc2_] as AlternativeMonstersInGroupLightInformations).serializeAs_AlternativeMonstersInGroupLightInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         AlternativeMonstersInGroupLightInformations _loc4_ = null;
         MonsterInGroupInformations _loc4_ = null;
         this.mainCreatureLightInfos = new MonsterInGroupLightInformations();
         this.mainCreatureLightInfos.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new MonsterInGroupInformations();
            _loc4_.deserialize(param1);
            this.underlings.push(_loc4_);
            _loc3_++;
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new AlternativeMonstersInGroupLightInformations();
            _loc4_.deserialize(param1);
            this.alternatives.push(_loc4_);
            _loc3_++;
         }
    }

}