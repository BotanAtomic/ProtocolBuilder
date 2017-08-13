package package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HavenBagDailyLoteryMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6644;
    private boolean _isInitialized = false;
    private int returnType = 0;
    private String tokenId = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6644;
    }

    public HavenBagDailyLoteryMessage initHavenBagDailyLoteryMessage(int param1,String  param2) {
         this.returnType = param1;
         this.tokenId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.returnType = 0;
         this.tokenId = "";
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
         this.serializeAs_HavenBagDailyLoteryMessage(param1);
    }

    public void serializeAs_HavenBagDailyLoteryMessage(ICustomDataOutput param1) {
         param1.writeByte(this.returnType);
         param1.writeUTF(this.tokenId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HavenBagDailyLoteryMessage(param1);
    }

    public void deserializeAs_HavenBagDailyLoteryMessage(ICustomDataInput param1) {
         this._returnTypeFunc(param1);
         this._tokenIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HavenBagDailyLoteryMessage(param1);
    }

    public void deserializeAsyncAs_HavenBagDailyLoteryMessage(FuncTree param1) {
         param1.addChild(this._returnTypeFunc);
         param1.addChild(this._tokenIdFunc);
    }

    private void _returnTypeFunc(ICustomDataInput param1) {
         this.returnType = param1.readByte();
         if(this.returnType < 0)
            throw new Exception("Forbidden value (" + this.returnType + ") on element of HavenBagDailyLoteryMessage.returnType.");
    }

    private void _tokenIdFunc(ICustomDataInput param1) {
         this.tokenId = param1.readUTF();
    }

}