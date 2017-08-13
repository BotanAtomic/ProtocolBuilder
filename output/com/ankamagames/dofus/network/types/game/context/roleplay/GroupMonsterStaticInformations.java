package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GroupMonsterStaticInformations extends Object implements INetworkType {

    private int protocolId = 140;
    private MonsterInGroupLightInformations mainCreatureLightInfos;
    private MonsterInGroupInformations[] underlings;
    private FuncTree _mainCreatureLightInfostree;
    private FuncTree _underlingstree;


    public void serialize(ICustomDataOutput param1) {
         this.mainCreatureLightInfos.serializeAs_MonsterInGroupLightInformations(param1);
         param1.writeShort(this.underlings.length);
         int _loc2_ = 0;
         while(_loc2_ < this.underlings.length)
         {
            (this.underlings[_loc2_] as MonsterInGroupInformations).serializeAs_MonsterInGroupInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
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
    }

}