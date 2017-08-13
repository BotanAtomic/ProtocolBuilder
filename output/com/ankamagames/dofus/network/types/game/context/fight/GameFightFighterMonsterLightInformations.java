package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightFighterMonsterLightInformations extends GameFightFighterLightInformations implements INetworkType {

    private int protocolId = 455;
    private int creatureGenericId = 0;


    public int getTypeId() {
         return 455;
    }

    public GameFightFighterMonsterLightInformations initGameFightFighterMonsterLightInformations(Number param1,int  param2,int  param3,int  param4,boolean  param5,boolean  param6,int  param7) {
         super.initGameFightFighterLightInformations(param1,param2,param3,param4,param5,param6);
         this.creatureGenericId = param7;
         return this;
    }

    public void reset() {
         super.reset();
         this.creatureGenericId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightFighterMonsterLightInformations(param1);
    }

    public void serializeAs_GameFightFighterMonsterLightInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterLightInformations(param1);
         if(this.creatureGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.creatureGenericId + ") on element creatureGenericId.");
         }
         param1.writeVarShort(this.creatureGenericId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightFighterMonsterLightInformations(param1);
    }

    public void deserializeAs_GameFightFighterMonsterLightInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._creatureGenericIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightFighterMonsterLightInformations(param1);
    }

    public void deserializeAsyncAs_GameFightFighterMonsterLightInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._creatureGenericIdFunc);
    }

    private void _creatureGenericIdFunc(ICustomDataInput param1) {
         this.creatureGenericId = param1.readVarUhShort();
         if(this.creatureGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.creatureGenericId + ") on element of GameFightFighterMonsterLightInformations.creatureGenericId.");
         }
    }

}