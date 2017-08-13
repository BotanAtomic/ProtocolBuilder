package package com.ankamagames.dofus.network.messages.game.character.status;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PlayerStatusUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6386;
    private boolean _isInitialized = false;
    private int accountId = 0;
    private Number playerId = 0;
    private PlayerStatus status = ;
    private FuncTree _statustree = ;
    private int _loc2_ = param1.readUnsignedShort();


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6386;
    }

    public PlayerStatusUpdateMessage initPlayerStatusUpdateMessage(int param1,Number  param2,PlayerStatus  param3) {
         this.accountId = param1;
         this.playerId = param2;
         this.status = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.accountId = 0;
         this.playerId = 0;
         this.status = new PlayerStatus();
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
         this.serializeAs_PlayerStatusUpdateMessage(param1);
    }

    public void serializeAs_PlayerStatusUpdateMessage(ICustomDataOutput param1) {
         if(this.accountId < 0)
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PlayerStatusUpdateMessage(param1);
    }

    public void deserializeAs_PlayerStatusUpdateMessage(ICustomDataInput param1) {
         this._accountIdFunc(param1);
         this._playerIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PlayerStatusUpdateMessage(param1);
    }

    public void deserializeAsyncAs_PlayerStatusUpdateMessage(FuncTree param1) {
         param1.addChild(this._accountIdFunc);
         param1.addChild(this._playerIdFunc);
         this._statustree = param1.addChild(this._statustreeFunc);
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
            throw new Exception("Forbidden value (" + this.accountId + ") on element of PlayerStatusUpdateMessage.accountId.");
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element of PlayerStatusUpdateMessage.playerId.");
    }

    private void _statustreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserializeAsync(this._statustree);
    }

}