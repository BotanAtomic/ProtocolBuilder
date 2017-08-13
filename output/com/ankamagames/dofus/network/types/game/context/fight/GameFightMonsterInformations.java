package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightMonsterInformations extends GameFightAIInformations implements INetworkType {

    private int protocolId = 29;
    private int creatureGenericId = 0;
    private int creatureGrade = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameFightFighterInformations(param1);
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
    }

}