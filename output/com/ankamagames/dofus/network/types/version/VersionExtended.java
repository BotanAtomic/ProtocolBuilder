package com.ankamagames.dofus.network.types.version;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class VersionExtended extends Version implements INetworkType {

    private int protocolId = 393;
    private int install = 0;
    private int technology = 0;


    public int getTypeId() {
         return 393;
    }

    public VersionExtended initVersionExtended(int param1,int  param2,int  param3,int  param4,int  param5,int  param6,int  param7,int  param8) {
         super.initVersion(param1,param2,param3,param4,param5,param6);
         this.install = param7;
         this.technology = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.install = 0;
         this.technology = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_VersionExtended(param1);
    }

    public void serializeAs_VersionExtended(ICustomDataOutput param1) {
         super.serializeAs_Version(param1);
         param1.writeByte(this.install);
         param1.writeByte(this.technology);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_VersionExtended(param1);
    }

    public void deserializeAs_VersionExtended(ICustomDataInput param1) {
         super.deserialize(param1);
         this._installFunc(param1);
         this._technologyFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_VersionExtended(param1);
    }

    public void deserializeAsyncAs_VersionExtended(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._installFunc);
         param1.addChild(this._technologyFunc);
    }

    private void _installFunc(ICustomDataInput param1) {
         this.install = param1.readByte();
         if(this.install < 0)
         {
            throw new Exception("Forbidden value (" + this.install + ") on element of VersionExtended.install.");
         }
    }

    private void _technologyFunc(ICustomDataInput param1) {
         this.technology = param1.readByte();
         if(this.technology < 0)
         {
            throw new Exception("Forbidden value (" + this.technology + ") on element of VersionExtended.technology.");
         }
    }

}