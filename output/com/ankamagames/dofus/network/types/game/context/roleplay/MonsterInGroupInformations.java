package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MonsterInGroupInformations extends MonsterInGroupLightInformations implements INetworkType {

    private int protocolId = 144;
    private EntityLook look = ;
    private FuncTree _looktree = ;


    public int getTypeId() {
         return 144;
    }

    public MonsterInGroupInformations initMonsterInGroupInformations(int param1,int  param2,EntityLook  param3) {
         super.initMonsterInGroupLightInformations(param1,param2);
         this.look = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.look = new EntityLook();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MonsterInGroupInformations(param1);
    }

    public void serializeAs_MonsterInGroupInformations(ICustomDataOutput param1) {
         super.serializeAs_MonsterInGroupLightInformations(param1);
         this.look.serializeAs_EntityLook(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MonsterInGroupInformations(param1);
    }

    public void deserializeAs_MonsterInGroupInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.look = new EntityLook();
         this.look.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MonsterInGroupInformations(param1);
    }

    public void deserializeAsyncAs_MonsterInGroupInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._looktree = param1.addChild(this._looktreeFunc);
    }

    private void _looktreeFunc(ICustomDataInput param1) {
         this.look = new EntityLook();
         this.look.deserializeAsync(this._looktree);
    }

}