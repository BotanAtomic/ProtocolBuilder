package com.ankamagames.dofus.network.types.secure;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TrustCertificate extends Object implements INetworkType {

    private int protocolId = 377;
    private int id = 0;
    private String hash = "";


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeInt(this.id);
         param1.writeUTF(this.hash);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readInt();
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of TrustCertificate.id.");
         }
         this.hash = param1.readUTF();
    }

}