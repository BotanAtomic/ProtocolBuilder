package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HumanOptionTitle extends HumanOption implements INetworkType {

    private int protocolId = 408;
    private int titleId = 0;
    private String titleParam = "";


    public void serialize(ICustomDataOutput param1) {
         if(this.titleId < 0)
         {
            throw new Exception("Forbidden value (" + this.titleId + ") on element titleId.");
         }
         param1.writeVarShort(this.titleId);
         param1.writeUTF(this.titleParam);
         if(this.titleId < 0)
         {
            throw new Exception("Forbidden value (" + this.titleId + ") on element titleId.");
         }
         param1.writeVarShort(this.titleId);
         param1.writeUTF(this.titleParam);
         super.serializeAs_HumanOption(param1);
         if(this.titleId < 0)
         {
            throw new Exception("Forbidden value (" + this.titleId + ") on element titleId.");
         }
         param1.writeVarShort(this.titleId);
         param1.writeUTF(this.titleParam);
    }

    public void deserialize(ICustomDataInput param1) {
         this.titleId = param1.readVarUhShort();
         if(this.titleId < 0)
         {
            throw new Exception("Forbidden value (" + this.titleId + ") on element of HumanOptionTitle.titleId.");
         }
         this.titleParam = param1.readUTF();
    }

}