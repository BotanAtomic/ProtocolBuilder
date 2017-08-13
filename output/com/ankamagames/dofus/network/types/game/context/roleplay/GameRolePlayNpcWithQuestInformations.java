package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.quest.GameRolePlayNpcQuestFlag;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayNpcWithQuestInformations extends GameRolePlayNpcInformations implements INetworkType {

    private int protocolId = 383;
    private GameRolePlayNpcQuestFlag questFlag;
    private FuncTree _questFlagtree;


    public void serialize(ICustomDataOutput param1) {
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
         this.questFlag.serializeAs_GameRolePlayNpcQuestFlag(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.contextualId = param1.readDouble();
         if(this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.contextualId + ") on element of GameContextActorInformations.contextualId.");
         }
         this.look = new EntityLook();
         this.look.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.disposition = ProtocolTypeManager.getInstance(EntityDispositionInformations,_loc2_);
         this.disposition.deserialize(param1);
         this.npcId = param1.readVarUhShort();
         if(this.npcId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcId + ") on element of GameRolePlayNpcInformations.npcId.");
         }
         this.sex = param1.readBoolean();
         this.specialArtworkId = param1.readVarUhShort();
         if(this.specialArtworkId < 0)
         {
            throw new Exception("Forbidden value (" + this.specialArtworkId + ") on element of GameRolePlayNpcInformations.specialArtworkId.");
         }
         this.questFlag = new GameRolePlayNpcQuestFlag();
         this.questFlag.deserialize(param1);
    }

}