package package com.ankamagames.dofus.network.messages.updater.parts;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DownloadErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1513;
    private boolean _isInitialized = false;
    private int errorId = 0;
    private String message = "";
    private String helpUrl = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 1513;
    }

    public DownloadErrorMessage initDownloadErrorMessage(int param1,String  param2,String  param3) {
         this.errorId = param1;
         this.message = param2;
         this.helpUrl = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.errorId = 0;
         this.message = "";
         this.helpUrl = "";
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
         this.serializeAs_DownloadErrorMessage(param1);
    }

    public void serializeAs_DownloadErrorMessage(ICustomDataOutput param1) {
         param1.writeByte(this.errorId);
         param1.writeUTF(this.message);
         param1.writeUTF(this.helpUrl);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DownloadErrorMessage(param1);
    }

    public void deserializeAs_DownloadErrorMessage(ICustomDataInput param1) {
         this._errorIdFunc(param1);
         this._messageFunc(param1);
         this._helpUrlFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DownloadErrorMessage(param1);
    }

    public void deserializeAsyncAs_DownloadErrorMessage(FuncTree param1) {
         param1.addChild(this._errorIdFunc);
         param1.addChild(this._messageFunc);
         param1.addChild(this._helpUrlFunc);
    }

    private void _errorIdFunc(ICustomDataInput param1) {
         this.errorId = param1.readByte();
         if(this.errorId < 0)
            throw new Exception("Forbidden value (" + this.errorId + ") on element of DownloadErrorMessage.errorId.");
    }

    private void _messageFunc(ICustomDataInput param1) {
         this.message = param1.readUTF();
    }

    private void _helpUrlFunc(ICustomDataInput param1) {
         this.helpUrl = param1.readUTF();
    }

}