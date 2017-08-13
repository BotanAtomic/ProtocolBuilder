package package com.ankamagames.dofus.network.messages.updater.parts;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class DownloadSetSpeedRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1512;
    private boolean _isInitialized = false;
    private int downloadSpeed = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 1512;
    }

    public DownloadSetSpeedRequestMessage initDownloadSetSpeedRequestMessage(int param1) {
         this.downloadSpeed = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.downloadSpeed = 0;
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
         this.serializeAs_DownloadSetSpeedRequestMessage(param1);
    }

    public void serializeAs_DownloadSetSpeedRequestMessage(ICustomDataOutput param1) {
         if(this.downloadSpeed < 1 || this.downloadSpeed > 10)
            throw new Exception("Forbidden value (" + this.downloadSpeed + ") on element downloadSpeed.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DownloadSetSpeedRequestMessage(param1);
    }

    public void deserializeAs_DownloadSetSpeedRequestMessage(ICustomDataInput param1) {
         this._downloadSpeedFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DownloadSetSpeedRequestMessage(param1);
    }

    public void deserializeAsyncAs_DownloadSetSpeedRequestMessage(FuncTree param1) {
         param1.addChild(this._downloadSpeedFunc);
    }

    private void _downloadSpeedFunc(ICustomDataInput param1) {
         this.downloadSpeed = param1.readByte();
         if(this.downloadSpeed < 1 || this.downloadSpeed > 10)
            throw new Exception("Forbidden value (" + this.downloadSpeed + ") on element of DownloadSetSpeedRequestMessage.downloadSpeed.");
    }

}