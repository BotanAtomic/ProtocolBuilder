package package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.version.VersionExtended;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentificationAccountForceMessage extends IdentificationMessage implements INetworkMessage {

    private int protocolId = 6119;
    private boolean _isInitialized = false;
    private String forcedAccountLogin = "";


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6119;
    }

    public IdentificationAccountForceMessage initIdentificationAccountForceMessage(VersionExtended param1,String  param2,Vector.<int>  param3,int  param4,boolean  param5,boolean  param6,boolean  param7,Number  param8,Vector.<uint>  param9,String  param10) {
         super.initIdentificationMessage(param1,param2,param3,param4,param5,param6,param7,param8,param9);
         this.forcedAccountLogin = param10;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.forcedAccountLogin = "";
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
         this.serializeAs_IdentificationAccountForceMessage(param1);
    }

    public void serializeAs_IdentificationAccountForceMessage(ICustomDataOutput param1) {
         super.serializeAs_IdentificationMessage(param1);
         param1.writeUTF(this.forcedAccountLogin);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdentificationAccountForceMessage(param1);
    }

    public void deserializeAs_IdentificationAccountForceMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._forcedAccountLoginFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdentificationAccountForceMessage(param1);
    }

    public void deserializeAsyncAs_IdentificationAccountForceMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._forcedAccountLoginFunc);
    }

    private void _forcedAccountLoginFunc(ICustomDataInput param1) {
         this.forcedAccountLogin = param1.readUTF();
    }

}