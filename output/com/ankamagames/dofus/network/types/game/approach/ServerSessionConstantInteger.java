package package com.ankamagames.dofus.network.types.game.approach;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServerSessionConstantInteger extends ServerSessionConstant implements INetworkType {

    private int protocolId = 433;
    private int value = 0;


    public int getTypeId() {
         return 433;
    }

    public ServerSessionConstantInteger initServerSessionConstantInteger(int param1,int  param2) {
         super.initServerSessionConstant(param1);
         this.value = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.value = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ServerSessionConstantInteger(param1);
    }

    public void serializeAs_ServerSessionConstantInteger(ICustomDataOutput param1) {
         super.serializeAs_ServerSessionConstant(param1);
         param1.writeInt(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ServerSessionConstantInteger(param1);
    }

    public void deserializeAs_ServerSessionConstantInteger(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ServerSessionConstantInteger(param1);
    }

    public void deserializeAsyncAs_ServerSessionConstantInteger(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readInt();
    }

}