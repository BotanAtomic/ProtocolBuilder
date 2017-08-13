package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayNamedActorInformations extends GameRolePlayActorInformations implements INetworkType {

    private int protocolId = 154;
    private String name = "";


    public int getTypeId() {
         return 154;
    }

    public GameRolePlayNamedActorInformations initGameRolePlayNamedActorInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,String  param4) {
         super.initGameRolePlayActorInformations(param1,param2,param3);
         this.name = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.name = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayNamedActorInformations(param1);
    }

    public void serializeAs_GameRolePlayNamedActorInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         param1.writeUTF(this.name);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayNamedActorInformations(param1);
    }

    public void deserializeAs_GameRolePlayNamedActorInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._nameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayNamedActorInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayNamedActorInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nameFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

}