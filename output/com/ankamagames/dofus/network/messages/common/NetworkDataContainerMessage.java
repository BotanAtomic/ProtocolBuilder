package com.ankamagames.dofus.network.messages.common;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.INetworkDataContainerMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class NetworkDataContainerMessage {

    private int protocolId = 2;
    private ByteArray _content;
    private boolean _isInitialized = false;


    public ByteArray content() {
         return this._content;
    }

    public void set content(ByteArray param1) {
         this._content = param1;
    }

    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 2;
    }

    public NetworkDataContainerMessage initNetworkDataContainerMessage(ByteArray param1) {
         this.content = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.content = new ByteArray();
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
         this.serializeAs_NetworkDataContainerMessage(param1);
    }

    public void serializeAs_NetworkDataContainerMessage(ICustomDataOutput param1) {
         param1.writeBytes(this.content);
         throw new Exception("Not implemented");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NetworkDataContainerMessage(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_RawDataMessage(param1);
    }

    public void deserializeAs_NetworkDataContainerMessage(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         ByteArray _loc3_ = new ByteArray();
         param1.readBytes(_loc3_,0,_loc2_);
         _loc3_.uncompress();
         this.content = _loc3_;
    }

    public void deserializeAsyncAs_RawDataMessage(FuncTree param1) {
         param1.addChild(this.deserializeAs_NetworkDataContainerMessage);
    }

}