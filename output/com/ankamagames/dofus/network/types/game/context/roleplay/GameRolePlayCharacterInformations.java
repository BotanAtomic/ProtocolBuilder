package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.alignment.ActorAlignmentInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayCharacterInformations extends GameRolePlayHumanoidInformations implements INetworkType {

    private int protocolId = 36;
    private ActorAlignmentInformations alignmentInfos;
    private FuncTree _alignmentInfostree;


    public int getTypeId() {
         return 36;
    }

    public GameRolePlayCharacterInformations initGameRolePlayCharacterInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,String  param4,HumanInformations  param5,int  param6,ActorAlignmentInformations  param7) {
         super.initGameRolePlayHumanoidInformations(param1,param2,param3,param4,param5,param6);
         this.alignmentInfos = param7;
         return this;
    }

    public void reset() {
         super.reset();
         this.alignmentInfos = new ActorAlignmentInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameRolePlayCharacterInformations(param1);
    }

    public void serializeAs_GameRolePlayCharacterInformations(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayHumanoidInformations(param1);
         this.alignmentInfos.serializeAs_ActorAlignmentInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayCharacterInformations(param1);
    }

    public void deserializeAs_GameRolePlayCharacterInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.alignmentInfos = new ActorAlignmentInformations();
         this.alignmentInfos.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayCharacterInformations(param1);
    }

    public void deserializeAsyncAs_GameRolePlayCharacterInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._alignmentInfostree = param1.addChild(this._alignmentInfostreeFunc);
    }

    private void _alignmentInfostreeFunc(ICustomDataInput param1) {
         this.alignmentInfos = new ActorAlignmentInformations();
         this.alignmentInfos.deserializeAsync(this._alignmentInfostree);
    }

}