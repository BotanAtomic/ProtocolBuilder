package com.ankamagames.dofus.network.types.game.interactive;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InteractiveElementSkill extends Object implements INetworkType {

    private int protocolId = 219;
    private int skillId = 0;
    private int skillInstanceUid = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarInt(this.skillId);
         if(this.skillInstanceUid < 0)
         {
            throw new Exception("Forbidden value (" + this.skillInstanceUid + ") on element skillInstanceUid.");
         }
         param1.writeInt(this.skillInstanceUid);
    }

    public void deserialize(ICustomDataInput param1) {
         this.skillId = param1.readVarUhInt();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of InteractiveElementSkill.skillId.");
         }
         this.skillInstanceUid = param1.readInt();
         if(this.skillInstanceUid < 0)
         {
            throw new Exception("Forbidden value (" + this.skillInstanceUid + ") on element of InteractiveElementSkill.skillInstanceUid.");
         }
    }

}