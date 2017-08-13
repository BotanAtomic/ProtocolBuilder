package com.ankamagames.dofus.network.types.game.dare;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DareReward extends Object implements INetworkType {

    private int protocolId = 505;
    private int type = 0;
    private int monsterId = 0;
    private Number kamas = 0;
    private Number dareId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.type);
         if(this.monsterId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterId + ") on element monsterId.");
         }
         param1.writeVarShort(this.monsterId);
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element kamas.");
         }
         param1.writeVarLong(this.kamas);
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
         }
         param1.writeDouble(this.dareId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of DareReward.type.");
         }
         this.monsterId = param1.readVarUhShort();
         if(this.monsterId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterId + ") on element of DareReward.monsterId.");
         }
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamas + ") on element of DareReward.kamas.");
         }
         this.dareId = param1.readDouble();
         if(this.dareId < 0 || this.dareId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.dareId + ") on element of DareReward.dareId.");
         }
    }

}