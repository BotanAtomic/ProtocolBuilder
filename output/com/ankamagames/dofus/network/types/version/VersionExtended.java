package com.ankamagames.dofus.network.types.version;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class VersionExtended extends Version implements INetworkType {

    private int protocolId = 393;
    private int install = 0;
    private int technology = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.install);
         param1.writeByte(this.technology);
         param1.writeByte(this.install);
         param1.writeByte(this.technology);
         super.serializeAs_Version(param1);
         param1.writeByte(this.install);
         param1.writeByte(this.technology);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdentificationFailedMessage(param1);
         this.requiredVersion = new Version();
         this.requiredVersion.deserialize(param1);
         this.install = param1.readByte();
         if(this.install < 0)
         {
            throw new Exception("Forbidden value (" + this.install + ") on element of VersionExtended.install.");
         }
         this.technology = param1.readByte();
         if(this.technology < 0)
         {
            throw new Exception("Forbidden value (" + this.technology + ") on element of VersionExtended.technology.");
         }
    }

}