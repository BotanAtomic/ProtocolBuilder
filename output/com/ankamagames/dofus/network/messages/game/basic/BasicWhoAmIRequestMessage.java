package package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicWhoAmIRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5664;
    private boolean _isInitialized = false;
    private boolean verbose = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5664;
    }

    public BasicWhoAmIRequestMessage initBasicWhoAmIRequestMessage(boolean param1) {
         this.verbose = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.verbose = false;
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
         this.serializeAs_BasicWhoAmIRequestMessage(param1);
    }

    public void serializeAs_BasicWhoAmIRequestMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.verbose);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicWhoAmIRequestMessage(param1);
    }

    public void deserializeAs_BasicWhoAmIRequestMessage(ICustomDataInput param1) {
         this._verboseFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicWhoAmIRequestMessage(param1);
    }

    public void deserializeAsyncAs_BasicWhoAmIRequestMessage(FuncTree param1) {
         param1.addChild(this._verboseFunc);
    }

    private void _verboseFunc(ICustomDataInput param1) {
         this.verbose = param1.readBoolean();
    }

}