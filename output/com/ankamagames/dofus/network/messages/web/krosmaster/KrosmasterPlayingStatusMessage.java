package package com.ankamagames.dofus.network.messages.web.krosmaster;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class KrosmasterPlayingStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6347;
    private boolean _isInitialized = false;
    private boolean playing = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6347;
    }

    public KrosmasterPlayingStatusMessage initKrosmasterPlayingStatusMessage(boolean param1) {
         this.playing = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.playing = false;
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
         this.serializeAs_KrosmasterPlayingStatusMessage(param1);
    }

    public void serializeAs_KrosmasterPlayingStatusMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.playing);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_KrosmasterPlayingStatusMessage(param1);
    }

    public void deserializeAs_KrosmasterPlayingStatusMessage(ICustomDataInput param1) {
         this._playingFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_KrosmasterPlayingStatusMessage(param1);
    }

    public void deserializeAsyncAs_KrosmasterPlayingStatusMessage(FuncTree param1) {
         param1.addChild(this._playingFunc);
    }

    private void _playingFunc(ICustomDataInput param1) {
         this.playing = param1.readBoolean();
    }

}