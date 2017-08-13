package com.ankamagames.dofus.network.types.game.character;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterMinimalPlusLookAndGradeInformations extends CharacterMinimalPlusLookInformations implements INetworkType {

    private int protocolId = 193;
    private int grade = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_CharacterMinimalInformations(param1);
         this.entityLook.serializeAs_EntityLook(param1);
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element grade.");
         }
         param1.writeVarInt(this.grade);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterMinimalPlusLookInformations(param1);
         this.grade = param1.readVarUhInt();
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element of CharacterMinimalPlusLookAndGradeInformations.grade.");
         }
    }

}