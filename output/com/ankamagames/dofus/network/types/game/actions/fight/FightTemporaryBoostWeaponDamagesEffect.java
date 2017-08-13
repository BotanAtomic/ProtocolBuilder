package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTemporaryBoostWeaponDamagesEffect extends FightTemporaryBoostEffect implements INetworkType {

    private int protocolId = 211;
    private int weaponTypeId = 0;


    public int getTypeId() {
         return 211;
    }

    public FightTemporaryBoostWeaponDamagesEffect initFightTemporaryBoostWeaponDamagesEffect(int param1,Number  param2,int  param3,int  param4,int  param5,int  param6,int  param7,int  param8,int  param9) {
         super.initFightTemporaryBoostEffect(param1,param2,param3,param4,param5,param6,param7,param8);
         this.weaponTypeId = param9;
         return this;
    }

    public void reset() {
         super.reset();
         this.weaponTypeId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTemporaryBoostWeaponDamagesEffect(param1);
    }

    public void serializeAs_FightTemporaryBoostWeaponDamagesEffect(ICustomDataOutput param1) {
         super.serializeAs_FightTemporaryBoostEffect(param1);
         param1.writeShort(this.weaponTypeId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTemporaryBoostWeaponDamagesEffect(param1);
    }

    public void deserializeAs_FightTemporaryBoostWeaponDamagesEffect(ICustomDataInput param1) {
         super.deserialize(param1);
         this._weaponTypeIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTemporaryBoostWeaponDamagesEffect(param1);
    }

    public void deserializeAsyncAs_FightTemporaryBoostWeaponDamagesEffect(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._weaponTypeIdFunc);
    }

    private void _weaponTypeIdFunc(ICustomDataInput param1) {
         this.weaponTypeId = param1.readShort();
    }

}