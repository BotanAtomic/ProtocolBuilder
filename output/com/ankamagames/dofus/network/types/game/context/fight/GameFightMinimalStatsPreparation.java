package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightMinimalStatsPreparation extends GameFightMinimalStats implements INetworkType {

    private int protocolId = 360;
    private int initiative = 0;


    public int getTypeId() {
         return 360;
    }

    public GameFightMinimalStatsPreparation initGameFightMinimalStatsPreparation(int param1,int  param2,int  param3,int  param4,int  param5,int  param6,int  param7,int  param8,int  param9,Number  param10,boolean  param11,int  param12,int  param13,int  param14,int  param15,int  param16,int  param17,int  param18,int  param19,int  param20,int  param21,int  param22,int  param23,int  param24,int  param25,int  param26,int  param27,int  param28,int  param29,int  param30,int  param31,int  param32,int  param33,int  param34,int  param35,int  param36,int  param37,int  param38,int  param39,int  param40,int  param41,int  param42,int  param43,int  param44) {
         super.initGameFightMinimalStats(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14,param15,param16,param17,param18,param19,param20,param21,param22,param23,param24,param25,param26,param27,param28,param29,param30,param31,param32,param33,param34,param35,param36,param37,param38,param39,param40,param41,param42,param43);
         this.initiative = param44;
         return this;
    }

    public void reset() {
         super.reset();
         this.initiative = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightMinimalStatsPreparation(param1);
    }

    public void serializeAs_GameFightMinimalStatsPreparation(ICustomDataOutput param1) {
         super.serializeAs_GameFightMinimalStats(param1);
         if(this.initiative < 0)
            throw new Exception("Forbidden value (" + this.initiative + ") on element initiative.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightMinimalStatsPreparation(param1);
    }

    public void deserializeAs_GameFightMinimalStatsPreparation(ICustomDataInput param1) {
         super.deserialize(param1);
         this._initiativeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightMinimalStatsPreparation(param1);
    }

    public void deserializeAsyncAs_GameFightMinimalStatsPreparation(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._initiativeFunc);
    }

    private void _initiativeFunc(ICustomDataInput param1) {
         this.initiative = param1.readVarUhInt();
         if(this.initiative < 0)
            throw new Exception("Forbidden value (" + this.initiative + ") on element of GameFightMinimalStatsPreparation.initiative.");
    }

}