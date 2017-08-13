package com.ankamagames.dofus.network.types.game.friend;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AbstractContactInformations extends Object implements INetworkType {

    private int protocolId = 380;
    private int accountId = 0;
    private String accountName = "";


    public int getTypeId() {
         return 380;
    }

    public AbstractContactInformations initAbstractContactInformations(int param1,String  param2) {
         this.accountId = param1;
         this.accountName = param2;
         return this;
    }

    public void reset() {
         this.accountId = 0;
         this.accountName = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AbstractContactInformations(param1);
    }

    public void serializeAs_AbstractContactInformations(ICustomDataOutput param1) {
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
         param1.writeUTF(this.accountName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractContactInformations(param1);
    }

    public void deserializeAs_AbstractContactInformations(ICustomDataInput param1) {
         this._accountIdFunc(param1);
         this._accountNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AbstractContactInformations(param1);
    }

    public void deserializeAsyncAs_AbstractContactInformations(FuncTree param1) {
         param1.addChild(this._accountIdFunc);
         param1.addChild(this._accountNameFunc);
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of AbstractContactInformations.accountId.");
         }
    }

    private void _accountNameFunc(ICustomDataInput param1) {
         this.accountName = param1.readUTF();
    }

}