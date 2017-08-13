package package com.ankamagames.dofus.network.types.game.approach;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ServerSessionConstantLong extends ServerSessionConstant implements INetworkType {

    private int protocolId = 429;
    private Number value = 0;


    public int getTypeId() {
         return 429;
    }

    public ServerSessionConstantLong initServerSessionConstantLong(int param1,Number  param2) {
         super.initServerSessionConstant(param1);
         this.value = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.value = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ServerSessionConstantLong(param1);
    }

    public void serializeAs_ServerSessionConstantLong(ICustomDataOutput param1) {
         super.serializeAs_ServerSessionConstant(param1);
         if(this.value < -9.007199254740992E15 || this.value > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.value + ") on element value.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ServerSessionConstantLong(param1);
    }

    public void deserializeAs_ServerSessionConstantLong(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ServerSessionConstantLong(param1);
    }

    public void deserializeAsyncAs_ServerSessionConstantLong(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readDouble();
         if(this.value < -9.007199254740992E15 || this.value > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.value + ") on element of ServerSessionConstantLong.value.");
    }

}