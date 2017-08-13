package package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class AbstractFightDispellableEffect extends Object implements INetworkType {

    private int protocolId = 206;
    private int uid = 0;
    private Number targetId = 0;
    private int turnDuration = 0;
    private int dispelable = 1;
    private int spellId = 0;
    private int effectId = 0;
    private int parentBoostUid = 0;


    public int getTypeId() {
         return 206;
    }

    public AbstractFightDispellableEffect initAbstractFightDispellableEffect(int param1,Number  param2,int  param3,int  param4,int  param5,int  param6,int  param7) {
         this.uid = param1;
         this.targetId = param2;
         this.turnDuration = param3;
         this.dispelable = param4;
         this.spellId = param5;
         this.effectId = param6;
         this.parentBoostUid = param7;
         return this;
    }

    public void reset() {
         this.uid = 0;
         this.targetId = 0;
         this.turnDuration = 0;
         this.dispelable = 1;
         this.spellId = 0;
         this.effectId = 0;
         this.parentBoostUid = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AbstractFightDispellableEffect(param1);
    }

    public void serializeAs_AbstractFightDispellableEffect(ICustomDataOutput param1) {
         if(this.uid < 0)
            throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractFightDispellableEffect(param1);
    }

    public void deserializeAs_AbstractFightDispellableEffect(ICustomDataInput param1) {
         this._uidFunc(param1);
         this._targetIdFunc(param1);
         this._turnDurationFunc(param1);
         this._dispelableFunc(param1);
         this._spellIdFunc(param1);
         this._effectIdFunc(param1);
         this._parentBoostUidFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AbstractFightDispellableEffect(param1);
    }

    public void deserializeAsyncAs_AbstractFightDispellableEffect(FuncTree param1) {
         param1.addChild(this._uidFunc);
         param1.addChild(this._targetIdFunc);
         param1.addChild(this._turnDurationFunc);
         param1.addChild(this._dispelableFunc);
         param1.addChild(this._spellIdFunc);
         param1.addChild(this._effectIdFunc);
         param1.addChild(this._parentBoostUidFunc);
    }

    private void _uidFunc(ICustomDataInput param1) {
         this.uid = param1.readVarUhInt();
         if(this.uid < 0)
            throw new Exception("Forbidden value (" + this.uid + ") on element of AbstractFightDispellableEffect.uid.");
    }

    private void _targetIdFunc(ICustomDataInput param1) {
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.targetId + ") on element of AbstractFightDispellableEffect.targetId.");
    }

    private void _turnDurationFunc(ICustomDataInput param1) {
         this.turnDuration = param1.readShort();
    }

    private void _dispelableFunc(ICustomDataInput param1) {
         this.dispelable = param1.readByte();
         if(this.dispelable < 0)
            throw new Exception("Forbidden value (" + this.dispelable + ") on element of AbstractFightDispellableEffect.dispelable.");
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element of AbstractFightDispellableEffect.spellId.");
    }

    private void _effectIdFunc(ICustomDataInput param1) {
         this.effectId = param1.readVarUhInt();
         if(this.effectId < 0)
            throw new Exception("Forbidden value (" + this.effectId + ") on element of AbstractFightDispellableEffect.effectId.");
    }

    private void _parentBoostUidFunc(ICustomDataInput param1) {
         this.parentBoostUid = param1.readVarUhInt();
         if(this.parentBoostUid < 0)
            throw new Exception("Forbidden value (" + this.parentBoostUid + ") on element of AbstractFightDispellableEffect.parentBoostUid.");
    }

}