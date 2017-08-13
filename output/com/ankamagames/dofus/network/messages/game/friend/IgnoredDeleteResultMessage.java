package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class IgnoredDeleteResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5677;
    private boolean _isInitialized = false;
    private boolean success = false;
    private String name = "";
    private boolean session = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5677;
    }

    public IgnoredDeleteResultMessage initIgnoredDeleteResultMessage(boolean param1,String  param2,boolean  param3) {
         this.success = param1;
         this.name = param2;
         this.session = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.success = false;
         this.name = "";
         this.session = false;
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
         this.serializeAs_IgnoredDeleteResultMessage(param1);
    }

    public void serializeAs_IgnoredDeleteResultMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.success);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.session);
         param1.writeByte(_loc2_);
         param1.writeUTF(this.name);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IgnoredDeleteResultMessage(param1);
    }

    public void deserializeAs_IgnoredDeleteResultMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._nameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IgnoredDeleteResultMessage(param1);
    }

    public void deserializeAsyncAs_IgnoredDeleteResultMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._nameFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.success = BooleanByteWrapper.getFlag(_loc2_,0);
         this.session = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

}