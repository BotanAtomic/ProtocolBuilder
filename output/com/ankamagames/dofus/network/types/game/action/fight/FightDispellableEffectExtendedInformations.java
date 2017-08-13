package package com.ankamagames.dofus.network.types.game.action.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.actions.fight.AbstractFightDispellableEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FightDispellableEffectExtendedInformations extends Object implements INetworkType {

    private int protocolId = 208;
    private int actionId = 0;
    private Number sourceId = 0;
    private AbstractFightDispellableEffect effect = ;
    private FuncTree _effecttree = ;
    private int _loc2_ = param1.readUnsignedShort();


    public int getTypeId() {
         return 208;
    }

    public FightDispellableEffectExtendedInformations initFightDispellableEffectExtendedInformations(int param1,Number  param2,AbstractFightDispellableEffect  param3) {
         this.actionId = param1;
         this.sourceId = param2;
         this.effect = param3;
         return this;
    }

    public void reset() {
         this.actionId = 0;
         this.sourceId = 0;
         this.effect = new AbstractFightDispellableEffect();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightDispellableEffectExtendedInformations(param1);
    }

    public void serializeAs_FightDispellableEffectExtendedInformations(ICustomDataOutput param1) {
         if(this.actionId < 0)
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightDispellableEffectExtendedInformations(param1);
    }

    public void deserializeAs_FightDispellableEffectExtendedInformations(ICustomDataInput param1) {
         this._actionIdFunc(param1);
         this._sourceIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.effect = ProtocolTypeManager.getInstance(AbstractFightDispellableEffect,_loc2_);
         this.effect.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightDispellableEffectExtendedInformations(param1);
    }

    public void deserializeAsyncAs_FightDispellableEffectExtendedInformations(FuncTree param1) {
         param1.addChild(this._actionIdFunc);
         param1.addChild(this._sourceIdFunc);
         this._effecttree = param1.addChild(this._effecttreeFunc);
    }

    private void _actionIdFunc(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
            throw new Exception("Forbidden value (" + this.actionId + ") on element of FightDispellableEffectExtendedInformations.actionId.");
    }

    private void _sourceIdFunc(ICustomDataInput param1) {
         this.sourceId = param1.readDouble();
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.sourceId + ") on element of FightDispellableEffectExtendedInformations.sourceId.");
    }

    private void _effecttreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.effect = ProtocolTypeManager.getInstance(AbstractFightDispellableEffect,_loc2_);
         this.effect.deserializeAsync(this._effecttree);
    }

}