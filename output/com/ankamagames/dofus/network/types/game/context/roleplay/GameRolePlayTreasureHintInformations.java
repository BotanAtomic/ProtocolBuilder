package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayTreasureHintInformations extends GameRolePlayActorInformations implements INetworkType {

    private int protocolId = 471;
    private int npcId = 0;


    public int getTypeId() {
         return 471;
    }

    public GameRolePlayTreasureHintInformations initGameRolePlayTreasureHintInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4) {
         super.initGameRolePlayActorInformations(param1,param2,param3);
         this.npcId = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.npcId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayTreasureHintInformations(param1);
    }

    public void serializeAs_GameRolePlayTreasureHintInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element npcId.");
         }
         param1.writeVarShort(this.npcId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayTreasureHintInformations(param1);
    }

    public void deserializeAs_GameRolePlayTreasureHintInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._npcIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayTreasureHintInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayTreasureHintInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._npcIdFunc);
    }

    private void _npcIdFunc(ICustomDataInput param1) {
         this.npcId = param1.readVarUhShort();
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element of GameRolePlayTreasureHintInformations.npcId.");
         }
    }

}