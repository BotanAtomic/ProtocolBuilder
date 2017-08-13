package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightEntityDispositionInformations extends EntityDispositionInformations implements INetworkType {

    private int protocolId = 217;
    private Number carryingCharacterId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_EntityDispositionInformations(param1);
         if(this.carryingCharacterId < -9.007199254740992E15 || this.carryingCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.carryingCharacterId + ") on element carryingCharacterId.");
         }
         param1.writeDouble(this.carryingCharacterId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.cellId = param1.readShort();
         if(this.cellId < -1 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of EntityDispositionInformations.cellId.");
         }
         this.direction = param1.readByte();
         if(this.direction < 0)
         {
            throw new Exception("Forbidden value (" + this.direction + ") on element of EntityDispositionInformations.direction.");
         }
         this.carryingCharacterId = param1.readDouble();
         if(this.carryingCharacterId < -9.007199254740992E15 || this.carryingCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.carryingCharacterId + ") on element of FightEntityDispositionInformations.carryingCharacterId.");
         }
    }

}