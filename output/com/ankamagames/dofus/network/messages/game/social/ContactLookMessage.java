package package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ContactLookMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5934;
    private boolean _isInitialized = false;
    private int requestId = 0;
    private String playerName = "";
    private Number playerId = 0;
    private EntityLook look = ;
    private FuncTree _looktree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5934;
    }

    public ContactLookMessage initContactLookMessage(int param1,String  param2,Number  param3,EntityLook  param4) {
         this.requestId = param1;
         this.playerName = param2;
         this.playerId = param3;
         this.look = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.requestId = 0;
         this.playerName = "";
         this.playerId = 0;
         this.look = new EntityLook();
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
         this.serializeAs_ContactLookMessage(param1);
    }

    public void serializeAs_ContactLookMessage(ICustomDataOutput param1) {
         if(this.requestId < 0)
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ContactLookMessage(param1);
    }

    public void deserializeAs_ContactLookMessage(ICustomDataInput param1) {
         this._requestIdFunc(param1);
         this._playerNameFunc(param1);
         this._playerIdFunc(param1);
         this.look = new EntityLook();
         this.look.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ContactLookMessage(param1);
    }

    public void deserializeAsyncAs_ContactLookMessage(FuncTree param1) {
         param1.addChild(this._requestIdFunc);
         param1.addChild(this._playerNameFunc);
         param1.addChild(this._playerIdFunc);
         this._looktree = param1.addChild(this._looktreeFunc);
    }

    private void _requestIdFunc(ICustomDataInput param1) {
         this.requestId = param1.readVarUhInt();
         if(this.requestId < 0)
            throw new Exception("Forbidden value (" + this.requestId + ") on element of ContactLookMessage.requestId.");
    }

    private void _playerNameFunc(ICustomDataInput param1) {
         this.playerName = param1.readUTF();
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element of ContactLookMessage.playerId.");
    }

    private void _looktreeFunc(ICustomDataInput param1) {
         this.look = new EntityLook();
         this.look.deserializeAsync(this._looktree);
    }

}