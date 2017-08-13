package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightAIInformations extends GameFightFighterInformations implements INetworkType {

    private int protocolId = 151;


    public int getTypeId() {
         return 151;
    }

    public GameFightAIInformations initGameFightAIInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,int  param5,boolean  param6,GameFightMinimalStats  param7,Vector.<uint>  param8) {
         super.initGameFightFighterInformations(param1,param2,param3,param4,param5,param6,param7,param8);
         return this;
    }

    public void reset() {
         super.reset();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightAIInformations(param1);
    }

    public void serializeAs_GameFightAIInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightAIInformations(param1);
    }

    public void deserializeAs_GameFightAIInformations(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightAIInformations(param1);
    }

    public void deserializeAsyncAs_GameFightAIInformations(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}