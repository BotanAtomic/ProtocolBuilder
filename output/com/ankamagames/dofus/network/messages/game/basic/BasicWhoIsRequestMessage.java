package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicWhoIsRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 181;
    private boolean _isInitialized = false;
    private boolean verbose = false;
    private String search = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 181;
    }

    public BasicWhoIsRequestMessage initBasicWhoIsRequestMessage(boolean param1,String  param2) {
         this.verbose = param1;
         this.search = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.verbose = false;
         this.search = "";
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
         this.serializeAs_BasicWhoIsRequestMessage(param1);
    }

    public void serializeAs_BasicWhoIsRequestMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.verbose);
         param1.writeUTF(this.search);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicWhoIsRequestMessage(param1);
    }

    public void deserializeAs_BasicWhoIsRequestMessage(ICustomDataInput param1) {
         this._verboseFunc(param1);
         this._searchFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicWhoIsRequestMessage(param1);
    }

    public void deserializeAsyncAs_BasicWhoIsRequestMessage(FuncTree param1) {
         param1.addChild(this._verboseFunc);
         param1.addChild(this._searchFunc);
    }

    private void _verboseFunc(ICustomDataInput param1) {
         this.verbose = param1.readBoolean();
    }

    private void _searchFunc(ICustomDataInput param1) {
         this.search = param1.readUTF();
    }

}