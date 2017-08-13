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


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayNamedActorInformations(param1);
         param1.writeShort(this.humanoidInfo.getTypeId());
         this.humanoidInfo.serialize(param1);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
         this.alignmentInfos.serializeAs_ActorAlignmentInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayHumanoidInformations(param1);
         this.alignmentInfos = new ActorAlignmentInformations();
         this.alignmentInfos.deserialize(param1);
    }

}