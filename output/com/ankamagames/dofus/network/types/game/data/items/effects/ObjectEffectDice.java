package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectEffectDice extends ObjectEffect implements INetworkType {

    private int protocolId = 73;
    private int diceNum = 0;
    private int diceSide = 0;
    private int diceConst = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeVarShort(this.actionId);
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
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
         }
         this.diceNum = param1.readVarUhShort();
         if(this.diceNum < 0)
         {
            throw new Exception("Forbidden value (" + this.diceNum + ") on element of ObjectEffectDice.diceNum.");
         }
         this.diceSide = param1.readVarUhShort();
         if(this.diceSide < 0)
         {
            throw new Exception("Forbidden value (" + this.diceSide + ") on element of ObjectEffectDice.diceSide.");
         }
         this.diceConst = param1.readVarUhShort();
         if(this.diceConst < 0)
         {
            throw new Exception("Forbidden value (" + this.diceConst + ") on element of ObjectEffectDice.diceConst.");
         }
    }

}