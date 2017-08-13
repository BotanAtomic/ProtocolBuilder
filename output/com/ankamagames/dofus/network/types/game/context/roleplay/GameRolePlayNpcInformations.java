package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayNpcInformations extends GameRolePlayActorInformations implements INetworkType {

    private int protocolId = 156;
    private int npcId = 0;
    private boolean sex = false;
    private int specialArtworkId = 0;


    public int getTypeId() {
         return 156;
    }

    public GameRolePlayNpcInformations initGameRolePlayNpcInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,boolean  param5,int  param6) {
         super.initGameRolePlayActorInformations(param1,param2,param3);
         this.npcId = param4;
         this.sex = param5;
         this.specialArtworkId = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.npcId = 0;
         this.sex = false;
         this.specialArtworkId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayNpcInformations(param1);
    }

    public void serializeAs_GameRolePlayNpcInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element npcId.");
         }
         param1.writeVarShort(this.npcId);
         param1.writeBoolean(this.sex);
         if(this.specialArtworkId < 0)
         {
            throw new Exception("Forbidden value (" + this.specialArtworkId + ") on element specialArtworkId.");
         }
         param1.writeVarShort(this.specialArtworkId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayNpcInformations(param1);
    }

    public void deserializeAs_GameRolePlayNpcInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._npcIdFunc(param1);
         this._sexFunc(param1);
         this._specialArtworkIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayNpcInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayNpcInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._npcIdFunc);
         param1.addChild(this._sexFunc);
         param1.addChild(this._specialArtworkIdFunc);
    }

    private void _npcIdFunc(ICustomDataInput param1) {
         this.npcId = param1.readVarUhShort();
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element of GameRolePlayNpcInformations.npcId.");
         }
    }

    private void _sexFunc(ICustomDataInput param1) {
         this.sex = param1.readBoolean();
    }

    private void _specialArtworkIdFunc(ICustomDataInput param1) {
         this.specialArtworkId = param1.readVarUhShort();
         if(this.specialArtworkId < 0)
         {
            throw new Exception("Forbidden value (" + this.specialArtworkId + ") on element of GameRolePlayNpcInformations.specialArtworkId.");
         }
    }

}