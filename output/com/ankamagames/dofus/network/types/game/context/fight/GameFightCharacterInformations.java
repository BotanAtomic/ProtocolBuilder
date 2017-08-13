package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.alignment.ActorAlignmentInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightCharacterInformations extends GameFightFighterNamedInformations implements INetworkType {

    private int protocolId = 46;
    private int level = 0;
    private ActorAlignmentInformations alignmentInfos;
    private int breed = 0;
    private boolean sex = false;
    private FuncTree _alignmentInfostree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterInformations(param1);
         param1.writeUTF(this.name);
         this.status.serializeAs_PlayerStatus(param1);
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         this.alignmentInfos.serializeAs_ActorAlignmentInformations(param1);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightFighterNamedInformations(param1);
         this.level = param1.readUnsignedByte();
         if(this.level < 0 || this.level > 255)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of GameFightCharacterInformations.level.");
         }
         this.alignmentInfos = new ActorAlignmentInformations();
         this.alignmentInfos.deserialize(param1);
         this.breed = param1.readByte();
         this.sex = param1.readBoolean();
    }

}