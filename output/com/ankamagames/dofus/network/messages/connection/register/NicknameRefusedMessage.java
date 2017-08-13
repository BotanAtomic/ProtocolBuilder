package com.ankamagames.dofus.network.messages.connection.register;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class NicknameRefusedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5638;
    private boolean _isInitialized = false;
    private int reason = 99;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5638;
    }

    public NicknameRefusedMessage initNicknameRefusedMessage(int param1) {
         this.reason = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.reason = 99;
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
         this.serializeAs_NicknameRefusedMessage(param1);
    }

    public void serializeAs_NicknameRefusedMessage(ICustomDataOutput param1) {
         param1.writeByte(this.reason);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NicknameRefusedMessage(param1);
    }

    public void deserializeAs_NicknameRefusedMessage(ICustomDataInput param1) {
         this._reasonFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NicknameRefusedMessage(param1);
    }

    public void deserializeAsyncAs_NicknameRefusedMessage(FuncTree param1) {
         param1.addChild(this._reasonFunc);
    }

    private void _reasonFunc(ICustomDataInput param1) {
         this.reason = param1.readByte();
         if(this.reason < 0)
         {
            throw new Exception("Forbidden value (" + this.reason + ") on element of NicknameRefusedMessage.reason.");
         }
    }

}