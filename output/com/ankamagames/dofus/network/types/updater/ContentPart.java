package com.ankamagames.dofus.network.types.updater;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ContentPart extends Object implements INetworkType {

    private int protocolId = 350;
    private String id = "";
    private int state = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.id);
         param1.writeByte(this.state);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readUTF();
         this.state = param1.readByte();
         if(this.state < 0)
         {
            throw new Exception("Forbidden value (" + this.state + ") on element of ContentPart.state.");
         }
    }

}