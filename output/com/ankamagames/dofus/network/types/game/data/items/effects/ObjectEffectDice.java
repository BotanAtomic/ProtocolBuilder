package com.ankamagames.dofus.network.types.game.data.items.effects;

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

public class ObjectEffectDice extends ObjectEffect implements INetworkType {

    private int protocolId = 73;
    private int diceNum = 0;
    private int diceSide = 0;
    private int diceConst = 0;


    public int getTypeId() {
         return 73;
    }

    public ObjectEffectDice initObjectEffectDice(int param1,int  param2,int  param3,int  param4) {
         super.initObjectEffect(param1);
         this.diceNum = param2;
         this.diceSide = param3;
         this.diceConst = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.diceNum = 0;
         this.diceSide = 0;
         this.diceConst = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectEffectDice(param1);
    }

    public void serializeAs_ObjectEffectDice(ICustomDataOutput param1) {
         super.serializeAs_ObjectEffect(param1);
         if(this.diceNum < 0)
         {
            throw new Exception("Forbidden value (" + this.diceNum + ") on element diceNum.");
         }
         param1.writeVarShort(this.diceNum);
         if(this.diceSide < 0)
         {
            throw new Exception("Forbidden value (" + this.diceSide + ") on element diceSide.");
         }
         param1.writeVarShort(this.diceSide);
         if(this.diceConst < 0)
         {
            throw new Exception("Forbidden value (" + this.diceConst + ") on element diceConst.");
         }
         param1.writeVarShort(this.diceConst);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectEffectDice(param1);
    }

    public void deserializeAs_ObjectEffectDice(ICustomDataInput param1) {
         super.deserialize(param1);
         this._diceNumFunc(param1);
         this._diceSideFunc(param1);
         this._diceConstFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectEffectDice(param1);
    }

    public void deserializeAsyncAs_ObjectEffectDice(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._diceNumFunc);
         param1.addChild(this._diceSideFunc);
         param1.addChild(this._diceConstFunc);
    }

    private void _diceNumFunc(ICustomDataInput param1) {
         this.diceNum = param1.readVarUhShort();
         if(this.diceNum < 0)
         {
            throw new Exception("Forbidden value (" + this.diceNum + ") on element of ObjectEffectDice.diceNum.");
         }
    }

    private void _diceSideFunc(ICustomDataInput param1) {
         this.diceSide = param1.readVarUhShort();
         if(this.diceSide < 0)
         {
            throw new Exception("Forbidden value (" + this.diceSide + ") on element of ObjectEffectDice.diceSide.");
         }
    }

    private void _diceConstFunc(ICustomDataInput param1) {
         this.diceConst = param1.readVarUhShort();
         if(this.diceConst < 0)
         {
            throw new Exception("Forbidden value (" + this.diceConst + ") on element of ObjectEffectDice.diceConst.");
         }
    }

}