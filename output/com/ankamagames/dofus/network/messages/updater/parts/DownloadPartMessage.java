package package com.ankamagames.dofus.network.messages.updater.parts;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DownloadPartMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1503;
    private boolean _isInitialized = false;
    private String id = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 1503;
    }

    public DownloadPartMessage initDownloadPartMessage(String param1) {
         this.id = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.id = "";
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
         this.serializeAs_DownloadPartMessage(param1);
    }

    public void serializeAs_DownloadPartMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.id);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DownloadPartMessage(param1);
    }

    public void deserializeAs_DownloadPartMessage(ICustomDataInput param1) {
         this._idFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DownloadPartMessage(param1);
    }

    public void deserializeAsyncAs_DownloadPartMessage(FuncTree param1) {
         param1.addChild(this._idFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readUTF();
    }

}