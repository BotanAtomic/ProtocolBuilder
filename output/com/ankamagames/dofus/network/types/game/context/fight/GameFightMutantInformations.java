package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightMutantInformations extends GameFightFighterNamedInformations implements INetworkType {

    private int protocolId = 50;
    private int powerLevel = 0;


    public int getTypeId() {
         return 50;
    }

    public GameFightMutantInformations initGameFightMutantInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,int  param5,boolean  param6,GameFightMinimalStats  param7,Vector<uint>  param8,String  param9,PlayerStatus  param10,int  param11) {
         super.initGameFightFighterNamedInformations(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10);
         this.powerLevel = param11;
         return this;
    }

    public void reset() {
         super.reset();
         this.powerLevel = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightMutantInformations(param1);
    }

    public void serializeAs_GameFightMutantInformations(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterNamedInformations(param1);
         if(this.powerLevel < 0)
         {
            throw new Exception("Forbidden value (" + this.powerLevel + ") on element powerLevel.");
         }
         param1.writeByte(this.powerLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightMutantInformations(param1);
    }

    public void deserializeAs_GameFightMutantInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._powerLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightMutantInformations(param1);
    }

    public void deserializeAsyncAs_GameFightMutantInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._powerLevelFunc);
    }

    private void _powerLevelFunc(ICustomDataInput param1) {
         this.powerLevel = param1.readByte();
         if(this.powerLevel < 0)
         {
            throw new Exception("Forbidden value (" + this.powerLevel + ") on element of GameFightMutantInformations.powerLevel.");
         }
    }

}