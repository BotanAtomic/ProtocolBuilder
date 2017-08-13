package com.ankamagames.dofus.network.types.secure;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class TrustCertificate extends Object implements INetworkType {

    private int protocolId = 377;
    private int id = 0;
    private String hash = "";


    public int getTypeId() {
         return 377;
    }

    public TrustCertificate initTrustCertificate(int param1,String  param2) {
         this.id = param1;
         this.hash = param2;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.hash = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TrustCertificate(param1);
    }

    public void serializeAs_TrustCertificate(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeInt(this.id);
         param1.writeUTF(this.hash);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TrustCertificate(param1);
    }

    public void deserializeAs_TrustCertificate(ICustomDataInput param1) {
         this._idFunc(param1);
         this._hashFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TrustCertificate(param1);
    }

    public void deserializeAsyncAs_TrustCertificate(FuncTree param1) {
         param1.addChild(this._idFunc);
         param1.addChild(this._hashFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readInt();
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of TrustCertificate.id.");
         }
    }

    private void _hashFunc(ICustomDataInput param1) {
         this.hash = param1.readUTF();
    }

}