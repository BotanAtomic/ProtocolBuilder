package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.alignment.ActorAlignmentInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightMonsterWithAlignmentInformations extends GameFightMonsterInformations implements INetworkType {

    private int protocolId = 203;
    private ActorAlignmentInformations alignmentInfos;
    private FuncTree _alignmentInfostree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameFightAIInformations(param1);
         if(this.creatureGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.creatureGenericId + ") on element creatureGenericId.");
         }
         param1.writeVarShort(this.creatureGenericId);
         if(this.creatureGrade < 0)
         {
            throw new Exception("Forbidden value (" + this.creatureGrade + ") on element creatureGrade.");
         }
         param1.writeByte(this.creatureGrade);
         this.alignmentInfos.serializeAs_ActorAlignmentInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightFighterInformations(param1);
         this.creatureGenericId = param1.readVarUhShort();
         if(this.creatureGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.creatureGenericId + ") on element of GameFightMonsterInformations.creatureGenericId.");
         }
         this.creatureGrade = param1.readByte();
         if(this.creatureGrade < 0)
         {
            throw new Exception("Forbidden value (" + this.creatureGrade + ") on element of GameFightMonsterInformations.creatureGrade.");
         }
         this.alignmentInfos = new ActorAlignmentInformations();
         this.alignmentInfos.deserialize(param1);
    }

}