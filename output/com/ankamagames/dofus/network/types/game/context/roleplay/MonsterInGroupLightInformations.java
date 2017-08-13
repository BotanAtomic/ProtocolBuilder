package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MonsterInGroupLightInformations extends Object implements INetworkType {

    private int protocolId = 395;
    private int creatureGenericId = 0;
    private int grade = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.creatureGenericId);
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element grade.");
         }
         param1.writeByte(this.grade);
    }

    public void deserialize(ICustomDataInput param1) {
         this.creatureGenericId = param1.readInt();
         this.grade = param1.readByte();
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element of MonsterInGroupLightInformations.grade.");
         }
    }

}