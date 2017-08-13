package package com.ankamagames.dofus.network.types.game.approach;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServerSessionConstantString extends ServerSessionConstant implements INetworkType {

    private int protocolId = 436;
    private String value = "";


    public int getTypeId() {
         return 436;
    }

    public ServerSessionConstantString initServerSessionConstantString(int param1,String  param2) {
         super.initServerSessionConstant(param1);
         this.value = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.value = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ServerSessionConstantString(param1);
    }

    public void serializeAs_ServerSessionConstantString(ICustomDataOutput param1) {
         super.serializeAs_ServerSessionConstant(param1);
         param1.writeUTF(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ServerSessionConstantString(param1);
    }

    public void deserializeAs_ServerSessionConstantString(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ServerSessionConstantString(param1);
    }

    public void deserializeAsyncAs_ServerSessionConstantString(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readUTF();
    }

}