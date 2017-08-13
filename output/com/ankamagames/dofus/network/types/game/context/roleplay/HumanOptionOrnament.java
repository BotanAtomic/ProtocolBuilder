package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HumanOptionOrnament extends HumanOption implements INetworkType {

    private int protocolId = 411;
    private int ornamentId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.ornamentId < 0)
         {
            throw new Exception("Forbidden value (" + this.ornamentId + ") on element ornamentId.");
         }
         param1.writeVarShort(this.ornamentId);
         if(this.ornamentId < 0)
         {
            throw new Exception("Forbidden value (" + this.ornamentId + ") on element ornamentId.");
         }
         param1.writeVarShort(this.ornamentId);
         super.serializeAs_HumanOption(param1);
         if(this.ornamentId < 0)
         {
            throw new Exception("Forbidden value (" + this.ornamentId + ") on element ornamentId.");
         }
         param1.writeVarShort(this.ornamentId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.ornamentId = param1.readVarUhShort();
         if(this.ornamentId < 0)
         {
            throw new Exception("Forbidden value (" + this.ornamentId + ") on element of HumanOptionOrnament.ornamentId.");
         }
    }

}