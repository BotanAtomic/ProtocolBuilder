package package com.ankamagames.dofus.network.types.updater;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ContentPart extends Object implements INetworkType {

    private int protocolId = 350;
    private String id = "";
    private int state = 0;


    public int getTypeId() {
         return 350;
    }

    public ContentPart initContentPart(String param1,int  param2) {
         this.id = param1;
         this.state = param2;
         return this;
    }

    public void reset() {
         this.id = "";
         this.state = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ContentPart(param1);
    }

    public void serializeAs_ContentPart(ICustomDataOutput param1) {
         param1.writeUTF(this.id);
         param1.writeByte(this.state);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ContentPart(param1);
    }

    public void deserializeAs_ContentPart(ICustomDataInput param1) {
         this._idFunc(param1);
         this._stateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ContentPart(param1);
    }

    public void deserializeAsyncAs_ContentPart(FuncTree param1) {
         param1.addChild(this._idFunc);
         param1.addChild(this._stateFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readUTF();
    }

    private void _stateFunc(ICustomDataInput param1) {
         this.state = param1.readByte();
         if(this.state < 0)
            throw new Exception("Forbidden value (" + this.state + ") on element of ContentPart.state.");
    }

}