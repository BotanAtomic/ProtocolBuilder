package package com.ankamagames.dofus.network.types.game.approach;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ServerSessionConstant extends Object implements INetworkType {

    private int protocolId = 430;
    private int id = 0;


    public int getTypeId() {
         return 430;
    }

    public ServerSessionConstant initServerSessionConstant(int param1) {
         this.id = param1;
         return this;
    }

    public void reset() {
         this.id = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ServerSessionConstant(param1);
    }

    public void serializeAs_ServerSessionConstant(ICustomDataOutput param1) {
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ServerSessionConstant(param1);
    }

    public void deserializeAs_ServerSessionConstant(ICustomDataInput param1) {
         this._idFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ServerSessionConstant(param1);
    }

    public void deserializeAsyncAs_ServerSessionConstant(FuncTree param1) {
         param1.addChild(this._idFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhShort();
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element of ServerSessionConstant.id.");
    }

}