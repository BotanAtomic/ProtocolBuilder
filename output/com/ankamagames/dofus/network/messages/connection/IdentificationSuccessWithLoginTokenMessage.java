package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentificationSuccessWithLoginTokenMessage extends IdentificationSuccessMessage implements INetworkMessage {

    private int protocolId = 6209;
    private boolean _isInitialized = false;
    private String loginToken = "";


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6209;
    }

    public IdentificationSuccessWithLoginTokenMessage initIdentificationSuccessWithLoginTokenMessage(String param1,String  param2,int  param3,int  param4,boolean  param5,String  param6,Number  param7,Number  param8,Number  param9,boolean  param10,int  param11,String  param12) {
         super.initIdentificationSuccessMessage(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11);
         this.loginToken = param12;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.loginToken = "";
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_IdentificationSuccessWithLoginTokenMessage(param1);
    }

    public void serializeAs_IdentificationSuccessWithLoginTokenMessage(ICustomDataOutput param1) {
         super.serializeAs_IdentificationSuccessMessage(param1);
         param1.writeUTF(this.loginToken);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdentificationSuccessWithLoginTokenMessage(param1);
    }

    public void deserializeAs_IdentificationSuccessWithLoginTokenMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._loginTokenFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdentificationSuccessWithLoginTokenMessage(param1);
    }

    public void deserializeAsyncAs_IdentificationSuccessWithLoginTokenMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._loginTokenFunc);
    }

    private void _loginTokenFunc(ICustomDataInput param1) {
         this.loginToken = param1.readUTF();
    }

}