package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MonsterInGroupInformations extends MonsterInGroupLightInformations implements INetworkType {

    private int protocolId = 144;
    private EntityLook look;
    private FuncTree _looktree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.creatureGenericId);
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element grade.");
         }
         param1.writeByte(this.grade);
         this.look.serializeAs_EntityLook(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MonsterInGroupLightInformations(param1);
         this.look = new EntityLook();
         this.look.deserialize(param1);
    }

}