package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayMutantInformations extends GameRolePlayHumanoidInformations implements INetworkType {

    private int protocolId = 3;
    private int monsterId = 0;
    private int powerLevel = 0;


    public int getTypeId() {
         return 3;
    }

    public GameRolePlayMutantInformations initGameRolePlayMutantInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,String  param4,HumanInformations  param5,int  param6,int  param7,int  param8) {
         super.initGameRolePlayHumanoidInformations(param1,param2,param3,param4,param5,param6);
         this.monsterId = param7;
         this.powerLevel = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.monsterId = 0;
         this.powerLevel = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayMutantInformations(param1);
    }

    public void serializeAs_GameRolePlayMutantInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayHumanoidInformations(param1);
         if(this.monsterId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterId + ") on element monsterId.");
         }
         param1.writeVarShort(this.monsterId);
         param1.writeByte(this.powerLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayMutantInformations(param1);
    }

    public void deserializeAs_GameRolePlayMutantInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._monsterIdFunc(param1);
         this._powerLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayMutantInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayMutantInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._monsterIdFunc);
         param1.addChild(this._powerLevelFunc);
    }

    private void _monsterIdFunc(ICustomDataInput param1) {
         this.monsterId = param1.readVarUhShort();
         if(this.monsterId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterId + ") on element of GameRolePlayMutantInformations.monsterId.");
         }
    }

    private void _powerLevelFunc(ICustomDataInput param1) {
         this.powerLevel = param1.readByte();
    }

}