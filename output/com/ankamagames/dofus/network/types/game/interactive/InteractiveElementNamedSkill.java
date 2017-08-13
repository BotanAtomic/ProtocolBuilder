package com.ankamagames.dofus.network.types.game.interactive;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InteractiveElementNamedSkill extends InteractiveElementSkill implements INetworkType {

    private int protocolId = 220;
    private int nameId = 0;


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
         if(this.nameId < 0)
         {
            throw new Exception("Forbidden value (" + this.nameId + ") on element nameId.");
         }
         param1.writeVarInt(this.nameId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveElementSkill(param1);
         this.nameId = param1.readVarUhInt();
         if(this.nameId < 0)
         {
            throw new Exception("Forbidden value (" + this.nameId + ") on element of InteractiveElementNamedSkill.nameId.");
         }
    }

}