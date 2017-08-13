package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightMonsterInformations extends GameFightAIInformations implements INetworkType {

    private int protocolId = 29;
    private int creatureGenericId = 0;
    private int creatureGrade = 0;


    public int getTypeId() {
         return 29;
    }

    public GameFightMonsterInformations initGameFightMonsterInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,int  param5,boolean  param6,GameFightMinimalStats  param7,Vector.<uint>  param8,int  param9,int  param10) {
         super.initGameFightAIInformations(param1,param2,param3,param4,param5,param6,param7,param8);
         this.creatureGenericId = param9;
         this.creatureGrade = param10;
         return this;
    }

    public void reset() {
         super.reset();
         this.creatureGenericId = 0;
         this.creatureGrade = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightMonsterInformations(param1);
    }

    public void serializeAs_GameFightMonsterInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightAIInformations(param1);
         if(this.creatureGenericId < 0)
            throw new Exception("Forbidden value (" + this.creatureGenericId + ") on element creatureGenericId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightMonsterInformations(param1);
    }

    public void deserializeAs_GameFightMonsterInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._creatureGenericIdFunc(param1);
         this._creatureGradeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightMonsterInformations(param1);
    }

    public void deserializeAsyncAs_GameFightMonsterInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._creatureGenericIdFunc);
         param1.addChild(this._creatureGradeFunc);
    }

    private void _creatureGenericIdFunc(ICustomDataInput param1) {
         this.creatureGenericId = param1.readVarUhShort();
         if(this.creatureGenericId < 0)
            throw new Exception("Forbidden value (" + this.creatureGenericId + ") on element of GameFightMonsterInformations.creatureGenericId.");
    }

    private void _creatureGradeFunc(ICustomDataInput param1) {
         this.creatureGrade = param1.readByte();
         if(this.creatureGrade < 0)
            throw new Exception("Forbidden value (" + this.creatureGrade + ") on element of GameFightMonsterInformations.creatureGrade.");
    }

}