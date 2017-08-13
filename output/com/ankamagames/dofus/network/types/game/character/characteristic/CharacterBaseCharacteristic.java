package com.ankamagames.dofus.network.types.game.character.characteristic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterBaseCharacteristic extends Object implements INetworkType {

    private int protocolId = 4;
    private int base = 0;
    private int additionnal = 0;
    private int objectsAndMountBonus = 0;
    private int alignGiftBonus = 0;
    private int contextModif = 0;


    public int getTypeId() {
         return 4;
    }

    public CharacterBaseCharacteristic initCharacterBaseCharacteristic(int param1,int  param2,int  param3,int  param4,int  param5) {
         this.base = param1;
         this.additionnal = param2;
         this.objectsAndMountBonus = param3;
         this.alignGiftBonus = param4;
         this.contextModif = param5;
         return this;
    }

    public void reset() {
         this.base = 0;
         this.additionnal = 0;
         this.objectsAndMountBonus = 0;
         this.alignGiftBonus = 0;
         this.contextModif = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterBaseCharacteristic(param1);
    }

    public void serializeAs_CharacterBaseCharacteristic(ICustomDataOutput param1) {
         param1.writeVarShort(this.base);
         param1.writeVarShort(this.additionnal);
         param1.writeVarShort(this.objectsAndMountBonus);
         param1.writeVarShort(this.alignGiftBonus);
         param1.writeVarShort(this.contextModif);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterBaseCharacteristic(param1);
    }

    public void deserializeAs_CharacterBaseCharacteristic(ICustomDataInput param1) {
         this._baseFunc(param1);
         this._additionnalFunc(param1);
         this._objectsAndMountBonusFunc(param1);
         this._alignGiftBonusFunc(param1);
         this._contextModifFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterBaseCharacteristic(param1);
    }

    public void deserializeAsyncAs_CharacterBaseCharacteristic(FuncTree param1) {
         param1.addChild(this._baseFunc);
         param1.addChild(this._additionnalFunc);
         param1.addChild(this._objectsAndMountBonusFunc);
         param1.addChild(this._alignGiftBonusFunc);
         param1.addChild(this._contextModifFunc);
    }

    private void _baseFunc(ICustomDataInput param1) {
         this.base = param1.readVarShort();
    }

    private void _additionnalFunc(ICustomDataInput param1) {
         this.additionnal = param1.readVarShort();
    }

    private void _objectsAndMountBonusFunc(ICustomDataInput param1) {
         this.objectsAndMountBonus = param1.readVarShort();
    }

    private void _alignGiftBonusFunc(ICustomDataInput param1) {
         this.alignGiftBonus = param1.readVarShort();
    }

    private void _contextModifFunc(ICustomDataInput param1) {
         this.contextModif = param1.readVarShort();
    }

}