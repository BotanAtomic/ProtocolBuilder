package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.dofus.network.types.game.context.GameContextActorInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayActorInformations extends GameContextActorInformations implements INetworkType {

    private int protocolId = 141;


    public int getTypeId() {
         return 141;
    }

    public GameRolePlayActorInformations initGameRolePlayActorInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3) {
         super.initGameContextActorInformations(param1,param2,param3);
         return this;
    }

    public void reset() {
         super.reset();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayActorInformations(param1);
    }

    public void serializeAs_GameRolePlayActorInformations(ICustomDataOutput param1) {
         super.serializeAs_GameContextActorInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayActorInformations(param1);
    }

    public void deserializeAs_GameRolePlayActorInformations(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayActorInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayActorInformations(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}