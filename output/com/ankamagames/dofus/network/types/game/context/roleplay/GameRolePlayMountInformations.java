package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayMountInformations extends GameRolePlayNamedActorInformations implements INetworkType {

    private int protocolId = 180;
    private String ownerName = "";
    private int level = 0;


    public int getTypeId() {
         return 180;
    }

    public GameRolePlayMountInformations initGameRolePlayMountInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,String  param4,String  param5,int  param6) {
         super.initGameRolePlayNamedActorInformations(param1,param2,param3,param4);
         this.ownerName = param5;
         this.level = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.ownerName = "";
         this.level = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayMountInformations(param1);
    }

    public void serializeAs_GameRolePlayMountInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayNamedActorInformations(param1);
         param1.writeUTF(this.ownerName);
         if(this.level < 0 || this.level > 255)
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayMountInformations(param1);
    }

    public void deserializeAs_GameRolePlayMountInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._ownerNameFunc(param1);
         this._levelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayMountInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayMountInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._ownerNameFunc);
         param1.addChild(this._levelFunc);
    }

    private void _ownerNameFunc(ICustomDataInput param1) {
         this.ownerName = param1.readUTF();
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
            throw new Exception("Forbidden value (" + this.level + ") on element of GameRolePlayMountInformations.level.");
    }

}